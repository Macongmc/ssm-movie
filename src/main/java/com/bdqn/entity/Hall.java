package com.bdqn.entity;

import java.io.Serializable;

/**
 * 放映厅(Hall)实体类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public class Hall implements Serializable {
    private static final long serialVersionUID = -15618517088090079L;
    
    private Long hallId;
    
    private String hallName;
    
    private Integer hallCapacity;
    
    private Long cinemaId;


    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getHallCapacity() {
        return hallCapacity;
    }

    public void setHallCapacity(Integer hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

}

