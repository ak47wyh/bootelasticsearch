package com.spring.boot.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/23.
 */
@Aspect
@Component
public class LogAop {

    private static Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Pointcut("execution(* com.jege.spring.boot.service..*(..))")
    public void methodPointCut(){

    }

    @Around("methodPointCut()")
    public Object methodAround(ProceedingJoinPoint p){

        long stime = System.currentTimeMillis();
        logger.debug("log:"+p.getSignature());
        logger.debug("log:"+JSON.toJSONString(p.getArgs()));
        logger.debug("log:"+p.getStaticPart());


        Object result = null;
        try {
            result = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            long etime = System.currentTimeMillis();
            logger.debug("The method costs"+(stime-etime));
        }

        return result;
    }


}
