package cn.mxcorp.mvntest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cookie
 * @date 2015年5月6日 上午11:13:34
 **/
public class core {

	public static void main(String[] args) {
		String springXml = "/applicationContext.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				springXml);
		ctx.start();
		System.out.println(ctx.getBean("systemService").hashCode());
		System.out.println(ctx.getBean("systemService").hashCode());
		System.out.println(ctx.getBean("rt").hashCode());
		System.out.println(ctx.getBean("rt").hashCode());
		System.out
				.println((((ServiceManager) ctx.getBean("serviceManager")).systemService
						.test("a", 1)));
	}
}
