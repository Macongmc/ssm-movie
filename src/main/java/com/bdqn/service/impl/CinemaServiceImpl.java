package com.bdqn.service.impl;

import com.bdqn.entity.Cinema;
import com.bdqn.dao.CinemaDao;
import com.bdqn.service.CinemaService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 电影院表(Cinema)表服务实现类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService {
    @Resource
    private CinemaDao cinemaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cinemaId 主键
     * @return 实例对象
     */
    @Override
    public Cinema queryById(Long cinemaId) {
        return this.cinemaDao.queryById(cinemaId);
    }

    /**
     * 分页查询
     *
     * @param cinema 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Cinema> queryByPage(Cinema cinema, PageRequest pageRequest) {
        long total = this.cinemaDao.count(cinema);
        return new PageImpl<>(this.cinemaDao.queryAllByLimit(cinema, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    @Override
    public Cinema insert(Cinema cinema) {
        this.cinemaDao.insert(cinema);
        return cinema;
    }

    /**
     * 修改数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    @Override
    public Cinema update(Cinema cinema) {
        this.cinemaDao.update(cinema);
        return this.queryById(cinema.getCinemaId());
    }

    /**
     * 通过主键删除数据
     *
     * @param cinemaId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long cinemaId) {
        return this.cinemaDao.deleteById(cinemaId) > 0;
    }
}
