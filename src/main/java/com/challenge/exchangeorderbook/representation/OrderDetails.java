package com.challenge.exchangeorderbook.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;


/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 15-JUN-2021
 ************************************/
public class OrderDetails {
    @NotNull
    @JsonProperty("Side")
    private Side side;
    @JsonProperty("Quantity")
    @NotNull
    private int quantity;

    @JsonProperty("price")
    @NotNull
    private double price;
    @JsonProperty("Symbol")
    @NotNull
    private String symbol;

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }







}
