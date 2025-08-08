package aopdemo.airmanagement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aopdemo.airmanagement.components.AirTravelProcess;
import aopdemo.airmanagement.expections.NoSeatAvailableException;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("aopdemo.airmanagement.*");
        ctx.refresh();

        AirTravelProcess air = ctx.getBean(AirTravelProcess.class);

        try {
            air.checkIn(true); 
            
            air.collectBoardingPass();
            air.doSecurityCheck();
            air.doBoarding();
        } catch (NoSeatAvailableException ex) {
            System.out.println("check with your manager");
            
        }

       
    }
}
