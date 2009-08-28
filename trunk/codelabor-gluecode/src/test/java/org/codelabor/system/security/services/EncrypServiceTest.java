package org.codelabor.system.security.services;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class EncrypServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private EncryptService xecureDBService;

	@Override
	public void onSetUp() throws Exception {
		xecureDBService = (EncryptService) applicationContext
				.getBean("xecureDBService");
	}

	public void test() {
		try {

			InputStreamReader inputStreamReader = new FileReader(
					"password-encrypted.txt");
			OutputStreamWriter outputStreamWriter = new FileWriter(
					"password-decrypted.txt");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			BufferedWriter bufferedWriter = new BufferedWriter(
					outputStreamWriter);

			String encryptedLine = null;
			while ((encryptedLine = bufferedReader.readLine()) != null) {
				String[] splitedLines = encryptedLine.split(", ");
				String id = splitedLines[0].substring(1, splitedLines[0]
						.length() - 1);
				String encryptedPassword = splitedLines[1].substring(1,
						splitedLines[1].length() - 1);
				String decryptedPassword = null;
				if (encryptedPassword.equals("null")) {
					decryptedPassword = encryptedPassword;
				} else {
					decryptedPassword = xecureDBService
							.decrypt64(encryptedPassword);
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
		return new String[] { "classpath*:/**/applicationContext-xecureDBService.xml" };
	}
}
