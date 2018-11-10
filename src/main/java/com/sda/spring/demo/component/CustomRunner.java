package com.sda.spring.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomRunner implements CommandLineRunner {

    @Autowired
    private ExampleList exampleList;

    private static final Logger logger = LoggerFactory.getLogger(CustomRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("random string: {}", exampleList.generate());
        logger.info("random string: {}", exampleList.generate());
        logger.info("random string: {}", exampleList.generate());
        logger.info("random string: {}", exampleList.generate());
        logger.info("random string: {}", exampleList.generate());
    }
}
