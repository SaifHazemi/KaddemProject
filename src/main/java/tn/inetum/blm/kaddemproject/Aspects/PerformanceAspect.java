package tn.inetum.blm.kaddemproject.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {
    @Around("execution(* tn.inetum.blm.kaddemproject.Services.*.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

    @Around("execution(* tn.inetum.blm.kaddemproject.Services.*.*.retrieveAll(..))")
    public List<Object> profileAll(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        List<Object> obj = (List<Object>)pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

    @Around("execution(* tn.inetum.blm.kaddemproject.Services.*.*.getEtudiantsByDepartement(..))")
    public List<Object> profilegetEtudiantsByDepartement(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        List<Object> obj = (List<Object>)pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}
