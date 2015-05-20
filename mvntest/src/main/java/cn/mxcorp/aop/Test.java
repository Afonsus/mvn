package cn.mxcorp.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cookie
 * @date 2015年5月19日 下午4:26:21
 **/
public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"applicationContext-aop.xml");
		CommonEmployee e = (CommonEmployee) act.getBean("commonEmployee");
		e.signIn("x", 1);
		e.logOut("y");
	}
}