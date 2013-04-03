package com.jci.client.rest;

import com.jci.shared.domain.ContactMessage;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

public interface ContactService extends RestService {
    @POST
    public void contact(ContactMessage contactMessage, MethodCallback<Void> callback);

    @GET
    public void lol(ContactMessage contactMessage, MethodCallback<Void> callback);
}
