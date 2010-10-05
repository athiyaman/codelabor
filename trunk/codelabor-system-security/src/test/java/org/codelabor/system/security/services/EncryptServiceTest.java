package org.codelabor.system.security.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

public class EncryptServiceTest extends AbstractSingleSpringContextTests {

	private EncryptService encryptService;
	protected Logger logger = LoggerFactory.getLogger(EncryptServiceTest.class);

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext-encryptService.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		// encryptService = (EncryptService) applicationContext
		// .getBean("encryptService");
	}

	public void testEncrypt() {
		try {
			String charsetName = "EUC-KR";

			FileInputStream fileInputStream = new FileInputStream(
					"./src/test/resources/password-decrypted.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(
					"./src/test/resources/password-encrypted.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream, charsetName);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					fileOutputStream, charsetName);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			BufferedWriter bufferedWriter = new BufferedWriter(
					outputStreamWriter);

			String encryptedLine = null;
			while ((encryptedLine = bufferedReader.readLine()) != null) {
				String[] splitedLines = encryptedLine.split(", ");
				String id = splitedLines[0].substring(0, splitedLines[0]
						.length());
				String encryptedPassword = splitedLines[1].substring(0,
						splitedLines[1].length());
				String decryptedPassword = null;
				// if (encryptedPassword.equals("null")) {
				// decryptedPassword = encryptedPassword;
				// } else {
				// decryptedPassword = encryptService
				// .encrypt64(encryptedPassword);
				// }
				StringBuilder sb = new StringBuilder();
				sb.append(id).append(", ");
				sb.append(decryptedPassword);
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

			FileInputStream fileInputStream = new FileInputStream(
					"./src/test/resources/password-encrypted.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(
					"./src/test/resources/password-decrypted.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream, charsetName);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					fileOutputStream, charsetName);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			BufferedWriter bufferedWriter = new BufferedWriter(
					outputStreamWriter);

			String encryptedLine = null;
			while ((encryptedLine = bufferedReader.readLine()) != null) {
				String[] splitedLines = encryptedLine.split(", ");
				String id = splitedLines[0].substring(0, splitedLines[0]
						.length());
				String encryptedPassword = splitedLines[1].substring(0,
						splitedLines[1].length());
				String decryptedPassword = null;
				// if (encryptedPassword.equals("null")) {
				// decryptedPassword = encryptedPassword;
				// } else {
				// decryptedPassword = encryptService
				// .decrypt64(encryptedPassword);
				// }
				StringBuilder sb = new StringBuilder();
				sb.append(id).append(", ");
				sb.append(decryptedPassword);
				sb.append(System.getProperty("line.separator"));
				bufferedWriter.write(sb.toString());
				bufferedWriter.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
