package com.djx.bean;

import org.apache.commons.lang.time.StopWatch;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookupDemoTest {

	public static void main(String[] args) {
		//����Spring����
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		stressTest(ctx, "abstractLookupBean");//����abstractLookupBeanʵ����
		System.out.println("----------------------");
		stressTest(ctx, "standardLookupBean");
		
	}
	private static void stressTest(AbstractApplicationContext ctx,String beanName) {
		DemoBean bean=(DemoBean) ctx.getBean(beanName);
		MyHelper helper1=bean.getHelper();
		MyHelper help2=bean.getHelper();
		System.out.println("����"+beanName);
		System.out.println("Helperʵ���Ƿ���ͬ����"+(helper1==help2));
		org.springframework.util.StopWatch stopWatch=new org.springframework.util.StopWatch();
		stopWatch.start("luupupDemo");//��ʼ���������ĳ��ʱ����������ʱ��
		for (int i = 0; i < 10000; i++) {
			MyHelper helper=bean.getHelper();
		}
		stopWatch.stop();//������ǰʱ�����Ĳ���
		System.out.println("��ȡ10000�λ�����"+stopWatch.getTotalTimeMillis()+"����");
	}
}
