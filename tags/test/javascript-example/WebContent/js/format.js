// 밀리세컨드로 표현된 시간을 포매팅된 형식으로 되돌려준다.
function getFormatedTimeByMilliseconds(milliseconds) {
	var date = new Date(milliseconds);
	var hours = paddingWithZeros(date.getHours());
	var minutes = paddingWithZeros(date.getMinutes());
	var seconds = paddingWithZeros(date.getSeconds());
	var formatedTime = hours + ":" + minutes + ":" + seconds;
	return formatedTime;
}

// 초 로 표현된 시간을 포매팅된 형식으로 되돌려준다.
function getFormatedTimeBySeconds(seconds) {
	var hours = paddingWithZeros(Math.floor(seconds / (60 * 60)));
	var minutes = paddingWithZeros(Math.floor(seconds / 60));
	var seconds = paddingWithZeros(seconds % 60);
	var formatedTime = hours + ":" + minutes + ":" + seconds;
	return formatedTime;
}

// 0을 채운다.
function paddingWithZeros(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}