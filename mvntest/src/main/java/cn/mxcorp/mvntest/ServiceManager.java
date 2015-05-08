package cn.mxcorp.mvntest;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author cookie
 * @date 2015年5月6日 下午1:26:16
 **/
@Service
public class ServiceManager implements ApplicationContextAware,
		InitializingBean {
	@Resource
	public SystemService systemService;

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub

	}

}
