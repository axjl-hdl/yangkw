package gov.yangkw.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * 全局异常捕捉，对程序运行时出现的异常进行捕捉并进行处理
 * 不能在客户端直接显示异常信息，所以要根据捕捉的异常返回相应的view或者string
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(Exception.class) //声明要拦截的异常是Excepiton
	@ResponseBody
	public String defaultExcetionHandler(HttpServletRequest req, Exception e){
		/*
		 * 如果返回view -- defaultExcetionHandler方法的返回数据类型是ModelAndView
		 * 如果返回String或json -- 则需要加@ResponseBody
		 */
		return "抱歉，系统内部错误";
	}
	
}
