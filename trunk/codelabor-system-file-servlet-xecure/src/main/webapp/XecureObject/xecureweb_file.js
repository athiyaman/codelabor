var hostname = window.location.hostname;
var po = window.location.port;
var port;

if (po == '') {
	port = 80;
} else {
	port = parseInt(po, 10);
}

var desc_upload = '';// '파일을 암호화하여 전송합니다...';
var desc_download = '';// '파일을 암호화하여 내려받고 있습니다..';
var initdir_up = ''; // v 2.1.4 add
var initdir_down = ''; // v 2.1.4 add
/*
 * file_upload.jsp 는 암호화된 파일을 그냥 읽어준다.
 */

var packageURL1 = 'http://' + window.location.host + '/XecureObject/NPFileAccess_Install.jar';
var packageName1 = 'XecureWeb File 4.0 Plug-in'
var updateObjectName1 = 'XecureWeb File 4.0 Plug-in';
var versionMaj1 = 4;
var versionMin1 = 2;
var versionRel1 = 6;
var versionBld1 = 20011012;

var accept_cert = "CA131000002Test,CA131000002,Xecure TestCA,SoftforumCA,Softforum Demo CA,Softforum CA 3.0,yessignCA,yessignCA-OCSP,signGATE CA,SignKorea CA,CrossCertCA,CrossCertCA-Test2,NCASign CA,TradeSignCA,yessignCA-TEST,lotto test CA,NCATESTSign,SignGateFTCA,SignKorea Test CA,TestTradeSignCA,Matsushita Group PKI Card CA 2002";

function EAlert(errCode, errMsg) {

	alert("에러코드 : " + errCode + "\n\n" + errMsg);
}

function Agent() {
	var str;
	var agent;

	str = navigator.userAgent;
	agent = str.substring(0, 9);
	return agent;
}

function FileUpload(link) {
	var qs;
	var errCode;
	var errMsg = '';
	var extname;
	var filename;
	var docKind;
	var agent = Agent();
	var link2 = link;

	if (link.indexOf("?") != -1) {
		link2 = link.substring(0, link.indexOf("?"));
		qs = link.substring(link.indexOf("?") + 1);
	}

	/*
	 * qs = link.search; if (qs.length > 1) { qs = link.search.substring(1); }
	 */

	path = link2.pathname + "?fileEnc=true";

	// alert(path);

	ext = path.lastIndexOf('.');
	// php확장자가 php3 php4 phps php 인 경우에 대해서 처리한다. 그 이외의 경우에는 조건문에 추가해 준다.
	extname = path.substring(ext + 1, ext + 4);
	if (extname == 'php')
		docKind = "php";
	else
		docKind = "jsp";

	if (navigator.appName == 'Netscape') {

		if (agent != 'Mozilla/5') {

			filename = document.FileAccess.FileSelect2(escape(initdir_up));

			if (filename == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			} else if (filename == "CANCEL") {
				alert('암호화 파일 전송이 취소되었습니다!');
				return false;
			}

			if (docKind == "php")
				r = document.FileAccess.FileUpload(xgate_addr,
						"/cgi-bin/xw_upload.cgi", "", hostname, port, filename,
						escape(desc_upload));
			else
				r = document.FileAccess.FileUpload(xgate_addr, path,
						escape(qs), hostname, port, filename,
						escape(desc_upload));

			if (r == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		} else {
			filename = document.FileAccess.nsIXecureFileInstance
					.FileSelect2(escape(initdir_up));
			if (filename == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}

			r = document.FileAccess.nsIXecureFileInstance.FileUpload(
					xgate_addr, path, escape(qs), hostname, port, filename,
					escape(desc_upload));

			if (r == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		}
	} else { /* Explorer */

		path = "/" + path;
		filename = document.FileAccess.FileSelect2(initdir_up);
		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			alert('암호화 파일 전송이 취소되었습니다!');
			return true;
		}
		if (docKind == "php")
			r = document.FileAccess.FileUpload(xgate_addr,
					"/cgi-bin/xw_upload.cgi", "", hostname, port, filename,
					desc_upload);
		else
			r = document.FileAccess.FileUpload(xgate_addr, path, qs, hostname,
					port, filename, desc_upload);
		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}
	}

	if (r == 'OK') {
		alert('암호화 파일 전송이 완료되었습니다!');
		return true;
	}
	if (r == 'CANCEL') {
		alert('암호화 파일 전송이 취소되었습니다!');
		return false;
	}
	if (r != '') {
		redirect = BlockDec(r);
		if (redirect == null || redirect.length == 0) {
			alert('암호화 파일 전송이 실패하였습니다!');
			return false;
		}
		if (qs.length > 1) {
			redirect = path + "?" + redirect + "&" + qs;
		} else {
			redirect = path + "?" + redirect;
		}
		// alert(redirect);
		XecureNavigate(redirect, '_self')
		return true;
	}

	return false;
}

/*
 * [FileUploadEx]
 * 
 * filePath : 업로드할 파일 경로. ""이면 파일 선택창으로부터 사용자 선택
 * 
 * upOption = 0 : 한 번에 한 개의 파일씩 업로드함 = 16 : 여러 개의 파일을 동시에 업로드함(valid for only
 * over v5.4.x)
 */
