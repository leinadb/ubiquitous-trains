package com.leinadb.trains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UbiquitousTrainsApplication {

    Logger logger = LoggerFactory.getLogger(com.leinadb.trains.UbiquitousTrainsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(com.leinadb.trains.UbiquitousTrainsApplication.class, args);
    }
}
