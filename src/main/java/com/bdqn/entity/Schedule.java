package com.bdqn.entity;

import java.io.Serializable;

/**
 * 场次表(Schedule)实体类
 *
 * @author makejava
 * @since 2022-04-23 15:59:34
 */
public class Schedule implements Serializable {
    private static final long serialVersionUID = 695227354052503325L;
    
    private Long scheduleId;
    
    private Long hallId;
    
    private Long movieId;
    
    private String scheduleStarttime;
    
    private Integer schedulePrice;
    
    private Integer scheduleRemain;
    
    private Integer scheduleState;


    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getScheduleStarttime() {
        return scheduleStarttime;
    }

    public void setScheduleStarttime(String scheduleStarttime) {
        this.scheduleStarttime = scheduleStarttime;
    }

    public Integer getSchedulePrice() {
        return schedulePrice;
    }

    public void setSchedulePrice(Integer schedulePrice) {
        this.schedulePrice = schedulePrice;
    }

    public Integer getScheduleRemain() {
        return scheduleRemain;
    }

    public void setScheduleRemain(Integer scheduleRemain) {
        this.scheduleRemain = scheduleRemain;
    }

    public Integer getScheduleState() {
        return scheduleState;
    }

    public void setScheduleState(Integer scheduleState) {
        this.scheduleState = scheduleState;
    }

}

