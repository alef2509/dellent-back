package br.com.dellent.labseq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LabelseqApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabelseqApplication.class, args);
    }
    //http://localhost:8487/swagger-ui.html
}
