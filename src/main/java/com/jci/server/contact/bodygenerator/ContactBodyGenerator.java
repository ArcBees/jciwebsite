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
