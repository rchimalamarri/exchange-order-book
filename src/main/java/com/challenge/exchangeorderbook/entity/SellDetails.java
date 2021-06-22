package com.challenge.exchangeorderbook.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 15-JUN-2021
 ************************************/
@Entity
@Table(name ="SellDetails")
public class SellDetails {

    @Id
    @Column(name ="ORDER_ID", length = 36)
    private String orderId;
    @Column(name ="ASK_PRICE")
    @NotNull
    private Double askPrice;
    @Column(name ="ASK_QUANTITY")
    @NotNull
    private int askQuantity;

    @Column(name="SIDE")
    private String side;
    @Column(name ="ORDER_COUNT")
    private int orderCount;
    @Column(name ="LEVEL")
    private int level;
    @Column(name ="ASK_CREATED_TS")
    @Temporal(TemporalType.DATE)
    private Date askCreatedDate;
    @Column(name ="ASK_UPDATED_TS")
    @Temporal(TemporalType.DATE)
    private Date askUpdatedDate;

    public Date getAskUpdatedDate() {
        return askUpdatedDate;
    }

    public void setAskUpdatedDate(Date askUpdatedDate) {
        this.askUpdatedDate = askUpdatedDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public int getAskQuantity() {
        return askQuantity;
    }

    public void setAskQuantity(int askQuantity) {
        this.askQuantity = askQuantity;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getLevel() {
        return level;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getAskCreatedDate() {
        return askCreatedDate;
    }

    public void setAskCreatedDate(Date askCreatedDate) {
        this.askCreatedDate = askCreatedDate;
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
