package tn.inetum.blm.kaddemproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KaddemProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaddemProjectApplication.class, args);
    }

}
