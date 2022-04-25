package com.bdqn.service;

import com.bdqn.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 电影表(Movie)表服务接口
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public interface MovieService {

    /**
     * 通过ID查询单条数据
     *
     * @param movieId 主键
     * @return 实例对象
     */
    Movie queryById(Long movieId);

    /**
     * 分页查询
     *
     * @param movie 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Movie> queryByPage(Movie movie, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param movie 实例对象
     * @return 实例对象
     */
    Movie insert(Movie movie);

    /**
     * 修改数据
     *
     * @param movie 实例对象
     * @return 实例对象
     */
    Movie update(Movie movie);

    /**
     * 通过主键删除数据
     *
     * @param movieId 主键
     * @return 是否成功
     */
    boolean deleteById(Long movieId);
    List<Movie> findAllMovies(int movieState);

    List<Movie> sortMovieByScore();

    List<Movie> findMoviesLikeType(String order,String type,String area,String year,String searchMovie);

    Movie findMovieById(Long movie_id);
}
