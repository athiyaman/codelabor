//////////////////////////////Update Zhang////////////////////////////////
// XecureWeb SSL Client Java Script ver4.1  2001.5.30
//
// 아직 : Netscape 6.0은 지원되지 않습니다....
// Edit List 2000,05,30
// process_error() --> XecureWebError() // by Zhang 변경
// function IsNetscape60()		// by Zhang 추가
// function XecureUnescape(Msg)		// by Zhang 추가
// function XecureEscape(Msg)		// by Zhang 추가
// function XecurePath(xpath)		// by zhang 추가

var gIsContinue=0;
var busy_info = "암호화 작업이 진행중입니다. 확인을 누르시고 잠시 기다려 주십시오."

// /////////// since 6.0 v210 //////////////////////////////////////////////
// usePageCharset : 암복호시 페이지에 명시된 문자셋의 사용 여부
// XecureWeb Java 버전 암복호시 시스템 디폴트 인코딩과 다른 문자셋의
// 메세지를 처리하는 경우 true 설정
//
var usePageCharset=true;
// var usePageCharset=false;

// YESSIGN CA ADDRESS//////////////////////////////////////////////////////
// TEST : 203.233.91.234
// REAL : 203.233.91.71
// var yessign_ca_type = 1; // Yessign Real
var yessign_ca_type = 11;	// Yessign Test
var yessign_ca_ip =  "203.233.91.234";
var yessign_ca_port = 4512;

// XECURE CA ADDRESS///////////////////////////////////////////////////////
// TEST : 192.168.10.30
var xecure_ca_type = 101;	// XecureCA (RSA)
// var xecure_ca_type = 102; // XecureCA (GPKI)
var xecure_ca_ip =  "192.168.10.25;SoftforumCA";
// var xecure_ca_ip = "192.168.10.25";
var xecure_ca_port = 8200;

var xecure_ca_type_1 = 101;	// XecureCA (RSA)
// var xecure_ca_type = 102; // XecureCA (GPKI)
var xecure_ca_ip_1 =  "192.168.10.30;mma ca";
var xecure_ca_port_1 = 2223;

// /////////////////////////////////////////////////////////////////////////////
// !!!!!!!!!!!!!!< 주의 >!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Sign, RequestCertificate, RevokeCertificate 시 나타나는 인증서 목록
// XecureWeb ver 5.1 에서는 accept_cert 에 유효한 인증기관 인증서의
// CN 을 정확히 적어준다.
// ver 4.0 에서 yessign 이라 적었던 것은 yessignCA-TEST, yessignCA 로 세분화 된다.
// YESSIGN TEST : yessignCA-TEST
// YESSIGN REAL : yessignCA
// //////////////////////////////////////////////////////////////////////////////
// 모든인증서 허용
var accept_cert = "yessignCA,SignKorea CA,TradeSignCA,CrossCert Certificate Authority,NCASignCA,signGATE CA2";

/*
 * //증권전산 var accept_cert="SignKorea CA:1.2.410.200004.5.1.1.5:1.2.410.200004.5.1.1.7:1.2.410.200004.5.1.1.9:1.2.410.200004.5.1.1.10:1.2.410.200004.5.1.1.12";
 *
 * //금융결제원: 상호연동(개인,법인) accept_cert+= ",yessignCA:1.2.410.200005.1.1.1:1.2.410.200005.1.1.5";
 *
 * //한국정보인증 : 상호연동(개인,법인), 용도제한(증권/보험용) accept_cert+=",signGATE CA:1.2.410.200004.5.2.1.2:1.2.410.200004.5.2.1.1:1.2.410.200004.5.2.1.7.2";
 *
 * //한국전산원 : 상호연동(개인,법인,기관) accept_cert+=",NCASign CA:1.2.410.200004.5.3.1.9:1.2.410.200004.5.3.1.2:1.2.410.200004.5.3.1.1";
 *
 * //한국전자인증 : 상호연동(개인,법인), 용도제한(증권용) accept_cert+=",CrossCertCA:1.2.410.200004.5.4.1.1:1.2.410.200004.5.4.1.2:1.2.410.200004.5.4.1.102";
 *
 * //한국무역정보통신 : 상호연동(개인,법인), 용도제한(증권/보험용) accept_cert+=",TradeSignCA:1.2.410.200012.1.1.1:1.2.410.200012.1.1.3:1.2.410.200012.1.1.103";
 *
 * //3280 변경된 CA인증서 accept_cert+=",signGATE CA2:1.2.410.200004.5.2.1.2:1.2.410.200004.5.2.1.1:1.2.410.200004.5.2.1.7.2"; accept_cert+=",NCASignCA:1.2.410.200004.5.3.1.9:1.2.410.200004.5.3.1.2:1.2.410.200004.5.3.1.1"; accept_cert+=",CrossCert Certificate
 * Authority:1.2.410.200004.5.4.1.1:1.2.410.200004.5.4.1.2:1.2.410.200004.5.4.1.102";
 */

// ///////////////////////////////////////////////////////////////////////////////
// 전자서명, 인증서 갱신, 인증서 폐기시에 인증서 암호오류를 허용회수
var pwd_fail = 3;

// ////////////////////////////////////////////////////////////////////////////////
// 로그인 창에 보일 이미지를 다운로드 받을 URL
// var bannerUrl = "http://" + window.location.host +
// "/XecureObject/xecure.bmp";
var bannerUrl =  "http://" + window.location.host + "/XecureObject/xecure.bmp.sig";

// /////////////////////////////////////////////////////////////////////////////////
// 인증기관 인증서 다운로드시 인증기관 인증서와 인증서 CN
// var pCaCertUrl= "http://" + window.location.host +
// "/XecureObject/signed_cacert.bin";
// var pCaCertName = "넥서브 CA";
var pCaCertUrl= "http://" + window.location.host + "/XecureObject/signed_cacert.bin";
// var pCaCertName = "테스트 인증기관";
var pCaCertName = "shinbo real ca";

// ////////////////////////////////////////////////////////////////////////////////
// 전자서명 확인창에 보일 메세지와 전자서명 확인창 보기 옵션
// 0 : 서명 원문 출력 안함, 1: 서명 원문 출력
var sign_desc = "";
var show_plain = 0;

// /////////////////////////////////////////////////////////////////////////////////
// xgate 서버 명:포트 지정 , 포트 생략시 디폴트로 443 포트 사용
var port = 8080; // default port
if (navigator.appVersion.indexOf("Win")!=-1) {
	port = 9080; // developer workstation
}
var xgate_addr	= window.location.hostname + ":443:"+port;
// var xgate_addr = "210.124.178.206" +
// ":8443:8001,8002,8003,8004,8005,8006,8007,8008,8009,8010,8011";

// /////////////////////////////////////////////////////////////////////////////////
// Netscape plugin version information
var packageURL = 'http://' + window.location.host + '/XecureObject/NPXecSSL_Install.jar';
// var packageURL = 'http://' + window.location.host +
// '/XecureObject/NPXecSSL50_Install.jar';
// var packageURL =
// 'http://download.softforum.co.kr/XecureObject/NPXecSSL50_Install.jar';
// var packageURL =
// 'http://download.softforum.co.kr/XecureObject41/NPXecSSL40_Install.jar';
// var versionMaj = 4;
// var versionMin = 2;
// var versionRel = 6;
var versionMaj = 5;
var versionMin = 1;
var versionRel = 0;

