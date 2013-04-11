/*
 Copyright 2013 ArcBees Inc.

 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy of
 the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 License for the specific language governing permissions and limitations under
 the License.
 */

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
