package lk.ijse.spring;

import lk.ijse.spring.bean.MyConnection;
import lk.ijse.spring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        context.registerShutdownHook();

        // Context Bean Dependency Invocation
        MyConnection bean = context.getBean(MyConnection.class);
        System.out.println(bean);
    }
}
