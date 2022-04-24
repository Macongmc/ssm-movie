package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.entity.Movie;
import com.bdqn.entity.User;
import com.bdqn.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电影表(Movie)表控制层
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
@Controller
@RequestMapping("movie")
public class MovieController {
    /**
     * 服务对象
     */
    @Resource
    private MovieService movieService;

    /**
     * 分页查询
     *
     * @param movie 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Movie>> queryByPage(Movie movie, PageRequest pageRequest) {
        return ResponseEntity.ok(this.movieService.queryByPage(movie, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Movie> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.movieService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param movie 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Movie> add(Movie movie) {
        return ResponseEntity.ok(this.movieService.insert(movie));
    }

    /**
     * 编辑数据
     *
     * @param movie 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Movie> edit(Movie movie) {
        return ResponseEntity.ok(this.movieService.update(movie));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.movieService.deleteById(id));
    }
    @GetMapping("movieList")
    public String movieList(){
        return "movieList";
    }
    @GetMapping("findAllMovies")
    @ResponseBody
    public Map<String, Object> findAllMovies(){
        List<Movie> list = movieService.findAllMovies(1);
        List<Movie> offList = movieService.sortMovieByScore();
        ArrayList typeArr = new ArrayList();
        String type[] = {"喜剧","动作","爱情","动画","科幻","惊悚","冒险","犯罪","悬疑"};
        for(int i = 0;i < type.length;i++) {
            List<Movie> movieList = this.movieService.findMoviesLikeType("",type[i],"","","");
            float boxOffice = 0;
            for(int j = 0; j < movieList.size();j++) {

                boxOffice +=movieList.get(j).getMovieBoxoffice();
            }
            JSONObject typeJson = new JSONObject();
            typeJson.put(type[i], boxOffice);
            typeArr.add(typeJson);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("count", list.size());
        map.put("data", list);
        map.put("sort", offList);
        map.put("type", typeArr);

        return map;
    }

}