// ////////////////////////////////////////////////////////////////////////////////
// Xecure Big 함수들....
function SetConvertTable() {
// document.XecureWeb.SetPolicyConvertTableFirst(0, "1.2.410.200009.1.1.1", "내맘대로:금융결제원");
// document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200009.1.1.1.33", "내맘대로
// 특별등급 법인", "테스트2 Policy OID");
/*
 * document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200005.1.1.2", "금융거래법인"); // document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200005.1.1.3", "금융거래단체"); document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200005.1.1.4", "전자거래개인");
 * document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200005.1.1.5", "전자거래법인"); // document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200005.1.1.6", "금융거래단체"); document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200004.5.2.1.1", "정보인증");
 * document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200004.5.1.1.5", "증권전산"); document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200004.5.3.1", "전산원"); document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200004.5.4.1.1", "전자인증");
 * document.XecureWeb.SetPolicyConvertTableNext("1.2.410.200004.2.1", "공인인증기관");
 */
// document.XecureWeb.SetPolicyConvertTableFinal(0);


// document.XecureWeb.SetIssuerConvertTableFirst("lotto test CA", "로또인증기관");
// document.XecureWeb.SetIssuerConvertTableNext("SE CA", "에스이인증기관", "테스트");
    /*
     * document.XecureWeb.SetIssuerConvertTableNext("SE CA", "에스이인증기관", ""); document.XecureWeb.SetIssuerConvertTableNext("한빛은행 CA", "한빛은행", ""); document.XecureWeb.SetIssuerConvertTableNext("yessignCA", "금융결제원", ""); document.XecureWeb.SetIssuerConvertTableNext("yessignCA-TEST", "금결원TEST", "");
     * document.XecureWeb.SetIssuerConvertTableNext("SignGateFTCA", "정보인증TEST", ""); document.XecureWeb.SetIssuerConvertTableNext("signGate CA", "정보인증", ""); document.XecureWeb.SetIssuerConvertTableNext("rootca", "전산원", ""); document.XecureWeb.SetIssuerConvertTableNext("CrossCertCA", "전자인증", "");
     * document.XecureWeb.SetIssuerConvertTableNext("CertRSA01", "KISA인증기관", "");
     */
// document.XecureWeb.SetIssuerConvertTableFinal();

}

// ////////////////////////////////////////////////////////////////////////////////
// Xecure 함수들....
function UserAgent()
{
	return navigator.userAgent.substring(0,9);
}

function IsNetscape()			// by Zhang
{
	if(navigator.appName == 'Netscape') {
		return true ;
	} else {
		return false ;
	}
}

function IsNetscape60()			// by Zhang
{
	if(IsNetscape() && UserAgent() == 'Mozilla/5') {
		return true ;
	} else {
		return false ;
	}
}

function IsNetscape60()			// by Zhang
{
	if(IsNetscape() && UserAgent() == 'Mozilla/5') {
		return true ;
	} else {
		return false ;
	}
}

function XecureUnescape(Msg)		// by Zhang
{
	if(IsNetscape()) {
		return unescape(Msg) ;
	} else {
		return Msg ;
	}
}

function XecureEscape(Msg)		// by Zhang
{
	if(IsNetscape()) {
		return escape(Msg) ;
	} else {
		return Msg ;
	}
}

function XecurePath(xpath)		// by zhang
{
	if(IsNetscape()) {
		return xpath ;
	} else {
		return "/" + xpath ;
	}
}

function XecureAddQuery(qs)
{
	if(qs == "") {
		return "" ;
	} else {
		return "&" + qs ;
	}
}

function XecureWebError()		// by zhang
{
	var errCode = 0 ;
	var errMsg = "" ;

	if( IsNetscape60() )		// Netscape 6.0
	{
		errCode = document.XecureWeb.nsIXecurePluginInstance.LastErrCode();
		errMsg  = document.XecureWeb.nsIXecurePluginInstance.LastErrMsg();
	}
	else
	{
		errCode = document.XecureWeb.LastErrCode();
		errMsg  = document.XecureWeb.LastErrMsg();
	}

	if(errCode == -144)
	{
		if(confirm("에러코드 : " + errCode + "\n\n" + XecureUnescape(errMsg) + "\n\n 인증서관리창을 열겠습니까?")){ShowCertManager() ;}
	}
// else if(errCode != 0)
		alert( "에러코드 : " + errCode + "\n\n" + XecureUnescape(errMsg) );

	return false;
}

function escape_url(url) {
	var i;
	var ch;
	var out = '';
	var url_string = '';

	url_string = String(url);

	for (i = 0; i < url_string.length; i++) {
		ch = url_string.charAt(i);
		if (ch == ' '){out += '%20';}else if (ch == '%'){out += '%25';}else if (ch == '&'){out += '%26';}else if (ch == '+'){out += '%2B';}else if (ch == '='){out += '%3D';}else if (ch == '?'){out += '%3F';} else {out += ch;}
	}
	return out;
}

function ran_gen()
{
	var maxnumbers = "999999";
	var r = Math.round(Math.random() * (maxnumbers-1))+1+"";

	for(var i=0; i < 6-r.length; i++) {r = "0" + r;}

	return r;
}

function XecureNavigate_NoEnc( url, target )
{
	var qs ;
	var path = "/";
	var sid;
	var xecure_url;

	// get path info & query string & hash from url
	qs_begin_index = url.indexOf('?');
	path = getPath(url)

	// get query string action url
	if ( qs_begin_index < 0 ) {
		qs = "";
	}
	else {
		qs = url.substring(qs_begin_index + 1, url.length );
	}

	if( gIsContinue == 0 ) {
		gIsContinue = 1;
		if( IsNetscape60() ){sid = document.XecureWeb.nsIXecurePluginInstance.BlockEnc(xgate_addr, path, "", "GET");} else {sid = document.XecureWeb.BlockEnc ( xgate_addr, path, "", "GET" );}
		gIsContinue = 0;
	}
	else {
		alert(busy_info);
		return false ;
	}

	if( sid == "") {
		return XecureWebError();
	}

	xecure_url = path + "?q=" + sid + XecureAddQuery(qs);
	// adding character set information
	if(usePageCharset){xecure_url += "&charset=" + document.charset;}

	open ( xecure_url, target );
}

function XecureNavigate( url, target, feature )
{
	var qs ;
	var path = "/";
	var cipher;
	var xecure_url;

	// get path info & query string & hash from url
	qs_begin_index = url.indexOf('?');
	path = getPath(url)
	// get query string action url
	if ( qs_begin_index < 0 ) {
		qs = "";
	}
	else {
		qs = url.substring(qs_begin_index + 1, url.length );
	}

	if( gIsContinue == 0 ) {
		gIsContinue = 1;
		if( IsNetscape60() ){cipher = document.XecureWeb.nsIXecurePluginInstance.BlockEnc(xgate_addr, path, XecureEscape(qs), "GET");} else {cipher = document.XecureWeb.BlockEnc(xgate_addr, path, XecureEscape(qs),"GET");}
		gIsContinue = 0;
	}
	else {
		alert(busy_info);
		return false;
	}

	if( cipher == "" ) {
		return XecureWebError();
	}

	xecure_url = path + "?q=" + escape_url(cipher);
	// adding character set information
	if(usePageCharset){xecure_url += "&charset=" + document.charset;}

	if (feature=="" || feature==null){open ( xecure_url, target );} else {open(xecure_url, target, feature );}

}

/**
 * @since XecureWeb 6.0 v220
 */
function XecureNavigate_Env( url, target, feature )
{
	var qs ;
	var path = "/";
	var cipher;
	var xecure_url;

	// get path info & query string & hash from url
	qs_begin_index = url.indexOf('?');
	path = getPath(url)
	// get query string action url
	if ( qs_begin_index < 0 ) {
		qs = "";
	}
	else {
		qs = url.substring(qs_begin_index + 1, url.length );
	}

	if( gIsContinue == 0 ) {
		gIsContinue = 1;
		// cipher = document.XecureWeb.BlockEnc(xgate_addr, path,
		// XecureEscape(qs), "GET");
		cipher = EnvelopData(XecureEscape(qs), "", serverCert, 1);
		gIsContinue = 0;
	}
	else {
		alert(busy_info);
		return false;
	}

	if( cipher == "" ) {
		return XecureWebError();
	}

	// xecure_url = path + "?q=" + escape_url(cipher);
	xecure_url = path + "?eq=" + escape_url(cipher);

	// adding character set information
	if(usePageCharset){xecure_url += "&charset=" + document.charset;}

	if (feature=="" || feature==null) {
		open ( xecure_url, target );
	}
	else {
		open(xecure_url, target, feature );
	}

}

