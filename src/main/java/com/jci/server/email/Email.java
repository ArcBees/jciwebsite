package com.jci.server.email;

import javax.inject.Inject;
import java.io.Serializable;

public class Email implements Serializable {
    private final String to;
    private final String from;
    private final String subject;
    private final String body;

    @Inject
    public Email(final String to, final String from, final String subject, final String body) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;

        if (to == null || from == null || subject == null || body == null) {
            throw new IllegalEmailException(to, from, subject, body);
        }
    }

    public String getTo() {
        return to;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String toString() {
        String s = "Email(\n";
        s += "to=" + to + ",\n";
        s += "from=" + from + ",\n";
        s += "subject=" + subject + ",\n";
        s += "body=" + body;
        s += ")\n";
        return s;
    }
}
