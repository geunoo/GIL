package com.example.crud.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class LoggerAop {

    @Pointcut("execution(* com.example.crud.controller.*.*(..))")
    private void cnt() {}

    @Before("cnt()")
    public void beforeLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Object[] args = joinPoint.getArgs();
        log.info("==================start==================");
        log.info("name :: " + method.getName());
        for (Object arg : args) {
            log.info("parameter type :: " + arg.getClass().getSimpleName());
            log.info("parameter value :: " + arg);
        }
    }

    @AfterReturning(value = "cnt()", returning = "returnObj")
    public void afterLog(JoinPoint joinPoint, Object returnObj) {
        if (returnObj == null) {
            return;
        }

        log.info("==================return==================");
        log.info("parameter type :: " + returnObj.getClass().getSimpleName());
        log.info("parameter value :: " + returnObj);
    }
}
