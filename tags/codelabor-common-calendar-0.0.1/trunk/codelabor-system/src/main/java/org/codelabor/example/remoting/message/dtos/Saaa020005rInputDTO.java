package org.codelabor.example.remoting.message.dtos;

import java.util.HashMap;
import java.util.Map;

import org.codelabor.system.remoting.message.dtos.DataDTO;

import com.sds.anyframe.util.IOUtil;

public class Saaa020005rInputDTO extends DataDTO {

	private String charSet = "EUC-KR";

	/**
	 * 표준
	 * 
	 * @name_ko 인터넷뱅킹ID
	 * @length 30
	 */
	private String inbkId;
	/**
	 * 표준
	 * 
	 * @name_ko 인터넷뱅킹비밀번호
	 * @length 24
	 */
	private String inbkPwd;

	/**
	 * 인터넷뱅킹ID Getter Method
	 * 
	 * @name_ko 인터넷뱅킹ID Getter Method
	 * @return 인터넷뱅킹ID
	 */
	public String getInbkId() {
		return inbkId;
	}

	/**
	 * 인터넷뱅킹ID Setter Method
	 * 
	 * @name_ko 인터넷뱅킹ID Setter Method
	 * @param String
	 *            인터넷뱅킹ID
	 */
	public void setInbkId(String inbkId) {
		this.inbkId = inbkId;
	}

	/**
	 * 인터넷뱅킹비밀번호 Getter Method
	 * 
	 * @name_ko 인터넷뱅킹비밀번호 Getter Method
	 * @return 인터넷뱅킹비밀번호
	 */
	public String getInbkPwd() {
		return inbkPwd;
	}

	/**
	 * 인터넷뱅킹비밀번호 Setter Method
	 * 
	 * @name_ko 인터넷뱅킹비밀번호 Setter Method
	 * @param String
	 *            인터넷뱅킹비밀번호
	 */
	public void setInbkPwd(String inbkPwd) {
		this.inbkPwd = inbkPwd;
	}

	/**
	 * byte[] 내용을 VO로 변환한다.
	 * 
	 * @name_ko byte[]->VO 변환 메소드
	 * @param 변환될
	 *            byte[]
	 * 
	 */
	public void fromBytes(byte[] bytes) throws Exception {
		setInbkId(IOUtil.substr(bytes, 0, 30, charSet).trim());
		setInbkPwd(IOUtil.substr(bytes, 30, 54, charSet).trim());
	}

	/**
	 * VO의 내용을 byte[] 변환한다.
	 * 
	 * @name_ko VO->byte[] 변환 메소드
	 * @return byte[] 변환된 byte[]
	 */
	public byte[] toBytes() throws Exception {
		byte[] destBytes = new byte[54];
		IOUtil.bytecopy(getInbkId(), destBytes, 0, 30, ' ', charSet);
		IOUtil.bytecopy(getInbkPwd(), destBytes, 30, 24, ' ', charSet);

		return destBytes;
	}

	/**
	 * Map의 내용을 VO로 변환한다.
	 * 
	 * @name_ko Map->VO 변환 메소드
	 * @param 변환될
	 *            Map
	 */
	public void fromMap(Map<String, Object> map) {
		setInbkId(IOUtil.getString(map, "inbkId"));
		setInbkPwd(IOUtil.getString(map, "inbkPwd"));
	}

	/**
	 * VO의 내용을 Map으로 변환한다.
	 * 
	 * @name_ko VO->Map 변환 메소드
	 * @return Map 변환된 Map
	 */
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("inbkId", getInbkId());
		result.put("inbkPwd", getInbkPwd());
		return result;
	}

}