function XecureLink( link )
{
	var qs ;
// var path = "/";
	var cipher;


	// get path info & query string from action url

	if ( link.protocol != "http:" ) {
		// alert ( "http 프로토콜만 사용 가능합니다." );
		return true;
	}

	qs = link.search;
	if ( qs.length > 1 ) {
		qs = link.search.substring(1);
	}

	hash = link.hash;

	if( gIsContinue == 0 ) {
		path = XecurePath(link.pathname) ;
		gIsContinue = 1;

		if( IsNetscape60() ){cipher = document.XecureWeb.nsIXecurePluginInstance.BlockEnc(xgate_addr, path, XecureEscape(qs), "GET");}else {
			// cipher = document.XecureWeb.BlockEnc(xgate_addr, "/XecureDemo/jsp/ibs/transfer_input.jsp", XecureEscape(qs),"GET");
			cipher = document.XecureWeb.BlockEnc(xgate_addr, path, XecureEscape(qs),"GET");
		}
		gIsContinue = 0;
	}
	else {
		alert(busy_info);
		return false;
	}
	if( cipher.length == 0) {
		return XecureWebError() ;
	}

	// link.search = "?q=" + escape_url(cipher);
	xecure_url = "http://" + link.host + path + hash + "?q=" + escape_url(cipher);
	// adding character set information
	if(usePageCharset){xecure_url += "&charset=" + document.charset;}

	if ( link.target == "" || link.target == null ){open ( xecure_url, "_self" );} else {open( xecure_url, link.target );}
	return false;
}

/**
 * @since XecureWeb 6.0 v220
 */
function XecureLink_Env( link )
{
	var qs ;
// var path = "/";
	var cipher;


	// get path info & query string from action url

	if ( link.protocol != "http:" ) {
		// alert ( "http 프로토콜만 사용 가능합니다." );
		return true;
	}

	qs = link.search;
	if ( qs.length > 1 ) {
		qs = link.search.substring(1);
	}

	hash = link.hash;

	if( gIsContinue == 0 ) {
		path = XecurePath(link.pathname) ;
		gIsContinue = 1;
		// cipher = document.XecureWeb.BlockEnc(xgate_addr, path,
		// XecureEscape(qs),"GET");
		cipher = EnvelopData(XecureEscape(qs), "", serverCert, 1);
		gIsContinue = 0;
	}
	else {
		alert(busy_info);
		return false;
	}
	if( cipher.length == 0) {
		return XecureWebError() ;
	}

	// link.search = "?q=" + escape_url(cipher);
	// xecure_url = "http://" + link.host + path + hash + "?q=" +
	// escape_url(cipher);
	xecure_url = "http://" + link.host + path + hash + "?eq=" + escape_url(cipher);

	// adding character set information
	if(usePageCharset){xecure_url += "&charset=" + document.charset;}

	if ( link.target == "" || link.target == null ){open ( xecure_url, "_self" );} else {open( xecure_url, link.target );}
	return false;
}

function XecureSubmit( form )
{
	var qs ;
	var path ;
	var cipher;

	qs_begin_index = form.action.indexOf('?');

	// if action is relative url, get base url from window location
	path = getPath(form.action)
	// get path info & query string & hash from action url
	if ( qs_begin_index < 0 ) {
		qs = "";
	}
	else {
		qs = form.action.substring(qs_begin_index + 1, form.action.length );
	}
	document.xecure.target = form.target;

	if ( form.method == "get" || form.method=="GET" ) {
		// collect input field values
		// qs = XecureMakePlain( form );
		if(qs.length!=0){qs += "&"+XecureMakePlain( form );} else {qs = XecureMakePlain( form );}

		// encrypt QueryString
		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			if( IsNetscape60() ){cipher = document.XecureWeb.nsIXecurePluginInstance.BlockEnc(xgate_addr, path, XecureEscape(qs),"GET");}else{
				cipher = document.XecureWeb.BlockEnc(xgate_addr, path, XecureEscape(qs),"GET");
			}
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}

		if( cipher == "" ) {
			return XecureWebError() ;
		}

		xecure_url = path + "?q=" + escape_url(cipher);
		// adding character set information
		if(usePageCharset){xecure_url += "&charset=" + document.charset;}

		if ( form.target == "" || form.target == null ){open( xecure_url, "_self");} else {open ( xecure_url, form.target );}
	}
	else {
		document.xecure.method = "post";

		// encrypt QueryString of action field
		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			if( IsNetscape60() ){cipher = document.XecureWeb.nsIXecurePluginInstance.BlockEnc(xgate_addr, path, XecureEscape(qs),"GET");}else {
				cipher = document.XecureWeb.BlockEnc(xgate_addr, path, XecureEscape(qs),"GET");
			}
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}


		if( cipher == "" ) {
			return XecureWebError() ;
		}

		document.xecure.action = path + "?q=" + escape_url(cipher);
		// adding character set information
		if(usePageCharset){document.xecure.action += "&charset=" + document.charset;}

		posting_data = XecureMakePlain( form );

		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			if( IsNetscape60() ){cipher = document.XecureWeb.nsIXecurePluginInstance.BlockEnc ( xgate_addr, path, XecureEscape(posting_data), "POST" );}else{
				cipher = document.XecureWeb.BlockEnc ( xgate_addr, path, XecureEscape(posting_data), "POST" );
			}
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}

		if( cipher == "" ) {
			return XecureWebError() ;
		}

		document.xecure.p.value = cipher;
		document.xecure.submit();
	}
	return false;
}

/**
 * @since XecureWeb 6.0 v220
 */
function XecureSubmit_Env( form )
{
	var qs ;
	var path ;
	var cipher;

	qs_begin_index = form.action.indexOf('?');

	// if action is relative url, get base url from window location
	path = getPath(form.action)
	// get path info & query string & hash from action url
	if ( qs_begin_index < 0 ) {
		qs = "";
	}
	else {
		qs = form.action.substring(qs_begin_index + 1, form.action.length );
	}
	document.xecure.target = form.target;

	if ( form.method == "get" || form.method=="GET" ) {
		// collect input field values
		if(qs.length!=0){qs += "&"+XecureMakePlain( form );} else {qs = XecureMakePlain( form );}

		// encrypt QueryString
		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			// cipher = document.XecureWeb.BlockEnc(xgate_addr, path,
			// XecureEscape(qs),"GET");
			cipher = EnvelopData(XecureEscape(qs), "", serverCert, 1);
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}

		if( cipher == "" ) {
			return XecureWebError() ;
		}

		// xecure_url = path + "?q=" + escape_url(cipher);
		xecure_url = path + "?eq=" + escape_url(cipher);

		// adding character set information
		if(usePageCharset){xecure_url += "&charset=" + document.charset;}

		if ( form.target == "" || form.target == null ){open( xecure_url, "_self");} else {open ( xecure_url, form.target );}
	}
	else {
		document.xecure.method = "post";

		// encrypt QueryString of action field
		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			// cipher = document.XecureWeb.BlockEnc(xgate_addr, path,
			// XecureEscape(qs),"GET");
			cipher = EnvelopData(XecureEscape(qs), "", serverCert, 1);
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}


		if( cipher == "" ) {
			return XecureWebError() ;
		}

		// document.xecure.action = path + "?q=" + escape_url(cipher);
		document.xecure.action = path + "?eq=" + escape_url(cipher);
		// adding character set information
		if(usePageCharset){document.xecure.action += "&charset=" + document.charset;}

		posting_data = XecureMakePlain( form );

		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			// cipher = document.XecureWeb.BlockEnc ( xgate_addr, path,
			// XecureEscape(posting_data), "POST" );
			cipher = EnvelopData(XecureEscape(posting_data), "", serverCert, 1);
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}

		if( cipher == "" ) {
			return XecureWebError() ;
		}

		// document.xecure.p.value = cipher;
		document.xecure.ep.value = cipher;
		document.xecure.submit();
	}
	return false;
}

function XecureMakePlain_Org(form)
{
	var name = new Array(form.elements.length);
	var value = new Array(form.elements.length);
	var flag = false;
	var j = 0;
	var plain_text="";
	var enable=false;// for softcamp

	// for softcamp
	if(document.secukey==null || typeofdocument.secukey == "undefined" || document.secukey.object==null) {
		enable=false;
	}
	else {
		enable=secukey.GetSecuKeyEnable();
	}


	len = form.elements.length;
	for (i = 0; i < len; i++) {
		if (form.elements[i].type != "button" && form.elements[i].type != "reset" && form.elements[i].type != "submit") {
			if (form.elements[i].type == "radio" || form.elements[i].type == "checkbox") { // Leejh 99.11.10 checkbox추가
				if (form.elements[i].checked == true) {
					name[j] = form.elements[i].name;
					value[j] = form.elements[i].value;
					j++;
				}
			}
			// for softcamp
			else if(enable && form.elements[i].type == "password"){
				if(form.elements[i].type == "password"){
					name[j] = form.elements[i].name;
					value[j] = secukey.GetRealPass(form.elements[i].name,form.elements[i].value);
					j++;
				}
			}
			else {
				name[j] = form.elements[i].name;
				if (form.elements[i].type == "select-one") {
					var ind = form.elements[i].selectedIndex;
					if (form.elements[i].options[ind].value != ''){value[j] = form.elements[i].options[ind].value;} else {value[j] = form.elements[i].options[ind].text;
// form.elements[i].selectedIndex = 0;
}
				}
				else {
					value[j] = form.elements[i].value;
				}
				j++;
			}
		}
	}
	for (i = 0; i < j; i++) {
		str = value[i];
		value[i] = escape_url(str);
	}

	for (i = 0; i < j; i++) {
		if (flag){plain_text += "&";} else {flag = true;}
		plain_text += name[i] ;
		plain_text += "=";
		plain_text += value[i];
	}

	return plain_text;
}

