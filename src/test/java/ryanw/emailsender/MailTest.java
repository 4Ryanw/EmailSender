package ryanw.emailsender;/**
 * Created by NARNEW on 2021/7/5
 */

/**
 * @ClassName MailController
 * @Description TODO
 * @Author NARNEW
 * @Date 2021/7/5 0:35
 */
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.web.bind.annotation.RestController;



@RestController


public class MailTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人
        String receiver="a120935779@vip.qq.com";
        simpleMailMessage.setTo(new String[] {receiver});
        simpleMailMessage.setFrom("enxi4r@163.com");
        simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
        simpleMailMessage.setText("本测试邮件!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        // 发送邮件
        try {

            mailSender.send(simpleMailMessage);

            logger.info("邮件已经发送到账户"+receiver);


        } catch (Exception e) {

            logger.error("发送邮件时发生异常了！", e);

        }

    }

}