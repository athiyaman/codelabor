///
// Xecure EXP Sign Control Java Script ver1.1  2001.6.28.
//

//var s_ca_ip = "192.168.10.25";
//var s_ca_ip = "europa.softforum.co.kr";
//var s_ca_port = 8200;
//var s_ca_port = 8200;

//   GPKI �� /////////
var s_ca_ip = "192.168.10.30";
var s_ca_port = 2223;

///////////////////////////////////////////////////////////////////////////////
// ��ȿ�� ������� �������� CN �� ��Ȯ�� �����ش�.
//

var s_accept_cert = "SoftforumCA,SFSN CA,CA131000002,Softforum Demo CA,mma ca";
//var s_accept_cert = "SoftforumCA";
//var s_accept_cert = "CA131000002";
//var s_accept_cert = "HanssemTestCA ";
//var s_accept_cert = "SignKorea CA";

/////////////////////////////////////////////////////////////////////////////////
// ���ڼ���, ������ ����, ������ ���ÿ� ������ ��ȣ������ ���ȸ��
// ���ڼ��� Ȯ��â�� ���� �޼���

var s_pwd_fail = 3;
var s_sign_desc = "";
var s_envelop_desc = "";

//////////////////////////////////////////////////////////////////////////////////
// �α��� â�� ���� �̹����� �ٿ�ε� ���� URL
 
var s_bannerUrl =  "http://" + window.location.host + "/XecureExpObjectV2/xecure.bmp";
//var s_bannerPath = window.location.hostname + "_8448_8011";
var s_bannerPath = "image";

///////////////////////////////////////////////////////////////////////////////////
// ������� ������ �ٿ�ε�� ������� �������� ������ CN

//var s_pCaCertUrl= "http://" + window.location.host + "/XecureExpObjectV2/cacert.bin";
//var s_pCaCertName = "Softforum Public CA";
//var s_pCaCertName = "SoftforumCA";
//   GPKI �� /////////
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
        
	alert( "�����ڵ� : " + errCode + "\n\n" + errMsg );
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

function RandomGenerator( num )
{
	var rand;

	if(navigator.appName != 'Netscape')
		rand = document.XESignE.RandomGen( num );

	return rand;
}

// option : 0 : ���� ���� ��� ����
//	    	1 : ���� ���� ���

function Sign_with_option( option, plain )
{
        var signed_msg;

        if(navigator.appName != 'Netscape')
                signed_msg = document.XESignE.SignData ( s_accept_cert, plain, option, s_sign_desc, s_pwd_fail );
		
        if( signed_msg == "" ) 
                process_error2();

       	return signed_msg;
}

function VerifySignedData (signed_data)
{
        var ori_msg;
        var msg;
        var agent;
        var position;
        var signer_dn = "";
        var msg1;
        var cert;
    
        agent = UserAgent();
    	
    	if(navigator.appName != 'Netscape')
        	ori_msg = document.XESignE.VerifySignedData(signed_data); 

        if( ori_msg == "" ) {
            	process_error2();
	}
	else {
		position = ori_msg.indexOf(";");

		if( position == -1 ) {
			msg1 = ori_msg;
			signer_dn = "";
		}
		else {
			msg1 = ori_msg.substring(0, position-1);
			signer_dn = ori_msg.substring(position+1, ori_msg.length );
		}

		msg = '���� Ȯ�� ��� \n\n[ ���� �޼��� ] ';
		msg += "\n\n";
		msg += msg1;

		if( signer_dn != "" ) {
			msg += "\n\n[������ DN]\n\n";
			msg += signer_dn;
			cert = document.XESignE.GetSignerCert();
		}
		else {
			msg += "\n\n[������ ���� ����]\n\n";
        		if(navigator.appName != 'Netscape') {
        			errCode = document.XESignE.LastErrCode();
        			errMsg = document.XESignE.LastErrMsg();
			}
			
			msg += "�����ڵ� : ";
			msg += errCode;
			msg += "\n���� �޼��� : ";
			msg += errMsg;
		}
	}
	return ori_msg;
}

function GetSignerCert() {
	var	signerCert;
	
	if(navigator.appName != 'Netscape')
		signerCert = document.XESignE.GetSignerCert();
		
	return signerCert;
}



function RequestCertificate ( ref_code, auth_code, class_id )
{
	var r;

	if(navigator.appName != 'Netscape'){
		r = document.XESignE.RequestCertificate ( ref_code, auth_code, class_id, 1, s_ca_ip, s_ca_port, 0 ); //gpki �� 4��° field 1, xecurera �� 0
		//r = document.XESignE.RequestCertificate ( ref_code, auth_code, class_id, 0, s_ca_ip, s_ca_port, 0 );
	}

	if ( r != 0 ) {
				alert(r);
                process_error2();
    }
                
	return r;
}

function RenewCertificate ( )
{
	var r;
	
	if(navigator.appName != 'Netscape'){
		r = document.XESignE.RenewCertificate ( 1, s_ca_ip, s_ca_port, s_accept_cert, s_pwd_fail, 0 ); //gpki �� 1��° field 1, xecurera �� 0
		//r = document.XESignE.RenewCertificate ( 0, s_ca_ip, s_ca_port, s_accept_cert, s_pwd_fail, 0 );
	}

	if ( r != 0 ) 
                process_error2();
	
	return r;
}

function RevokeCertificate ( reason )
{
	var r;

	if(navigator.appName != 'Netscape'){
		r = document.XESignE.RevokeCertificate ( 1, s_ca_ip, s_ca_port, reason, s_accept_cert, s_pwd_fail, 0 ); //gpki �� 1��° field 1, xecurera �� 0
		//r = document.XESignE.RevokeCertificate ( 0, s_ca_ip, s_ca_port, reason, s_accept_cert, s_pwd_fail, 0 );
	}

        if ( r != 0 ) 
                process_error2();
	
	return r;
}

function PutBannerUrl()
{
	if(navigator.appName != 'Netscape')
		document.XESignE.PutBannerUrl( s_bannerPath, s_bannerUrl);
}

function PutCACert()
{
	var r;
	
	if(navigator.appName != 'Netscape') {
		r = document.XESignE.PutCACert( s_pCaCertName, s_pCaCertUrl);
	}

	if( r != 0 ) 
                process_error2();
	
}

function CertManager()
{
	if(navigator.appName != 'Netscape')
		document.XESignE.ShowCertManager();
}

function UserAgent()
{
	var str;
	var agent;

	str = navigator.userAgent;
	agent = str.substring(0,9);
	return agent;
}

function PrintObjectTag()
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

