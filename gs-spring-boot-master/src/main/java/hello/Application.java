package hello;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public boolean validate(String input) {
        if (input.length() >= 3 && input.length()<=20 ){
        	return true;
        }
        else{
        	return false;
        }
    }

    
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {


        };
    }

}
