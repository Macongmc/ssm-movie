package com.bdqn.service.impl;

import com.bdqn.dao.HallDao;
import com.bdqn.dao.ScheduleDao;
import com.bdqn.entity.Cinema;
import com.bdqn.dao.CinemaDao;
import com.bdqn.entity.Hall;
import com.bdqn.service.CinemaService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

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
    @Resource
    private HallDao hallDao;
    @Resource
    private ScheduleDao scheduleDao;

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

    @Override
    public List<Cinema> findCinemasByMovieIdPage(Long movie_id, Long cinema_id, String dataStr, int page, int limit) {
        int startPage = (page - 1) * limit;
        int endPage = limit;
        List<Cinema> cinemaList = cinemaDao.findCinemasByMovieIdPage(movie_id,cinema_id,dataStr,startPage,endPage);
        for(Cinema cinema : cinemaList) {
            List<Hall> hallList = hallDao.findHallByCinemaId(cinema.getCinemaId());
            for(Hall hall : hallList) {
                hall.setScheduleList(scheduleDao.findScheduleByCinemaAndMovieAndHall(hall.getHallId(), hall.getCinemaId(), movie_id,dataStr));
            }
            cinema.setHallList(hallList);
        }
        return cinemaList;
    }

    @Override
    public List<Cinema> findAllCinemas() {
        return null;
    }

    @Override
    public Collection<Object> findCinemasByMovieId(Long movie_id, Long cinema_id, String dateStr) {
        return null;
    }
}
