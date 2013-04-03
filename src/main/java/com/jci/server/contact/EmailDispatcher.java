package com.jci.server.contact;

import com.jci.server.email.Email;
import com.jci.server.email.SendEmailTask;
import com.jci.shared.domain.ContactMessage;
import com.jci.server.contact.bodygenerator.*;

import javax.inject.Inject;

public class EmailDispatcher {
    private final ContactBodyGenerator contactBodyGenerator;

    @Inject
    public EmailDispatcher(ContactBodyGenerator contactBodyGenerator) {
        this.contactBodyGenerator = contactBodyGenerator;
    }

    public void sendContactMessage(ContactMessage contactMessage) {
        String to = "info@unlimited2013.ca";
        String from = "zom.bee@arcbees.com";
        String subject = "JCI - Contact - From: " + contactMessage.getEmail() + " Subject: " + contactMessage
                .getSubject();
        String body = contactBodyGenerator.generate(contactMessage);

        SendEmailTask.createEmailTaskAndSendEmail(new Email(to, from, subject, body));
    }
}
