package aopdemo.airmanagement.airTravel.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AirTravelAspects {

    @Before("execution(* aopdemo.airmanagement.components..checkIn(..))")
    void showPhotoId(JoinPoint jp) {
        System.out.println("show photo ID from aspect");
    }

    @Before("execution(* aopdemo.airmanagement.components..doSecurityCheck(..))")
    void showBoardingPass() {
        System.out.println("show boarding pass from aspect");
    }

   
    @AfterThrowing(
        pointcut = "execution(* aopdemo.airmanagement.components..checkIn(..))",throwing = "ex")
    public void handleNoSeatException(JoinPoint jp, Throwable ex) {
        System.out.println("Exception occurred during check-in: " + ex.getMessage());
    }
}
