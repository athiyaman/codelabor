/**
 * 
 */

function deleteBySearchCondition() {
	$("#integerIdListDto").append(
			"<input type='hidden' name='job' value='" + $("#job").val()
					+ "' />");
	$("#integerIdListDto").append(
			"<input type='hidden' name='salFrom' value='" + $("#salFrom").val()
					+ "' />");
	$("#integerIdListDto").append(
			"<input type='hidden' name='salTo' value='" + $("#salTo").val()
					+ "' />");
}