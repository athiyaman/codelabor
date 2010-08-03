///
// Xecure Sign Control Java Script ver1.1  2001.6.28.
//
//

// /////////////////////////////////////////////////////////////////
// YESSIGN TEST CA 	: 203.233.91.234, 4512, ca_type : 11
// YESSIGN REAL CA 	: 203.233.91.71 , ?, ca_type : 1
// SIGNGATE TEST CA 	: 128.134.254.166, 4502, ca_type : 22
// SIGNGATE REAL CA	:  ?, ?, ca_type : 2
// SIGNKOREA TEST CA	: 211.58.248.101, 4099, ca_type : 33
// SIGNKOREA REAK CA	: 210.207.195.100, ?, ca_type : 3

var s_ca_ip =  "203.233.91.234";
var s_ca_port = 4512;
var s_ca_type = 11; 

///////////////////////////////////////////////////////////////////////////////
// ��ȿ�� ������� �������� CN �� ��Ȯ�� �����ش�.
// YESSIGN TEST : yessignCA-TEST
// YESSIGN REAL : yessignCA
// SIGNGATE TEST : SignGateFTCA
// SIGNGATE REAL : signGate CA
// SIGNKOREA TEST : SignKorea Test CA 
// SIGNKOREA REAL : SignKorea CA

var s_accept_cert = "������� �������,yessignCA,�׽�Ʈ �������,aa,yessignCA-TEST,SignGateFTCA,SignKorea Test CA";

/////////////////////////////////////////////////////////////////////////////////
// ���ڼ���, ������ ����, ������ ���ÿ� ������ ��ȣ������ ���ȸ��   
// ���ڼ��� Ȯ��â�� ���� �޼���

var s_pwd_fail = 3;
var s_sign_desc = "";
var s_envelop_desc = "";

//////////////////////////////////////////////////////////////////////////////////
// �α��� â�� ���� �̹����� �ٿ�ε� ���� URL
 
var s_bannerUrl =  "http://" + window.location.host + "/XecureObject/xecure.bmp";
//pc�� ����Ǵ� ����� ��ġ(�⺻������ ����Ʈ URL���)
var s_bannerPath = window.location.hostname;

///////////////////////////////////////////////////////////////////////////////////
// ������� ������ �ٿ�ε�� ������� �������� ������ CN

//var s_pCaCertUrl= "http://" + window.location.host + "/XecureObject/signed_cacert.bin";
//var s_pCaCertName = "";


///////////////////////////////////////////////////////////////////////////////////
// ���ڼ��� ������ ����ϴ� �ɼ�
// ���ڼ��� ���� �������� ���� �������� ��쿡�� ��ȿ�� �ɼ��̴�.  
// verify_option (1) :RFC2459 �� ������ ���� ����
// 		 (7) :(1) + DS �� ���ؼ� ������ ��� ���� ����. 
var s_verify_option = 1;
//var s_ds = "dirsys.rootca.or.kr:389,203.233.91.234:389";
var s_ds ="210.124.178.206:25957;cn=CRL,ou=eSpkiCrl,o=co.kr";
var s_cert_revoke_chk=1;


///////////////////////////////////////////////////////////////////////////////////
// Netscape plugin version information

var     s_packageURL = 'http://' + window.location.host + '/XecureObject/NPXPSign_Install.jar';
var     s_packageName = 'Xecure Sign Plug-in'
var     s_updateObjectName = 'Xecure Sign Plug-in';
var     s_versionMaj = 1;
var     s_versionMin = 0;
var     s_versionRel = 1;
var     s_versionBld = 20010702;


function process_error2() 
{
	var errCode;
	var errMsg; 
	var agent;
	agent = UserAgent();

	if(navigator.appName != 'Netscape'){
        	errCode = document.XPSign.LastErrCode();
                errMsg = document.XPSign.LastErrMsg();
        }
        else if(agent != 'Mozilla/5') {
       		errCode = document.XPSign.LastErrCode();
               	errMsg = unescape(document.XPSign.LastErrMsg());
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



// option : 0 : ���� ���� ��� ���� 
//	    1 : ���� ���� ���
// mask : 0 : all certificates
//        1 : only user certificates
//        2 : only coperation certificates
 
function Sign_with_option2( option, mask, plain )
{
        var signed_msg;
	var agent;
	agent = UserAgent();

        if(navigator.appName == 'Netscape'){
                if ( agent != 'Mozilla/5'){
                        signed_msg = document.XPSign.SignData( escape(s_accept_cert), escape(plain),
					option, escape(s_sign_desc), mask, s_bannerPath, s_pwd_fail);
		}
	}
        else{
                signed_msg = document.XPSign.SignData ( s_accept_cert, plain, option, s_sign_desc, 
							mask, s_bannerPath, s_pwd_fail );
	}

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

        agent = UserAgent();

        if(navigator.appName == 'Netscape'){
        	if ( agent != 'Mozilla/5')
                	ori_msg = unescape( document.XPSign.VerifySignedData (
						signed_data, s_verify_option, s_ds)); 
	}
	else {
                ori_msg = document.XPSign.VerifySignedData (
						signed_data, s_verify_option, s_ds); 
	}

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
		}
		else {
			msg += "\n\n[������ ���� ����]\n\n";
                	if(navigator.appName != 'Netscape'){
                		errCode = document.XPSign.LastErrCode();
                		errMsg = document.XPSign.LastErrMsg();
			}
                	else if(agent != 'Mozilla/5') {
                        	errCode = document.XPSign.LastErrCode();
                        	errMsg = unescape(document.XPSign.LastErrMsg());
                	}
			
			msg += "�����ڵ� : ";
			msg += errCode;
			msg += "\n���� �޼��� : ";
			msg += errMsg;
		}
			
		alert(msg);
	}
	return ori_msg;
}

