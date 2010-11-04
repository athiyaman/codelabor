//// 서버측 세션 타임 아웃을 가져와서 클라이언트 측 타임 아웃을 설정한다.
var sessionTimeout = 0; // 세션 타임 아웃 시간 (초)
var sessionRemainedTime = 0; // 남은 시간 (초)
var sessinoWariningTime = 60; // 세션 타임 아웃 시간 연장 여부를 확인하는 시간 (초)

var sessionTimer; // 세션 타임 아웃 타이머
var sessionTimerIsOn = false; // 세션 타임 아웃 타이머 활성화 여부
var getSessionTimeoutRequest; // 세션 타임 아웃 요청
var warnTimeoutWindow; // 세션 타임아웃 경고 윈도우

// 세션 타임 아웃 시간을 설정한다.
function setSessionTimeout() {
	if (getSessionTimeoutRequest.readyState == 4) {
		if (getSessionTimeoutRequest.status == 200) {
			sessionTimeout = getSessionTimeoutRequest.responseText;
			sessionRemainedTime = getSessionTimeoutRequest.responseText;
			document.getElementById("maxInactiveInterval").innerHTML = sessionTimeout;
			document.getElementById("sessionRemainedTime").innerHTML = sessionRemainedTime;
		}
	}
}

// 세션 타임아웃 시간을 가져온다.
function getMaxInactiveInterval() {
	getSessionTimeoutRequest = createRequest();
	if (getSessionTimeoutRequest == null) {
		alert("Unable to create request");
		return;
	}
	var url = "/max-inactive-interval.jsp";
	getSessionTimeoutRequest.open("GET", url, true);
	getSessionTimeoutRequest.onreadystatechange = setSessionTimeout;
	getSessionTimeoutRequest.send(null);
}

// 세션 시간을 계산한다.
function checkRemainTime() {
	document.getElementById("sessionRemainedTime").innerHTML = sessionRemainedTime;
	if (sessionRemainedTime == 0) {
		timeout();
		return;
	} else {
		if (sessionRemainedTime == sessinoWariningTime) {
			warnTimeout();
		}
		sessionRemainedTime--;
	}
}

// 세션 시간 타이머를 시작한다.
function startSessionTimer() {
	if (!sessionTimerIsOn) {
		sessionTimerIsOn = true;
		sessionTimer = setInterval("checkRemainTime()", 1000);
	}
}

// 세션 시간 타이머를 정지한다.
function stopSessionTimer() {
	if (sessionTimerIsOn) {
		sessionTimerIsOn = false;
		clearInterval(sessionTimer);
	}
}

// 세션 시간 타이머를 초기화한다.
function resetSessionTimer() {
	sessionRemainedTime = sessionTimeout;
}

// 세션 타임 아웃 경고창을 띄운다.
function warnTimeout() {
	// open warn timeout popup
	var url = "warn-timeout-popup.html";
	var name = "_blank";
	var specs = "witdh=100, height=100, left=50, top=50, location=no, titlebar=no, menubar=no, toolbar=no, status=no, scrollbars=no, resizable=no";
	var replace = "false";
	warnTimeoutWindow = window.open(url, name, specs, replace);
}

// //세션 유지를 위해 마지막 세션 접근 시간을 가져온다.
var keepAliveTimer; // 세션 유지 타이머
var keepAliveTimerIsOn = false; // 세션 유지 타이머 활성화 여부
var keepAliveRequest; // 세션 유지 요청

// 마지막 세션 접근 시간을 표시한다.
function displayLastAccessedTime() {
	if (keepAliveRequest.readyState == 4) {
		if (keepAliveRequest.status == 200) {
			document.getElementById("lastAccessedTime").innerHTML = keepAliveRequest.responseText;
		}
	}
}

// 마지막 세션 접근 시간을 가져온다.
function getLastAccessedTime() {
	keepAliveRequest = createRequest();
	if (keepAliveRequest == null) {
		alert("Unable to create request");
		return;
	}
	var url = "/last-accessed-time.jsp";
	keepAliveRequest.open("GET", url, true);
	keepAliveRequest.onreadystatechange = displayLastAccessedTime;
	keepAliveRequest.send(null);
}

// 세션 유지 타이머를 시작한다.
function startKeepAliveTimer() {
	if (!keepAliveTimerIsOn) {
		keepAliveTimerIsOn = true;
		keepAliveTimer = setInterval("getLastAccessedTime()", 1000);
	}
}

// 세션 유지 타이머를 정지한다.
function stopKeepAliveTimer() {
	if (keepAliveTimerIsOn) {
		keepAliveTimerIsOn = false;
		clearInterval(keepAliveTimer);
	}
}

// //세션 무효화 작업
var sessionInvalidateRequest; // 세션 무효화 요청
var logoutWindow; // 로그 아웃 팝업 윈도우

// 세션을 무효화한다.
function invalidateSession() {
	sessionInvalidateRequest = createRequest();
	if (sessionInvalidateRequest == null) {
		alert("Unable to create request");
		return;
	}
	var url = "/session-invalidate.jsp";
	sessionInvalidateRequest.open("GET", url, true);
	sessionInvalidateRequest.send(null);
}

// 세션 타임 아웃 처리한다.
function timeout() {
	stopSessionTimer(); // 세션 타임 아웃 타이머를 종료한다.
	stopKeepAliveTimer(); // 세션 유지 타이머를 종료한다.
	invalidateSession(); // 세션을 무효화 한다.

	// open warn timeout popup
	var url = "logout-popup.html";
	var name = "_blank";
	var specs = "witdh=100, height=100, left=50, top=50, location=no, titlebar=no, menubar=no, toolbar=no, status=no, scrollbars=no, resizable=no";
	var replace = "false";
	logoutWindow = window.open(url, name, specs, replace);
}