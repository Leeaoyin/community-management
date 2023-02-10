package org.management.core;

import org.management.core.infrastructure.config.ORMConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackageClasses = {ManagementApplication.class})
@ComponentScan(basePackages = {"org.management.core.*"})
@Import({ORMConfig.class})
@MapperScan(basePackages = {"org.management.core.infrastructure.repository.mapper"})
public class ManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class,args);
    }
}
