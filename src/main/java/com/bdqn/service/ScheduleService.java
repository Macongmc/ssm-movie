package com.bdqn.service;

import com.bdqn.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 场次表(Schedule)表服务接口
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public interface ScheduleService {

    /**
     * 通过ID查询单条数据
     *
     * @param scheduleId 主键
     * @return 实例对象
     */
    Schedule queryById(Long scheduleId);

    /**
     * 分页查询
     *
     * @param schedule 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Schedule> queryByPage(Schedule schedule, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    Schedule insert(Schedule schedule);

    /**
     * 修改数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    Schedule update(Schedule schedule);

    /**
     * 通过主键删除数据
     *
     * @param scheduleId 主键
     * @return 是否成功
     */
    boolean deleteById(Long scheduleId);

}
