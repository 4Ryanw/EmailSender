package ryanw.emailsender.service;/**
 * Created by NARNEW on 2021/7/5
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ryanw.emailsender.dao.MailDao;
import ryanw.emailsender.pojo.Staff;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.List;

/**
 * @ClassName MailService
 * @Description 发送邮件服务类
 * @Author NARNEW
 * @Date 2021/7/5 0:06
 */
@Service
public class MailService  {
    @Autowired
    private  JavaMailSender mailSender;

    @Autowired
    private MailDao mailDao;

    //发件人地址
    private static String senderAddress;

    @Value("${spring.mail.username}")
    public  void setSenderAddress(String senderAddress) {
        MailService.senderAddress = senderAddress;
    }

    /**
     * 获得创建一封邮件的实例对象
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
    public  void sendMail(){
        final Logger logger = LoggerFactory.getLogger(MailService.class);

        //创建邮件的实例对象
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // 设置寄件人,主题
        simpleMailMessage.setFrom(senderAddress);

        simpleMailMessage.setSubject("生日祝福邮件");

        List<Staff> todayList = mailDao.getTodayList();
        for (Staff staff : todayList) {
            // 设置收件人，发送内容
            simpleMailMessage.setTo(staff.getEmailAddress());

            simpleMailMessage.setText(staff.getName()+",祝你生日快乐!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            // 发送邮件
            try {

                mailSender.send(simpleMailMessage);

                logger.info("邮件已经发送到账户"+staff.getEmailAddress());

            } catch (Exception e) {

                logger.error("发送邮件时发生异常了！", e);

            }

        }





    }

}
