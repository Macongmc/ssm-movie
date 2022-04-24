package com.bdqn.service.impl;

import com.bdqn.entity.Movie;
import com.bdqn.dao.MovieDao;
import com.bdqn.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 电影表(Movie)表服务实现类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieDao movieDao;

    /**
     * 通过ID查询单条数据
     *
     * @param movieId 主键
     * @return 实例对象
     */
    @Override
    public Movie queryById(Long movieId) {
        return this.movieDao.queryById(movieId);
    }

    /**
     * 分页查询
     *
     * @param movie 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Movie> queryByPage(Movie movie, PageRequest pageRequest) {
        long total = this.movieDao.count(movie);
        return new PageImpl<>(this.movieDao.queryAllByLimit(movie, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param movie 实例对象
     * @return 实例对象
     */
    @Override
    public Movie insert(Movie movie) {
        this.movieDao.insert(movie);
        return movie;
    }

    /**
     * 修改数据
     *
     * @param movie 实例对象
     * @return 实例对象
     */
    @Override
    public Movie update(Movie movie) {
        this.movieDao.update(movie);
        return this.queryById(movie.getMovieId());
    }

    /**
     * 通过主键删除数据
     *
     * @param movieId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long movieId) {
        return this.movieDao.deleteById(movieId) > 0;
    }

    @Override
    public List<Movie> findAllMovies(int movieState) {
        return movieDao.findAllMovies(movieState);
    }

    @Override
    public List<Movie> sortMovieByScore() {
        return movieDao.sortMovieByScore();
    }

    @Override
    public List<Movie> findMoviesLikeType(String order, String type, String area, String year, String searchMovie) {
        return movieDao.findMoviesLikeType(order,  type, area, year, searchMovie);
    }
}
