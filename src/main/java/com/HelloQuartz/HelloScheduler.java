/**
 * 
 */
package com.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
  * <p>Title: HelloScheduler</p>
  * <p>Description: </p>
  * <p>Company: </p> 
  * @author PC
  * @date 2019年2月13日下午3:08:33
*/
public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException {
		//创建一个JobDetail实例，将实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
				.usingJobData("message", "hello myjob1")
				.usingJobData("FloatJobValue", 3.14F)
				.build();
		//创建一个Trigger实例，定义该job立即执行，并且每个两秒钟重复执行，直到永远
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.usingJobData("message", "hello myTrigger1")
				.usingJobData("DoubleTriggerValue", 2.0D)
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
				.build();
		//创建Scheduler实例
		SchedulerFactory sfact = new StdSchedulerFactory();
		Scheduler scheduler = sfact.getScheduler();
		scheduler.start();
		// 打印当前的执行时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf.format(date));
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
