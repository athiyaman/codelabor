/**
 *	키보드 보안 기능 end-to-end 지원 공통 Java Script
 */
/****************************************************************************************
         Company:    Kings Information & Network
         Telephone:  (02)554-5441
         Update: 2004.04.01
****************************************************************************************/

/**
 * 입력값에 스페이스 이외의 의미있는 값이 있는지 체크
 * ex) if (isEmpty(form.keyword)) {
 *         alert("검색조건을 입력하세요.");
 *     }
 */
function isEmpty_K(input) {
    if (input.value == null || input.value.replace(/ /gi,"") == "") {
        return true;
    }
    return false;
}

/**
 *  문자열에 있는 특정문자패턴을 다른 문자패턴으로 바꾸는 함수.
 */
function replace_K(targetStr, searchStr, replaceStr)
{
	var len, i, tmpstr;

	len = targetStr.length;
	tmpstr = "";

	for ( i = 0 ; i < len ; i++ ) {
		if ( targetStr.charAt(i) != searchStr ) {
			tmpstr = tmpstr + targetStr.charAt(i);
		}
		else {
			tmpstr = tmpstr + replaceStr;
		}
	}
	return tmpstr;
}

/**
 *  문자열에서 좌우 공백제거
 */
function trim_K(str)
{
	return replace_K(str," ","");
}
         
/**
 * 입력값이 특정 문자(chars)만으로 되어있는지 체크
 * 특정 문자만 허용하려 할 때 사용
 * 	(2004.03.18:MAXUP)
 * ex) if (!hasCharsOnly_K(form.blood,"ABO")) {
 *         alert("혈액형 필드에는 A,B,O 문자만 사용할 수 있습니다.");
 *     }
 */
function hasCharsOnly_K(input,chars) {

   var nRet;
   
   if(input.type == "password")   {
      if(document.kdefense != null && typeof(document.kdefense) != "undefined" && document.kdefense.object != null) {
         nRet = document.kdefense.checkChars(input.form.name, input.name, input.value, chars);
         
         if(nRet == 1) return true;
         else if(nRet == 2) return false;
      }
   }

   for (var inx = 0; inx < input.value.length; inx++) {
      if (chars.indexOf(input.value.charAt(inx)) == -1)
          return false;
   }
   return true;  
}

function hasCharsOnly2_K(input,ivalue,chars) {

   var nRet;
   
   if(input.type == "password")   {
      if(document.kdefense != null && typeof(document.kdefense) != "undefined" && document.kdefense.object != null) {
         nRet = document.kdefense.checkChars(input.form.name, input.name, ivalue, chars);
         
         if(nRet == 1) return true;
         else if(nRet == 2) return false;
      }
   }

   for (var inx = 0; inx < ivalue.length; inx++) {
      if (chars.indexOf(ivalue.charAt(inx)) == -1)
          return false;
   }
   return true;  
}

/**
 *	입력값에 숫자만 있는지 체크
 *	(번호 입력란 체크.
 *	 금액입력란은 isNumComma를 사용해야 합니다.)
 */
function isNumber_K(input) {
    var chars = "0123456789";
    return hasCharsOnly_K(input,chars);
}

/**
 *	패스워드 입력란 체크
 *	check : size 4 , 숫자만입력
 */
function isPassword_K(input)
{
	var chars = "0123456789";
	if(isEmpty_K(input))
	{
		alert(input.name+'를 입력하십시오');
		input.select();
//    	input.value = '';
//    	input.focus();
    	return false;
	}
	
    else if(!hasCharsOnly_K(input,chars))
    {
    	alert(input.name+'는 숫자만 입력 가능합니다');
    	input.select();
//    	input.value = '';
//    	input.focus();
    	return false;
    }

    else if(input.value.length != 4)
    {
    	alert(input.name+' 길이는 4자리입니다');
    	input.select();
//    	input.value = '';
//    	input.focus();
    	return false;
    }
    else 
    	return true;
}

/**
 *	영문 & 숫자만 입력 가능
 *	(2004.03.29:MAXUP)
 */
function isAlphaNum_K(input){
    var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
    return hasCharsOnly_K(input,chars);
}

/**
 *	특수문자 있는지 확인
 *	있으면 false, 없으면 true리턴
 *	(2004.03.29:MAXUP)
 */
function hasPeculChar_K(input)
{
	var input_chars = trim_K(input.value);

	if(input_chars.length == 0)
		return true;
	else
	{
		var chars = " 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz{}|~";
		return hasCharsOnly2_K(input, input_chars, chars);
	}
}


/**
 *	Form과 특정 Password Type의 Element에 대해서
 *	인증서 연동 암호화를 수행한다.
 *	kFormEleString은 "FormName.EleName" 형태이다.
 *	(2004.03.18:MAXUP)
 */
function regFormEle_K(kFormEleString, caseOption){
    var szFormEle;
    
    if(document.kdefense != null && typeof(document.kdefense) != "undefined" && document.kdefense.object != null)
    {
        if(caseOption == "toUpperCase"){
            document.kdefense.RegFormEle(kFormEleString, 1);
        }
        else if(caseOption == "toLowerCase"){
            document.kdefense.RegFormEle(kFormEleString, 2);
        }
        else if(caseOption == "none"){
            document.kdefense.RegFormEle(kFormEleString, 0);
        }
    }
}
/**
 * 	2004.01.30 MAXUP
 * 	암호화된 Password 값을 얻는다.
 */
function GetPwdValue_K(form, element, extention, StartTag, EndTag)
{
	if(document.kdefense != null && typeof(document.kdefense) != "undefined" && document.kdefense.object != null)
	{
		return document.kdefense.GetPwdValue(form.name, element.name, element.value, extention, StartTag, EndTag);
	}
	
	return element.value;
}


/**
 *	값이 암호화되어 저장되는 Password Type의 Element에 대해서
 *	String Operation을 수행한다.
 *	(2004.03.29:MAXUP)
 *      - opString값이 "strcmp" 인 경우 input1.value == input2.value 비교하여
 *        같으면 true를 Return하고 다르면 false를 Return 한다.	
 */
function stringOP_K(opString, input1, input2){
    var nRet;
    
    if(document.kdefense != null && typeof(document.kdefense) != "undefined" && document.kdefense.object != null)
    {
        if(opString == "strcmp"){
            nRet = document.kdefense.StringOP(1, input1.form.name, input1.name, input1.value,
                                                 input2.form.name, input2.name, input2.value);
            
            if(nRet == 1) return true;
            else if(nRet == 2) return false;

	    if(input1.value == input2.value) return true;
	    else return false;
        }
    }
    else
    {
    	if(opString == "strcmp")
    	{
	    if(input1.value == input2.value) return true;
	    else return false;
    	}
    }
    
    return false;
}
