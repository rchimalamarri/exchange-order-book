package com.challenge.exchangeorderbook.service;
import com.challenge.exchangeorderbook.exception.ExchangeOrderBookException;
import com.challenge.exchangeorderbook.representation.*;
import org.springframework.stereotype.Service;
@Service
public interface OrderHandlerService {

        void addOrder(OrderDetails orderDetails)throws ExchangeOrderBookException;
        void modifyOrder(UpdateOrderDetails updateOrderDetails,String side)throws ExchangeOrderBookException;
        void removeOrder(DeleteOrderDetails deleteOrderDetails)throws ExchangeOrderBookException;
        PriceInfoResponse getPrice(String symbol, int quantity, Side side)throws ExchangeOrderBookException;
    }

