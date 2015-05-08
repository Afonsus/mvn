package cn.mxcorp.mvntest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import javax.annotation.Resource;

/**
 * User: landy Date: 15/2/7 Time: 上午10:54
 */
@Service
public class SystemService implements ApplicationContextAware, InitializingBean {
	@Resource
	private rt rt;
	public static final Logger LOGGER = LoggerFactory
			.getLogger(SystemService.class);
	public static final String FLAG_LOCAL = "flag_local";
	public static final TypeReference<Map<String, String[]>> MAP_TYPE_REFERENCE = new TypeReference<Map<String, String[]>>() {
	};

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub

	}

	public String test(String name, int s) {
		return rt.test(name, s);
	}
}
