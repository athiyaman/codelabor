package org.codelabor.system.services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.dtos.MailDTO;
import org.junit.Ignore;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class MailServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private MailService mailService;
	private final String mailAddressFrom = "tester@codelabor.org";
	private final String mailAddressReplyTo = "tester@codelabor.org";
	private final String mailAddressTo = "tester@codelabor.org";
	private final String mailAddressCC = "tester@codelabor.org";
	private final String mailAddressBCC = "tester@codelabor.org";
	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public void onSetUp() throws Exception {
		mailService = (MailService) applicationContext.getBean("mailService");
	}

	@Ignore
	public void testSend() {
		try {
			// mail text
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<h1>mail service test</h1>");
			stringBuilder.append("<ul>");
			stringBuilder.append("<li>abcdefg</li>");
			stringBuilder.append("<li>가나다라마바사</li>");
			stringBuilder.append("<li>あえいおう </li>");
			stringBuilder.append("</ul>");
			stringBuilder.append("<img src='cid:image1'/>");
			stringBuilder.append("<img src='cid:image2'/>");

			// address
			InternetAddress from = new InternetAddress(mailAddressFrom);
			InternetAddress replyTo = new InternetAddress(mailAddressReplyTo);
			InternetAddress[] to = new InternetAddress[] { new InternetAddress(
					mailAddressTo) };
			InternetAddress[] cc = new InternetAddress[] { new InternetAddress(
					mailAddressCC) };
			InternetAddress[] bcc = new InternetAddress[] { new InternetAddress(
					mailAddressBCC) };

			// mail vo
			MailDTO mailDTO = new MailDTO();
			mailDTO.setFrom(from);
			mailDTO.setReplyTo(replyTo);
			mailDTO.setTo(to);
			mailDTO.setCc(cc);
			mailDTO.setBcc(bcc);

			// content
			mailDTO.setSubject("mail test");
			mailDTO.setText(stringBuilder.toString());

			// embeded image
			File image1 = new File(
					"C:/WINDOWS/Help/Tours/htmlTour/intro_logo.jpg");
			File image2 = new File("C:/WINDOWS/Help/Tours/htmlTour/img126.jpg");
			Map<String, File> imageFileMap = new HashMap<String, File>();
			imageFileMap.put("image1", image1);
			imageFileMap.put("image2", image2);
			mailDTO.setImageFileMap(imageFileMap);

			// attachement
			File attachement1 = new File("C:/WINDOWS/Media/chimes.wav");
			File attachement2 = new File("C:/WINDOWS/Media/ding.wav");
			File[] attachements = new File[] { attachement1, attachement2 };
			mailDTO.setAttachement(attachements);
			if (log.isDebugEnabled()) {
				log.debug(mailDTO.toString());
			}
			mailService.send(mailDTO);

			// TODO assert
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
