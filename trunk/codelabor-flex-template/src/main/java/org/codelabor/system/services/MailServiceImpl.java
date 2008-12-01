package org.codelabor.system.services;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeMessage;

import org.codelabor.system.dtos.MailDTO;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailServiceImpl extends BaseServiceImpl implements MailService {
	public JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void send(MailDTO mailDTO) throws Exception {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					mailDTO.isMultipart(), mailDTO.getEncoding());

			// address
			messageHelper.setFrom(mailDTO.getFrom());
			messageHelper.setReplyTo(mailDTO.getReplyTo());
			messageHelper.setTo(mailDTO.getTo());
			messageHelper.setBcc(mailDTO.getBcc());
			messageHelper.setCc(mailDTO.getCc());

			// content
			messageHelper.setSubject(mailDTO.getSubject());
			messageHelper.setText(mailDTO.getText(), mailDTO.isHtml());
			messageHelper.setFileTypeMap(mailDTO.getFileTypeMap());

			// embeded image
			Map<String, File> imageFileMap = mailDTO.getImageFileMap();
			if (imageFileMap != null) {
				Set<String> keySet = imageFileMap.keySet();
				Iterator<String> keyIter = keySet.iterator();
				while (keyIter.hasNext()) {
					String contentId = keyIter.next();
					messageHelper.addInline(contentId, imageFileMap
							.get(contentId));
				}
			}

			// attachement
			File[] attachements = mailDTO.getAttachement();
			if (attachements != null) {
				for (File attachement : attachements) {
					messageHelper.addAttachment(attachement.getName(),
							attachement);
				}
			}
			mailSender.send(message);
		} catch (Exception e) {
			String messageCode = "ERROR-MAIL-0000";
			String messageKey = "error.mail";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
	}
}
