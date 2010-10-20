function createRequest() {
	try {
		request = new XMLHttpRequest();
	} catch (tryMS) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (otherMS) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (faile) {
				request = null;
			}
		}
	}
	return request;

	function addEventHander(obj, eventName, handler) {
		if (document.attachEvent) {
			obj.attachEvent("on" + eventName, handler);
		} else if (document.addEventListener) {
			obj.addEventListener(eventName, hanler, false);
		}
	}
}