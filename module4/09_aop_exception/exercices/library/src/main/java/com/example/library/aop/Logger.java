package com.example.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    private int count=0;
    @After(value = "execution(public * com.example.library.service.BookService.rent(..)) || execution(public * com.example.library.service.BookService.giveBack(..)))")
    public void log(JoinPoint joinPoint) {
        System.out.println("method "+ joinPoint.getSignature().getName());
        System.out.println("Count: "+ ++count);
    }
}
