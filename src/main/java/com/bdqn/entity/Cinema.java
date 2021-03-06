package com.bdqn.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 电影院表(Cinema)实体类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public class Cinema implements Serializable {
    private static final long serialVersionUID = -17340816171679113L;
    
    private Long cinemaId;
    
    private String cinemaName;
    
    private String cinemaAddress;
    private List<Hall> hallList;   //所有的放映厅集合

    public List<Hall> getHallList() {
        return hallList;
    }

    public void setHallList(List<Hall> hallList) {
        this.hallList = hallList;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

}

