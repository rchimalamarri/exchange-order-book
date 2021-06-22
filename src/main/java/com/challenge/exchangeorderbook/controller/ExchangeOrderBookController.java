package com.challenge.exchangeorderbook.controller;

import com.challenge.exchangeorderbook.exception.ExchangeOrderBookException;
import com.challenge.exchangeorderbook.representation.*;
import com.challenge.exchangeorderbook.service.OrderHandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/***********************************
 * This is micro service controller ,which will handle request for
 *  multiple end points addOrder,modifyOrder,updateOrder,deleteOrder,GetPrice details
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 15-JUN-2021
 ************************************/
@Named
@Controller
@Path("exchange/trade")
public class ExchangeOrderBookController {
    private static final Logger logger = LoggerFactory.getLogger(ExchangeOrderBookController.class);

    private final OrderHandlerService orderHandlerService;

    @Autowired
    public ExchangeOrderBookController(OrderHandlerService orderHandlerService) {
        this.orderHandlerService = orderHandlerService;
    }

    @POST
    @Path("/addOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(
            @RequestBody OrderDetails requestBody) {
        try {
            orderHandlerService.addOrder(requestBody);
            return Response.status(Response.Status.CREATED).build();
        } catch (ExchangeOrderBookException e) {
            logger.info("Error occured in adding order process Due to Bad data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in adding Order");
            return internalServerError();
        }
    }

    @PUT
    @Path("modifyOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGuestCheckout(
            @RequestBody UpdateOrderDetails requestBody,String side) {

        try {
            orderHandlerService.modifyOrder(requestBody,side);
            return Response.status(Response.Status.OK).build();
        } catch (ExchangeOrderBookException e) {
            logger.info("Error occured in updating order process Due to Bad data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in  modify order");
            return internalServerError();
        }
    }


    @GET
    @Path("getPrice")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuestInfo(
            @PathParam("symbol") String symbol,
            @PathParam("quantity") int quantity,
            @PathParam("side") Side side) {
        try {
            PriceInfoResponse priceInfoResponse = orderHandlerService.getPrice(symbol, quantity, side);
            return Response.status(Response.Status.OK).entity(priceInfoResponse).build();
        } catch (ExchangeOrderBookException e) {
            logger.info("Error occured in updating order process Due to Bad data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in get order details");
            return internalServerError();
        }
    }

    @DELETE
    @Path("removeOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createParcelAccept(
            @RequestBody DeleteOrderDetails requestBody) {

        try {
            orderHandlerService.removeOrder(requestBody);
            return Response.status(Response.Status.OK).build();
        } catch (ExchangeOrderBookException e) {
            logger.info("Error occured in the process of removing order due to bad data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in removing order");
            return internalServerError();
        }
    }

    private Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private Response internalServerError() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
