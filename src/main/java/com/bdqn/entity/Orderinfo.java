package com.bdqn.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(Orderinfo)实体类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public class Orderinfo implements Serializable {
    private static final long serialVersionUID = -75295313701187008L;
    
    private String orderId;
    
    private Long userId;
    
    private Long scheduleId;
    
    private String orderPosition;
    
    private Integer orderState;
    
    private Integer orderPrice;
    
    private Date orderTime;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(String orderPosition) {
        this.orderPosition = orderPosition;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

}