function FileUploadEx(filePath, link, upOption) {
	var qs;
	var errCode;
	var errMsg = '';
	var extname;
	var filename;
	var docKind;
	var agent = Agent();
	var link2 = link;

	if (link.indexOf("?") != -1) {
		link2 = link.substring(0, link.indexOf("?"));
		qs = link.substring(link.indexOf("?") + 1);
	}

	/*
	 * qs = link.search; if (qs.length > 1) { qs = link.search.substring(1); }
	 */

	// path = link.pathname;
	path = link2 + "?fileEnc=true"; // "/" + link.pathname+ "?fileEnc=true";

	ext = path.lastIndexOf('.');
	// php확장자가 php3 php4 phps php 인 경우에 대해서 처리한다. 그 이외의 경우에는 조건문에 추가해 준다.
	extname = path.substring(ext + 1, ext + 4);
	if (extname == 'php')
		docKind = "php";
	else
		docKind = "jsp";

	if (navigator.appName == 'Netscape') {

		if (agent != 'Mozilla/5') {

			filename = document.FileAccess.FileSelect2(escape(initdir_up));

			if (filename == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			} else if (filename == "CANCEL") {
				alert('암호화 파일 전송이 취소되었습니다!');
				return false;
			}

			if (docKind == "php")
				r = document.FileAccess.FileUpload(xgate_addr,
						"/cgi-bin/xw_upload.cgi", "", hostname, port, filename,
						escape(desc_upload));
			else
				r = document.FileAccess.FileUpload(xgate_addr, path,
						escape(qs), hostname, port, filename,
						escape(desc_upload));

			if (r == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		} else {
			filename = document.FileAccess.nsIXecureFileInstance
					.FileSelect2(escape(initdir_up));
			if (filename == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}

			r = document.FileAccess.nsIXecureFileInstance.FileUpload(
					xgate_addr, path, escape(qs), hostname, port, filename,
					escape(desc_upload));

			if (r == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		}
	} else { /* Explorer */

		path = "/" + path;
		if (filePath == "")
			filename = document.FileAccess.FileSelect2(initdir_up);
		else
			filename = filePath;

		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			alert('암호화 파일 전송이 취소되었습니다!');
			return true;
		}
		if (docKind == "php")
			r = document.FileAccess.FileUploadEx(xgate_addr,
					"/cgi-bin/xw_upload.cgi", "", hostname, port, filename,
					desc_upload, upOption);
		else
			r = document.FileAccess.FileUploadEx(xgate_addr, path, qs,
					hostname, port, filename, desc_upload, upOption);
		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}
	}

	if (r == 'OK') {
		alert('암호화 파일 전송이 완료되었습니다!');
		return true;
	}
	if (r == 'CANCEL') {
		alert('암호화 파일 전송이 취소되었습니다!');
		return false;
	}
	if (r != '') {
		redirect = BlockDec(r);
		if (redirect == null || redirect.length == 0) {
			alert('암호화 파일 전송이 실패하였습니다!');
			return false;
		}
		if (qs.length > 1) {
			redirect = path + "?" + redirect + "&" + qs;
		} else {
			redirect = path + "?" + redirect;
		}
		alert(redirect);
		XecureNavigate(redirect, '_self')
		return true;
	}

	return false;
}

/*
 * [FileDownload2]
 * 
 * option = 0 : 다운로드 받은 파일에 대한 저장/실행 여부를 사용자에게 확인받음 (확장자가 doc, xls, ppt, cvs인
 * 파일은 저장/실행 여부를 묻지 않고 웹브라우저 상에서 바로 실행됨) = 1 : 다운로드 받은 파일을 무조건 저장시킴 = 16 : 다운로드
 * 창을 여러 개 띄울 수 있음(valid for only over v5.4.x) (이 때는 다운로드가 완료되기 전에 리턴되기 때문에 후처리
 * 작업시 주의 요망)
 * 
 * return value(modified for v5.4.x) - 오류 : "" - 사용자 취소 : "CANCEL" - 성공 : 다운로드된
 * 파일 경로 ex) "C:\\Download\\..."
 */
