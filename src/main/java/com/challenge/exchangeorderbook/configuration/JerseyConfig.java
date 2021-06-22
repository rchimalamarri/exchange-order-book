package com.challenge.exchangeorderbook.configuration;

import com.challenge.exchangeorderbook.controller.ExchangeOrderBookController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 15-JUN-2021
 ************************************/
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ExchangeOrderBookController.class);

    }
}