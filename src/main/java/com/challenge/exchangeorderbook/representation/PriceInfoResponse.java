package com.challenge.exchangeorderbook.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 15-JUN-2021
 ************************************/
public class PriceInfoResponse {

    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Symbol")
    private int symbol;
    @JsonProperty("Side")
    private Side side;
    @JsonProperty("Price")
    private double price;

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
