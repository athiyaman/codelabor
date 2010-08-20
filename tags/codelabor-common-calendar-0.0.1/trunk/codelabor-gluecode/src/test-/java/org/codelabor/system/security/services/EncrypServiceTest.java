package org.codelabor.system.security.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class EncrypServiceTest extends AbstractDependencyInjectionSpringContextTests {

	private EncryptService encryptService;

	@Override
	public void onSetUp() throws Exception {
		encryptService = (EncryptService) applicationContext.getBean("xecureEncryptService");
	}

	public void testEncrypt() {
		try {
			String charsetName = "EUC-KR";

			FileInputStream fileInputStream = new FileInputStream("password-decrypted.txt");
			FileOutputStream fileOutputStream = new FileOutputStream("password-encrypted.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charsetName);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, charsetName);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			String encryptedLine = null;
			while ((encryptedLine = bufferedReader.readLine()) != null) {
				String[] splitedLines = encryptedLine.split(", ");
				String id = splitedLines[0].substring(1, splitedLines[0].length() - 1);
				String encryptedPassword = splitedLines[1].substring(1, splitedLines[1].length() - 1);
				String decryptedPassword = null;
				if (encryptedPassword.equals("null")) {
					decryptedPassword = encryptedPassword;
				} else {
					decryptedPassword = encryptService.encrypt64(encryptedPassword);
				}
				StringBuilder sb = new StringBuilder();
				sb.append("\"").append(id).append("\", \"");
				sb.append(decryptedPassword).append("\"");
				sb.append(System.getProperty("line.separator"));
				bufferedWriter.write(sb.toString());
				bufferedWriter.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testDecrypt() {
		try {
			String charsetName = "EUC-KR";

			FileInputStream fileInputStream = new FileInputStream("password-encrypted.txt");
			FileOutputStream fileOutputStream = new FileOutputStream("password-decrypted.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charsetName);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, charsetName);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			String encryptedLine = null;
			while ((encryptedLine = bufferedReader.readLine()) != null) {
				String[] splitedLines = encryptedLine.split(", ");
				String id = splitedLines[0].substring(1, splitedLines[0].length() - 1);
				String encryptedPassword = splitedLines[1].substring(1, splitedLines[1].length() - 1);
				String decryptedPassword = null;
				if (encryptedPassword.equals("null")) {
					decryptedPassword = encryptedPassword;
				} else {
					decryptedPassword = encryptService.decrypt64(encryptedPassword);
				}
				StringBuilder sb = new StringBuilder();
				sb.append("\"").append(id).append("\", \"");
				sb.append(decryptedPassword).append("\"");
				sb.append(System.getProperty("line.separator"));
				bufferedWriter.write(sb.toString());
				bufferedWriter.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext-encryptService.xml" };
	}
}
