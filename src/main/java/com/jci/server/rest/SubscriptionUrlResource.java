package com.jci.server.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.jci.server.util.RegistrationUrlExtractor;

@Path("subscriptionurl")
public class SubscriptionUrlResource {
    private final RegistrationUrlExtractor registrationUrlExtractor;

    @Inject
    public SubscriptionUrlResource(RegistrationUrlExtractor registrationUrlExtractor) {
        this.registrationUrlExtractor = registrationUrlExtractor;
    }

    @GET
    public Response getSubscriptionUrl() {
        return Response.ok(registrationUrlExtractor.extract()).build();
    }
}
