/**
 *	Ű���� ���� ��� end-to-end ���� ���� Java Script
 */
/****************************************************************************************
         Company:    Kings Information & Network
         Telephone:  (02)554-5441
         Update: 2004.04.01
****************************************************************************************/

/**
 * �Է°��� �����̽� �̿��� �ǹ��ִ� ���� �ִ��� üũ
 * ex) if (isEmpty(form.keyword)) {
 *         alert("�˻������� �Է��ϼ���.");
 *     }
 */
function isEmpty_K(input) {
    if (input.value == null || input.value.replace(/ /gi,"") == "") {
        return true;
    }
    return false;
}

/**
 *  ���ڿ��� �ִ� Ư������������ �ٸ� ������������ �ٲٴ� �Լ�.
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
 *  ���ڿ����� �¿� ��������
 */
function trim_K(str)
{
	return replace_K(str," ","");
}
         
/**
 * �Է°��� Ư�� ����(chars)������ �Ǿ��ִ��� üũ
 * Ư�� ���ڸ� ����Ϸ� �� �� ���
 * 	(2004.03.18:MAXUP)
 * ex) if (!hasCharsOnly_K(form.blood,"ABO")) {
 *         alert("������ �ʵ忡�� A,B,O ���ڸ� ����� �� �ֽ��ϴ�.");
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
 *	�Է°��� ���ڸ� �ִ��� üũ
 *	(��ȣ �Է¶� üũ.
 *	 �ݾ��Է¶��� isNumComma�� ����ؾ� �մϴ�.)
 */
function isNumber_K(input) {
    var chars = "0123456789";
    return hasCharsOnly_K(input,chars);
}

/**
 *	�н����� �Է¶� üũ
 *	check : size 4 , ���ڸ��Է�
 */
function isPassword_K(input)
{
	var chars = "0123456789";
	if(isEmpty_K(input))
	{
		alert(input.name+'�� �Է��Ͻʽÿ�');
		input.select();
//    	input.value = '';
//    	input.focus();
    	return false;
	}
	
    else if(!hasCharsOnly_K(input,chars))
    {
    	alert(input.name+'�� ���ڸ� �Է� �����մϴ�');
    	input.select();
//    	input.value = '';
//    	input.focus();
    	return false;
    }

    else if(input.value.length != 4)
    {
    	alert(input.name+' ���̴� 4�ڸ��Դϴ�');
    	input.select();
//    	input.value = '';
//    	input.focus();
    	return false;
    }
    else 
    	return true;
}

/**
 *	���� & ���ڸ� �Է� ����
 *	(2004.03.29:MAXUP)
 */
function isAlphaNum_K(input){
    var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
    return hasCharsOnly_K(input,chars);
}

/**
 *	Ư������ �ִ��� Ȯ��
 *	������ false, ������ true����
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
 *	Form�� Ư�� Password Type�� Element�� ���ؼ�
 *	������ ���� ��ȣȭ�� �����Ѵ�.
 *	kFormEleString�� "FormName.EleName" �����̴�.
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
 * 	��ȣȭ�� Password ���� ��´�.
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
 *	���� ��ȣȭ�Ǿ� ����Ǵ� Password Type�� Element�� ���ؼ�
 *	String Operation�� �����Ѵ�.
 *	(2004.03.29:MAXUP)
 *      - opString���� "strcmp" �� ��� input1.value == input2.value ���Ͽ�
 *        ������ true�� Return�ϰ� �ٸ��� false�� Return �Ѵ�.	
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
