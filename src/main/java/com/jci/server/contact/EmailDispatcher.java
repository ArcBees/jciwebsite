package com.jci.server.contact;

import com.arcbees.appengine.mail.Email;
import com.arcbees.appengine.mail.Mail;
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

        Mail.send(new Email(to, from, subject, body));
    }
}