function FileDownload(filePath, link, option, newWindow) {
	var r;
	var qs;
	var errCode;
	var errMsg = '';
	var filename;
	var agent = Agent();

	qs = link.search;
	if (qs.length > 1) {
		qs = link.search.substring(1);
	}

	if (navigator.appName == 'Netscape') {
		path = link.pathname;
		if (agent != 'Mozilla/5') {
			r = document.FileAccess.FileDownload2(xgate_addr, path, escape(qs),
					hostname, port, filePath, escape(initdir_down),
					escape(desc_download));
			if (r == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		} else { // for netscape 6 , not implemented...
			r = document.FileAccess.nsIXecureFileInstance.FileDownload2(
					xgate_addr, path, escape(qs), hostname, port, filePath,
					escape(initdir_down), escape(desc_download));
			if (r == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		}
	} else /* explorer */
	{
		if (newWindow == 0) {
			path = "/" + link.pathname + "?fileEnc=true";

			r = document.FileAccess.FileDownload2(xgate_addr, path, qs,
					hostname, port, filePath, initdir_down, desc_download,
					option);
			if (r == "") // error
			{
				errCode = document.FileAccess.LastErrCode();
				errMsg = document.FileAccess.LastErrMsg();
				EAlert(errCode, errMsg);
				return false;
			}
		} else if (newWindow == 1) {
			path = "/" + link.pathname + "?fileEnc=true";
			winObject = window
					.open(
							"",
							"",
							"toolbar=yes, location=yes, status=yes, menubar=yes, resizable=yes, width=600, height=400");
			winObject.document
					.write("<OBJECT ID='FileAccess' CLASSID='CLSID:6AC69002-DAD5-11D4-B065-00C04F0CD404' CODEBASE='/XecureObject/xw50_install.cab#Version=5,0,3,0'><PARAM name='lang' value='KOREAN'>\n");
			winObject.document
					.write("<COMMENT><EMBED type='application/x-SoftForum-XWFile' hidden=true name='FileAccess' lang='KOREAN'>\n");
			winObject.document
					.write("<NOEMBED></COMMENT>No XecureWeb 5.0 File PlugIn</NOEMBED></EMBED></OBJECT>\n");
			winObject.document.write("<script language='javascript'>\n");
			winObject.document
					.write("if (navigator.appName == 'Netscape') {\n");
			winObject.document.write("} else {\n");
			winObject.document.write("path = '/" + link.pathname + "';\n");
			winObject.document.write("r = document.FileAccess.FileDownload2('"
					+ xgate_addr + "',\n");
			winObject.document.write("'" + path + "','" + qs + "','" + hostname
					+ "'," + port + ",'" + filePath + "','" + "" + "','"
					+ desc_download + "'," + option + ");\n");
			winObject.document.write("if( r== '' ) {\n");
			winObject.document
					.write("errCode = document.FileAccess.LastErrCode();\n");
			winObject.document
					.write("errMsg = document.FileAccess.LastErrMsg();\n");
			// winObject.document.write("}\n");
			winObject.document.write("}else{\n");
			winObject.document
					.write("alert( '암호화 파일 다운로드가 완료되었습니다[' + r + '].' );\n");
			winObject.document.write("}\n");
			winObject.document.write("}\n");
			winObject.document.write("</script>\n");

			return "OK";
		}
	}

	/*
	 * if( r == 'OK' ) alert('암호화 파일 다운로드가 완료 되었습니다!'); if( r == 'CANCEL' )
	 * alert('암호화 파일 다운로드가 취소 되었습니다!');
	 * 
	 * if( r != "" ) { alert(r); }
	 */

	if (r == "CANCEL")
		alert('암호화 파일 다운로드가 취소되었습니다.');
	else if (r != "") {
		desc = "암호화 파일 다운로드가 완료되었습니다[" + r + "].";
		alert(desc);
	}

	return r;
}

function file_isNewPlugin(desc) {
	index = desc.indexOf('v.', 0);
	if (index < 0)
		return false;
	desc += ' ';

	versionString = desc.substring(index + 2, desc.length);
	arrayOfStrings = versionString.split('.');
	thisMajor = parseInt(arrayOfStrings[0], 10);
	thisMinor = parseInt(arrayOfStrings[1], 10);
	thisBuild = parseInt(arrayOfStrings[2], 10);
	if (thisMajor > versionMaj1)
		return true;
	else if (thisMajor < versionMaj1)
		return false;
	if (thisMinor > versionMin1)
		return true;
	else if (thisMinor < versionMin1)
		return false;
	if (thisBuild > versionRel1)
		return true;
	else if (thisBuild < versionRel1)
		return false;
	return true;
}

function file_downloadNow() {
	if (navigator.javaEnabled()) {
		trigger = netscape.softupdate.Trigger;
		if (trigger.UpdateEnabled()) {
			if (navigator.platform == "Win32") {
				trigger.StartSoftwareUpdate(packageURL1, trigger.DEFAULT_MODE);

			} else
				alert('이 플러그 인은 윈도우즈 95/98/NT 환경에서만 작동합니다.')
		} else
			alert('넷스케입의 SmartUpdate 설치를 가능하도록 해야합니다.');
	} else
		alert('Java 실행을 가능하도록 해야합니다.');
}

function PrintFileObjectTag() {
	var tag;
	var agent;
	agent = Agent();

	if (navigator.appName == 'Netscape') {
		tag = "<EMBED type='application/x-SoftForum-XWFile' hidden=true name='FileAccess'>";
	} else {
		tag = '<OBJECT ID="FileAccess" CLASSID="CLSID:6AC69002-DAD5-11D4-B065-00C04F0CD404" CODEBASE="/XecureObject/xw50_install.cab#Version=4,1,0,6"></OBJECT>';
	}
	document.write(tag);
}

function FileDirectDownload(filePath) {
	var r;
	var qs = "";
	var errCode;
	var errMsg = '';
	var filename;
	var agent = Agent();

	path = '/XecureDemo/file/file_download.jsp';
	if (navigator.appName == 'Netscape') {
		if (agent != 'Mozilla/5') {

			r = document.FileAccess.FileDownload(xgate_addr,
					'/XecureDemo/file/file_download.jsp', qs, hostname, port,
					filePath, escape(desc_download));
			if (r == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		} else { // for netscape 6 , not implemented...
			r = document.FileAccess.nsIXecureFileInstance
					.FileDownload(xgate_addr,
							'/XecureDemo/jsp/file_download.jsp', escape(qs),
							hostname, port, filePath, escape(desc_download));
			if (r == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		}
	} else {
		r = document.FileAccess.FileDownload(xgate_addr,
				'/XecureDemo/file/file_download.jsp', qs, hostname, port,
				filePath, desc_download);
		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}
	}

	alert('암호화 파일 다운로드가 완료 되었습니다!');

	return true;
}

/*
 * ** valid for only XWebFilCom v5.4.x ***
 * 
 * It is possible to combine following option flags
 * 
 * signOption = 0 : 기본 서명 + 원본 파일 경로에 서명된 파일 저장 = 1 : cert chain을 포함시켜 서명 = 2 :
 * CRL 포함시켜 서명 = 4 : 다수 인증서로 서명 가능(only for FileSign) = 8 : signed attribute(s)
 * 포함 = 16 : XecureWeb 임시 폴더에 서명된 파일 저장 = 32 : 사용자 선택 디렉토리에 서명된 파일 저장 = 64 : CMS
 * 타입으로 서명 = 256 : 로그인한 인증서로 서명
 * 
 * return value - success : path of signed file - fail : ""
 */
function FileSign(filePath, signOption) {
	var r;
	var errCode;
	var errMsg = '';
	var filename;
	// var signOption = 4 + 8 + 32 + 64;
	if (navigator.appName == 'Netscape') {
		alert("Not supported function");
	} else /* Explorer */
	{
		if (filePath == "" || filePath == null)
			filename = document.FileAccess.FileSelect2(initdir_up);
		else
			filename = filePath;

		if (filename == "" || filename == null) {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			return false;
		}

		// 리턴값은 서명된 파일의 경로입니다.
		r = document.FileAccess.FileSign(xgate_addr, accept_cert, filename, "",
				signOption, "", "", 0, "", 3);

		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}

		// FileClear( xgate_addr );

		alert("서명이 완료되었습니다[" + r + "].");
	}

	return r;
}

/*
 * ** valid for only XWebFilCom v5.4.x ***
 * 
 * It is possible to combine following option flags
 * 
 * signOption = FileSign에서 사용하는 값과 동일
 * 
 * verifyOption = 0 : 서명문만 검증 = 1 : 인증서 기본 검증 = 2 : cert chain 검증 = 4 : CRL 검증 =
 * 16 : 원본 파일 저장하지 못함 = 32 : 추가 서명하지 못함
 * 
 * return value - success : path of signed file / "OK" - fail : ""
 */
function FileVerify(filePath, verifyOption) {
	var r;
	var errCode;
	var errMsg = '';
	var filename;
	// var verifyOption = 0;
	var signOption = 8 + 32;

	if (navigator.appName == 'Netscape') {
		alert("Not supported function");
	} else /* Explorer */
	{
		if (filePath == "")
			filename = document.FileAccess.FileSelect2(initdir_up);
		else
			filename = filePath;

		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			return false;
		}

		// 리턴값은 추가 서명된 파일의 경로 / OK 입니다.
		r = document.FileAccess.FileVerify(xgate_addr, accept_cert, filename,
				verifyOption, signOption, "", "", 0, "");

		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}

		// FileClear( xgate_addr );

		alert("서명문 검증이 완료되었습니다[" + r + "].");
	}

	return r;
}

