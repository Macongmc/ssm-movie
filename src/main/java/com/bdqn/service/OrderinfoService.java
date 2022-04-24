package com.bdqn.service;

import com.bdqn.entity.Orderinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 订单表(Orderinfo)表服务接口
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public interface OrderinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Orderinfo queryById(String orderId);

    /**
     * 分页查询
     *
     * @param orderinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Orderinfo> queryByPage(Orderinfo orderinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param orderinfo 实例对象
     * @return 实例对象
     */
    Orderinfo insert(Orderinfo orderinfo);

    /**
     * 修改数据
     *
     * @param orderinfo 实例对象
     * @return 实例对象
     */
    Orderinfo update(Orderinfo orderinfo);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(String orderId);

}
