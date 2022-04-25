package com.bdqn.dao;

import com.bdqn.entity.Cinema;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 电影院表(Cinema)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public interface CinemaDao {

     List<Cinema> findCinemasByMovieIdPage(Long movie_id, Long cinema_id, String dataStr, int startPage, int endPage);

    /**
     * 通过ID查询单条数据
     *
     * @param cinemaId 主键
     * @return 实例对象
     */
    Cinema queryById(Long cinemaId);

    /**
     * 查询指定行数据
     *
     * @param cinema 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Cinema> queryAllByLimit(Cinema cinema, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cinema 查询条件
     * @return 总行数
     */
    long count(Cinema cinema);

    /**
     * 新增数据
     *
     * @param cinema 实例对象
     * @return 影响行数
     */
    int insert(Cinema cinema);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cinema> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Cinema> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cinema> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Cinema> entities);

    /**
     * 修改数据
     *
     * @param cinema 实例对象
     * @return 影响行数
     */
    int update(Cinema cinema);

    /**
     * 通过主键删除数据
     *
     * @param cinemaId 主键
     * @return 影响行数
     */
    int deleteById(Long cinemaId);

}