/*
 * ** valid for only XWebFilCom v5.4.x ***
 * 
 * It is possible to combine following option flags [EXCEPTION] - 1,2,64 are not
 * used simultaneously - 4 is valid for only 1 - 16,32 are not used
 * simultaneously
 * 
 * envOption = 1 : 인증서기반 전자봉투 = 2 : 패스워드기반 전자봉투 = 4 : 여러 개의 인증서로 전자봉투 = 8 : CMS
 * 타입으로 Envelop = 16 : 임시 폴더에 전자봉투 파일 저장 = 32 : 사용자 선택 디렉토리에 전자봉투 파일 저장(사용자가 임의의
 * 위치에 있는 인증서 파일을 선택할 수 있음) = 64 : 사용자에 의해 선택된 인증서 파일기반 전자봉투 = 256 : 로그인한 인증서로
 * 전자봉투
 * 
 * return value - success : path of enveloped file - fail : ""
 */
function FileEnvelop(filePath, envOption) {
	var r;
	var errCode;
	var errMsg = '';
	var filename;
	// var envOption = 64 + 32 + 8;
	var cert_pem = "";

	if (navigator.appName == 'Netscape') {
		alert("Not supported function");
	} else /* Explorer */
	{
		if (filePath == "")
			filename = document.FileAccess.FileSelect2(initdir_up);
		else
			filename = filePath;

		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			return false;
		}

		// 리턴값은 envelop된 파일의 경로입니다.
		r = document.FileAccess.FileEnvelop(xgate_addr, accept_cert, filename,
				"", envOption, "", cert_pem, "", 0, "", 3);

		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}

		// FileClear( xgate_addr );

		alert("파일 암호화가 완료되었습니다[" + r + "].");
	}

	return r;
}

/*
 * ** valid for only XWebFilCom v5.4.x ***
 * 
 * It is possible to combine following option flags
 * 
 * deenvOption = 1 : execute the deenveloped file
 * 
 * return value - success : "OK" - fail : ""
 */
function FileDeEnvelop(filePath, deenvOption) {
	var r;
	var errCode;
	var errMsg = '';
	var filename;
	// var deenvOption = 0;

	if (navigator.appName == 'Netscape') {
		alert("Not supported function");
	} else /* Explorer */
	{
		if (filePath == "")
			filename = document.FileAccess.FileSelect2(initdir_up);
		else
			filename = filePath;

		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			return false;
		}

		r = document.FileAccess.FileDeEnvelop(xgate_addr, accept_cert,
				filename, deenvOption, "", 3);

		if (r != "OK") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}

		// FileClear( xgate_addr );

		alert("파일 복호화가 완료되었습니다[" + r + "].");
	}

	return r;
}

function FileClear(xaddr) {
	if (navigator.appName == 'Netscape') {
		alert("Not supported function");
	} else
		document.FileAccess.FileClear(xaddr, 0);

	return false;
}

