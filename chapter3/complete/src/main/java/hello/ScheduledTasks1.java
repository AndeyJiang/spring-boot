package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangbin on 2018/11/12.
 */
@Component
public class ScheduledTasks1 {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks1.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    //(fixedDelayString ="2000")
    //(fixedDelay = "2000")
    public void task1() throws InterruptedException {
        Thread current = Thread.currentThread();
       // System.out.println(" 定时任务1 "+dateFormat.format(new Date())+current.getId()+ ",id:"+current.getId());
    }

}
