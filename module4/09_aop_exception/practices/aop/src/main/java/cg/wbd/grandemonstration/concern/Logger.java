package cg.wbd.grandemonstration.concern;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.findAll(..))")
    public void error() {
        System.out.println("[CMS] ERROR! bbbbbb");
    }

    @Before(value = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))")
    public void beforeExcuteSerivce(){
        System.out.println("beforeExcuteSerivce");
    }

    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))", throwing = "e")
    public void log(Exception e) {
        System.out.println("[CMS] co loi xay ra: " + e.getMessage());
    }
}
