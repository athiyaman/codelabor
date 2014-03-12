<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="Apache Forrest" name="Generator">
<meta name="Forrest-version" content="0.8">
<meta name="Forrest-skin-name" content="pelt">

<link rel="shortcut icon" href="">
</head>
<body>

	<script type="text/javascript">
		// --------------------------------
		// 서비스 함수들
		// --------------------------------

		function testAuth() {
			wWidth = 360;
			wHight = 120;

			wX = (window.screen.width - wWidth) / 2;
			wY = (window.screen.height - wHight) / 2;

			var w = window.open("Sample-AuthRequest.jsp", "gPinLoginWin",
					"directories=no,toolbar=no,left=" + wX + ",top=" + wY
							+ ",width=" + wWidth + ",height=" + wHight);
		}

		function testSiteUserConfirm() {
			wWidth = 350;
			wHight = 120;
			wX = (window.screen.width - wWidth) / 2;
			wY = (window.screen.height - wHight) / 2;

			attr = "GPIN_AQ_SERVICE_SITE_USER_CONFIRM";

			// vidn 값에 vidn + siteuserid 값을 붙여 보낸다.
			requrl = "Sample-SiteUserConfirmRequest.jsp?Attr=" + attr
					+ "&vidn=" + vidn.value + "|" + siteuserid.value;

			var w = window.open(requrl, "_blank",
					"directories=no,toolbar=no,left=" + wX + ",top=" + wY
							+ ",width=" + wWidth + ",height=" + wHight);
		}

		function testUserSync() {
			alert("이 테스트는 공공I-PIN센터에서 시작됩니다.");
		}

		function testCI() {
			wWidth = 350;
			wHight = 120;
			wX = (window.screen.width - wWidth) / 2;
			wY = (window.screen.height - wHight) / 2;

			attr = "coInfo1";

			// vidn 값에 vidn + siteuserid 값을 붙여 보낸다.
			requrl = "Sample-CIRequest.jsp?Attr=" + attr + "&vidn="
					+ vidn1.value + "&regNo=" + regNo1.value;

			var w = window.open(requrl, "_blank",
					"directories=no,toolbar=no,left=" + wX + ",top=" + wY
							+ ",width=" + wWidth + ",height=" + wHight);
		}

		function testUserDupValue() {
			wWidth = 850;
			wHight = 520;
			wX = (window.screen.width - wWidth) / 2;
			wY = (window.screen.height - wHight) / 2;

			requrl = "Sample-UserDuplicationValue.jsp?regNo=" + regNo.value
					+ "&siteId=" + siteId.value;

			var w = window.open(requrl, "_blank",
					"directories=no,toolbar=no,left=" + wX + ",top=" + wY
							+ ",width=" + wWidth + ",height=" + wHight);
		}

		function testVersion() {
			wWidth = 350;
			wHight = 120;
			wX = (window.screen.width - wWidth) / 2;
			wY = (window.screen.height - wHight) / 2;

			// vidn 값에 vidn + siteuserid 값을 붙여 보낸다.
			requrl = "ServiceResponse.jsp?versionRequest=versionRequest";

			var w = window.open(requrl, "_blank",
					"directories=no,toolbar=no,left=" + wX + ",top=" + wY
							+ ",width=" + wWidth + ",height=" + wHight);
		}
	</script>


	<div id="main">
		<div id="publishedStrip">
			<div id="level2tabs"></div>
		</div>

		<div id="content">

			<h1>Sample Page 테스트</h1>

			<div id="minitoc-area">
				<ul class="minitoc">
					<li><a href="#sentence1">본인확인(Auth)</a></li>
					<li><a href="#sentence2">이용기관 가입확인(SiteUserConfirm)</a></li>
					<li><a href="#sentence5">사용자 정보 동기화(UserSync)</a></li>
					<li><a href="#sentence6">공공I-PIN 이용기관 버전확인</a></li>
					<li><a href="#sentence7">사용자 연계정보(CI) 요청 </a></li>
					<li><a href="#sentence3">사용자 중복가입확인코드 생성하기(UserDupValue)</a></li>
				</ul>
			</div>


			<!-- ################################################################################ -->
			<!-- ###   단락					                                                  ### -->
			<!-- ################################################################################ -->
			<br /> <br /> <br /> <a name="N10011"></a><a name="sentence1"></a>
			<h2 class="boxed">본인확인(Auth)</h2>
			<hr color="#ffa500" />
			<div class="section">
				<p>
					G-PIN 서비스의 가장 기본이 되며 또한 지금까지 앞 단계에서의 설정과정을 처음 테스트 해보는 서비스이기도 합니다. 이
					서비스의 테스트로 지금까지의 설정정보가 올바른지 확인해 볼 수 있게 됩니다. <br /> 본인확인 결과에는
					개인식별번호와 이름 그리고 중복가입확인 정보가 포함됩니다.
				</p>
				<p>
					<input type="button" value="테스트 실행" onclick="testAuth()" />
				</p>
			</div>


			<!-- ################################################################################ -->
			<!-- ###   단락					                                                  ### -->
			<!-- ################################################################################ -->
			<br /> <br /> <br /> <a name="N1003E"></a><a name="sentence2"></a>
			<h2 class="boxed">이용기관 가입확인(SiteUserConfirm)</h2>
			<hr color="#ffa500" />
			<div class="section">
				<p>
					이용기관 회원가입 처리 후, 회원가입이 정상적으로 최종 완료되었음을 공공I-PIN센터에 알려주는 서비스입니다. 이 후
					공공I-PIN센터에서는 해당 회원에 대하여 이용기관의 정상적인 가입회원으로 인정합니다. 이 때 아래 예에서와 같이 가입한
					회원의 '개인식별번호'와 사이트에서의 '가입 ID' 값을 요구합니다. <br /> 서비스 호출 결과, 성공 유무에 따라
					이용기관에서의 회원가입 처리 절차를 마무리 하십시오.
				</p>
				<p>
					개인식별번호: <input id="vidn" type="text" size="20" value="" /> <br />
					이용기관 사용자 ID(사이트에서의 ID): <input id="siteuserid" type="text"
						size="15" value="" /> <br /> <br /> <input type="button"
						value="테스트 실행" onclick="testSiteUserConfirm()" />
				</p>
			</div>



			<!-- ################################################################################ -->
			<!-- ###   단락					                                                  ### -->
			<!-- ################################################################################ -->
			<br /> <br /> <br /> <a name="N1011D"></a><a name="sentence5"></a>
			<h2 class="boxed">사용자 정보 동기화(UserSync)</h2>
			<hr color="#ffa500" />
			<div class="section">
				<p>회원정보가 변경되었을때 공공I-PIN센터에서 이용기관측으로 사용자 정보을 송신하는 페이지입니다. 이 서비스는
					공공I-PIN센터에서 시작됩니다.</p>
				<p>
					<input type="button" value="테스트 실행"
						onclick="javascript:testUserSync()" />
				</p>
			</div>







			<!-- ################################################################################ -->
			<!-- ###   단락					                                                  ### -->
			<!-- ################################################################################ -->
			<br /> <br /> <br /> <a name="N1011D"></a><a name="sentence6"></a>
			<h2 class="boxed">공공I-PIN 이용기관 버전확인</h2>
			<hr color="#ffa500" />
			<div class="section">
				<p>공공I-PIN센터에서 이용기관측의 서비스버전을 확인하는 서비스입니다. 공공I-PIN센터에서 확인하는
					서비스입니다.</p>
				<p>
					<input type="button" value="테스트 실행"
						onclick="javascript:testVersion()" />
				</p>
			</div>

			<BR> <BR> <BR> <br /> <br /> <br /> <a
				name="N1011D"></a><a name="sentence7"></a>
			<h2 class="boxed">사용자 연계정보(CI) 요청</h2>
			<hr color="#ffa500" />
			<div class="section">
				이용기관에서 다른 이용기관사이트간의 연계를 목적으로 사용자 연계정보(CI)가 필요할 경우 개인식별번호나 주민등록번호를
				통해서 확인하는 서비스입니다.
				<div class="warning">
					<div class="label">주의</div>
					<div class="content">
						<p>본 서비스 요청 시, 사용자의 주민등록번호를 입력하는 경우 반드시 적합한 보안처리가 적용되어 처리되어야
							하며 본 예제 페이지에서는 기본적으로 제공하지 않고 있습니다.</p>
					</div>
				</div>
				<p>
					주민등록번호: <input id="regNo1" type="text" size="13" value=""
						maxlength="13"> <br /> OR <br> 개인식별번호: <input
						id="vidn1" type="text" size="15" value="" /> <br /> <br /> <input
						type="button" value="테스트 실행" onclick="javascript:testCI()" />
				</p>
			</div>

			<BR> <BR> <BR>












			<!-- ################################################################################ -->
			<!-- ###   단락					                                                  ### -->
			<!-- ################################################################################ -->
			<br /> <br /> <br /> <a name="N1011D"></a><a name="sentence3"></a>
			<h2 class="boxed">사용자 중복가입확인코드 생성하기(UserDupValue)</h2>
			<hr color="#ffa500" />
			<div class="section">
				<p>이용기관에서 본인확인 서비스로, I-PIN 서비스를 사용하지 않고 실명확인 등 다른 방법의 사용을 한 동안
					유지해야 할 경우 I-PIN 서비스와의 호환성을 위해 중복가입확인코드의 생성이 필요합니다. 이 서비스는 사용자의
					주민번호와 이용기관에 부여된 이용기관코드(Site Code)를 입력받아 중복가입확인코드를 생성해줍니다.</p>

				<div class="warning">
					<div class="label">주의</div>
					<div class="content">
						<p>본 서비스 요청 시, 사용자의 주민등록번호와 사이트 ID를 입력 받아야 합니다. 이 때 입력받는 부분은
							반드시 적합한 보안처리가 적용되어 처리되어야 하며 본 예제 페이지에서는 기본적으로 제공하지 않고 있습니다. 그리고
							G-PIN 클라이언트 모듈 G-PIN Client Tomcat은 반드시 이용기관 WAS가 설치된 장비에 같이 설치
							되는 것을 원칙으로 합니다.</p>
					</div>
				</div>
				<p>
					주민등록번호: <input id="regNo" type="text" size="13" value=""
						maxlength="13"> <br /> 이용기관 사이트 ID: <input id="siteId"
						type="text" size="15" value="" /> <br /> <br /> <input
						type="button" value="테스트 실행" onclick="testUserDupValue()" />
				</p>
			</div>

			<BR> <BR> <BR>



		</div>
		<!-- ================================================================================ -->
		<!--+
    |end content
    +-->
		<div class="clearboth">&nbsp;</div>

	</div>
</body>
</html>
