package springdemo.dept.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Mobile {
    private Display display;

  
    public Mobile(Display display) {
        this.display = display;
    }

   
    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

	@Override
	public String toString() {
		return "Mobile [display=" + display + "]";
	}
	
	

    
}
