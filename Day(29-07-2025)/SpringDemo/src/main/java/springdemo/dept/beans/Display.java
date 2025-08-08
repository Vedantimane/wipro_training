package springdemo.dept.beans;

import org.springframework.stereotype.Component;

@Component
public class Display {
     int size;  

    public Display() {
       
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

	@Override
	public String toString() {
		return "Display [size=" + size + "]";
	}
    
    
}
