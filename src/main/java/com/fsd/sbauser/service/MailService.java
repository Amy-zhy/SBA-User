package com.fsd.sbauser.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Value("${spring.mail.maillink}")
	private String maillink;
	  
	private static Logger logger = LoggerFactory.getLogger(MailService.class);
	
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * test email function
     */
    public void sendSimpleEmail(){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("yhz04056608@163.com");
            message.setTo("759241899@qq.com");
            message.setSubject("FSD");
            message.setText("SBA assessment");
            message.setCc("yhz04056608@163.com");
            mailSender.send(message);

        }catch (Exception e){
        	e.printStackTrace();
            System.out.println("发送简单文本文件-发生异常"+e);
        }
    }

    /**
     * send new pw email
     * @param
     * @throws MessagingException 
     */
    @Async
    public void sendHTMLMail(String email, String username) throws MessagingException{
    
       try {
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("yhz04056608@163.com");
            messageHelper.setTo(email);
            messageHelper.setCc("yhz04056608@163.com");
            messageHelper.setSubject("User Confirm of Stock Market Charting System");
            messageHelper.setText("<h3>please click </h3><a href='"+ maillink + username + "'>Here</a><h3> to confirm your registration!</h3>", true);
            mailSender.send(mimeMessage);
            System.out.println("发送html文本文件-成功");
       } catch (Exception e){
       	e.printStackTrace();
       	System.out.println("发送html文本文件-发生异常");
       	logger.error("html email send failed!", e.getMessage());
       }
    }
    
    /**
     * a发送new pw
     */
    public void sendNewPasswordEmail(String email, String newpassword){
//        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("yhz04056608@163.com");
            message.setTo(email);
            message.setSubject("Please using new password to login system!");
            message.setText("Please Remember Your New Password >>>> "+ newpassword);
            message.setCc("yhz04056608@163.com");
            mailSender.send(message);

//        }catch (Exception e){
//        	e.printStackTrace();
//            System.out.println("发送简单文本文件-发生异常"+e.getMessage());
//        }
    }
    
    
}
