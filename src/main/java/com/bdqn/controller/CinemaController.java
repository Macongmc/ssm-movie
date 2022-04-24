package com.bdqn.controller;

import com.bdqn.entity.Cinema;
import com.bdqn.service.CinemaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 电影院表(Cinema)表控制层
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@RestController
@RequestMapping("cinema")
public class CinemaController {
    /**
     * 服务对象
     */
    @Resource
    private CinemaService cinemaService;

    /**
     * 分页查询
     *
     * @param cinema 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Cinema>> queryByPage(Cinema cinema, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cinemaService.queryByPage(cinema, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Cinema> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.cinemaService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cinema 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Cinema> add(Cinema cinema) {
        return ResponseEntity.ok(this.cinemaService.insert(cinema));
    }

    /**
     * 编辑数据
     *
     * @param cinema 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Cinema> edit(Cinema cinema) {
        return ResponseEntity.ok(this.cinemaService.update(cinema));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.cinemaService.deleteById(id));
    }

}

