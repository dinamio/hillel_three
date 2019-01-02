package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mihail on 12/27/18.
 */
public class AppContext {
    private static ApplicationContext springContext;

    public static ApplicationContext getSpringContext() {
        if (springContext == null) {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        }
        return springContext;
    }
}
