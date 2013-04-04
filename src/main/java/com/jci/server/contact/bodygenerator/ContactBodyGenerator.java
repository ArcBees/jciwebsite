package com.jci.server.contact.bodygenerator;

import com.jci.server.velocity.VelocityWrapper;
import com.jci.server.velocity.VelocityWrapperFactory;
import com.jci.shared.domain.ContactMessage;

import javax.inject.Inject;

public class ContactBodyGenerator {
    private final static String templateLocation =
            "com/jci/server/resource/velocitytemplates/contact.vm";
    private final VelocityWrapper velocityWrapper;

    @Inject
    public ContactBodyGenerator(VelocityWrapperFactory velocityWrapperFactory) {
        this.velocityWrapper = velocityWrapperFactory.create(templateLocation);
    }

    public String generate(ContactMessage contactMessage) {
        velocityWrapper.put("from", contactMessage.getEmail());
        velocityWrapper.put("name", contactMessage.getName());
        velocityWrapper.put("subject", contactMessage.getSubject());
        velocityWrapper.put("message", contactMessage.getMessage());

        return velocityWrapper.generate();
    }
}