function XecureMakePlain(form)	// modified by tiger on 2004/12/22
{
       var name = new Array(form.elements.length);
       var value = new Array(form.elements.length);
       var flag = false;
       var j = 0;
       var plain_text="";

       if(document.NPKXSite == null || typeof(document.NPKXSite) == "undefined" || document.NPKXSite.object == null){
   			enable = false;
	   	}else{
	   		enable = true;
	   	}
       var enc_xgate;
	   	if(document.XecureWeb.GetVerInfo(0) >= '7, 2, 1, 7'){
	   	    enc_xgate = document.XecureWeb.GetEncUserData(xgate_addr);
	   	} else {
	        enc_xgate = xgate_addr;
	   	}

       len = form.elements.length;
       for (i = 0; i < len; i++) {
                    if (form.elements[i].type != "button" && form.elements[i].type != "reset" && form.elements[i].type != "submit") {
                                 if (form.elements[i].type == "radio" || form.elements[i].type == "checkbox") {
                                              if (form.elements[i].checked == true) {
                                                if (form.elements[i].disabled == false) {
                                                          name[j] = form.elements[i].name;
                                                          value[j] = form.elements[i].value;
                                                          j++;
                                                }
                                              }
                                 }else if(enable && (form.elements[i].type == "text")){
                                	 if (form.elements[i].npkencrypt == "on")
                                     {

                                     	name[j] = "xk"+form.elements[i].name;
                                     	value[j] = document.NPKXSite.GetXKData(form.elements[i].name);
                                     	// E2E 디버깅 시 주석 제거
                                     	//alert(name[j] + " : " +	value[j]);
                                     	j++;
                                     }else{
										name[j] = form.elements[i].name;
                                        value[j] = form.elements[i].value;
                                        j++
									 }
                                 }
                                 else if(enable && form.elements[i].type == "password"){
                                              if(form.elements[i].type == "password"){
                                                    name[j] = "xk" + form.elements[i].name;
                                                    value[j] = document.NPKXSite.GetXKData(form.elements[i].name);
                                                    // E2E 디버깅 시 주석 제거
                                                    //alert(name[j] + " : " +	value[j]);
                                                    j++;
                                              }
                                 }
                                 else {
                                              name[j] = form.elements[i].name;
                                              if (form.elements[i].type == "select-one") {
                                                            var ind = form.elements[i].selectedIndex;
                                                            var op_len = form.elements[i].length;
                                                if (op_len > 0) {
                                                          if(ind > 0) {
                                                                     if (form.elements[i].options[ind].value != ''){value[j] = form.elements[i].options[ind].value;} else {// value[j] = form.elements[i].options[ind].text;
																	   value[j] = "";}
                                                          } else {
                                                                     if(ind == 0)
                                                                     {
                                                                               if (form.elements[i].options[ind].value != ''){value[j] = form.elements[i].options[ind].value;} else {// value[j] = form.elements[i].options[ind].text;
																			  value[j] = "";}
                                                                     }
                                                          }
                                                          // form.elements[i].selectedIndex = 0;
                                                }
                                     }
                                     else if (form.elements[i].type == "select-multiple") {
                                                var llen = form.elements[i].length;
                                                var increased = 0;
                                                for( k = 0; k < llen; k++) {
                                                          if (form.elements[i].options[k].selected) {
                                                                     name[j] = form.elements[i].name;
                                                                     if (form.elements[i].options[k].value != ''){value[j] = form.elements[i].options[k].value;} else {// value[j] = form.elements[i].options[k].text;
																	   value[j] = "";}
                                                                     j++;
                                                                     increased++;
                                                          }
                                                }
                                                if(increased > 0) {
                                                          j--;
                                                }
                                                else {
                                                          value[j] = "";
                                                }
                                     }
                                     else {
                                                value[j] = form.elements[i].value;
                                     }
                                     j++;
                          }
                }
     }

       for (i = 0; i < j; i++) {
                    str = value[i];
                    value[i] = escape_url(str);
       }

       for (i = 0; i < j; i++) {
                    if (flag){plain_text += "&";} else {flag = true;}
                    plain_text += name[i] ;
                    plain_text += "=";
                    if (value[i] !="undefined"){
                                 plain_text += value[i];
                    }else {
                                 plain_text += "";
                    }
       }
		//	alert("plain : " + plain_text);
       return plain_text;
}

/*
function XecureMakePlain(form)	// modified by tiger on 2004/12/22
{
       var name = new Array(form.elements.length);
       var value = new Array(form.elements.length);
       var flag = false;
       var j = 0;
       var plain_text="";


       // for softcamp
       if(document.secukey==null || typeofdocument.secukey == "undefined" || document.secukey.object==null) {
                    enable=false;
       }
       else {
                    enable=secukey.GetSecuKeyEnable();
       }

       len = form.elements.length;
       for (i = 0; i < len; i++) {
                    if (form.elements[i].type != "button" && form.elements[i].type != "reset" && form.elements[i].type != "submit") {
                                 if (form.elements[i].type == "radio" || form.elements[i].type == "checkbox") {
                                              if (form.elements[i].checked == true) {
                                                if (form.elements[i].disabled == false) {
                                                          name[j] = form.elements[i].name;
                                                          value[j] = form.elements[i].value;
                                                          j++;
                                                }
                                              }
                                 }
                                 // for softcamp
                                 else if(enable && form.elements[i].type == "password"){
                                              if(form.elements[i].type == "password"){
                                                            name[j] = form.elements[i].name;
                                                            value[j] = secukey.GetRealPass(form.elements[i].name,form.elements[i].value);
                                                            j++;
                                              }
                                 }
                                 else {
                                              name[j] = form.elements[i].name;
                                              if (form.elements[i].type == "select-one") {
                                                            var ind = form.elements[i].selectedIndex;
                                                            var op_len = form.elements[i].length;
                                                if (op_len > 0) {
                                                          if(ind > 0) {
                                                                     if (form.elements[i].options[ind].value != ''){value[j] = form.elements[i].options[ind].value;} else {// value[j] = form.elements[i].options[ind].text;
																	   value[j] = "";}
                                                          } else {
                                                                     if(ind == 0)
                                                                     {
                                                                               if (form.elements[i].options[ind].value != ''){value[j] = form.elements[i].options[ind].value;} else {// value[j] = form.elements[i].options[ind].text;
																			  value[j] = "";}
                                                                     }
                                                          }
                                                          // form.elements[i].selectedIndex = 0;
                                                }
                                     }
                                     else if (form.elements[i].type == "select-multiple") {
                                                var llen = form.elements[i].length;
                                                var increased = 0;
                                                for( k = 0; k < llen; k++) {
                                                          if (form.elements[i].options[k].selected) {
                                                                     name[j] = form.elements[i].name;
                                                                     if (form.elements[i].options[k].value != ''){value[j] = form.elements[i].options[k].value;} else {// value[j] = form.elements[i].options[k].text;
																	   value[j] = "";}
                                                                     j++;
                                                                     increased++;
                                                          }
                                                }
                                                if(increased > 0) {
                                                          j--;
                                                }
                                                else {
                                                          value[j] = "";
                                                }
                                     }
                                     else {
                                                value[j] = form.elements[i].value;
                                     }
                                     j++;
                          }
                }
     }

       for (i = 0; i < j; i++) {
                    str = value[i];
                    value[i] = escape_url(str);
       }

       for (i = 0; i < j; i++) {
                    if (flag){plain_text += "&";} else {flag = true;}
                    plain_text += name[i] ;
                    plain_text += "=";
                    if (value[i] !="undefined"){
                                 plain_text += value[i];
                    }else {
                                 plain_text += "";
                    }
       }

       return plain_text;
}

*/

