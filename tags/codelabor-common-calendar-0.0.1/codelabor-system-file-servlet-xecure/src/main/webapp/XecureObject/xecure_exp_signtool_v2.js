///
// Xecure EXP Sign Control Java Script ver1.1  2001.6.28.
//

var s_ca_ip = "192.168.10.25";
//var s_ca_ip = "europa.softforum.co.kr";
//var s_ca_port = 8200;
var s_ca_port = 8200;

//   GPKI 용 /////////
var s_ca_ip_g = "192.168.10.30";
var s_ca_port_g = 2223;

///////////////////////////////////////////////////////////////////////////////
// 유효한 인증기관 인증서의 CN 을 정확히 적어준다.
//

var s_accept_cert = "SoftforumCA,SFSN CA,CA131000002,yessignCA,Softforum Demo CA,mma ca";
//var s_accept_cert = "SoftforumCA";
//var s_accept_cert = "CA131000002";
//var s_accept_cert = "HanssemTestCA ";
//var s_accept_cert = "SignKorea CA";

/////////////////////////////////////////////////////////////////////////////////
// 전자서명, 인증서 갱신, 인증서 폐기시에 인증서 암호오류를 허용회수
// 전자서명 확인창에 보일 메세지

var s_pwd_fail = 3;
var s_sign_desc = "";
var s_envelop_desc = "";

//////////////////////////////////////////////////////////////////////////////////
// 로그인 창에 보일 이미지를 다운로드 받을 URL
 
var s_bannerUrl =  "http://" + window.location.host + "/XecureExpObjectV2/xecure.bmp";
//var s_bannerPath = window.location.hostname + "_8448_8011";
var s_bannerPath = "image";

///////////////////////////////////////////////////////////////////////////////////
// 인증기관 인증서 다운로드시 인증기관 인증서와 인증서 CN

//var s_pCaCertUrl= "http://" + window.location.host + "/XecureExpObjectV2/cacert.bin";
//var s_pCaCertName = "Softforum Public CA";
//var s_pCaCertName = "SoftforumCA";
//   GPKI 용 /////////
var s_pCaCertUrl= "http://" + window.location.host + "/XecureExpObjectV2/cacert_new_mma.bin";
var s_pCaCertName = "Softforum Demo CA";

 
 
function process_error2()
{
	var errCode;
	var errMsg;

	if(navigator.appName != 'Netscape') {
        	errCode = document.XESignE.LastErrCode();
                errMsg = document.XESignE.LastErrMsg();
        }
        
	alert( "에러코드 : " + errCode + "\n\n" + errMsg );
}

function RandomGenerator( num )
{
	var rand;

	if(navigator.appName != 'Netscape')
		rand = document.XESignE.RandomGen( num );

	return rand;
}

function RequestCertificateE ( ref_code, auth_code, class_id )
{
	var r;

	if(navigator.appName != 'Netscape'){
		//r = document.XESignE.RequestCertificate ( ref_code, auth_code, class_id, 1, s_ca_ip, s_ca_port, 0 ); //gpki 는 4번째 field 1, xecurera 는 0
		r = document.XESignE.RequestCertificate ( ref_code, auth_code, class_id, 0, s_ca_ip, s_ca_port, 0 );
	}

	if ( r != 0 ) {
				alert(r);
                process_error2();
    }
                
	return r;
}

function RenewCertificateE ( )
{
	var r;
	
	if(navigator.appName != 'Netscape'){
		//r = document.XESignE.RenewCertificate ( 1, s_ca_ip, s_ca_port, s_accept_cert, s_pwd_fail, 0 ); //gpki 는 1번째 field 1, xecurera 는 0
		r = document.XESignE.RenewCertificate ( 0, s_ca_ip, s_ca_port, s_accept_cert, s_pwd_fail, 0 );
	}

	if ( r != 0 ) 
                process_error2();
	
	return r;
}

function RevokeCertificateE ( reason )
{
	var r;

	if(navigator.appName != 'Netscape'){
		//r = document.XESignE.RevokeCertificate ( 1, s_ca_ip, s_ca_port, reason, s_accept_cert, s_pwd_fail, 0 ); //gpki 는 1번째 field 1, xecurera 는 0
		r = document.XESignE.RevokeCertificate ( 0, s_ca_ip, s_ca_port, reason, s_accept_cert, s_pwd_fail, 0 );
	}

        if ( r != 0 ) 
                process_error2();
	
	return r;
}

function RequestCertificateG ( ref_code, auth_code, class_id )
{
	var r;

	if(navigator.appName != 'Netscape'){
		r = document.XESignE.RequestCertificate ( ref_code, auth_code, class_id, 1, s_ca_ip_g, s_ca_port_g, 0 ); //gpki 는 4번째 field 1, xecurera 는 0
		//r = document.XESignE.RequestCertificate ( ref_code, auth_code, class_id, 0, s_ca_ip, s_ca_port, 0 );
	}

	if ( r != 0 ) {
				alert(r);
                process_error2();
    }
                
	return r;
}

function RenewCertificateG ( )
{
	var r;
	
	if(navigator.appName != 'Netscape'){
		r = document.XESignE.RenewCertificate ( 1, s_ca_ip_g, s_ca_port_g, s_accept_cert, s_pwd_fail, 0 ); //gpki 는 1번째 field 1, xecurera 는 0
		//r = document.XESignE.RenewCertificate ( 0, s_ca_ip, s_ca_port, s_accept_cert, s_pwd_fail, 0 );
	}

	if ( r != 0 ) 
                process_error2();
	
	return r;
}

function RevokeCertificateG ( reason )
{
	var r;

	if(navigator.appName != 'Netscape'){
		r = document.XESignE.RevokeCertificate ( 1, s_ca_ip_g, s_ca_port_g, reason, s_accept_cert, s_pwd_fail, 0 ); //gpki 는 1번째 field 1, xecurera 는 0
		//r = document.XESignE.RevokeCertificate ( 0, s_ca_ip, s_ca_port, reason, s_accept_cert, s_pwd_fail, 0 );
	}

        if ( r != 0 ) 
                process_error2();
	
	return r;
}

function PrintObjectTagE()
{
	var tag;
	
    	if(navigator.appName == 'Netscape') {
		alert('Netscape is Not Support!');
	}
	else {
		tag = '<OBJECT ID="XESignE" CLASSID="CLSID:3DBD0562-7FB7-461A-842C-F63A1AD8C2DE" CODEBASE="/XecureExpObjectV2/XESignE_Install.cab#Version=1,0,2,0"></OBJECT>';
	}
	document.write(tag);
}

