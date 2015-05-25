package cn.mxcorp.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author cookie
 * @date 2015年5月19日 下午4:23:20
 **/
@Component
public class CommonEmployee {
	@Value("tom")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommonEmployee() {
		super();
	}

	public CommonEmployee(String name) {
		super();
		this.name = name;
	}

	public CommonEmployee signIn(String x, int y) {
		System.out.println(name + "已经签到了...........");
		return new CommonEmployee(x);
	}

	public int logOut(String x) {
		System.out.println(name + "已经登出了...........");
		return 3;
	}
}