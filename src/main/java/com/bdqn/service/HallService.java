package com.bdqn.service;

import com.bdqn.entity.Hall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 放映厅(Hall)表服务接口
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public interface HallService {

    /**
     * 通过ID查询单条数据
     *
     * @param hallId 主键
     * @return 实例对象
     */
    Hall queryById(Long hallId);

    /**
     * 分页查询
     *
     * @param hall 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Hall> queryByPage(Hall hall, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param hall 实例对象
     * @return 实例对象
     */
    Hall insert(Hall hall);

    /**
     * 修改数据
     *
     * @param hall 实例对象
     * @return 实例对象
     */
    Hall update(Hall hall);

    /**
     * 通过主键删除数据
     *
     * @param hallId 主键
     * @return 是否成功
     */
    boolean deleteById(Long hallId);

}
