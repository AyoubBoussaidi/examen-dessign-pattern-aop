package ma.boussaidi.Annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    @Pointcut("@annotation(Log)")
    public void logAnnotatedMethods() {
    }

    @Around("logAnnotatedMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        System.out.println(
                String.format("Méthode %s exécutée en %d millisecondes", joinPoint.getSignature().toShortString(), duration)
        );

        return result;
    }
}
