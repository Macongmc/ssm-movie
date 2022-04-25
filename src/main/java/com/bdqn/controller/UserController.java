package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.User;
import com.bdqn.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2022-04-23 15:41:09
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /***
     * 跳转登录页面
     * @return
     */
    @GetMapping("toLogin")
    public String tologin(){
        return "login";
    }

    /***
     * 跳转主页页面
     * @return
     */
    @RequestMapping("tomainPage")
    public String tomainPage(){
        return "mainPage";
    }
    /****
     * 登录
     * @return
     */

    @RequestMapping("login")
    @ResponseBody
    public void login(String user_name, String user_pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ModelAndView mv = new ModelAndView();

        Map<String,Object> map = new HashMap<>();
        User user = userService.login(user_name, user_pwd);
        if(user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("loginUser", user);
            if(user.getUserRole() == 0) {
                map.put("msg", "usersuccess");
                map.put("data", user);
            }else {
                map.put("msg", "adminsuccess");
                map.put("data", user);
            }
        }else{
            map.put("msg", "fail");
        }
        PrintWriter out=resp.getWriter();
        String resJSON = JSON.toJSONString(map);
        out.print(resJSON);
    }


    /***
     * 注册功能
     */
    @RequestMapping("register")
    @ResponseBody
    public void register(String user_name, String user_pwd,String user_email, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        user.setUserName(user_name);
        user.setUserPwd(user_pwd);
        user.setUserEmail(user_email);
        user.setUserRole(0);
        PrintWriter out = resp.getWriter();
        Map<String,Object> map = new HashMap<>();
        String result = "";
        User u = userService.findUserByName(user_name);
        if(u!=null) {
            result = "fail";
        }else {
            User u1 = userService.insert(user);
            if(u1!=null) {
                result =  "success";
            }else {
                result =  "fail";
            }
        }
        map.put("state", result);
        String resJSON = JSON.toJSONString(map);
        out.print(resJSON);
    }

    /****
     * 注销功能
     */
    @RequestMapping("logout")
    @ResponseBody
    public void logout(HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("user",789);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

