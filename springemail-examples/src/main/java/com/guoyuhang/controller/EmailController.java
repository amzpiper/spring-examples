package com.guoyuhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/email")
public class EmailController {

    /**
     * 装配和使用邮件发送器
     */
//    @Autowired
//    JavaMailSender javaMailSender;
    String from = "from@.com";

    @GetMapping("/mailname")
    public String getMailName() {
        return "mailname";
    }

    @GetMapping("/mailname2")
    public String getMailName2() {
        return "mailname2";
    }

    @GetMapping("/mailname3")
    public String getMailName3() {
        return "mailname3";
    }

//    /**
//     * 发送简单邮件信息
//     *
//     * @param from
//     * @param to
//     * @param msg
//     */
//    @GetMapping("/sendemail")
//    public void sendSimpleEmail(String from, String to, String msg) {
//        //构建消息
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to, to, to);
//        //主题
//        message.setSubject("New Email:" + msg);
//        //内容
//        message.setText(msg);
//        //发送
//        javaMailSender.send(message);
//    }

//    /**
//     * 发送带附件邮件
//     *
//     * @param from
//     * @param to
//     * @param msg
//     */
//    public void sendMultipartEmail(String from, String to, String msg) {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject("New Subject" + msg);
//            helper.setText(msg);
//            //添加附件，加载从应用类路径下a.png
//            FileSystemResource image = new FileSystemResource("/a.png");
//            helper.addAttachment("a.png", image);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        javaMailSender.send(message);
//    }

//    /**
//     * 发送富文本邮件
//     *
//     * @param from
//     * @param to
//     * @param msg
//     */
//    public void sendHtmlEmail(String from, String to, String msg) {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = null;
//        try {
//            helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject("New Subject" + msg);
//            helper.setText("<img src='cid:logo'/>" + msg);
//            ClassPathResource image = new ClassPathResource("5.png");
//            helper.addInline("logo", image);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        javaMailSender.send(mimeMessage);
//    }

    //使用模板神额过程Email
    //Velocity,注册bean
    //装配到controller

    //Thymeleaf后见email消息
}
