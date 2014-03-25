// do not edit !!
function jsonDatatoRexData(oDataSet) {
	var sData = "";
	var sColSep = "";
	var sDsSep = "";
	var oDs;

	for (k = 0; k < arguments.length; k++) { // dataset
		oDs = "{'rexDS': " + arguments[k] + "}";
		oDs = eval('(' + oDs + ')');
		if (k > 0)
			sDsSep = rex_gsCsvSeparatorDataset;
		sData += sDsSep;
		for (i = 0; i < oDs.rexDS.length; i++) { // row
			var obj = oDs.rexDS[i];
			for ( var key in obj) { // column
				if ((typeof obj[key]).toString() != "object")
					sData += obj[key] + rex_gsCsvSeparatorColumn;
			}
		}
		// dataset별 마지막 컬럼구분자 지우기
		var sDataLen = sData.length;
		if (sDataLen > 0)
			sData = sData.substr(0,
					(sDataLen - (rex_gsCsvSeparatorColumn.length)));
	}
	return sData;
}
