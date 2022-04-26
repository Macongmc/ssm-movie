package com.bdqn.dao;

import com.bdqn.entity.Hall;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 放映厅(Hall)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public interface HallDao {

    /**
     * 通过ID查询单条数据
     *
     * @param hallId 主键
     * @return 实例对象
     */
    Hall queryById(Long hallId);

    /**
     * 查询指定行数据
     *
     * @param hall 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Hall> queryAllByLimit(Hall hall, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param hall 查询条件
     * @return 总行数
     */
    long count(Hall hall);

    /**
     * 新增数据
     *
     * @param hall 实例对象
     * @return 影响行数
     */
    int insert(Hall hall);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Hall> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Hall> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Hall> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Hall> entities);

    /**
     * 修改数据
     *
     * @param hall 实例对象
     * @return 影响行数
     */
    int update(Hall hall);

    /**
     * 通过主键删除数据
     *
     * @param hallId 主键
     * @return 影响行数
     */
    int deleteById(Long hallId);

    List<Hall> findHallByCinemaId(Long cinemaId);
}

