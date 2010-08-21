var var_kLicense;
var kdfv_domain = window.location.hostname;

//--xx 200607월까지 사용가능한 테스트 라이센스 입니다.
var_kLicense = "3ffa42a839d18d2fdf983bce8510268d8d9dd914baff095211dbda8e0b79c2e9c0";

if (window.ActiveXObject)
{
	document.write('<object id=kdefense classid="CLSID:A4508A45-F1C4-40f3-99B4-0CA08AC77E3B"');
	document.write('	codebase="http://kings.nefficient.co.kr/kings/kdfx/kdfx229/kdfense8.cab#Version=8,2,2,9"');
	document.write('	height=0 width=0 align=left size=0>');
	document.write('	<PARAM name="IsDebug" value="no">');

	document.write('	<PARAM name="IsDebug" value="no">');
	document.write('	<PARAM name="nOption" value=', parseInt("0x00010006",16), '>');

	document.write('	<PARAM name="nModuleVersion" value=16051701>');
	document.write('	<PARAM name="szModulePath" value="http://kings.nefficient.co.kr/kings/kdfinj4x/16051701/kdfinj.dll">');
	document.write('	<PARAM name="szModuleHash" value="F1B06FD018C28F8B42B795FEFCFC3AD1">');

	document.write('	<PARAM name="nExModuleVersion" value=06052901>');
	document.write('	<PARAM name="szExModulePath" value="http://kings.nefficient.co.kr/kings/kdfmod3x/06052901/kdfmod.dll">');
	document.write('	<PARAM name="szExModuleHash" value="C44D8540C8D4C2825E89403653EA9090">');

	document.write('	<PARAM name="szGKey" value="58c705643199c2ff067850db4181dff9f0d63edeecde16ab33ac57c24703d22ff0">');	
	
	document.write('	<PARAM name="kLicense" value=', var_kLicense, '>');
	document.write('</object>');
}
