package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;


public class MailSender {
    private JavaMailSenderImpl javaMailSender;

    public MailSender (){
        javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.mail.ru");
        javaMailSender.setPort(465);
        javaMailSender.setUsername(Const.EMAIL);
        javaMailSender.setPassword(Const.PASS);

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.smtps.ssl.checkserveridentity", "true"); //true
        properties.put("mail.smtps.ssl.trust", "*");
        properties.put("mail.smtp.ssl.enable", "true");

    }

    public @NonNull JavaMailSenderImpl getJavaMailSender() {
        return javaMailSender;
    }
    public SimpleMailMessage messageToMail (String text){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(Const.EMAIL2);
        message.setSubject("Test mail");
        message.setFrom(Const.EMAIL);
        message.setText(text);
        return message;
    }

}
