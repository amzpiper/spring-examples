package com.kuang.demo03;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//标注这是一个切面
@Aspect
public class AnnotationPointCut {

    //自定义切入点
    @Pointcut("execution(* com.kuang.demo01.service.UserServiceImpl.*(..))")
    public void pointcut() {
    }

    //前置增强
    @Before("pointcut()")
    public void before() {
        System.out.println("***方法执行前***");
    }

    //后置增强
    @After("execution(* com.kuang.demo01.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("***方法执行后***");
    }

    //环绕增强
    //可以定义一个参数，代表要获取处理的切入的点
    @Around("execution(* com.kuang.demo01.service.UserServiceImpl.*(..))")
    public int around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("***方法环绕前***");
        System.out.println("***方法环绕:切入点joinPoint:"+joinPoint+"***");
        System.out.println("***方法环绕:签名getSignature:"+joinPoint.getSignature()+"***");
        System.out.println("***方法环绕:位置getSourceLocation:"+joinPoint.getSourceLocation()+"***");
        System.out.println("***方法环绕:对象getTarget:"+joinPoint.getTarget()+"***");
        System.out.println("***方法环绕:自己getThis:"+joinPoint.getThis()+"***");

        Object result = joinPoint.proceed();
        System.out.println("***方法环绕后***");

        //环绕返回类型要和处理切入点的方法返回类型一致
        return 0;
    }
}
