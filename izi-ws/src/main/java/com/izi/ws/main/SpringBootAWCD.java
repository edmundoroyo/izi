
package com.izi.ws.main;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.izi.ws.config.JpaConfiguration;

 
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.izi.ws,com.izi.domain,com.izi.dao,com.izi.ws.bean,com.izi.ws.filter"})
public class SpringBootAWCD {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAWCD.class, args);
    }
}
