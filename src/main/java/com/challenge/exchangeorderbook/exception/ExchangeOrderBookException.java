package com.challenge.exchangeorderbook.exception;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 15-JUN-2021
 ************************************/
public class ExchangeOrderBookException extends Exception {

    public ExchangeOrderBookException(String errorMessage) {
        super(errorMessage);
    }
}
