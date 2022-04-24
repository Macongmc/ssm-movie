package com.bdqn.service;

import com.bdqn.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 电影院表(Cinema)表服务接口
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public interface CinemaService {

    /**
     * 通过ID查询单条数据
     *
     * @param cinemaId 主键
     * @return 实例对象
     */
    Cinema queryById(Long cinemaId);

    /**
     * 分页查询
     *
     * @param cinema 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Cinema> queryByPage(Cinema cinema, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    Cinema insert(Cinema cinema);

    /**
     * 修改数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    Cinema update(Cinema cinema);

    /**
     * 通过主键删除数据
     *
     * @param cinemaId 主键
     * @return 是否成功
     */
    boolean deleteById(Long cinemaId);

}
