package com.bdqn.controller;

import com.bdqn.entity.Hall;
import com.bdqn.service.HallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 放映厅(Hall)表控制层
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@RestController
@RequestMapping("hall")
public class HallController {
    /**
     * 服务对象
     */
    @Resource
    private HallService hallService;

    /**
     * 分页查询
     *
     * @param hall 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Hall>> queryByPage(Hall hall, PageRequest pageRequest) {
        return ResponseEntity.ok(this.hallService.queryByPage(hall, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Hall> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.hallService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param hall 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Hall> add(Hall hall) {
        return ResponseEntity.ok(this.hallService.insert(hall));
    }

    /**
     * 编辑数据
     *
     * @param hall 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Hall> edit(Hall hall) {
        return ResponseEntity.ok(this.hallService.update(hall));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.hallService.deleteById(id));
    }

}

