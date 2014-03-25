var usePageCharset=false;
var gIsContinue=0;
var busy_info = "암호화 작업이 진행중입니다. 확인을 누르시고 잠시 기다려 주십시오."
//var test_host_addr = "http://210.124.178.193:8080";
//var xgate_addr = "210.124.178.193:9443:9080";
//var test_host_addr = "http://192.168.10.149:8080";
var test_host_addr = "http://"+window.location.hostname+":8188";
//var xgate_addr = "192.168.10.149:9443:9080";
var xgate_addr	= window.location.hostname + ":5443:5080";

function escape_url(url) {
	var i;
	var ch;
	var out = '';
	var url_string = '';

	url_string = String(url);

	for (i = 0; i < url_string.length; i++) {
		ch = url_string.charAt(i);
		if (ch == ' ')		out += '%20';
		else if (ch == '%')	out += '%25';
		else if (ch == '&')	out += '%26';
		else if (ch == '+')	out += '%2B';
		else if (ch == '=')	out += '%3D';
		else if (ch == '?') out += '%3F';
		else				out += ch;
	}
	return out;
}

function getPath(url)
{
	var path = "/";
	// get path info & query string & hash from url
	qs_begin_index = url.indexOf('?');
	// if action is relative url, get base url from window location
	if ( url.charAt(0) != '/' && url.substring(0,7) != "http://" ) {
		path_end = window.location.href.indexOf('?');
		if(path_end < 0)	path_end_str = window.location.href;
		else				path_end_str = window.location.href.substring(0,path_end); 
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

function XecureLinkTest()
{
	var	cipher = "";
	alert(xgate_addr);
	cipher = document.XecureWeb.BlockEnc(xgate_addr, "/off", "", "GET");
	
	alert( "sid :=\n" + cipher );
}

function XecureSubmitTest( form )
{
	var qs ;
	var path ;
	var cipher;

	qs_begin_index = form.action.indexOf('?');
	
	// if action is relative url, get base url from window location
	path = getPath(form.action)
	path = test_host_addr + path;

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
		//qs = XecureMakePlain( form );
		if(qs.length!=0)
			qs += "&"+XecureMakePlain( form );
		else
			qs = XecureMakePlain( form );
		

		// encrypt QueryString
		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			cipher = document.XecureWeb.BlockEnc(xgate_addr, path, qs,"GET");
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}
		
		if( cipher == "" )	return XecureWebError() ;
		
		xecure_url = path + "?q=" + escape_url(cipher);
		// adding character set information
		if(usePageCharset)
			xecure_url += "&charset=" + document.charset;
		
		if ( form.target == "" || form.target == null ) open( xecure_url, "_self");
		else open ( xecure_url, form.target );
	}
	else {
		document.xecure.method = "post";
		
		// encrypt QueryString of action field
		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			cipher = document.XecureWeb.BlockEnc(xgate_addr, path, qs,"GET");
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}		
		

		if( cipher == "" )	return XecureWebError() ;	
		

		document.xecure.action = path + "?q=" + escape_url(cipher);
		// adding character set information
		if(usePageCharset)
			document.xecure.action += "&charset=" + document.charset;
			
		posting_data = XecureMakePlain( form );
		
		alert( "posting_data :=\n" + posting_data );

		if( gIsContinue == 0 ) {
			gIsContinue = 1;
			cipher = document.XecureWeb.BlockEnc ( xgate_addr, path, posting_data, "POST" );
			gIsContinue = 0;
		}
		else {
			alert(busy_info);
			return false;
		}		
		
		if( cipher == "" )	return XecureWebError() ;
		
		document.xecure.p.value = cipher;
		document.xecure.submit();
	}
	return false;
}

