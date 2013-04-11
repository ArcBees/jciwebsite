package com.jci.server.velocity;

import com.google.inject.assistedinject.Assisted;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.inject.Inject;
import java.io.StringWriter;

public class VelocityWrapper {
    private final Template template;
    private final VelocityContext velocityContext = new VelocityContext();

    @Inject
    public VelocityWrapper(VelocityEngine velocityEngine,
                           @Assisted String templateLocation) {
        this.template = velocityEngine.getTemplate(templateLocation);
    }

    public VelocityWrapper put(String key, Object value) {
        velocityContext.put(key, value);

        return this;
    }

    public String generate() {
        StringWriter writer = new StringWriter();

        template.merge(velocityContext, writer);

        return writer.toString();
    }
}