package by.htp.hermanovich.aspect;

import by.htp.hermanovich.constant.Constants;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;

/**
 * This class describe util methods which are used to perform the logging operation in the application.
 * @author  Hermanovich Yauheni
 */
@Aspect
public class LoggerAspect {

    private final Logger loggerController = Logger.getLogger(this.getClass());

    /**
     * This method describes a predicate that matches join points of the Controller class.
     * Advice (action taken by an aspect at a particular join point) is associated with
     * a pointcut expression and runs at any join point matched by the pointcut.
     */
    @Pointcut("within(by.htp.hermanovich.command.* || by.htp.hermanovich.service.newsService.* || by.htp.hermanovich.dao.newsDao.*) && !execution(void by.htp.hermanovich.command.NewsCommand.initBinder(..))")
    public void executeAspect() {
    }

    /**
     * This method describes an advice surrounds a method invocation.
     * The method performs logging operations at the stages of behavior.
     * The behavior of the method-advice consists of two basic behaviors,
     * such as before and after method invocation, and one behavior
     * in the event of an exception was generated.
     * The underlying method invocation is determined by calling <i>proceed()</i> method of
     * <i>ProceedingJoinPoint</i> interface which is passed as a argument t the advice method.
     * The advice also returns its own return value or throwing an exception of the surrounded method.
     * @param joinPoint     a point during the execution of a program, executing method .
     * @return              the return value seen by the caller of the method.
     */
    @Around("executeAspect()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object methodResult = null;
        loggerController.info(Constants.EXEC_METHOD
                + joinPoint.getSignature().getDeclaringTypeName()
                + Constants.DELIMETER + joinPoint.getSignature().getName());
        try {
            methodResult = joinPoint.proceed();
        } catch (Throwable thr) {
            loggerController.error(
                    joinPoint.getSignature().getDeclaringType().getSimpleName()
                    + Constants.DELIMETER + joinPoint.getSignature().getName()
                    + Constants.DELIMETER + thr.toString()
                    + Constants.DELIMETER + thr.getCause());
        }
        loggerController.info(
                joinPoint.getSignature().getDeclaringType().getSimpleName()
                + Constants.DELIMETER + joinPoint.getSignature().getName()
                + Constants.DELIMETER + Constants.SUCCESS);
        return methodResult;
    }
}