function XecureMakePlain(form)	// modified by tiger on 2004/12/22
{
       var name = new Array(form.elements.length);
       var value = new Array(form.elements.length);
       var flag = false;
       var j = 0;
       var plain_text="";


       // for e2e test
       if(document.kdefense==null || typeof(document.kdefense) == "undefined" || document.kdefense.object==null) {
                    enable=false;
                    alert( "no e2e module" );
       }
       else {
                    enable=true;
       }
       //////////////       
       
       len = form.elements.length;
       for (i = 0; i < len; i++) {
                    if ((form.elements[i].type != "button") && (form.elements[i].type != "reset") && (form.elements[i].type != "submit")) {
                                 if (form.elements[i].type == "radio" || form.elements[i].type == "checkbox") {
                                              if (form.elements[i].checked == true) {
                                                if (form.elements[i].disabled == false) {
                                                          name[j] = form.elements[i].name;
                                                          value[j] = form.elements[i].value;
                                                          j++;
                                                }
                                              }
                                 }
                                 // for e2e test
                                 else if(enable && form.elements[i].type == "password"){
                                              if(form.elements[i].type == "password"){
                                                            //name[j] = "xw"+form.elements[i].name;
															name[j] = form.elements[i].name;
                                                            // value[j] = document.kdefense.GetEncData(xgate_addr, form.elements[i].value);
															version = document.XecureWeb.GetVerInfo(0);
															if(version == '7, 2, 1, 3') {
																//alert(document.XecureWeb.GetPID());
																xgate_addr = xgate_addr + ":" + document.XecureWeb.GetPID();
																alert(xgate_addr);
															}
															value[j] = GetPwdValue_K(form, form.elements[i], xgate_addr, "", "");
															//value[j] = GetPwdValue_K(form, name[j], form.elements[i].value, xgate_addr, "", "");
                                                            alert( "encrypted data :=\n"+value[j] );
                                                            j++;
                                              }
                                 }
                                 ///////////////
                                 else {
                                              name[j] = form.elements[i].name;
                                              if (form.elements[i].type == "select-one") {
                                                            var ind = form.elements[i].selectedIndex;
                                                            var op_len = form.elements[i].length;
                                                if (op_len > 0) {
                                                          if(ind > 0) {
                                                                     if (form.elements[i].options[ind].value != '')
                                                                               value[j] = form.elements[i].options[ind].value;
                                                                     else
                                                                               //value[j] = form.elements[i].options[ind].text;
                                                                               value[j] = "";
                                                          } else {
                                                                     if(ind == 0)
                                                                     {
                                                                               if (form.elements[i].options[ind].value != '')
                                                                                          value[j] = form.elements[i].options[ind].value;
                                                                               else
                                                                                          //value[j] = form.elements[i].options[ind].text;
                                                                                          value[j] = "";
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
                                                                     if (form.elements[i].options[k].value != '')
                                                                               value[j] = form.elements[i].options[k].value;
                                                                     else
                                                                               //value[j] = form.elements[i].options[k].text;
                                                                               value[j] = "";
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
                    if (flag)
                                 plain_text += "&";
                    else
                                 flag = true;
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

function BlockDec(cipher)
{
	var plain = "";
	
	plain = document.XecureWeb.BlockDec( xgate_addr, cipher);

	if( plain == "" ) XecureWebError() ;
		
	return plain;
}

function XecureWebError()		// by zhang
{
	var errCode = 0 ;
	var errMsg = "" ;
	
	errCode = document.XecureWeb.LastErrCode();
	errMsg  = document.XecureWeb.LastErrMsg();
	
	if(errCode == -144)
	{
		if(confirm("에러코드 : " + errCode + "\n\n" + errMsg + "\n\n 인증서관리창을 열겠습니까?"))
			ShowCertManager() ;
	}
//	else if(errCode != 0)	
		alert( "에러코드 : " + errCode + "\n\n" + errMsg );
	
	return false;
}

function PrintObjectTag()
{	
	document.write('<OBJECT ID="XecureWeb" CLASSID="CLSID:7E9FDB80-5316-11D4-B02C-00C04F0CD404" width=0 height=0>');
	document.write('No XecureWeb PlugIn</OBJECT>');
}