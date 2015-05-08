package cn.mxcorp.mvntest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class rt implements ApplicationContextAware, InitializingBean {

	/**
	 * @Fields name : 姓名
	 */
	private String name;

	/**
	 * @Description:测试用例
	 * @param name
	 * @param s
	 * @return:void
	 */
	public String test(String name, int s) {
		return "你好";
	}

	/**
	 * 获取name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub

	}

}
