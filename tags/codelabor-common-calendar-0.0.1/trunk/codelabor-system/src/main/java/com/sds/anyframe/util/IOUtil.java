package com.sds.anyframe.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public class IOUtil {

	public static void bytecopy(BigDecimal bd, byte[] destBytes, int destPos, int length, char pad, String charSet, int scale) throws Exception {
		pad = '0';
		byte[] srcBytes = lpad(bd, length, pad, charSet, scale);
		System.arraycopy(srcBytes, 0, destBytes, destPos, length);
	}
	
//* blocked by bonobono, 09/11/30
	public static void bytecopy(BigDecimal bd, byte[] destBytes, int destPos, int length, char pad, String charSet) throws Exception {
		pad = '0';
		byte[] srcBytes = lpad(bd, length, pad, charSet);
		System.arraycopy(srcBytes, 0, destBytes, destPos, length);
	}
// */

	public static void bytecopy(byte[] inbytes, int srcPos, byte[] destBytes, int destPos, int length, char pad) throws Exception {
		byte[] srcBytes = rpad(inbytes, length, pad);
		System.arraycopy(srcBytes, srcPos, destBytes, destPos, length);
	}
	
	public static void bytecopy(int intval, byte[] destBytes, int destPos, int length, char pad, String charSet) throws Exception {
		pad = '0';
		byte[] srcBytes = IOUtil.lpad(intval, length, pad, charSet);
		System.arraycopy(srcBytes, 0, destBytes, destPos, length);
	}
//bytes, string, BigDecimal, int에 대한 rpad와 bytecopy 메소드 end

	public static void bytecopy(String strval, byte[] destBytes, int destPos, int length, char pad, String charSet) throws Exception {
		byte[] srcBytes = rpad(strval, length, pad, charSet);
		System.arraycopy(srcBytes, 0, destBytes, destPos, length);
	}

	public static BigDecimal getBigDecimal(Map map, String key) {
		String wrkvar = null;
		if ( map.get(key) == null)
			wrkvar = "0";
		else if ( map.get(key).toString().equals(""))
			wrkvar = "0";
		else 
			wrkvar = map.get(key).toString().replace(",", "");
		return new BigDecimal(wrkvar);
	}
	
	////////////////////////////////////////////////
// MVO 전문 처리 위한 메소스 들	
///* blocked by bonobono, 09/11/30
	public static BigDecimal getBigDecimal(String args) {
		String wrkvar = null;
		if ( args == null)
			wrkvar = "0";
		else if ( args.equals(""))
			wrkvar = "0";
		else 
			wrkvar = args.replace(",", "");
		return new BigDecimal(wrkvar);
	}
// */

	public static BigDecimal getBigDecimal(String args, int scale) {
		String wrkvar = null;
		if ( args == null)
			wrkvar = "0";
		else if ( args.equals(""))
			wrkvar = "0";
		else 
			wrkvar = args.replace(",", "");
		return new BigDecimal(wrkvar).movePointLeft(scale);
	}

	public static BigInteger getBigInteger(Map map, String key) {
		String wrkvar = null;
		if ( map.get(key) == null)
			wrkvar = "0";
		else if ( map.get(key).toString().equals(""))
			wrkvar = "0";
		else 
			wrkvar = map.get(key).toString().replace(",", "");
		return new BigInteger(wrkvar);
	}

	public static boolean getBoolean(Map map, String key) {
		if(map.get(key) == null) {
			return false;
		} else {
			return Boolean.valueOf(map.get(key).toString());
		}
	}
	
	public static int getInt(Map map, String key) {
		String wrkvar = null;
		if ( map.get(key) == null)
			wrkvar = "0";
		else if ( map.get(key).toString().equals(""))
			wrkvar = "0";
		else
			wrkvar = map.get(key).toString().replace(",", "");
		return Integer.parseInt(wrkvar);
	}

	public static int getInt(String args) {
		String wrkvar = null;
		if ( args == null)
			wrkvar = "0";
		else if ( args.equals(""))
			wrkvar = "0";
		else
			wrkvar = args.replace(",", "");
		return Integer.parseInt(wrkvar);
	}

	public static Integer getInteger(Map map, String key) {
		String wrkvar = null;
		if ( map.get(key) == null)
			wrkvar = "0";
		else if ( map.get(key).toString().equals(""))
			wrkvar = "0";
		else
			wrkvar = map.get(key).toString().replace(",", "");
		return new Integer(wrkvar);
	}

	public static Integer getInteger(String args) {
		String wrkvar = null;
		if ( args == null)
			wrkvar = "0";
		else if ( args.equals(""))
			wrkvar = "0";
		else
			wrkvar = args.replace(",", "");
		return new Integer(wrkvar);
	}

	public static String getString(Map map, String key) {
		if ( map.get(key) == null)
			return "";
		else
			return map.get(key).toString();
	}
	
	//
	public static byte[] lpad(int intval, int length, char pad, String charSet) throws Exception {
		byte[] bytes = String.valueOf(intval).getBytes();
		return lpad(bytes, length, pad);
	}
	
///* blocked by bonobono, 09/11/30
	public static byte[] lpad(BigDecimal bd, int length, char pad, String charSet) throws Exception {
		byte[] bytes = null;
		if (bd == null) {
			bytes = "".getBytes();
		} else {
			if(bd.equals(bd.abs())) {
				bytes = String.valueOf(bd).getBytes();
			} else {	// negative number
				bytes = lpad(String.valueOf(bd.abs()).getBytes(), length, pad);
				bytes[0] = 45;		//	 "-".getBytes()[0]
				return bytes;
			}
		}
		return lpad(bytes, length, pad);
	}
// */
	
	public static byte[] lpad(BigDecimal bd, int length, char pad, String charSet, int scale) throws Exception {
		byte[] bytes = null;
		if (bd == null) {
			bytes = "".getBytes();
		} else {
			bd = bd.movePointRight(scale);
			if(bd.equals(bd.abs())) {
				bytes = String.valueOf(bd).getBytes();
			} else {	// negative number
				bytes = lpad(String.valueOf(bd.abs()).getBytes(), length, pad);
				bytes[0] = 45;		//	 "-".getBytes()[0]
				return bytes;
			}
		}
		return lpad(bytes, length, pad);
	}

	public static byte[] lpad(byte[] inbytes, int length, char pad) {
		int inlen  = inbytes.length;
		byte[] outbytes = new byte[length];
		int pads = length - inbytes.length;
		if(inlen > length) {
			System.arraycopy(inbytes, 0, outbytes, 0, length);
		} else {
			for(int i=0; i<pads; i++) {
				outbytes[i] = (byte)pad;
			}
			System.arraycopy(inbytes, 0, outbytes, pads, inlen);
		}
		return outbytes;
	}

	public static String lPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        
        return padding(pads, padChar).concat(str);
    }

	private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }

	//
	public static byte[] rpad(BigDecimal bd, int length, char pad) throws Exception {
		byte[] bytes = null;
		if (bd == null) {
			bytes = "".getBytes();
		} else {
			bytes = String.valueOf(bd).getBytes();
		}
		return rpad(bytes, length, pad);
	}

	//
	public static byte[] rpad(BigDecimal bd, int length, char pad, String charSet) throws Exception {
		byte[] bytes = null;
		if (bd == null) {
			bytes = "".getBytes();
		} else {
			bytes = String.valueOf(bd).getBytes();
		}
		return rpad(bytes, length, pad);
	}
	
	//
	public static byte[] rpad(int intval, int length, char pad) throws Exception {
		byte[] bytes = String.valueOf(intval).getBytes();
		return rpad(bytes, length, pad);
	}
	//
	public static byte[] rpad(int intval, int length, char pad, String charSet) throws Exception {
		byte[] bytes = String.valueOf(intval).getBytes();
		return rpad(bytes, length, pad);
	}
	
	//
    public static byte[] rpad(String strval, int length, char pad) throws Exception {
		if (strval == null) {
			strval = "";
		}
		return rpad(strval.getBytes(), length, pad);
	}
    
    //
    public static byte[] rpad(String strval, int length, char pad, String charSet) throws Exception {
		if (strval == null) {
			strval = "";
		}
		return rpad(strval.getBytes(charSet), length, pad);
	}

	//
	public static byte[] rpad(byte[] inbytes, int length, char pad) {
		int inlen  = inbytes.length;
		byte[] outbytes = new byte[length];
		if(inlen > length) {
			System.arraycopy(inbytes, 0, outbytes, 0, length);
		} else {
			System.arraycopy(inbytes, 0, outbytes, 0, inlen);
			for(int i=inlen; i<length; i++) {
				outbytes[i] = (byte)pad;
			}
		}
		return outbytes;
	}

	public static byte[] subbyte(byte[] bytes, int spos, int epos) throws Exception {
		int length = epos - spos;
		byte[] outbytes = new byte[length];
		System.arraycopy(bytes, spos, outbytes, 0, length);
		return outbytes;
	}
	
	//charSet없는 substr
	public static String substr(byte[] bytes, int spos, int epos) throws Exception {
		int length = epos - spos;
		byte[] outbytes = new byte[length];
		System.arraycopy(bytes, spos, outbytes, 0, length);
		return new String(outbytes);
	}
	
	public static String substr(byte[] bytes, int spos, int epos, String charSet) throws Exception {
		int length = epos - spos;
		byte[] outbytes = new byte[length];
		System.arraycopy(bytes, spos, outbytes, 0, length);
		return new String(outbytes, charSet);
	}
	
	public static String null2str(String str) {
		if(str == null || str.equals("null")) {
			return "";
		} else {
			return str;
		}
	}

}
