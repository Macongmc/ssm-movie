package com.bdqn.service.impl;

import com.bdqn.entity.Schedule;
import com.bdqn.dao.ScheduleDao;
import com.bdqn.service.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 场次表(Schedule)表服务实现类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private ScheduleDao scheduleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param scheduleId 主键
     * @return 实例对象
     */
    @Override
    public Schedule queryById(Long scheduleId) {
        return this.scheduleDao.queryById(scheduleId);
    }

    /**
     * 分页查询
     *
     * @param schedule 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Schedule> queryByPage(Schedule schedule, PageRequest pageRequest) {
        long total = this.scheduleDao.count(schedule);
        return new PageImpl<>(this.scheduleDao.queryAllByLimit(schedule, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    @Override
    public Schedule insert(Schedule schedule) {
        this.scheduleDao.insert(schedule);
        return schedule;
    }

    /**
     * 修改数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    @Override
    public Schedule update(Schedule schedule) {
        this.scheduleDao.update(schedule);
        return this.queryById(schedule.getScheduleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scheduleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long scheduleId) {
        return this.scheduleDao.deleteById(scheduleId) > 0;
    }
}