// option : 0 : ���ں��� ���� ��� ���� 
//	    1 : ���ں��� ���� ���

function Envelop_with_option ( pem, data, option)
{
        var agent;
        agent = UserAgent();

        if(navigator.appName == 'Netscape'){
        	if ( agent != 'Mozilla/5') {
                	envData = document.XPSign.EnvelopData( pem, escape(data), option, escape(s_envelop_desc));
		}
	}
	else {	
                envData = document.XPSign.EnvelopData( pem, data, option, s_envelop_desc);
	}
        
	if ( envData == '' ) 
                process_error2();
        
        return envData;
}

function UnsealData( envelopedData )
{
        var data;
        var agent;
        agent = UserAgent();
        
       	if ( navigator.appName == 'Netscape') {
        	if ( agent != 'Mozilla/5') {
               		data = unescape(document.XPSign.UnsealData( envelopedData, s_bannerPath, 3));
		}
	}
	else {
               	data = document.XPSign.UnsealData( envelopedData, s_bannerPath, 3);
	}
        if ( data == '' ) {
                process_error2();
		return data;
	}
	alert(data);
        return data;
}
 
function RequestCertificate ( ref_code, auth_code )
{
	var r;
	var agent;
	agent = UserAgent();

	if(agent != 'Mozilla/5') 
		r = document.XPSign.RequestCertificate ( s_ca_port, s_ca_ip, ref_code, auth_code, s_ca_type);

	if ( r != 0 ) 
                process_error2();
	
	return r;
}

function RenewCertificate ( )
{
	var r;
	var agent;
	agent = UserAgent();

	if(agent != 'Mozilla/5') 
		r = document.XPSign.RenewCertificate ( s_ca_port, s_ca_ip, s_bannerPath, s_ca_type, s_pwd_fail );

	if ( r != 0 ) 
                process_error2();
	
	return r;
}

function RevokeCertificate ( jobcode, reason )
{
	var r;
	var agent;
	agent = UserAgent();

	if(agent != 'Mozilla/5') 
		r = document.XPSign.RevokeCertificate ( s_ca_port, s_ca_ip, jobcode, reason, s_bannerPath, s_ca_type, s_pwd_fail );

        if ( r != 0 ) 
                process_error2();
	
	return r;
}


function GenCertReq ( )
{
	var agent;
	agent = UserAgent();

	if(agent != 'Mozilla/5') 
		cert_req = document.XPSign.GenerateCertReq( 1024 );

	if ( cert_req == "" ) 
                process_error2();
	
	return cert_req;
}

function InstallCertificate (cert_type, cert)
{
	var agent;
	agent = UserAgent();

	if(agent != 'Mozilla/5') 
		document.XPSign.InstallCertificate(cert_type, cert );
}

function PutBannerUrl()
{
	document.XPSign.PutBannerUrl( s_bannerPath, s_bannerUrl);
}

function PutCACert()
{
	var errCode;
	var errMsg = ""; 
	var r;
	var agent;
	agent = UserAgent();

	if(navigator.appName == 'Netscape') {
                if ( agent != 'Mozilla/5'){
			r = document.XPSign.PutCACert( escape(s_pCaCertName), s_pCaCertUrl);
		}
	}
	else {
		r = document.XPSign.PutCACert( s_pCaCertName, s_pCaCertUrl);
	}

	if( r != 0 ) 
                process_error2();
	
}

function CertManager()
{
        var r;
        var agent;
        agent = UserAgent();

        if ( agent != 'Mozilla/5'){
        	document.XPSign.CertManager(s_cert_revoke_chk ,s_ds );
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
	if (thisMajor > s_versionMaj)
		return true;
	else if (thisMajor < s_versionMaj)
		return false;
	if (thisMinor > s_versionMin)
		return true;
	else if (thisMinor < s_versionMin)
		return false;
	if (thisBuild > s_versionRel)
		return true;
	else if (thisBuild < s_versionRel)
		return false;
	return true;
}

function downloadNow () {
	if ( navigator.javaEnabled() ) {
		trigger = netscape.softupdate.Trigger;
		if ( trigger.UpdateEnabled() ) {
			if (navigator.platform == "Win32") {
				trigger.StartSoftwareUpdate( s_packageURL, trigger.DEFAULT_MODE);

			}
			else alert('�� �÷��� ���� �������� 95/98/NT ȯ�濡���� �۵��մϴ�.')
		}
		else
			alert('�ݽ������� SmartUpdate ��ġ�� �����ϵ��� �ؾ��մϴ�.');
	}
	else
		alert('Java ������ �����ϵ��� �ؾ��մϴ�.');
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
	var agent;
	agent = UserAgent();
        if(navigator.appName == 'Netscape') {
                tag = "<EMBED type='application/x-SoftForum-XPSign' hidden=true name='XPSign'></EMBED>"
        }
	else {
		tag = '<OBJECT ID="XPSign" CLASSID="CLSID:CAB55A2C-F27B-4B87-8B82-F43F9E37DD37" CODEBASE="/XecureObject/XPSign_Install.cab#Version=1,0,0,2" ></OBJECT>';
	}
	document.write(tag);
}

function VerifyVirtualID(subjectDN, TimeStamp, ServerCertPem)
{
        var msg;


        if( navigator.appName == 'Netscape' )
                msg = document.XPSign.VerifyAndGetVID(  s_accept_cert, 0, s_bannerPath, 3, ServerCertPem, TimeStamp, escape(subjectDN), 1);
        else
                msg = document.XPSign.VerifyAndGetVID(  s_accept_cert, 0, s_bannerPath, 3, ServerCertPem, TimeStamp, subjectDN, 1);

        return msg;
}

