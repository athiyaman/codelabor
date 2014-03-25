
//
// XecureWeb SSL Client Java Script ver4 2000.6.20
//
//


/* Test yessign CA IP */
var	ca_ip =  "203.233.91.232";
/* Real yessign CA IP */
//var	ca_ip =  "203.233.91.71";

var ca_port = 4512;
var csm_url;
var accept_cert = "yessign,테스트 인증기관";

// 반드시 호스트 명을 지정할 것 
// var bannerUrl = "http://www.softforum.co.kr/XecureObject/xecure.bmp";
var bannerUrl = "";
var pCaCertUrl= "http://" + window.location.host + "/XecureObject/signed_cacert.bin";
var pCaCertName = "테스트 인증기관";

// 전자서명 창의 메시지
var sign_desc = "";
var show_plain = 1; // 전자서명시 서명원문 창 보기 옵션. 0 : 서명원문 출력 안함, 1 : 서명원문 출력 

// xgate 서버 명:포트 지정 , 포트 생략시 디폴트로 443 포트 사용
var xgate_addr	= window.location.hostname + ":443:8080";

var     packageURL = 'http://' + window.location.host + '/XecureObject/NPXecSSL40_Install.jar';
var     packageName = 'XecureWeb SSL 4.0 Plug-in'
var     updateObjectName = 'XecureWeb SSL 4.0 Plug-in';
var     versionMaj = 4;
var     versionMin = 1;
var     versionRel = 1;
var     versionBld = 20001215;

var xecure_frame = top.xecure;

function process_error ( errCode, errMsg ) {

	alert( "에러코드 : " + errCode + "\n\n" + errMsg );
}

function escape_url(url) {
	var i;
	var ch;
	var out = '';
	var url_string = '';

	url_string = String(url);

	for (i = 0; i < url_string.length; i++) {
		ch = url_string.charAt(i);
		if (ch == ' ')
		    out += '%20';
		else if (ch == '%')
		    out += '%25';
		else if (ch == '&')
		    out += '%26';
		else if (ch == '+')
		    out += '%2B';
		else if (ch == '=')
		    out += '%3D';
		else if (ch == '?')
		    out += '%3F';
		else
		    out += ch;
	}
	return out;
}

