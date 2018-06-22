package com.ht.lottery.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leo on 2017/7/4.
 */
@Component
@Aspect
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String requestPath = null; // 请求地址
    private Map<?, ?> inputParamMap = null; // 传入参数
    Object outputResult = null;

    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间

    @Pointcut("execution(* com.ht.lottery.controller..*.*(..))")
    public void pt() {
    }

    /**
     * @Description: 方法调用前触发 记录开始时间
     */
    @Before("pt()")
    public void doBeforeInServiceLayer() {
        startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
    }

    /**
     * @Description: 方法调用后触发 记录结束时间
     */
    @After("pt()")
    public void doAfterInServiceLayer() {
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        this.printOptLog();
    }

    @AfterThrowing(value = "pt()", throwing = "ex")
    public void doExceptionAdvice(Exception ex) {
        System.out.println("异常通知: " + ex);
    }

    @AfterReturning(value = "pt()", returning = "result")
    public void doAfterReturningAdvice(Object result) {
        System.out.println("后置通知: " + result);
    }

    /**
     * @param pjp
     * @return
     * @throws Throwable
     * @Description: 环绕触发
     */
    @Around("pt()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        /**
         * 1.获取request信息 2.根据request获取session 3.从session中取出登录用户信息
         */
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        // 获取输入参数
        inputParamMap = request.getParameterMap();
        // 获取请求地址
        requestPath = request.getRequestURI();
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        outputResult = new HashMap<String, Object>();
        outputResult = pjp.proceed();// result的值就是被拦截方法的返回值
        return outputResult;
    }

    /**
     * @Description: 输出日志
     */
    private void printOptLog() {
        String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(startTimeMillis);
        logger.info("\n ============================================================================= \n 当前请求URL："
                + requestPath
                + "\n 请求参数："
                + JSONObject.toJSONString(inputParamMap)
                + ""
                + "\n 返回结果："
                + outputResult
                + "\n 请求时间："
                + optTime
                + "       处理时长："
                + (endTimeMillis - startTimeMillis)
                + "ms ;\n ====================================================================================================================================");
    }
}
