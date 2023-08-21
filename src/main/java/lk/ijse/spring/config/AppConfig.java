package lk.ijse.spring.config;

import lk.ijse.spring.bean.MyConnection;
import lk.ijse.spring.bean.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.spring.bean")
public class AppConfig {

    @Bean
    public MyDataSource dataSource() {

        /*return new MyDataSource(); // Context Manage Object*/

        /*MyConnection myConnection = new MyConnection();
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setMyConnection(myConnection);
        return myDataSource;*/

        // Inter Bean Dependency Invocation (Invoke bean method inside another bean method.)
        MyConnection connection1 = myConnection(); // Context Manage Object
        MyConnection connection2 = myConnection();

        System.out.println(connection1);
        System.out.println(connection2);

        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setMyConnection(connection1);
        return myDataSource;
    }

    @Bean
    public MyConnection myConnection() {
        return new MyConnection();
    }
}
