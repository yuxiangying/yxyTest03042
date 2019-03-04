/**
 * 
 */
package com.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
  * <p>Title: HelloJob</p>
  * <p>Description: </p>
  * <p>Company: </p> 
  * @author PC
  * @date 2019年2月13日下午3:04:17
*/
public class HelloJob implements Job{
	/*private String message;
	private Float FloatJobValue;
	private Double DoubleTriggerValue;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Float getFloatJobValue() {
		return FloatJobValue;
	}
	public void setFloatJobValue(Float floatJobValue) {
		FloatJobValue = floatJobValue;
	}
	public Double getDoubleTriggerValue() {
		return DoubleTriggerValue;
	}
	public void setDoubleTriggerValue(Double doubleTriggerValue) {
		DoubleTriggerValue = doubleTriggerValue;
	}*/

	public void execute(JobExecutionContext context) throws JobExecutionException {
		//打印当前的执行时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("HelloJob time is "+sf.format(date));
		//编写具体的业务逻辑
		System.out.println("Hello World!");
		/*JobKey key = context.getJobDetail().getKey();
		System.out.println("My Job name and group are:"+key.getName()+","+key.getGroup());
		TriggerKey trKey = context.getTrigger().getKey();
		System.out.println("My Trigger name and group are:"+trKey.getName()+","+trKey.getGroup());
		System.out.println("jobFloatValue: " + FloatJobValue);
		System.out.println("message: " + message);
		System.out.println("DoubleTriggerValue: " + DoubleTriggerValue);*/
	}

}
