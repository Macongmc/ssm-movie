package com.bdqn.service.impl;

import com.bdqn.entity.Hall;
import com.bdqn.dao.HallDao;
import com.bdqn.service.HallService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 放映厅(Hall)表服务实现类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@Service("hallService")
public class HallServiceImpl implements HallService {
    @Resource
    private HallDao hallDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hallId 主键
     * @return 实例对象
     */
    @Override
    public Hall queryById(Long hallId) {
        return this.hallDao.queryById(hallId);
    }

    /**
     * 分页查询
     *
     * @param hall 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Hall> queryByPage(Hall hall, PageRequest pageRequest) {
        long total = this.hallDao.count(hall);
        return new PageImpl<>(this.hallDao.queryAllByLimit(hall, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param hall 实例对象
     * @return 实例对象
     */
    @Override
    public Hall insert(Hall hall) {
        this.hallDao.insert(hall);
        return hall;
    }

    /**
     * 修改数据
     *
     * @param hall 实例对象
     * @return 实例对象
     */
    @Override
    public Hall update(Hall hall) {
        this.hallDao.update(hall);
        return this.queryById(hall.getHallId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hallId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long hallId) {
        return this.hallDao.deleteById(hallId) > 0;
    }
}