/** ***********For Applet********************* */
function BlockEnc(auth_type,plain_text)
{
	var cipher = "";

	if( IsNetscape60() ){cipher =  XecureUnescape(document.XecureWeb.nsIXecurePluginInstance.BlockEnc(xgate_addr,auth_type,plain_text,"GET"));} else {cipher =  XecureUnescape(document.XecureWeb.BlockEnc(xgate_addr,auth_type,plain_text,"GET"));}

	if( cipher == "" ){XecureWebError() ;}

	return cipher;
}

function BlockDec(cipher)
{
	var plain = "";

	if( IsNetscape60() ){plain = XecureUnescape(document.XecureWeb.nsIXecurePluginInstance.BlockDec( xgate_addr, cipher));}else {
		plain = XecureUnescape(document.XecureWeb.BlockDec( xgate_addr, cipher));
	}

	if( plain == "" ){XecureWebError() ;}

	return plain;
}

function BlockXMLDec(cipher)
{
	var path = "";

	if( IsNetscape60() ){path = XecureUnescape(document.XecureWeb.nsIXecurePluginInstance.BlockXMLDec( xgate_addr, cipher));} else {path = XecureUnescape(document.XecureWeb.BlockXMLDec( xgate_addr, cipher));}

	if( path == "" ){XecureWebError() ;}

	return path;
}

function XecureLogIn( link )
{
	EndSession();
	return XecureLink(link);
}

function EndSession()
{
	if( IsNetscape60() ){document.XecureWeb.nsIXecurePluginInstance.EndSession( xgate_addr );} else {document.XecureWeb.EndSession(xgate_addr);}
}

// XecureWeb ver 4.1 add
// option : 0 : no confirm window, all certificates
// option : 1 : confirm window, all certificates
// option : 2 : no confirm window, log-on certificate only
// option : 3 : confirm window, log-on certificate only

function Sign_with_option( option, plain )
{
    PutBannerUrl();

	var signed_msg;

	if( IsNetscape60() ){signed_msg = document.XecureWeb.nsIXecurePluginInstance.SignDataCMS( xgate_addr,
						escape(accept_cert),
						escape(plain),
						option,
						escape(sign_desc),
						pwd_fail);} else {signed_msg = document.XecureWeb.SignDataCMS(
						xgate_addr,
						XecureEscape(accept_cert),
						XecureEscape(plain),
						option,
						XecureEscape(sign_desc),
						pwd_fail);}

    if( signed_msg == "" ){XecureWebError();}

    return signed_msg;
}

function Sign_Add( option, plain )
{
    PutBannerUrl();

	var signed_msg;

	signed_msg = document.XecureWeb.SignDataAdd ( xgate_addr, accept_cert, plain, option, sign_desc, pwd_fail );

    if( signed_msg == "" ){XecureWebError() ;}

    return signed_msg;
}

function Sign( plain )
{
    PutBannerUrl();

	var signed_msg;

	if( IsNetscape60() )		// Netscape 6.0
	{
		signed_msg = document.XecureWeb.nsIXecurePluginInstance.SignDataCMS( xgate_addr, XecureEscape(accept_cert), XecureEscape(plain), show_plain, XecureEscape(sign_desc) );
	}
	else
	{
		signed_msg = document.XecureWeb.SignDataCMS( xgate_addr, XecureEscape(accept_cert), XecureEscape(plain), show_plain, XecureEscape(sign_desc) );
	}

	if( signed_msg == "" ){XecureWebError() ;}

	return signed_msg;
}

function Sign_with_desc( plain, desc )
{
	var signed_msg;

	if( IsNetscape60() ){signed_msg = document.XecureWeb.nsIXecurePluginInstance.SignDataCMS( xgate_addr, XecureEscape(accept_cert), XecureEscape(plain), show_plain, XecureEscape(desc) );} else {signed_msg = document.XecureWeb.SignDataCSM( xgate_addr, XecureEscape(accept_cert), XecureEscape(plain), show_plain, XecureEscape(desc) );}

	if( signed_msg == "" ){XecureWebError() ;}

	return signed_msg;
}

// XecureWeb ver 4.1 add
// option : 0 : no confirm window, all certificates
// option : 1 : confirm window, all certificates
// option : 2 : no confirm window, log-on certificate only
// option : 3 : confirm window, log-on certificate only

// XecureWeb ver 5.0 add

function Sign_with_vid_user( option, plain, svrCert )
{
    PutBannerUrl();

	var signed_msg;

	option = option + 4;

	if(IsNetscape())
	{
		alert("Not supported function");
	}
	else {
		signed_msg = document.XecureWeb.SignDataWithVID ( xgate_addr, accept_cert, plain, svrCert, option, sign_desc, pwd_fail );
	}

    if( signed_msg == "" ){XecureWebError();}

    return signed_msg;
}

function Sign_with_vid_web( option, plain, svrCert, idn )
{
    PutBannerUrl();

	var ret;
	var signed_msg;

	option = option + 12;

	if(IsNetscape())
	{
		alert("Not supported function");
	}
	else {
		ret = Set_ID_Num(idn);
		if(ret != 0) {
			XecureWebError();
			return signed_msg;
		}

		signed_msg = document.XecureWeb.SignDataWithVID ( xgate_addr, accept_cert, plain, svrCert, option, sign_desc, pwd_fail );
	}

    if( signed_msg == "" ){XecureWebError();}

    return signed_msg;
}

// only over XecureWeb Client v5.3.0.1
// [certLocation]
// 0 : HARD
// 1 : REMOVABLE
// 2 : ICCARD
// 3 : CSP
// 4 : VSC
// [option]
// 0 : 서명원문 확인창 없음
// 1 : 서명원문 확인창 띄움
function Sign_with_vid_user_serial( certSerial, certLocation, option, plain, svrCert )
{
    PutBannerUrl();

	var signed_msg;

	option = option + 4;

	if(IsNetscape())
	{
		alert("Not supported function");
	}
	else {
		signed_msg = document.XecureWeb.SignDataWithVID_Serial ( xgate_addr, accept_cert, certSerial, certLocation, plain, svrCert, option, sign_desc, pwd_fail );
	}

    if( signed_msg == "" ){XecureWebError();}

    return signed_msg;
}

// only over XecureWeb Client v5.3.0.1
// [certLocation]
// 0 : HARD
// 1 : REMOVABLE
// 2 : ICCARD
// 3 : CSP
// 4 : VSC
// [option]
// 0 : 서명원문 확인창 없음
// 1 : 서명원문 확인창 띄움
function Sign_with_vid_web_serial( certSerial, certLocation, option, plain, svrCert, idn )
{
    PutBannerUrl();

	var ret;
	var signed_msg;

	option = option + 12;

	if(IsNetscape())
	{
		alert("Not supported function");
	}
	else {
		ret = Set_ID_Num(idn);
		if(ret != 0) {
			XecureWebError();
			return signed_msg;
		}

		signed_msg = document.XecureWeb.SignDataWithVID_Serial ( xgate_addr, accept_cert, certSerial, certLocation, plain, svrCert, option, sign_desc, pwd_fail );
	}

    if( signed_msg == "" ){XecureWebError();}

    return signed_msg;
}

function Set_ID_Num(idn)
{
	var ret;

	if( IsNetscape() )
	{
		alert("Not supported function");
	}
	else
	{
		ret = document.XecureWeb.SetIDNum(idn);
	}

	return ret;
}

function send_vid_info()
{
	var	vid_info;

	if( IsNetscape() )
	{
		alert("Not supported function");
	}
	else
	{
		vid_info = document.XecureWeb.GetVidInfo();
	}

	if(vid_info.length == 0) {
		return null;
	} else {
		return vid_info;
	}
}

// only over XecureWeb Client v5.3.0.1
// [certLocation]
// 0 : HARD
// 1 : REMOVABLE
// 2 : ICCARD
// 3 : CSP
// 4 : VSC
// [option]
// 0 : 서명원문 확인창 없음
// 1 : 서명원문 확인창 띄움
function Sign_with_serial( certSerial, certLocation, plain, option )
{
	var	signed_msg;

	if( IsNetscape() )
	{
		alert("Not supported function");
	}
	else
	{
		signed_msg = document.XecureWeb.SignDataCMSWithSerial(  xgate_addr,
									XecureEscape(accept_cert),
									certSerial,
									certLocation,
									plain,
									option,
									XecureEscape(sign_desc),
									pwd_fail );
	}

	if( signed_msg == "" ){XecureWebError();}

	return signed_msg;
}

