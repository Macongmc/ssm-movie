package com.bdqn.controller;

import com.bdqn.entity.Orderinfo;
import com.bdqn.service.OrderinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单表(Orderinfo)表控制层
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@RestController
@RequestMapping("orderinfo")
public class OrderinfoController {
    /**
     * 服务对象
     */
    @Resource
    private OrderinfoService orderinfoService;

    /**
     * 分页查询
     *
     * @param orderinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Orderinfo>> queryByPage(Orderinfo orderinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderinfoService.queryByPage(orderinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Orderinfo> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.orderinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param orderinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Orderinfo> add(Orderinfo orderinfo) {
        return ResponseEntity.ok(this.orderinfoService.insert(orderinfo));
    }

    /**
     * 编辑数据
     *
     * @param orderinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Orderinfo> edit(Orderinfo orderinfo) {
        return ResponseEntity.ok(this.orderinfoService.update(orderinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.orderinfoService.deleteById(id));
    }

}

