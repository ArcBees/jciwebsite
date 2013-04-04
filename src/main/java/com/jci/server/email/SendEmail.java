package com.jci.server.email;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Logger;

public class SendEmail {
    private Logger logger = Logger.getLogger(SendEmail.class.getName());

    @Inject
    public SendEmail(@Assisted Email email) throws MessagingException, IllegalArgumentException {
        logger.info("Sending Email: email=" + email);

        send(email);
    }

    private void send(Email email) throws MessagingException, IllegalArgumentException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email.getFrom()));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
        message.setSubject(email.getSubject());
        message.setContent(email.getBody(), "text/html");

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            throw (e);
        } catch (IllegalArgumentException e) {
            throw (e);
        } catch (Exception e) {
            // skip... this will only throw in testing b/c api is not available
        }
    }
}