//
// only over XecureWeb Client v5.4.x
//
// !!! This function need site/executable license !!!
//
// [option]
// 0 : only signature verification( NOT perform cert verification )
// 1 : signature verification + default cert verification
// 2 : + cert chain check
// 3 : + CRL check
// 4 : + LDAP
// [directoryServer]
// ex) dirsys.rootca.or.kr:389 or ""
//
function Verify_SignedData( signedData, option, directoryServer )
{
	var	verified_msg;
	var	errCode;

	if( IsNetscape() )
	{
		alert("Not supported function");
		return "";
	}
	else
	{
		verified_msg = document.XecureWeb.VerifySignedData( signedData, option, directoryServer );
	}

	// VerifySignedData는 인증서 검증시 오류가 발생하더라도 원문 추출이 성공하면 원문을 리턴하기 때문에
	// 반드시 LastErrCode를 확인해야 한다.
	errCode = document.XecureWeb.LastErrCode();
	if( errCode != 0 ){XecureWebError();}

	return verified_msg;
}

//
// only over XecureWeb Client v5.4.x
//
// applicable cert location : usbtoken_kb, usbtoken_kiup
//
function Set_PinNumber( pin )
{
	var	ret = -1;

	if( IsNetscape() )
	{
		alert("Not supported function");
	}
	else
	{
		 ret = document.XecureWeb.SetPinNum( pin );
	}

	return ret;
}

// type 10 : YessignCA
// type 11 : XecureCA
function RequestCertificate ( type, ref_code, auth_code )
{
	var r;
	var ca_type;
	var ca_ip;
	var ca_port;

	if(type == 10) {
		ca_type = yessign_ca_type;
		ca_ip = yessign_ca_ip;
		ca_port = yessign_ca_port;
	}
	else if(type == 11) {
		ca_type = xecure_ca_type;
		ca_ip = xecure_ca_ip;
		ca_port = xecure_ca_port;
	}
	else if(type == 12) {
		ca_type = xecure_ca_type_1;
		ca_ip = xecure_ca_ip_1;
		ca_port = xecure_ca_port_1;
	}
	else {
		alert("Input type error!");
		return 0;
	}

	if(IsNetscape())
	{
		if( IsNetscape60() ){r = document.XecureWeb.nsIXecurePluginInstance.RequestCertificate2 ( ca_port, ca_ip, ref_code, auth_code, ca_type );} else {r = document.XecureWeb.RequestCertificate2 ( ca_port, ca_ip, ref_code, auth_code, ca_type );}
	}
	else
	{
		r = document.XecureWeb.RequestCertificate ( ca_port, ca_ip, ref_code, auth_code, ca_type);
	}

	if ( r != 0 ){XecureWebError();}

	return r;
}

// type 00 : YessignCA
// type 11 : XecureCA
function RenewCertificate ( type )
{
	var r;
	var ca_type;
	var ca_ip;
	var ca_port;

	if(type == 10) {
		ca_type = yessign_ca_type;
		ca_ip = yessign_ca_ip;
		ca_port = yessign_ca_port;
	}
	else if(type == 11) {
		ca_type = xecure_ca_type;
		ca_ip = xecure_ca_ip;
		ca_port = xecure_ca_port;
	}
	else if(type == 12) {
		ca_type = xecure_ca_type_1;
		ca_ip = xecure_ca_ip_1;
		ca_port = xecure_ca_port_1;
	}
	else {
		alert("Input type error!");
		return 0;
	}

	if(IsNetscape())
	{
		if( IsNetscape60() ){r = document.XecureWeb.nsIXecurePluginInstance.RenewCertificate2( ca_port, ca_ip, ca_type, pwd_fail );} else {r = document.XecureWeb.RenewCertificate2( ca_port, ca_ip, ca_type, pwd_fail );}
	}
	else{
		r = document.XecureWeb.RenewCertificate ( ca_port, ca_ip, ca_type, pwd_fail );
	}

	if ( r != 0 ){XecureWebError();}

	return r;
}

// type 00 : YessignCA
// type 11 : XecureCA
function RevokeCertificate ( type, jobcode, reason )
{
	var r;
	var ca_type;
	var ca_ip;
	var ca_port;

	if(type == 10) {
		ca_type = yessign_ca_type;
		ca_ip = yessign_ca_ip;
		ca_port = yessign_ca_port;
	}
	else if(type == 11) {
		ca_type = xecure_ca_type;
		ca_ip = xecure_ca_ip;
		ca_port = xecure_ca_port;
	}
	else if(type == 12) {
		ca_type = xecure_ca_type_1;
		ca_ip = xecure_ca_ip_1;
		ca_port = xecure_ca_port_1;
	}
	else {
		alert("Input type error!");
		return 0;
	}

	if(IsNetscape())
	{
		if( IsNetscape60() ){r = document.XecureWeb.nsIXecurePluginInstance.RevokeCertificate2( ca_port, ca_ip, jobcode, reason, ca_type, pwd_fail );} else {r = document.XecureWeb.RevokeCertificate2( ca_port, ca_ip, jobcode, reason, ca_type,  pwd_fail);}
	}
	else {
		r = document.XecureWeb.RevokeCertificate ( ca_port, ca_ip, jobcode, reason, ca_type, pwd_fail );
	}

        if ( r != 0 ){XecureWebError();}

	return r;
}

function GenCertReq ( )
{
	if( IsNetscape60() ){cert_req = document.XecureWeb.nsIXecurePluginInstance.GenerateCertReq( 1024 );} else {cert_req = document.XecureWeb.GenerateCertReq( 1024 );}

	if ( cert_req == "" ){XecureWebError() ;}

	return cert_req;
}

function InstallCertificate (cert_type, cert)
{
	if( IsNetscape60() ){document.XecureWeb.nsIXecurePluginInstance.InstallCertificate(cert_type, cert );} else {document.XecureWeb.InstallCertificate(cert_type, cert );}
}

function ShowCertManager()
{
	if( IsNetscape60() ){document.XecureWeb.nsIXecurePluginInstance.ShowCertManager();} else {document.XecureWeb.ShowCertManager();}
}

function DeleteCertificate( dn )
{
	var r;

	if( IsNetscape60() ){r = document.XecureWeb.nsIXecurePluginInstance.DeleteCertificate( XecureEscape(dn) );} else {r = document.XecureWeb.DeleteCertificate ( XecureEscape(dn) );}

	if( r != 0 ){XecureWebError() ;} else {alert('인증서를 삭제하였습니다.');}
}

function PutBannerUrl()
{
	if( IsNetscape60() )		// Netscape 6.0
	{
		document.XecureWeb.nsIXecurePluginInstance.PutBigBannerUrl( xgate_addr, bannerUrl);
	}
	else
	{
		document.XecureWeb.PutBigBannerUrl( xgate_addr, bannerUrl);
	}
}

function PutCACert()
{
	var r ;

	if( IsNetscape60() ){r = document.XecureWeb.nsIXecurePluginInstance.PutCACert( XecureEscape(pCaCertName), pCaCertUrl);} else {r = document.XecureWeb.PutCACert( XecureEscape(pCaCertName), pCaCertUrl);}

	if( r != 0 ){XecureWebError() ;}
}

function isNewPlugin(desc)
{
	index = desc.indexOf('v.', 0);
	if (index < 0) {
		return false;
	}
	desc += ' ';

	versionString = desc.substring(index +2, desc.length);
	arrayOfStrings = versionString.split('.');
	thisMajor = parseInt(arrayOfStrings[0], 10);
	thisMinor = parseInt(arrayOfStrings[1], 10);
	thisBuild = parseInt(arrayOfStrings[2], 10);

	if (thisMajor > versionMaj) {
		return true;
	}
	if (thisMajor < versionMaj) {
		return false;
	}

	if (thisMinor > versionMin) {
		return true;
	}
	if (thisMinor < versionMin) {
		return false;
	}

	if (thisBuild > versionRel) {
		return true;
	}
	if (thisBuild < versionRel) {
		return false;
	}

	return true;
}

