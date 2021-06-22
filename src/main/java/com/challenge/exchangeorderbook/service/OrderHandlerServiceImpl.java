package com.challenge.exchangeorderbook.service;

import com.challenge.exchangeorderbook.entity.BidDetails;
import com.challenge.exchangeorderbook.entity.SellDetails;
import com.challenge.exchangeorderbook.exception.ExchangeOrderBookException;
import com.challenge.exchangeorderbook.repository.BidDetailsRepository;
import com.challenge.exchangeorderbook.repository.SellDetailsRepository;
import com.challenge.exchangeorderbook.representation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.UUID;

/***********************************
 * This  Service  ,which will handle service logic  for
 *  multiple end points
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 15-JUN-2021
 ************************************/
@Service
public class OrderHandlerServiceImpl implements OrderHandlerService {

    private static final Logger logger = LoggerFactory.getLogger(OrderHandlerServiceImpl.class);
    @Autowired
    BidDetailsRepository bidDetailsRepository;
    @Autowired
    SellDetailsRepository sellDetailsRepository;

    /******************
     * This method will handle the service logic for add order details
     * @param orderDetails orderDetils
     *
     */

    @Override
    public void addOrder(OrderDetails orderDetails) {

        String uuid = UUID.randomUUID().toString();
        if (orderDetails.getSide().equals(Side.SELL)) {
            SellDetails sellDetails = new SellDetails();
            sellDetails.setOrderId(uuid);
            sellDetails.setAskCreatedDate(new Date());
            sellDetails.setAskQuantity(orderDetails.getQuantity());
            //todo level
            sellDetails.setLevel(1);
            sellDetails.setOrderCount(1);
            sellDetailsRepository.save(sellDetails);
        } else {
            BidDetails bidDetails = new BidDetails();
            bidDetails.setOrderId(uuid);
            bidDetails.setBidCreatedDate(new Date());
            bidDetails.setOrderCount(orderDetails.getQuantity());
            //todo level
            bidDetails.setLevel(1);
            bidDetails.setOrderCount(1);
            bidDetailsRepository.save(bidDetails);
        }
        /******************************
         * his method will handle the service logic for modify oder details
         * @param UpdateOrderDetails updateOrderDetails
         *
         * @throws ExchangeOrderBookException exchangeOrderBookException
         */
    }

    @Override
    public void modifyOrder(UpdateOrderDetails updateOrderDetails,String side) throws ExchangeOrderBookException {
        try {
            if(side.equals(Side.SELL)) {
                SellDetails sellDetails = sellDetailsRepository.findByorderId(updateOrderDetails.getOrderId());
                sellDetails.setOrderCount(sellDetails.getOrderCount() + 1);
                sellDetails.setAskPrice((double) (sellDetails.getOrderCount() + 1));
                sellDetails.setAskUpdatedDate(new Date());
                sellDetailsRepository.save(sellDetails);
            }
            else {
                BidDetails bidDetails = bidDetailsRepository.findByorderId(updateOrderDetails.getOrderId());
                bidDetails.setOrderCount(bidDetails.getOrderCount() + 1);
                bidDetails.setBidPrice(bidDetails.getBidPrice());
                bidDetails.setBidUpdatedDate(new Date());
                bidDetailsRepository.save(bidDetails);
            }
        } catch (EntityNotFoundException e) {
            logger.info("InValid GuestId");
            throw new ExchangeOrderBookException("Exception occurred while check out");
        }

    }

    //to do remove and GET calls
    @Override
    public void removeOrder(DeleteOrderDetails deleteOrderDetails) throws ExchangeOrderBookException {


    }

    @Override
    public PriceInfoResponse getPrice(String symbol, int quantity, Side side) throws ExchangeOrderBookException {
        return null;
    }
}
