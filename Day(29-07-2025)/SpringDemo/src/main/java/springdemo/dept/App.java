package springdemo.dept;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springdemo.dept.beans.Mobile;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("springdemo.dept.beans");  
        ctx.refresh();                     

        Mobile mobile = ctx.getBean(Mobile.class);
       

        System.out.println(mobile);
    }
}
