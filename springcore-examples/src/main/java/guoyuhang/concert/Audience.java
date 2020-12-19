package guoyuhang.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* top.guoyuhang.concert.Performance.perform(..))")
    public void performance(){}

    // 前置通知
    @Before("execution(* top.guoyuhang.concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("silenceCellPhones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("takeSeats");
    }

    // 后置返回通知
    @AfterReturning("execution(* top.guoyuhang.concert.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterReturning("execution(* top.guoyuhang.concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("demandRefund");
    }

    // 环绕通知
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint point) {
        try {
            System.out.println("silencing call phones ");
            System.out.println("taking seats");
            point.proceed();
            System.out.println("ClAP CLAP CLAP");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Demanding a refund");
        }
    }

}
