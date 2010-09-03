
var CKKeyPro_CLSID="clsid:6CE20149-ABE3-462E-A1B4-5B549971AA38";	

//var CKKeyPro_CODEBASE="http://ck.softforum.co.kr/keypro/2.2.0.50/CKKeyPro.cab";
var CKKeyPro_CODEBASE_x64= "http://ck.softforum.co.kr/keypro/3.0.0.3/CKKeyPro3003_64.cab";
var CKKeyPro_CODEBASE_x86= "http://ck.softforum.co.kr/keypro/3.0.0.3/CKKeyPro3003_32.cab";

var CKKeyPro_VERSION="version=3,0,0,3";

var USING_CKKeyPro = "1";

var USING_CUSTOM_IMAGE = 1;

var CUSTOM_IMAGE_URL = "http://ck.softforum.co.kr/CKKeyPro/keb/CKKeyPro_KEB.bmp";

alert (navigator.cpuClass.toLowerCase());

if (USING_CKKeyPro == "1")// && navigator.appName.indexOf("Microsoft")!=-1 && navigator.platform == "Win32" && navigator.appVersion.indexOf("4.")!=-1) 
{
		{
			var Str="";

			Str+= '<object classid="' + CKKeyPro_CLSID + '"';
			if(navigator.cpuClass.toLowerCase() == "x64")
			{
				Str+= '\n\t codebase="' + CKKeyPro_CODEBASE_x64 + '#' + CKKeyPro_VERSION + '"';
			}
				else
			{
				Str+= '\n\t codebase="' + CKKeyPro_CODEBASE_x86 + '#' + CKKeyPro_VERSION + '"';
			}
			//Str+= '\n\t codebase="' + CKKeyPro_CODEBASE + '#' + CKKeyPro_VERSION + '"';
			Str+= '\n\tvspace="0" hspace="0" width="0" id="CKKeyPro" style="display:none;">';
			Str+= '\n\t <PARAM name="PKI" value="XecureWebEx">';
			Str+= '\n\t <PARAM name="DefaultEnc" value="Off">';
			if(USING_CUSTOM_IMAGE)
				Str+= '\n\t <PARAM name="ImageURL" value="' + CUSTOM_IMAGE_URL + '">';

			//Str+= '\n\tNo CKKeyPro Plugin';
			Str+= '\n</object>';
			
			//alert(Str);
			document.write(Str);
		}
} 
/*else if (navigator.appName.indexOf("Netscape")!=-1) {
		USING_CKKeyPro = "0";
		alert("현재 고객님께서는 설치 불가능한 시스템을 사용하고 계십니다.\n\nCKKeyPro를 사용하시려면 Windows 95이상 \n\nInternet Explorer 5.5이상이어야 합니다.");
}

*/

function XecureCK_UIEevents(frm,ele,event,keycode)
{
	var obj;
	var eventObj;

	try{
		obj=document.forms[frm].elements[ele];
		if( document.createEventObject )
		{
			eventObj = document.createEventObject();
			eventObj.keyCode=keycode;
			if(obj)
			{
				obj.fireEvent(event,eventObj);
			}
		}
	}
	catch(e) {}
}

/*
	Rescan the current HTML Document & protects newly added elements.
	Call this function if you are adding Input Elements through JavaScript.
*/

function XecureCK_ReScan()
{
	if(document.CKKeyPro==null || typeof(document.CKKeyPro) == "undefined" || document.CKKeyPro.object==null)
	{
		//CKKeyPro is not running in current document.
		return;
	}
	document.CKKeyPro.ReScanDocument();
}

function HaveControl_CK()
{
	if(document.CKKeyPro==null || typeof(document.CKKeyPro) == "undefined" ||document.CKKeyPro.object==null)
	{
		alert("키보드 보안 프로그램이 설치되지 않았습니다.");
		return false;
	}
	else
		return true;
}

function CKKeyPro_Clear(frmName,eleName)
{
 	if(document.CKKeyPro==null || typeof(document.CKKeyPro) == "undefined" || document.CKKeyPro.object==null)
        {
                //XecureCK is not running in current document.
                return;
        }
	document.CKKeyPro.Clear(frmName,eleName,0);
}

function CKKeyPro_GetVariable(vn)
{
	//for ClientSM V7.2.1.7  20080311
	var xObj; 
	if(document.XecureWeb==null || typeof(document.XecureWeb) == "undefined" ||document.XecureWeb.object==null) 
	{
  	try 
  	{
   		xObj = new ActiveXObject("Xwctl40.XecCtl40");
  	}
  	catch(ex)
  	{
   		//alert("XecureWeb Client not installed");
   		//return;
  	}
	} 
 	else 
	{ 
  	xObj = document.XecureWeb;
 	}  
 
 	if(xObj.GetVerInfo(0) >= '7, 2, 1, 7')
  	enc_xgate = xObj.GetEncUserData(xgate_addr);
 	else
  	enc_xgate = xgate_addr;
  
 	return enc_xgate;
}