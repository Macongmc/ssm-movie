package com.bdqn.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 电影表(Movie)实体类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public class Movie implements Serializable {
    private static final long serialVersionUID = 676369700520091841L;
    
    private Long movieId;
    
    private String movieCnName;
    
    private String movieFgName;
    
    private String movieActor;
    
    private String movieDirector;
    
    private String movieDetail;
    
    private String movieDuration;
    
    private String movieType;
    
    private float movieScore;
    
    private float movieBoxoffice;
    
    private Long movieCommentcount;
    
    private Date movieReleasedate;
    
    private String moviePicture;
    
    private String movieCountry;
    
    private Integer movieState;


    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieCnName() {
        return movieCnName;
    }

    public void setMovieCnName(String movieCnName) {
        this.movieCnName = movieCnName;
    }

    public String getMovieFgName() {
        return movieFgName;
    }

    public void setMovieFgName(String movieFgName) {
        this.movieFgName = movieFgName;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(String movieDetail) {
        this.movieDetail = movieDetail;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Float getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(Float movieScore) {
        this.movieScore = movieScore;
    }

    public Float getMovieBoxoffice() {
        return movieBoxoffice;
    }

    public void setMovieBoxoffice(Float movieBoxoffice) {
        this.movieBoxoffice = movieBoxoffice;
    }

    public Long getMovieCommentcount() {
        return movieCommentcount;
    }

    public void setMovieCommentcount(Long movieCommentcount) {
        this.movieCommentcount = movieCommentcount;
    }

    public Date getMovieReleasedate() {
        return movieReleasedate;
    }

    public void setMovieReleasedate(Date movieReleasedate) {
        this.movieReleasedate = movieReleasedate;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public void setMoviePicture(String moviePicture) {
        this.moviePicture = moviePicture;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(String movieCountry) {
        this.movieCountry = movieCountry;
    }

    public Integer getMovieState() {
        return movieState;
    }

    public void setMovieState(Integer movieState) {
        this.movieState = movieState;
    }

}