function downloadNow () {
	if ( navigator.javaEnabled() ) {
		trigger = netscape.softupdate.Trigger;
		if ( trigger.UpdateEnabled() ) {
			if (navigator.platform == "Win32") {
				trigger.StartSoftwareUpdate( packageURL, trigger.DEFAULT_MODE);
			} else {alert('이 플러그 인은 윈도우즈 95/98/NT 환경에서만 작동합니다.')
}		} else {alert('넷스케입의 SmartUpdate 설치를 가능하도록 해야합니다.');}
	} else {alert('Java 실행을 가능하도록 해야합니다.');}
}

function isOldPlugin(desc,version)	// by Zhang
{
	index = desc.indexOf('v.', 0);
	if (index < 0) {
		return true;
	}

	desc += ' ';
	versionString = desc.substring(index +2, desc.length);
	arrayOfStrings = versionString.split('.');
	thisMaj = parseInt(arrayOfStrings[0], 10);
	thisMin = parseInt(arrayOfStrings[1], 10);
	thisRel = parseInt(arrayOfStrings[2], 10);

	arrayOfStrings = version.split('.');
// verMaj = parseInt(arrayOfStrings[0], 10);
// verMin = parseInt(arrayOfStrings[1], 10);
// verRel = parseInt(arrayOfStrings[2], 10);
	s_verMaj = parseInt(arrayOfStrings[0], 10);
	s_verMin = parseInt(arrayOfStrings[1], 10);
	s_verRel = parseInt(arrayOfStrings[2], 10);

	if (thisMaj > s_verMaj) {
		return false;
	}
	if (thisMaj < s_verMaj) {
		return true;
	}

	if (thisMin > s_verMin) {
		return false;
	}
	if (thisMin < s_verMin) {
		return true;
	}

	if (thisRel > s_verRel) {
		return false;
	}
	if (thisRel < s_verRel) {
		return true;
	}

	return false;
}

function DownloadPackage(packageURL) // by Zhang
{
	if ( navigator.javaEnabled() ) {
		trigger = netscape.softupdate.Trigger;
		if ( trigger.UpdateEnabled() ) {
			if (navigator.platform == "Win32") {
				trigger.StartSoftwareUpdate( packageURL, trigger.DEFAULT_MODE);
			} else {alert('이 플러그 인은 윈도우즈 95/98/NT 환경에서만 작동합니다.');}
		} else {alert('넷스케입의 SmartUpdate 설치를 가능하도록 해야합니다.');}
	} else {alert('Java 실행을 가능하도록 해야합니다.');}
}

function XecureWebPlugin(version)	// by Zhang
{
	if (navigator.appName == 'Netscape' && UserAgent() == "Mozilla/4")
	{
  		var XecureMime = navigator.mimeTypes["application/x-SoftForum-XecSSL40"];
		if (XecureMime) {   // Xecure PlugIn 이 이미 설치되어 있는 경우
			if ( isOldPlugin(XecureMime.enabledPlugin.description,version)){DownloadPackage(packageURL);}
		}
		else {     // Xecure PlugIn 이 설치되어 있지 않은 경우
			DownloadPackage(packageURL);
		}
	}
}

function PrintObjectTag()
{
	if( IsNetscape60() ){alert("Netscape 6.0은 지원하지 않습니다") ;}else
	{
		if(navigator.appName == 'Netscape')
		{
			document.write("<EMBED type='application/x-SoftForum-XecSSL40' hidden=true name='XecureWeb'></EMBED><NOEMBED>No XecureWeb PlugIn</NOEMBED>");
		}
		else
		{
			if( checkIE8() == 1 )
			{
				document.write('<OBJECT ID="XecureWeb" CLASSID="CLSID:7E9FDB80-5316-11D4-B02C-00C04F0CD404" CODEBASE="http://download.softforum.co.kr/Published/XecureWeb/v7.2.2.5/xw_install.cab#Version=7,2,2,5" width=0 height=0><PARAM NAME="STORAGE" VALUE="HARD,REMOVABLE,ICCARD,PKCS11"><param name="lang" value="korean">No XecureWeb PlugIn</OBJECT>');
			}else{
				document.write('<OBJECT ID="XecureWeb" CLASSID="CLSID:7E9FDB80-5316-11D4-B02C-00C04F0CD404" CODEBASE="http://download.softforum.co.kr/Published/XecureWeb/v7.2.2.7/xw_install.cab#Version=7,2,2,7" width=0 height=0><PARAM NAME="STORAGE" VALUE="HARD,REMOVABLE,ICCARD,PKCS11"><param name="lang" value="korean">No XecureWeb PlugIn</OBJECT>');
			}
		}
	}
}

function get_sid()
{
	var sid = document.XecureWeb.BlockEnc ( xgate_addr, "", "", "GET" );

	if( sid == "") {
		return XecureWebError() ;
	}

	return sid;
}

// applet에서 servlet으로 보낼 값을 암호화 하는 function
function enc(str) {
	var state='';
	var plain='';
	var escaped_state='';
	plain=String(str);

	if (navigator.appName == 'Netscape'){state=XecureWeb.BlockEnc(xgate_addr, path, escape(plain), "POST");} else {state=XecureWeb.BlockEnc(xgate_addr, path, plain, "POST");}
   	// escaped_state=escape_url(state);
   	escaped_state=escape_url_applet(state);
// alert("POST:" + escaped_state);
	return escaped_state;
}

// servlet에서 applet으로 보내준 값을 복호화 하는 function
function dec(str) {
	var result=BlockDec(str);
	return result;
}

function XecureNavigate2iframe( url, target, feature, sid)
{
	var qs ;
	var path = "/";
	var cipher;
	var xecure_url;

	path = getPath(url);

	cipher = document.XecureWeb.BlockEnc(xgate_addr, path, XecureEscape(qs),"POST");

	if( cipher.length == 0 ) {
		return XecureWebError() ;
	}

	xecure_url = path + "?q=" + sid + ";" + escape_url(cipher);
	if (feature=="" || feature==null){open ( xecure_url, target );} else {open(xecure_url, target, feature );}
}

function getPath(url)
{
	var path = "/";
	// get path info & query string & hash from url
	qs_begin_index = url.indexOf('?');
	// if action is relative url, get base url from window location
	if ( url.charAt(0) != '/' && url.substring(0,7) != "http://" ) {
		path_end = window.location.href.indexOf('?');
		if(path_end < 0){path_end_str = window.location.href;} else {path_end_str = window.location.href.substring(0,path_end);}
		path_relative_base_end = path_end_str.lastIndexOf('/');
		path_relative_base_str = path_end_str.substring(0,path_relative_base_end+1);
		path_begin_index = path_relative_base_str.substring (7,path_relative_base_str.length).indexOf('/');
		if (qs_begin_index < 0){
			path = path_relative_base_str.substring( 7+path_begin_index,path_relative_base_str.length ) + url;
		}
		else {
			path = path_relative_base_str.substring( 7+path_begin_index,path_relative_base_str.length )
				 + url.substring(0, qs_begin_index );
		}
	}
	else if ( url.substring(0,7) == "http://" ) {
		path_begin_index = url.substring (7, url.length).indexOf('/');
		if (qs_begin_index < 0){
			path = url.substring( path_begin_index + 7, url.length);
		}
		else {
			path = url.substring(path_begin_index + 7, qs_begin_index );
		}
	}
	else if (qs_begin_index < 0){
		path = url;
	}
	else {
		path = url.substring(0, qs_begin_index );
	}
	return path;
}

// option bit : _4_ _3_ _2_ _1_
// | |
// | --- 0 : 모든 인증서 리스트업, 1 : 로그인한 인증서 사용
// ------- 0 : 사용자에게 idn 입력 요구, 1 : idn에 "NULL" setting, 서버에서 idn 설정
function VerifyVirtualID(Idn, TimeStamp, ServerCertPem)
{
	var msg;

	var option = 0;

	option = 0;   // 모든 인증서 리스트업, 사용자에게 idn 입력 요구
// option = 1; // 로그인한 인증서 사용, 사용자에게 idn 입력 요구
// only over XecureWeb Client v5.3.0.1
// option = 2; // 모든 인증서 리스트업, idn에 "NULL" 설정
// option = 3; // 로그인한 인증서 사용, idn에 "NULL" 설정

	if( IsNetscape() )
	{
		msg = document.XecureWeb.VerifyAndGetVID(xgate_addr, ServerCertPem, TimeStamp, escape(accept_cert), option, escape(Idn));
	}
	else
	{
		msg = document.XecureWeb.VerifyAndGetVID(xgate_addr, ServerCertPem, TimeStamp, accept_cert, option, Idn);
	}

	return msg;

}

