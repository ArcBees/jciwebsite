package com.jci.server.email;

import com.google.appengine.api.taskqueue.DeferredTask;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.inject.Inject;

import javax.mail.MessagingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendEmailTask implements DeferredTask {
    public static void createEmailTaskAndSendEmail(Email email) {
        DeferredTask task = new SendEmailTask(email);
        
        TaskOptions taskOptions = TaskOptions.Builder.withPayload(task);
        Queue queue = QueueFactory.getDefaultQueue();
        queue.add(taskOptions);
    }
    
    private static Logger logger = Logger.getLogger(SendEmailTask.class.getName());
    
    @Inject
    private static SendMailFactory sendMailFactory;

    private Email email;

    private SendEmailTask() {
    }
    
    private SendEmailTask(final Email email) throws IllegalArgumentException {
        this.email = email;
    }

    @Override
    public void run() {
        try {
            sendMailFactory.send(email);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "", e);
        } catch (MessagingException e) {
            logger.log(Level.SEVERE, "", e);
        }
    }
}
