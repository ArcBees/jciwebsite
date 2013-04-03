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
