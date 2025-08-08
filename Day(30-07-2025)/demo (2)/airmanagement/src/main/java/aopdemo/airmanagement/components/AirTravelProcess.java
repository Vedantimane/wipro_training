package aopdemo.airmanagement.components;

import org.springframework.stereotype.Component;

import aopdemo.airmanagement.expections.NoSeatAvailableException;

@Component
public class AirTravelProcess {

	public void checkIn(Boolean flag) throws NoSeatAvailableException {
        if (flag) {
            System.out.println("Check-in successful");
        } else {
            throw new NoSeatAvailableException("No seat available during check-in.");
        }
    }

    public void collectBoardingPass() {
        System.out.println("collecting boradingpass");
    }

    public void doSecurityCheck() {
        System.out.println("doing Security Check");
    }

    public void doBoarding() {
        System.out.println("doing Boarding");
    }
}
