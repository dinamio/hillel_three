import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ModelService;


/**
 * Created by eugen on 12/12/18.
 */
public class SpringExample {

    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);

        /*Model tesla = context.getBean(Model.class);
        System.out.println(tesla);*/
        //System.out.println(zp);
        /*Car car = (Car) context.getBean("myCar");
        System.out.println(car);*/

        ModelService service = context.getBean(ModelService.class);
        service.useDao();


    }

}
