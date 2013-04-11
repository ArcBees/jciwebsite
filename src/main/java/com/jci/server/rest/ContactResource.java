/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.jci.server.rest;

import com.jci.server.contact.EmailDispatcher;
import com.jci.shared.domain.ContactMessage;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("contact")
public class ContactResource {
    private final EmailDispatcher emailDispatcher;

    @Inject
    public ContactResource(EmailDispatcher emailDispatcher) {
        this.emailDispatcher = emailDispatcher;
    }

    @POST
    public Response post(ContactMessage contactMessage) {
        emailDispatcher.sendContactMessage(contactMessage);

        return Response.ok().build();
    }
}