/*
 * ** valid for only XWebFilCom v5.4.x ***
 * 
 * zipOption = 16 : 임시 폴더에 압축 파일 저장 = 32 : 사용자 선택 디렉토리에 압축 파일 저장
 * 
 * return value - success : path of zipped file - fail : ""
 */
function FileZip(filePath, zipOption) {
	var r;
	var errCode;
	var errMsg = '';
	var filename;
	// var zipOption = 32;
	var selOption = 1; // allow multi-selection

	if (navigator.appName == 'Netscape') {
		alert("Not supported function");
	}
	/* Explorer */
	else {
		if (filePath == "")
			filename = document.FileAccess.FileSelectEx(initdir_up, selOption);
		else
			filename = filePath;

		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			return false;
		}

		// 리턴값은 압축된 파일의 경로입니다.
		r = document.FileAccess.FileZip(xgate_addr, filename, zipOption);

		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}

		alert("파일압축이 완료되었습니다[" + r + "]");

		// FileClear( xgate_addr );
	}

	return r;
}

/*
 * ** valid for only XWebFilCom v5.4.x ***
 * 
 * return value - success : "OK" - fail : ""
 */
function FileUnZip(filePath, targetPath, uzOption) {
	var r;
	var errCode;
	var errMsg = '';
	var filename;
	// var uzOption = 0;

	if (navigator.appName == 'Netscape') {
		alert("Not supported function");
	}
	/* Explorer */
	else {
		if (filePath == "")
			filename = document.FileAccess.FileSelectEx(initdir_up, 0);
		else
			filename = filePath;

		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			return false;
		}

		// 리턴값은 압축된 파일의 경로입니다.
		r = document.FileAccess.FileUnZip(filename, targetPath, uzOption);

		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}

		alert("압축풀기가 완료되었습니다[" + r + "]");

		// FileClear( xgate_addr );
	}

	return r;
}

function Demo_File_Sign_Zip_Upload(link) {
	var filename;

	filename = FileSign("", 8 + 16);
	filename = FileZip(filename, 16);
	FileUploadEx(filename, link, 0);

	return false;
}

function Demo_File_Download_Unzip_Verify(filePath, link, option, newWindow) {
	var filename, filename2, filename3, filename4;

	filename = FileDownload(filePath, link, option, newWindow);
	filename2 = filename.substring(0, filename.lastIndexOf("\\"));
	// alert( filename2 );
	FileUnZip(filename, filename2, 16);
	filename3 = filename.substring(filename.lastIndexOf("\\"), filename.length);
	// alert( filename3 );
	filename4 = filename2 + filename3.substring(0, filename3.lastIndexOf("."));
	// alert( filename4 );
	FileVerify(filename4, 0);

	return false;
}

function Demo_File_Envelop_Zip_Upload(link) {
	var filename;

	filename = FileEnvelop("", 2 + 16);
	filename = FileZip(filename, 16);
	FileUploadEx(filename, link, 0);

	return false;
}

function Demo_File_Download_Unzip_Deenvelop(filePath, link, option, newWindow) {
	var filename, filename2, filename3, filename4;

	filename = FileDownload(filePath, link, option, newWindow);
	filename2 = filename.substring(0, filename.lastIndexOf("\\"));
	// alert( filename2 );
	FileUnZip(filename, filename2, 16);
	filename3 = filename.substring(filename.lastIndexOf("\\"), filename.length);
	// alert( filename3 );
	filename4 = filename2 + filename3.substring(0, filename3.lastIndexOf("."));
	// alert( filename4 );
	FileDeEnvelop(filename4, 0);

	return false;
}

function MultiFileUpload(link) {
	var qs;
	var errCode;
	var errMsg = '';
	var filename;
	var agent = Agent();
	var response;

	qs = link.search;
	if (qs.length > 1) {
		qs = link.search.substring(1);
	}

	path = link.pathname + "?fileEnc=true";

	// Test adding Query Url for KookMin Bank.
	// path = path+"?quics=A1235";

	filename = document.FileAccess.FileSelectEx(initdir_up, 1);
	if (filename == "") {
		alert("filename is null");
		errCode = document.FileAccess.LastErrCode();
		errMsg = unescape(document.FileAccess.LastErrMsg());
		EAlert(errCode, errMsg);
		return false;
	} else if (filename == "CANCEL") {
		alert('암호화 파일 전송이 취소되었습니다!');
		return true;
	}

	else {
		path = "/" + path;
		r = document.FileAccess.MultiFileUpload(xgate_addr, path, qs, hostname,
				port, filename, desc_upload, 256);

		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			alert(r);
			return false;
		}
	}

	if (r == 'OK') {
		alert('암호화 파일 전송이 완료되었습니다!');
		// alert(r);
		return true;
	}
	if (r == 'CANCEL') {
		alert('암호화 파일 전송이 취소되었습니다!');
		return false;
	}
	if (r != '') {
		alert('암호화 파일 전송 실패 : ' + r);
		return false;
	}
}

function MultiFileDownload(fileDir, link) {

	var qs;
	var errCode;
	var errMsg = '';
	var filename;
	var agent = Agent();
	var destPath;
	var response;

	qs = link.search;
	if (qs.length > 1) {
		qs = link.search.substring(1);
	}

	path = "/" + link.pathname + "?fileEnc=true";

	// Test adding Query Url for KookMin Bank.
	// path = path+"?quics=A1235";

	response = document.FileAccess.MultiFileDownload(xgate_addr, path, qs,
			hostname, port, fileDir, "", "", 256);

	if (response == 'OK') {
		alert('파일 다운로드가 완료되었습니다!');
		return true;
	}
	if (response == 'CANCEL') {
		alert('파일 다운로드가 취소되었습니다!');
		return false;
	}
	if (response != '') {
		alert('UNKNOWN');
		alert('파일 다운로드 실패 : ' + response);
		return false;
	}
}

