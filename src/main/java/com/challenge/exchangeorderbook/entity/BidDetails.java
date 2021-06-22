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
@Table(name="BidDetails")
public class BidDetails {
    @Id
    @Column(name ="ORDER_ID", length = 36)
    private String orderId;
    @Column(name ="BID_PRICE")
    @NotNull
    private Double bidPrice;
    @Column(name ="ORDER_COUNT")
    private int orderCount;
    @Column(name ="SIDE")
    private String side;
    @Column(name ="BID_QUANTITY")
    @NotNull
    private int bidQuantity;
    @Column(name ="LEVEL")
    private int level;
    @Column(name ="BID_CREATED_TS")
    @Temporal(TemporalType.DATE)
    private Date bidCreatedDate;
    @Column(name ="BID_UPDATED_TS")
    @Temporal(TemporalType.DATE)
    private Date bidUpdatedDate;
    public String getOrderId() {
        return orderId;
    }

    public Date getBidUpdatedDate() {
        return bidUpdatedDate;
    }

    public void setBidUpdatedDate(Date bidUpdatedDate) {
        this.bidUpdatedDate = bidUpdatedDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getBidCreatedDate() {
        return bidCreatedDate;
    }

    public void setBidCreatedDate(Date bidCreatedDate) {
        this.bidCreatedDate = bidCreatedDate;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(int bidQuantity) {
        this.bidQuantity = bidQuantity;
    }
}

