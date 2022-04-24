package com.bdqn.service.impl;

import com.bdqn.entity.Orderinfo;
import com.bdqn.dao.OrderinfoDao;
import com.bdqn.service.OrderinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 订单表(Orderinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@Service("orderinfoService")
public class OrderinfoServiceImpl implements OrderinfoService {
    @Resource
    private OrderinfoDao orderinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public Orderinfo queryById(String orderId) {
        return this.orderinfoDao.queryById(orderId);
    }

    /**
     * 分页查询
     *
     * @param orderinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Orderinfo> queryByPage(Orderinfo orderinfo, PageRequest pageRequest) {
        long total = this.orderinfoDao.count(orderinfo);
        return new PageImpl<>(this.orderinfoDao.queryAllByLimit(orderinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param orderinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Orderinfo insert(Orderinfo orderinfo) {
        this.orderinfoDao.insert(orderinfo);
        return orderinfo;
    }

    /**
     * 修改数据
     *
     * @param orderinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Orderinfo update(Orderinfo orderinfo) {
        this.orderinfoDao.update(orderinfo);
        return this.queryById(orderinfo.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orderId) {
        return this.orderinfoDao.deleteById(orderId) > 0;
    }
}
