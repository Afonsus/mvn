package cn.mxcorp.aop;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author cookie
 * @date 2015年5月19日 下午4:24:12
 **/
@Component
@Aspect
public class AspectJLogger {
	/**
	 * 必须为final String类型的,注解里要使用的变量只能是静态常量类型的
	 */
	public static final String EDP2 = "execution(* cn.mxcorp.aop..*(..))";// 配置aop包下所有方法
	public static final String EDP4 = "execution(* *.sign*(..))";// 匹配所有以sign开头的方法
	public static final String EDP3 = "execution(* cn.mxcorp.aop.CommonEmployee.*(..))";// 匹配指定类下的所有方法
	public static final String EDP = "execution(* cn.mxcorp.aop.CommonEmployee.*(String))";// 匹配指定参数类型的所有方法
	public static final String EDP1 = "within(cn.mxcorp.aop.*)";

	// @Before(EDP)
	// // spring中Before通知
	// public void logBefore() {
	// System.out.println("logBefore:现在时间是:" + new Date());
	// }
	//
	// @After(EDP)
	// // spring中After通知
	// public void logAfter() {
	// System.out.println("logAfter:现在时间是:" + new Date());
	// }

	@Around(EDP)
	// spring中Around通知
	public Object logAround(ProceedingJoinPoint joinPoint) {
		System.out.println("参数为：" + Arrays.toString(joinPoint.getArgs()));
		System.out.println("logAround开始:现在时间是:" + new Date()); // 方法执行前的代理处理
		Object[] args = joinPoint.getArgs();
		Object obj = null;
		try {
			obj = joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("logAround结束:现在时间是:" + new Date()); // 方法执行后的代理处理
		System.out.println("参数为：" + Arrays.toString(joinPoint.getArgs()));
		System.out.println("返回值为：" + obj);
		return obj;
	}
}