// nOption is 0 : (default value) File version, which is checked by 'Internet Explorer'
// 1 : Product version
// 2 : File Description
function GetVersion(nOption)
{
	var ver;

	if( IsNetscape() )
	{
		alert("Not supported function");
		ver = "";
	}
	else
	{
		ver = document.XecureWeb.GetVerInfo(nOption);
		if( ver == "" ){alert("No version information");}
	}

	return ver;
}

// only over XecureWeb Client v5.3.0.1
function UpdateModules( infoURL )
{
	var	ret;

	if( IsNetscape() )
	{
		alert("Not supported function");
		ret = 0;
	}
	else
	{
		// success : 0, cancel : 1, file(s) holded : 2, already updated : 3, invalid user : 4, need not : 5
		// error : -1
		ret = document.XecureWeb.UpdateModules( infoURL );
	}

	return	ret;
}

// only over XecureWeb Client v5.3.0.1
function SetUpdateInfo( section, key, value1 )
{
	var	ret;

	if( IsNetscape() )
	{
		alert( "Not supported function" );
		ret = 0;
	}
	else
	{
		ret = document.XecureWeb.SetUpdateInfoString( section, key, value1 );
	}

	return ret;
}

// inserted by knlee 2003/06/10
function SetProviderList()
{
	var	ret;

	// var provName = "TrustedNet Connect 2 Smart Card CSP;Microsoft Base
	// Cryptographic Provider v1.0;Microsoft Enhanced Cryptographic Provider
	// v1.0";
	var	provName = "TrustedNet Connect 2 Smart Card CSP;Keycorp CSP";

	if( IsNetscape() )
	{
		alert("Not supported function");
		return -1;
	}
	else
	{
		ret = document.XecureWeb.SetProvider(provName);
		if( ret != 0 ){alert("Set Provider name is Fail!");}
	}

	return ret;
}

// applet에서 servlet으로 보낼 값을 암호화 하는 function
function enc(str) {
	var state='';
	var plain='';
	var escaped_state='';
// plain=String(str);

	alert("enc : " + str.length);
	if (navigator.appName == 'Netscape'){state=XecureWeb.BlockEnc(xgate_addr, "/off", escape(str), "POST");} else {state=XecureWeb.BlockEnc(xgate_addr, "/off", str, "POST");}
   	// escaped_state=escape_url(state);
// escaped_state=escape_url_applet(state);
   	alert("POST:" + state.length);
	alert("enc end");
	return state;
}

// servlet에서 applet으로 보내준 값을 복호화 하는 function
function dec(str) {
	var result=BlockDec(str);
	return result;
}

// add by softforum 2003.3.12 for CMS +
/*
 * function escape_url_applet(url) { var i, j, pos, k; var out = "";
 *
 * pos = 0; j = -2; k = -2; while (pos > -1) { if(j == -2) j = url.indexOf('+', pos); if(k == -2) k = url.indexOf('=', pos); if(j < 0 && k < 0) break; if ((j < k && j > -1) || (j > -1 && k < 0)) { out += url.substring(pos, j); out += '%2B'; pos = j + 1; j = -2; } else if ((j > k && k > -1) || (k >
 * -1 && j < 0)) { out += url.substring(pos, k); out += '%3D'; pos = k + 1; k = -2; } else pos = -1; } return out; }
 */

function quick_escape(str)
{
	var len, leftlen, cut, i, j, pos, k;
	var out = "", out1 = "", out2 = "";

	len = str.length;
	if(len > 160) {
		leftlen = len/2;
		cut = Math.round(leftlen);
		out1 = quick_escape(str.substring(0, cut));
		out2 = quick_escape(str.substring(cut));
		out = out1 + out2;
	}else {
		pos = 0;
		j = -2;
		k = -2;
		while (pos > -1 && pos < len)
		{
			if(j == -2){j = str.indexOf('+', pos);}
			if(k == -2){k = str.indexOf('=', pos);}
			if(j < 0 && k < 0) {
				out += str.substring(pos);
				break;
			}
			if (j < k && j > -1 || j > -1 && k < 0)
			{
				out += str.substring(pos, j);
				out += '%2B';
				pos = j + 1;
				j = -2;
			}
			else if (j > k && k > -1 || k > -1 && j < 0)
			{
				out += str.substring(pos, k);
				out += '%3D';
				pos = k + 1;
				k = -2;
			}
			else{
				out += str.substring(pos);
				pos = -1;
			}
		}
	}
	return out;
}
function escape_url_applet(in_str)
{
	var len, leftlen, cut;
	var out = "", out1 = "", out2 = "";

	len = in_str.length;

	if(len > 160) {
		leftlen = len/2;
		cut = Math.round(leftlen);
		out1 = quick_escape(in_str.substring(0, cut));
		out2 = quick_escape(in_str.substring(cut));
		out = out1 + out2;
	}else {
		out = quick_escape(in_str);
	}
	alert("escape_url_applet end : " + out.length);
	return out;
}

/*
 * ** valid for only XWebFilCom v5.5.x ***
 *
 * It is possible to combine following option flags [EXCEPTION] - 1,2 cannot be used simultaneously - 4 is valid for only 1
 *
 * envOption = 1 : 인증서기반 전자봉투 = 2 : 패스워드기반 전자봉투 = 4 : 여러 개의 인증서로 전자봉투 = 8 : CMS 타입으로 Envelop = 256 : 로그인한 인증서로 전자봉투
 *
 * return value - success : enveloped message - fail : ""
 */
function EnvelopData( inMsg, pwd, certPem, envOption )
{
	var envMsg;


	envMsg = document.XecureWeb.EnvelopData(
			xgate_addr,
			XecureEscape(accept_cert),
			XecureEscape(inMsg),
			envOption,
			pwd,
			certPem,
			"",
			0,
			"",
			3 );

   	if( envMsg == "" )
   	{
		XecureWebError();
   	}

	return envMsg;
}

function checkIE8()
{
	var rv = -1; // Return value assumes failure

	if (navigator.appName == 'Microsoft Internet Explorer')
 	{
		var ua = navigator.userAgent.toLowerCase();
		if( ua.indexOf('trident/4.0') != -1 )
		{
  			rv = 1;
	  	}
		else
		{
			rv = 0;
		}
	}

 	return rv;
}


/** **************For AJAX*************** */

function XecureAjaxGet(url)
{
    var qs ;
    var path = "/";
    var cipher;
    var xecure_url;

    // get path info & query string & hash from url
    qs_begin_index = url.indexOf('?');
    path = getPath(url)
    // get query string action url
    if ( qs_begin_index < 0 ) {
        qs = "";
    }
    else {
        qs = url.substring(qs_begin_index + 1, url.length );
    }

    if( gIsContinue == 0 ) {
        gIsContinue = 1;

        if( IsNetscape60() )        // Netscape 6.0
            cipher = document.XecureWeb.nsIXecurePluginInstance.BlockEnc(xgate_addr, "/off", XecureEscape(qs), "GET");
        else
            cipher = document.XecureWeb.BlockEnc(xgate_addr, "/off", XecureEscape(qs),"GET");

        gIsContinue = 0;
    }
    else {
        alert(busy_info);
        return false;
    }

    if( cipher == "" )  return XecureWebError();

    xecure_url = path + "?q=" + escape_url(cipher);
    return xecure_url;
}

function XecureAjaxPost(qs)
{
    var qs ;
    var p_value;

    if( gIsContinue == 0 ) {
        gIsContinue = 1;

        if( IsNetscape60() )        // Netscape 6.0
            cipher = document.XecureWeb.nsIXecurePluginInstance.BlockEnc ( xgate_addr, "/off", XecureEscape(qs), "POST" );
        else{
            cipher = document.XecureWeb.BlockEnc ( xgate_addr, "/off", XecureEscape(qs), "POST" );
        }
        gIsContinue = 0;
    }

    else {
        alert(busy_info);
        return false;
    }

    if( cipher == "" )  return XecureWebError() ;

    p_value = "p="+escape_url(cipher);
    return p_value;
}

