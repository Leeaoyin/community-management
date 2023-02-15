package org.management.core;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.management.core.ManagementApplication;
import org.management.core.infrastructure.config.ORMConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {ManagementApplication.class})
@RunWith(SpringRunner.class)
public class BaseTest {

}
