
function CKKeyPro_GetVariable(vn)
{
	return xgate_addr;
}

function XecureCK_UIEevents(frm,ele,event,keycode) {
        var obj;
        var eventObj;

        try {
                obj=document.forms[frm].elements[ele];
                if( document.createEventObject ) {
                        eventObj = document.createEventObject();
                        eventObj.keyCode=keycode;
                        if(obj) {
                                obj.fireEvent(event,eventObj);
                        }
                }
        } catch (e) {
        }
}

/*
        Rescan the current HTML Document & protects newly added elements.
        Call this function if you are adding Input Elements through JavaScript.
*/
function XecureCK_ReScan() {
        if(document.CKKeyPro==null || typeof(document.CKKeyPro) == "undefined" || document.CKKeyPro.object==null) {
                return; //XecureCK is not running in current document.
        }
        document.CKKeyPro.ReScanDocument();
}

/*
        Clear e2e enabled element's internal buffer.
        Call this function if you want to clear e2e enabled element value.
 */
function CKKeyPro_Clear(frmName,eleName) {
        if(document.CKKeyPro==null || typeof(document.CKKeyPro) == "undefined" || document.CKKeyPro.object==null) {
	        //XecureCK is not running in current document.
	        return;
        }
        document.CKKeyPro.Clear(frmName,eleName,0);
}

function keySecu() 
{
	var XecureCK_CLSID="clsid:6CE20149-ABE3-462E-A1B4-5B549971AA38"; 
	//var XecureCK_CODEBASE="CKKeyPro.cab";
	var XecureCK_CODEBASE="http://192.168.10.30:8188/XecureObject/CKKeyPro.cab";
	var XecureCK_VERSION="version=2,2,0,38";
	var USING_XecureCK = "1";
	var USING_CUSTOM_IMAGE = 1;
	//var CUSTOM_IMAGE_URL = "http://pib.wooribank.com/img/sec/woori_keyboard.bmp";
	var CUSTOM_IMAGE_URL = "CKKeyPro.bmp";

	// OS:64, Browser:32
	if(navigator.userAgent.indexOf("WOW64")>=0) {
		XecureCK_CODEBASE="http://s0fffffffffffff0.clientkeeper.co.kr/woori/CKKeyPro.cab";
		XecureCK_VERSION="version=2,2,0,40";
	}
	else
	// OS:64, Browser:64
	if(navigator.userAgent.indexOf("Win64")>=0) {
		alert ("고객님의 Windows 버젼은 지원하지 않습니다");
		return;
	}

	if (USING_XecureCK == "1" && navigator.appName.indexOf("Microsoft")!=-1 && navigator.platform == "Win32" && navigator.appVersion.indexOf("4.")!=-1)  {
			if (navigator.userAgent.indexOf("MSIE 5.5") == 25 || navigator.userAgent.indexOf("MSIE 6") == 25 || navigator.userAgent.indexOf("MSIE 7") == 25) {
				var Str="";
				
				Str+= '<object classid="' + XecureCK_CLSID + '"';
				Str+= '\n\t codebase="' + XecureCK_CODEBASE + '#' + XecureCK_VERSION + '"';
				Str+= '\n\t id="CKKeyPro" name="XecureCK" vspace="0" hspace="0" width="0" id="balu" style="display:none;">';
				
				//Str+= '\n\t <PARAM name="xgate" value="210.124.178.30:5443:5080">';
				//Str+= '\n\t <PARAM name="xgate" value="mercury.softforum.co.kr:5443:5080">';
				//Str+= '\n\t <PARAM name="xgate" value="192.168.10.30:5443:5080">';
				//Str+= '\n\t <PARAM name="PKI" value="xecurewebex">';
				Str+= '\n\t <PARAM name="PKI" value="xecureweb">';
				
				Str+= '\n\t <PARAM name="DefaultEnc" value="on">';

				if(USING_CUSTOM_IMAGE)
					Str+= '\n\t <PARAM name="ImageURL" value="' + CUSTOM_IMAGE_URL + '">';

				Str+= '\n\tNo XecureCK Plugin';
				Str+= '\n</object>';
				
				document.write(Str);

			} else if (navigator.userAgent.indexOf("MSIE 5") == 25) {
				alert ("Internet Explorer 5.0 이용자께서는 브라우저를 5.5 이상으로 업데이트 하셔야 합니다.");
			}

	} else if (navigator.appName.indexOf("Netscape")!=-1) {
			USING_XecureCK = "0";
			alert("현재 고객님께서는 설치 불가능한 시스템을 사용하고 계십니다.\n\nXecureCK를 사용하시려면 Windows 95이상 \n\nInternet Explorer 5.5이상이어야 합니다.");
	}
}

keySecu();
