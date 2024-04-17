package com.example.appplantorabackend.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {
    @AfterThrowing(pointcut = "execution(* org.*.*.delete(..))")
    public void deleteHandleException() {
        throw new MyNotFoundException("Delete product bo'lmadi");
    }

    @AfterThrowing(pointcut = "execution(* org..*.*.add(..))")
    public void addHandleException() {
        throw new MyConflictException("Bunday nomli product allaqachon bor");
    }

    @AfterThrowing(pointcut = "execution(* org..*.*.one(..))")
    public void oneHandleException() {
        throw new MyNotFoundException("Bunday nomli product topilmadi");
    }
}
