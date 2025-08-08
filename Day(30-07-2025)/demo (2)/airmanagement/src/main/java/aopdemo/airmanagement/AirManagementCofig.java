package aopdemo.airmanagement;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aopdemo.airmanagement")
@EnableAspectJAutoProxy
public class AirManagementCofig {
}