/*
 * [FileUploadExWithCP]
 * 
 * filePath : 업로드할 파일 경로. ""이면 파일 선택창으로부터 사용자 선택
 * 
 * upOption = 0 : 한 번에 한 개의 파일씩 업로드함 = 16 : 여러 개의 파일을 동시에 업로드함(valid for only
 * over v5.4.x)
 */
function FileUploadExWithCP(filePath, link, upOption, uACP) {
	var qs;
	var errCode;
	var errMsg = '';
	var extname;
	var filename;
	var docKind;
	var agent = Agent();

	qs = link.search;
	if (qs.length > 1) {
		qs = link.search.substring(1);
	}

	path = link.pathname;
	ext = path.lastIndexOf('.');
	// php확장자가 php3 php4 phps php 인 경우에 대해서 처리한다. 그 이외의 경우에는 조건문에 추가해 준다.
	extname = path.substring(ext + 1, ext + 4);
	if (extname == 'php')
		docKind = "php";
	else
		docKind = "jsp";

	if (navigator.appName == 'Netscape') {

		if (agent != 'Mozilla/5') {

			filename = document.FileAccess.FileSelect2(escape(initdir_up));

			if (filename == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			} else if (filename == "CANCEL") {
				alert('암호화 파일 전송이 취소되었습니다!');
				return false;
			}

			if (docKind == "php")
				r = document.FileAccess.FileUpload(xgate_addr,
						"/cgi-bin/xw_upload.cgi", "", hostname, port, filename,
						escape(desc_upload));
			else
				r = document.FileAccess.FileUpload(xgate_addr, path,
						escape(qs), hostname, port, filename,
						escape(desc_upload));

			if (r == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		} else {
			filename = document.FileAccess.nsIXecureFileInstance
					.FileSelect2(escape(initdir_up));
			if (filename == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}

			r = document.FileAccess.nsIXecureFileInstance.FileUpload(
					xgate_addr, path, escape(qs), hostname, port, filename,
					escape(desc_upload));

			if (r == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		}
	} else { /* Explorer */

		path = "/" + path;
		if (filePath == "")
			filename = document.FileAccess.FileSelect2(initdir_up);
		else
			filename = filePath;

		if (filename == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = unescape(document.FileAccess.LastErrMsg());
			EAlert(errCode, errMsg);
			return false;
		} else if (filename == "CANCEL") {
			alert('암호화 파일 전송이 취소되었습니다!');
			return true;
		}
		if (docKind == "php")
			r = document.FileAccess.FileUploadExWithCP(xgate_addr,
					"/cgi-bin/xw_upload.cgi", "", hostname, port, filename,
					desc_upload, upOption, uACP);
		else
			r = document.FileAccess.FileUploadExWithCP(xgate_addr, path, qs,
					hostname, port, filename, desc_upload, upOption, uACP);
		if (r == "") {
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}
	}

	if (r == 'OK') {
		alert('암호화 파일 전송이 완료되었습니다!');
		return true;
	}
	if (r == 'CANCEL') {
		alert('암호화 파일 전송이 취소되었습니다!');
		return false;
	}
	if (r != '') {
		redirect = BlockDec(r);
		if (redirect == null || redirect.length == 0) {
			alert('암호화 파일 전송이 실패하였습니다!');
			return false;
		}
		if (qs.length > 1) {
			redirect = path + "?" + redirect + "&" + qs;
		} else {
			redirect = path + "?" + redirect;
		}
		alert(redirect);
		XecureNavigate(redirect, '_self')
		return true;
	}

	return false;
}

function MultiFileUploadExWithCP(filePath, link, upOption, uACP) {
	var qs;
	var errCode;
	var errMsg = '';
	var filename;
	var agent = Agent();
	var link2 = link;

	/*
	 * qs = link.search; if (qs.length > 1) { qs = link.search.substring(1); }
	 * 
	 * path = link.pathname + "?fileEnc=true";
	 */

	if (link.indexOf("?") != -1) {
		link2 = link.substring(0, link.indexOf("?"));
		qs = link.substring(link.indexOf("?") + 1);
	}

	path = link2 + "?fileEnc=true"; // "/" + link.pathname+ "?fileEnc=true";

	ext = path.lastIndexOf('.');
	// php확장자가 php3 php4 phps php 인 경우에 대해서 처리한다. 그 이외의 경우에는 조건문에 추가해 준다.

	path = "/" + path;
	if (filePath == "") {

		filename = document.FileAccess.FileSelectEx(initdir_up, 1);

	} else
		filename = filePath;

	if (filename == "") {
		alert("filename is null");
		errCode = document.FileAccess.LastErrCode();
		errMsg = unescape(document.FileAccess.LastErrMsg());
		EAlert(errCode, errMsg);
		return false;
	} else if (filename == "CANCEL") {
		alert('암호화 파일 전송이 취소되었습니다!');
		return true;
	}

	filename = filename.split("|");
	for ( var idx = 0; idx < filename.length; idx++) {

		r = document.FileAccess.FileUploadExWithCP(xgate_addr, path, qs,
				hostname, port, filename[idx], desc_upload, upOption, uACP);

		if (r == "") {
			alert("r is null");
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}
	}

	if (r == 'OK') {
		alert('암호화 파일 전송이 완료되었습니다!');
		return true;
	}
	if (r == 'CANCEL') {
		alert('암호화 파일 전송이 취소되었습니다!');
		return false;
	}
	if (r != '') {
		redirect = BlockDec(r);
		if (redirect == null || redirect.length == 0) {
			alert('암호화 파일 전송이 실패하였습니다!');
			return false;
		}
		if (qs.length > 1) {
			redirect = path + "?" + redirect + "&" + qs;
		} else {
			redirect = path + "?" + redirect;
		}
		alert(redirect);
		XecureNavigate(redirect, '_self')
		return true;
	}

	return false;
}

function FileDownloadFixed(filePath, link, option, newWindow, named) {
	var r;
	var qs;
	var errCode;
	var errMsg = '';
	var filename;
	var agent = Agent();

	qs = link.search;
	if (qs.length > 1) {
		qs = link.search.substring(1);

	}

	if (link.indexOf("?") != -1) {
		link2 = link.substring(0, link.indexOf("?"));
		qs = link.substring(link.indexOf("?") + 1);
	}

	// qs = link.search;
	// if (qs.length > 1) {
	// qs = link.search.substring(1);
	// // alert(qs);
	// }
	// alert(qs);
	// qs = '';

	path = link2 + "?fileEnc=true"; // "/" + link.pathname+ "?fileEnc=true";

	if (navigator.appName == 'Netscape') {
		// path = link.pathname;
		if (agent != 'Mozilla/5') {
			r = document.FileAccess.FileDownload2(xgate_addr, path, escape(qs),
					hostname, port, filePath, escape(initdir_down),
					escape(desc_download));
			if (r == "") {
				errCode = document.FileAccess.LastErrCode();
				errMsg = unescape(document.FileAccess.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		} else { // for netscape 6 , not implemented...
			r = document.FileAccess.nsIXecureFileInstance.FileDownload2(
					xgate_addr, path, escape(qs), hostname, port, filePath,
					escape(initdir_down), escape(desc_download));
			if (r == "") {
				errCode = document.FileAccess.nsIXecureFileInstance
						.LastErrCode();
				errMsg = unescape(document.FileAccess.nsIXecureFileInstance
						.LastErrMsg());
				EAlert(errCode, errMsg);
				return false;
			}
		}
	} else /* explorer */
	{

		if (newWindow == 0) {
			// path = "/" + link.pathname;

			// alert("xgate_addr : " + xgate_addr + "\npath : " + path + "\nqs :
			// "
			// + qs + "\nhostname : " + hostname + "\nport : " + port
			// + "\nfilePath : " + filePath + "\ninitdir_down : "
			// + initdir_down + "\ndesc_download : " + desc_download
			// + "\noption : " + option);
			r = document.FileAccess.FileDownload2(xgate_addr, path, qs,
					hostname, port, filePath, named, desc_download, option);
			if (r == "") // error
			{
				errCode = document.FileAccess.LastErrCode();
				errMsg = document.FileAccess.LastErrMsg();
				EAlert(errCode, errMsg);
				return false;
			}
		} else if (newWindow == 1) {
			path = "/" + link.pathname;
			winObject = window
					.open(
							"",
							"",
							"toolbar=yes, location=yes, status=yes, menubar=yes, resizable=yes, width=600, height=400");
			winObject.document
					.write("<OBJECT ID='FileAccess' CLASSID='CLSID:6AC69002-DAD5-11D4-B065-00C04F0CD404' CODEBASE='/XecureObject/xw50_install.cab#Version=5,0,3,0'><PARAM name='lang' value='KOREAN'>\n");
			winObject.document
					.write("<COMMENT><EMBED type='application/x-SoftForum-XWFile' hidden=true name='FileAccess' lang='KOREAN'>\n");
			winObject.document
					.write("<NOEMBED></COMMENT>No XecureWeb 5.0 File PlugIn</NOEMBED></EMBED></OBJECT>\n");
			winObject.document.write("<script language='javascript'>\n");
			winObject.document
					.write("if (navigator.appName == 'Netscape') {\n");
			winObject.document.write("} else {\n");
			winObject.document.write("path = '/" + link.pathname + "';\n");
			winObject.document.write("r = document.FileAccess.FileDownload2('"
					+ xgate_addr + "',\n");
			winObject.document.write("'" + path + "','" + qs + "','" + hostname
					+ "'," + port + ",'" + filePath + "','" + "" + "','"
					+ desc_download + "'," + option + ");\n");
			winObject.document.write("if( r== '' ) {\n");
			winObject.document
					.write("errCode = document.FileAccess.LastErrCode();\n");
			winObject.document
					.write("errMsg = document.FileAccess.LastErrMsg();\n");
			// winObject.document.write("}\n");
			winObject.document.write("}else{\n");
			winObject.document
					.write("alert( '암호화 파일 다운로드가 완료되었습니다[' + r + '].' );\n");
			winObject.document.write("}\n");
			winObject.document.write("}\n");
			winObject.document.write("</script>\n");

			return "OK";
		}
	}

	/*
	 * if( r == 'OK' ) alert('암호화 파일 다운로드가 완료 되었습니다!'); if( r == 'CANCEL' )
	 * alert('암호화 파일 다운로드가 취소 되었습니다!');
	 * 
	 * if( r != "" ) { alert(r); }
	 */

	if (r == "CANCEL")
		alert('암호화 파일 다운로드가 취소되었습니다.');
	else if (r != "") {
		desc = "암호화 파일 다운로드가 완료되었습니다[" + r + "].";
		alert(desc);
	}

	return r;
}

function MultiFileUploadExWithoutCP(filePath, link, upOption, uACP) {
	var qs;
	var errCode;
	var errMsg = '';
	var filename;
	var agent = Agent();
	var link2 = link;

	if (link.indexOf("?") != -1) {
		link2 = link.substring(0, link.indexOf("?"));
		qs = link.substring(link.indexOf("?") + 1);
	}

	// qs = link.search;
	// alert("qs : " + qs);
	// if (qs.length > 1) {
	// qs = link.search.substring(1);
	// }
	// if (link.indexOf("?") != -1) qs = link.substring(link.indexOf("?") + 1);
	// qs = '';

	// alert("link.pathname :" + link.pathname);
	// path = link.pathname + "?fileEnc=true";
	// path = link";
	// ext = path.lastIndexOf('.');
	// php확장자가 php3 php4 phps php 인 경우에 대해서 처리한다. 그 이외의 경우에는 조건문에 추가해 준다.

	path = link2 + "?fileEnc=true";
	// alert(path);
	if (filePath == "") {
		filename = document.FileAccess.FileSelectEx(initdir_up, 1);
	} else {
		filename = filePath;
	}

	if (filename == "") {
		alert("filename is null");
		errCode = document.FileAccess.LastErrCode();
		errMsg = unescape(document.FileAccess.LastErrMsg());
		EAlert(errCode, errMsg);
		return false;
	} else if (filename == "CANCEL") {
		alert('암호화 파일 전송이 취소되었습니다!');
		return false;
	}

	filename = filename.split("|");
	for ( var idx = 0; idx < filename.length; idx++) {

		r = document.FileAccess.FileUploadExWithCP(xgate_addr, path, qs,
				hostname, port, filename[idx], desc_upload, upOption, uACP);
		// alert("xgate_addr : " + xgate_addr + "\n" + "path : " + path + "\n" +
		// "qs : " + qs + "\n" + "hostname : " + hostname + "\n" + "port : " +
		// port + "\n" + "filename : " + filename[idx] + "\n" + "desc_upload : "
		// + desc_upload + "\n" + "upOption : " + upOption + "\n" + "uACP : " +
		// uACP +
		// "\n");
		if (r == "") {
			alert("r is null");
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}
	}

	if (r == 'OK') {
		// alert('암호화 파일 전송이 완료되었습니다!');
		return true;
	}
	if (r == 'CANCEL') {
		alert('암호화 파일 전송이 취소되었습니다!');
		return false;
	}
	if (r != '') {
		redirect = BlockDec(r);
		if (redirect == null || redirect.length == 0) {
			alert('암호화 파일 전송이 실패하였습니다!');
			return false;
		}
		if (qs.length > 1) {
			redirect = path + "?" + redirect + "&" + qs;
		} else {
			redirect = path + "?" + redirect;
		}
		alert(redirect);
		XecureNavigate(redirect, '_self')
		return true;
	}

	return false;
}

function MultiFileDownloadExWidthoutCP(fromFile, link, option, toFile) {

	var r;
	var qs;
	var errCode;
	var errMsg = '';
	var files1;
	var files2;
	var agent = Agent();
	var link2 = link;
	// alert(fromFile);
	if (link.indexOf("?") != -1) {
		link2 = link.substring(0, link.indexOf("?"));
		qs = link.substring(link.indexOf("?") + 1);
	}

	// qs = link.search;
	// if (qs.length > 1) {
	// qs = link.search.substring(1);
	// // alert(qs);
	// }
	// alert(qs);
	// qs = '';

	path = link2 + "?fileEnc=true"; // "/" + link.pathname+ "?fileEnc=true";
	// alert(path);
	if (fromFile == "" || toFile == "") {
		alert("filename is null");
		errCode = document.FileAccess.LastErrCode();
		errMsg = unescape(document.FileAccess.LastErrMsg());
		EAlert(errCode, errMsg);
		return false;
	}

	files1 = fromFile.split("|");
	files2 = toFile.split("|");

	if (files1.length != files2.length) {
		alert("filename is Err");
		errCode = document.FileAccess.LastErrCode();
		errMsg = unescape(document.FileAccess.LastErrMsg());
		EAlert(errCode, errMsg);
		return false;
	}

	for ( var idx = 0; idx < files1.length; idx++) {
		r = document.FileAccess.FileDownload2(xgate_addr, path, qs, hostname,
				port, files1[idx], files2[idx], desc_download, option);
		/*
		 * alert("xgate_addr : " + xgate_addr + "\npath : " + path + "\nqs : " +
		 * qs + "\nhostname : " + hostname + "\nport : " + port + "\nfilePath :" +
		 * filePath + "\ninitdir_down : " + initdir_down + "\ndesc_download: " +
		 * desc_download + "\noption : " + option);
		 */
		if (r == "") // error
		{
			errCode = document.FileAccess.LastErrCode();
			errMsg = document.FileAccess.LastErrMsg();
			EAlert(errCode, errMsg);
			return false;
		}
	}

	/*
	 * if( r == 'OK' ) alert('암호화 파일 다운로드가 완료 되었습니다!'); if( r == 'CANCEL' )
	 * alert('암호화 파일 다운로드가 취소 되었습니다!');
	 * 
	 * if( r != "" ) { alert(r); }
	 */

	if (r == "CANCEL")
		alert('암호화 파일 다운로드가 취소되었습니다.');
	else if (r != "") {
		desc = "암호화 파일 다운로드가 완료되었습니다[" + r + "].";
		// alert(desc);
	}

	return r;
}
