package hello;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangbin on 2018/11/13.
 * 测试线程：当任务一和任务2同时运行，将任务2sleep 可见任务1和任务2都不执行了，任务2的start和end之间没有日志
 * 且id是同一个，要想两个任务独立并行运行，需要SchuledConfig.java;
 */
@Component
@EnableAsync
/**
 * 异步处理：虽然现充中有sleep，但不影响定时任务的正常触发
 */
public class ScheduledTasks2 {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 2000)
    @Async //异步执行，配合线程池执行并发
    public void task2() throws InterruptedException {
        Thread current = Thread.currentThread();

        System.out.println(" 定时任务2:Start "+sdf.format(new Date())+current.getId()+ ",id:"+current.getId());
        Thread.sleep(10000);
        System.out.println(" 定时任务2:End "+sdf.format(new Date())+current.getId()+ ",id:"+current.getId());
    }
}