function XecureNavigate_NoEnc( url, target ) {

	var qs ;
	var path = "/";
	var cipher;
	var xecure_url;

	var errCode;
	var errMsg = "";

	// get path info & query string & hash from url
	qs_begin_index = url.indexOf('?');

	if ( qs_begin_index < 0 ) {
		qs = "";
		// if action is relative url, get base url from window location  
		if ( url.charAt(0) != '/' && url.substring(0,7) != "http://" ) {
			path_end = window.location.pathname.lastIndexOf('/');
			path = window.location.pathname.substring(0,path_end+1) + url;
		}
		else if ( url.substring(0,7) == "http://" ) {
			path_begin_index = url.substring (7,url.length).indexOf('/');
			path = url.substring( path_begin_index + 7 , url.length);
		}
		else
			path = url;
	}
	else {
		qs = url.substring(qs_begin_index + 1, url.length );
		if ( url.charAt(0) != '/' && url.substring(0,7) != "http://" ) {
			path_end = window.location.pathname.lastIndexOf('/');
			path = window.location.pathname.substring(0,path_end+1) + url.substring(0,qs_begin_index);
		}
		else if ( url.substring(0,7) == "http://" ) {
			path_begin_index = url.substring (7,url.length).indexOf('/');
			path = url.substring( path_begin_index + 7 , qs_begin_index );
		}
		else
			path = url.substring(0, qs_begin_index );
	}

	cipher = xecure_frame.XecureWeb.BlockEnc ( xgate_addr, path, "", "GET" );
	if( cipher == "" ) {
		if(navigator.appName != 'Netscape'){
                        errCode = xecure_frame.XecureWeb.LastErrCode();
                        errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                        errCode = xecure_frame.XecureWeb.LastErrCode();
                        errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
		return false;
	}
	if ( qs == "" )
		xecure_url = path + "?q=" + escape_url(cipher) ;
	else
		xecure_url = path + "?q=" + escape_url(cipher) + "&" + qs;

	open ( xecure_url, target );
}

function XecureNavigate( url, target, feature ) {

	var qs ;
	var path = "/";
	var cipher;
	var xecure_url;

	var errCode;
	var errMsg = "";

	// get path info & query string & hash from url
	qs_begin_index = url.indexOf('?');

	if ( qs_begin_index < 0 ) {
		qs = "";
		// if action is relative url, get base url from window location  
		if ( url.charAt(0) != '/' && url.substring(0,7) != "http://" ) {
			path_end = window.location.pathname.lastIndexOf('/');
			path = window.location.pathname.substring(0,path_end+1) + url;
		}
		else if ( url.substring(0,7) == "http://" ) {
			path_begin_index = url.substring (7,url.length).indexOf('/');
			path = url.substring( path_begin_index + 7 , url.length);
		}
		else
			path = url;
	}
	else {
		qs = url.substring(qs_begin_index + 1, url.length );
		if ( url.charAt(0) != '/' && url.substring(0,7) != "http://" ) {
			path_end = window.location.pathname.lastIndexOf('/');
			path = window.location.pathname.substring(0,path_end+1) + url.substring(0,qs_begin_index );
		}
		else if ( url.substring(0,7) == "http://" ) {
			path_begin_index = url.substring (7,url.length).indexOf('/');
			path = url.substring( path_begin_index + 7 , qs_begin_index );
		}
		else
			path = url.substring(0, qs_begin_index );
	}
	if(navigator.appName == 'Netscape') {
		cipher = xecure_frame.XecureWeb.BlockEnc(xgate_addr, path, escape(qs),"GET");
	}
	else
		cipher = xecure_frame.XecureWeb.BlockEnc ( xgate_addr, path, qs, "GET" );
	if( cipher == "" ) {
		if(navigator.appName != 'Netscape'){
                        errCode = xecure_frame.XecureWeb.LastErrCode();
                        errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                        errCode = xecure_frame.XecureWeb.LastErrCode();
                        errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
		return false;
	}
	xecure_url = path + "?q=" + escape_url(cipher);

	if (feature=="" || feature==null) open ( xecure_url, target );
	else open(xecure_url, target, feature );
}

function XecureLink( link ) {
	var qs ;
	var path = "/";
	var cipher;

	var errCode;
	var errMsg = "";

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
	if(navigator.appName == 'Netscape') {
		path = link.pathname;
		cipher = xecure_frame.XecureWeb.BlockEnc(xgate_addr, path, escape(qs),"GET");
	}
	else  {
			
		path = "/" + link.pathname;
		cipher = xecure_frame.XecureWeb.BlockEnc ( xgate_addr, path, qs, "GET" );
	}	

	if( cipher == "" ) {
		if(navigator.appName != 'Netscape'){
                        errCode = xecure_frame.XecureWeb.LastErrCode();
                        errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                        errCode = xecure_frame.XecureWeb.LastErrCode();
                        errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
		return false;
	}
	// link.search = "?q=" + escape_url(cipher);
	xecure_url = "http://" + link.host + path + hash + "?q=" + escape_url(cipher);
	if ( link.target == "" || link.target == null ) open ( xecure_url, "_self" );
	else open( xecure_url, link.target );
	return false;
}

function XecureSubmit( form ) {

	var qs ;
	var path ;
	var cipher;

	var errCode;
	var errMsg = "";

	// get path info & query string & hash from action url
	qs_begin_index = form.action.indexOf('?');
	if ( qs_begin_index < 0 ) {
		qs = "";
		// if action is relative url, get base url from window location
		if ( form.action.charAt(0) != '/' && form.action.substring(0,7) != "http://" ) {
			path_end = window.location.pathname.lastIndexOf('/');
			path = window.location.pathname.substring(0,path_end+1) + form.action;
		}
		else if ( form.action.substring(0,7) == "http://" ) {
			path_begin_index = form.action.substring (7,form.action.length).indexOf('/');
			path = form.action.substring( path_begin_index + 7 , form.action.length);
		}
		else{
			path = form.action;
		}
	}
	else {
		qs = form.action.substring(qs_begin_index + 1, form.action.length );
		if ( form.action.charAt(0) != '/' && form.action.substring(0,7) != "http://" ) {
			path_end = window.location.pathname.lastIndexOf('/');
			path = window.location.pathname.substring(0,path_end+1) + form.action.substring(0,qs_begin_index );
		}
		else if ( form.action.substring(0,7) == "http://" ) {
			path_begin_index = form.action.substring (7,form.action.length).indexOf('/');
			path = form.action.substring( path_begin_index + 7 , qs_begin_index);
		}
		else {
			path = form.action.substring(0, qs_begin_index );
		}
	}
	xecure_frame.xecure.target = form.target;

	if ( form.method == "get" || form.method=="GET" ) {
		// collect input field values 
		qs = XecureMakePlain( form );

		// encrypt QueryString

		if(navigator.appName == 'Netscape') {
			cipher = xecure_frame.XecureWeb.BlockEnc(xgate_addr, path, escape(qs),"GET");
		}
		else
			cipher = xecure_frame.XecureWeb.BlockEnc ( xgate_addr, path, qs, "GET" );
		if( cipher == "" ) {
			if(navigator.appName != 'Netscape'){
                        	errCode = xecure_frame.XecureWeb.LastErrCode();
                        	errMsg = xecure_frame.XecureWeb.LastErrMsg();
                	}
                	else {
                        	errCode = xecure_frame.XecureWeb.LastErrCode();
                        	errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                	}
			process_error( errCode, errMsg );
			return false;
		}
		xecure_url = path + "?q=" + escape_url(cipher);
		if ( form.target == "" || form.target == null ) open( xecure_url, "_self");
		else open ( xecure_url, form.target );
	}
	else {
		xecure_frame.xecure.method = "post";

		// encrypt QueryString of action field

		if(navigator.appName == 'Netscape') {
			cipher = xecure_frame.XecureWeb.BlockEnc(xgate_addr, path, escape(qs),"GET");
		}
		else
			cipher = xecure_frame.XecureWeb.BlockEnc ( xgate_addr, path, qs, "GET" );

		if( cipher == "" ) {
			if(navigator.appName != 'Netscape'){
                        	errCode = xecure_frame.XecureWeb.LastErrCode();
                        	errMsg = xecure_frame.XecureWeb.LastErrMsg();
                	}
                	else {
                        	errCode = xecure_frame.XecureWeb.LastErrCode();
                        	errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                	}
			process_error( errCode, errMsg );
			return false;
		}

		xecure_frame.xecure.action = path + "?q=" + escape_url(cipher);
		posting_data = XecureMakePlain( form );
		
		if(navigator.appName == 'Netscape'){
			cipher = xecure_frame.XecureWeb.BlockEnc ( xgate_addr, path,  escape(posting_data), "POST" );
		}
		else
			cipher = xecure_frame.XecureWeb.BlockEnc ( xgate_addr, path,  posting_data, "POST" );

		if( cipher == "" ) {
			if(navigator.appName != 'Netscape'){
                                errCode = xecure_frame.XecureWeb.LastErrCode();
                                errMsg = xecure_frame.XecureWeb.LastErrMsg();
                        }
                        else {
                                errCode = xecure_frame.XecureWeb.LastErrCode();
                                errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                        }
			process_error( errCode, errMsg );
			return false;
		}
		xecure_frame.xecure.p.value = cipher;
		xecure_frame.xecure.submit();
	}
	return false;
}

function XecureMakePlain(form) {

	var name = new Array(form.elements.length); 
	var value = new Array(form.elements.length); 
	var flag = false;
	var j = 0;
	var plain_text="";


	len = form.elements.length; 
	for (i = 0; i < len; i++) {
		if ((form.elements[i].type != "button") && (form.elements[i].type != "reset") && (form.elements[i].type != "submit")) {
			if (form.elements[i].type == "radio" || form.elements[i].type == "checkbox") { // Leejh 99.11.10 checkbox추가
				if (form.elements[i].checked == true) {
					name[j] = form.elements[i].name; 
					value[j] = form.elements[i].value;
					j++;
				}
			}
			else {
				name[j] = form.elements[i].name; 
				if (form.elements[i].type == "select-one") {
					var ind = form.elements[i].selectedIndex;
					if (form.elements[i].options[ind].value != '')
						value[j] = form.elements[i].options[ind].value;
					else
						value[j] = form.elements[i].options[ind].text;
					// form.elements[i].selectedIndex = 0;
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
		if (flag)
			plain_text += "&";
		else
			flag = true;
		plain_text += name[i] ;
		plain_text += "=";
		plain_text += value[i];
	}

	return plain_text;
}

function BlockDec(cipher)
{

	var plain = "";
	var errCode = 0;
	var errMsg = "";
	
	if(navigator.appName == 'Netscape'){
		plain = unescape(xecure_frame.XecureWeb.BlockDec( xgate_addr, cipher));
	}
	else
		plain = xecure_frame.XecureWeb.BlockDec ( xgate_addr,  cipher );

	if( plain == "" ) {
		if(navigator.appName != 'Netscape'){
			errCode = xecure_frame.XecureWeb.LastErrCode();
			errMsg = xecure_frame.XecureWeb.LastErrMsg();
		}
		else {
			errCode = xecure_frame.XecureWeb.LastErrCode();
			errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
		}
		process_error( errCode, errMsg );
	}
	return plain;
}

function XecureLogIn( link )
{
	EndSession();
	return XecureLink(link);
}

function EndSession()
{
	xecure_frame.XecureWeb.EndSession( xgate_addr );
}

function Sign( plain )
{
	var signed_msg;
	
	if(navigator.appName != 'Netscape')
		signed_msg = xecure_frame.XecureWeb.SignData ( xgate_addr,accept_cert, plain, show_plain, sig_desc );
	else
		signed_msg = xecure_frame.XecureWeb.SignData ( xgate_addr,escape(accept_cert), escape(plain), show_plain, escape(sig_desc) );
	if( signed_msg == "" ) {
		if(navigator.appName != 'Netscape'){
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
	}
	return signed_msg;
}

function Sign_with_desc( plain, desc )
{
	var signed_msg;
	
	if(navigator.appName != 'Netscape')
		signed_msg = xecure_frame.XecureWeb.SignData ( xgate_addr,accept_cert, plain , show_plain, desc);
	else
		signed_msg = xecure_frame.XecureWeb.SignData ( xgate_addr,escape(accept_cert), escape(plain), show_plain, escape(desc) );
	if( signed_msg == "" ) {
		if(navigator.appName != 'Netscape'){
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
	}
	return signed_msg;
}

function RequestCertificate ( ref_code, auth_code )
{
	var r = xecure_frame.XecureWeb.RequestCertificate ( ca_port, ca_ip, ref_code, auth_code );
	if ( r != 0 ) {
		if(navigator.appName != 'Netscape'){
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
	}
	return r;
}

function RenewCertificate ( )
{
	var r = xecure_frame.XecureWeb.RenewCertificate ( ca_port, ca_ip );
	if ( r != 0 ) {
		if(navigator.appName != 'Netscape'){
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
	}
	return r;
}

function RevokeCertificate ( jobcode, reason )
{
	var r;
	r = xecure_frame.XecureWeb.RevokeCertificate ( ca_port, ca_ip, jobcode, reason );
        if ( r != 0 ) {

		if(navigator.appName != 'Netscape'){
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
	}
	return r;
}

function GenCertReq ( )
{
	cert_req = xecure_frame.XecureWeb.GenerateCertReq( 1024 );
	if ( cert_req == "" ) {
		if(navigator.appName != 'Netscape'){
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }
		process_error( errCode, errMsg );
	}
	return cert_req;
}

function InstallCertificate (cert_type, cert)
{
	xecure_frame.XecureWeb.InstallCertificate(cert_type, cert );
}

function ShowCertManager()
{
	xecure_frame.XecureWeb.ShowCertManager();
}

function PutBannerUrl()
{
	xecure_frame.XecureWeb.PutBannerUrl( xgate_addr, bannerUrl);
}

function PutCACert()
{
	var errCode;
	var errMsg = ""; 
	var r;

	if(navigator.appName != 'Netscape')
		r = xecure_frame.XecureWeb.PutCACert( pCaCertName, pCaCertUrl);
	else
		r = xecure_frame.XecureWeb.PutCACert( escape(pCaCertName), pCaCertUrl);

	r = xecure_frame.XecureWeb.PutCACert( pCaCertName, pCaCertUrl);
	if( r != 0 ) {
        	if(navigator.appName != 'Netscape'){
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = xecure_frame.XecureWeb.LastErrMsg();
                }
                else {
                       errCode = xecure_frame.XecureWeb.LastErrCode();
                       errMsg = unescape(xecure_frame.XecureWeb.LastErrMsg());
                }	
	   alert(errMsg); 
	}
}

function isNewPlugin(desc)
{
	index = desc.indexOf('v.', 0);
	if (index < 0)
		return false;
	desc += ' ';


	versionString = desc.substring(index +2, desc.length);
	arrayOfStrings = versionString.split('.');
	thisMajor = parseInt(arrayOfStrings[0], 10);
	thisMinor = parseInt(arrayOfStrings[1], 10);
	thisBuild = parseInt(arrayOfStrings[2], 10);
	if (thisMajor > versionMaj)
		return true;
	else if (thisMajor < versionMaj)
		return false;
	if (thisMinor > versionMin)
		return true;
	else if (thisMinor < versionMin)
		return false;
	if (thisBuild > versionRel)
		return true;
	else if (thisBuild < versionRel)
		return false;
	return true;
}

function downloadNow () {
	if ( navigator.javaEnabled() ) {
		trigger = netscape.softupdate.Trigger;
		if ( trigger.UpdateEnabled() ) {
			if (navigator.platform == "Win32") {
				trigger.StartSoftwareUpdate( packageURL, trigger.DEFAULT_MODE);

			}
			else alert('이 플러그 인은 윈도우즈 95/98/NT 환경에서만 작동합니다.')
		}
		else
			alert('넷스케입의 SmartUpdate 설치를 가능하도록 해야합니다.');
	}
	else
		alert('Java 실행을 가능하도록 해야합니다.');
}

/* for xecureweb ver 3 application */

function MakeInput ( form ) {
	if ( form.target == null || form.target == '' )
	{
		form.target= window.name;
	}
	return XecureSubmit( form ) ;
}

function haveControl_in_frame ( ) {
        var ctl;

        if ( xecure_frame != null ) {
                ctl = xecure_frame.xecure_frame.all.item("XecureWeb");
                if ( ctl != null )  {
                        return true;
                }
        }
        return false;
}

function StartSession(ver, url, target, err_url) {
	return XecureNavigate ( url, target );
}

function GenCertReq(keysize, dn, type) {
	cert_req = xecure_frame.XecureWeb.GenerateCertReq( 1024 );
	if ( cert_req == "" ) {
		errCode = xecure_frame.XecureWeb.LastErrCode();
		errMsg = xecure_frame.XecureWeb.LastErrMsg();
		alert( errMsg );
	}
	return cert_req;
}
