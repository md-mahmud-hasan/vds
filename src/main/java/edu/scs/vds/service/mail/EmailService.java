package edu.scs.vds.service.mail;

import java.io.IOException;
import java.util.Map;
import javax.mail.*;
import freemarker.template.TemplateException;

public interface EmailService {
    void sendSimpleMessage(String from, String to,
                           String subject,
                           String text);

//    void sendSimpleMessageUsingTemplate(String from, String to,
//                                        String subject,
//                                        String... templateModel);

    void sendMessageWithAttachment(String from, String to,
                                   String subject,
                                   String text,
                                   String pathToAttachment);

    void sendMessageUsingThymeleafTemplate(String from,String to,
                                           String subject,
                                           Map<String, Object> templateModel)
            throws IOException, MessagingException;

    void sendMessageUsingFreemarkerTemplate(String from,String to,
                                            String subject,
                                            Map<String, Object> templateModel)
            throws IOException, TemplateException, MessagingException;
}