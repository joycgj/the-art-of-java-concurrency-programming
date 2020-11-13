package com.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jWithLog4j2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jWithLog4j2.class);

    public static void main(String[] args) {
//        LOGGER.info("hello world, use slf4j-api and log4j2");
//        LOGGER.info("hello world, use slf4j-api and log4j2 test");
        LOGGER.info("hello world, test slf4j-api and log4j21111");
        LOGGER.info("hello world, hi slf4j-api and log4j21111");
        LOGGER.info("hello world");
//        LOGGER.info("hello world, test slf4j-api and log4j21111");
//        LOGGER.info("error", new ValidateException("oo test haha"));
    }
}

class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}
