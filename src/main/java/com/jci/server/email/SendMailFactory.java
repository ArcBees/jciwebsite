package com.jci.server.email;

import com.google.inject.assistedinject.Assisted;

import javax.mail.MessagingException;

public interface SendMailFactory {
    public SendEmail send(@Assisted Email email) throws MessagingException, IllegalArgumentException;
}
