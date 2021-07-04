package ryanw.emailsender.timer;/**
 * Created by NARNEW on 2021/7/4
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ryanw.emailsender.service.MailService;

import java.time.LocalDateTime;

/**
 * @ClassName ScheduleTask
 * @Description 开启定时任务
 * @Author NARNEW
 * @Date 2021/7/4 23:51
 */
@Configuration
@EnableScheduling
public class ScheduleTask {
    @Autowired
    MailService mailService;
    @Scheduled(cron = "0 30 9 * * ?") //每天早上9点半触发
    private void executeScheduleTask(){
        final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
        logger.info("执行任务"+ LocalDateTime.now());
        mailService.sendMail();
        logger.info("任务结束"+ LocalDateTime.now());
    }
}



