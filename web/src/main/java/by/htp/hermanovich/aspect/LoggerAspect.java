package by.htp.hermanovich.aspect;

import by.htp.hermanovich.constant.Constants;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;

/**
 * This class describe util methods which are used to perform
 * the logging operation in web module of the application
 * @author  Hermanovich Yauheni
 */
@Aspect
public class LoggerAspect {

    private final Logger loggerController = Logger.getLogger(this.getClass());

    /**
     * This method describes a predicate that matches join points of the Controller class
     * Advice (action taken by an aspect at a particular join point) is associated with
     * a pointcut expression and runs at any join point matched by the pointcut
     */
    @Pointcut("within(by.htp.hermanovich.command.* || by.htp.hermanovich.service.newsService.* || by.htp.hermanovich.dao.newsDao.*) && !execution(void by.htp.hermanovich.command.NewsCommand.initBinder(..))")
    public void executeAspect() {
    }

    /**
     * This method describes an advice that executes before a join point,
     * but which does not have the ability to prevent execution flow proceeding to the join point
     * The method makes a log with the name of the executing method in the beginning of the pointcut
     * @param joinPoint - a point during the execution of a program
     */
    @Before("executeAspect()")
    public void beforeExecution(JoinPoint joinPoint) {
        loggerController.info(Constants.EXEC_METHOD + joinPoint.getSignature().getDeclaringTypeName()
                + Constants.DELIMETER + joinPoint.getSignature().getName());
    }

    /**
     * This method describes an advice to be executed after a join point completes normally
     * The method makes a log with the name of the executing method and the success record
     * of the execution in the end of the pointcut
     ** @param joinPoint  - a point during the execution of a program
     */
    @AfterReturning("executeAspect()")
    public void afterReturning(JoinPoint joinPoint) {
        loggerController.info(joinPoint.getSignature().getDeclaringType().getSimpleName()
                + Constants.DELIMETER + joinPoint.getSignature().getName()
                + Constants.DELIMETER + Constants.SUCCESS);
    }

    /**
     * This method describes an advice to be executed if a method initiates an exception
     * @param joinPoint  - a point during the execution of a program
     */
    @AfterThrowing("executeAspect()")
    public void afterThrowing(JoinPoint joinPoint) {
        loggerController.error(joinPoint.getSignature().getDeclaringType().getSimpleName()
                + Constants.DELIMETER + joinPoint.getSignature().getName() + Constants.DELIMETER + Constants.SERVICE_EXCEPTION);
    }
}