package by.htp.hermanovich.dao.aspect;

import by.htp.hermanovich.constant.Constants;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * This class describe util methods which are used to perform
 * the logging operation in dao module of the application
 * @author Hermanovich Yauheni
 */
@Aspect
public class LoggerDaoAspect {

    private static Logger logger;

    /**
     * This method describes a predicate that matches join points of the Controller class
     * Advice (action taken by an aspect at a particular join point) is associated with
     * a pointcut expression and runs at any join point matched by the pointcut
     */
    @Pointcut("within(by.htp.hermanovich.dao.newsDao.*)")
    public void executeAspect() {
    }

    /**
     * This method describes an advice that executes before a join point,
     * but which does not have the ability to prevent execution flow proceeding to the join point
     * The method makes a log with the name of the executing method in the beginning of the pointcut
     * @param joinPoint - a point during the execution of a program
     */
    @Before("executeAspect()")
    public void beforeExecuting(JoinPoint joinPoint) {
        logger = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
        logger.info(Constants.EXEC_METHOD + joinPoint.getSignature().getName());
    }

    /**
     * This method describes an advice to be executed after a join point completes normally
     * The method makes a log with the name of the executing method and the success record
     * of the execution in the end of the pointcut
     ** @param joinPoint  - a point during the execution of a program
     */
    @AfterReturning("executeAspect()")
    public void after(JoinPoint joinPoint) {
        logger = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
        logger.info(joinPoint.getSignature().getName() + Constants.DELIMETER + Constants.SUCCESS);
    }

    /**
     * This method describes an advice to be executed if a method initiates an exception
     * @param joinPoint  - a point during the execution of a program
     */
    @AfterThrowing("executeAspect()")
    public void afterThrowing(JoinPoint joinPoint) {
        logger = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
        logger.error(Constants.EXECUTE_QUERY_TO_DB_ERROR);
    }
}