package com.djx.bean;

import org.apache.commons.lang.time.StopWatch;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookupDemoTest {

	public static void main(String[] args) {
		//创建Spring容器
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		stressTest(ctx, "abstractLookupBean");//传递abstractLookupBean实例名
		System.out.println("----------------------");
		stressTest(ctx, "standardLookupBean");
		
	}
	private static void stressTest(AbstractApplicationContext ctx,String beanName) {
		DemoBean bean=(DemoBean) ctx.getBean(beanName);
		MyHelper helper1=bean.getHelper();
		MyHelper help2=bean.getHelper();
		System.out.println("测试"+beanName);
		System.out.println("Helper实例是否相同？："+(helper1==help2));
		org.springframework.util.StopWatch stopWatch=new org.springframework.util.StopWatch();
		stopWatch.start("luupupDemo");//开始或继续测量某个时间间隔的运行时间
		for (int i = 0; i < 10000; i++) {
			MyHelper helper=bean.getHelper();
		}
		stopWatch.stop();//结束当前时间间隔的测量
		System.out.println("获取10000次花费了"+stopWatch.getTotalTimeMillis()+"毫秒");
	}
}
