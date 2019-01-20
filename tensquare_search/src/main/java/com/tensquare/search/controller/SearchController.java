package com.tensquare.search.controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author huachen
 * @create 2019-01-16 12:31
 */

@RestController
@RequestMapping("/article")
@CrossOrigin
public class SearchController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article) {
        articleService.save(article);
        return new Result(true, StatusCode.OK, "成功");
    }

    @RequestMapping(value = "/{key}/{page}/{size}", method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key, @PathVariable int page, @PathVariable int size) {
        Page<Article> pageDate = articleService.findByKey(key, page, size);
        if (pageDate.getTotalElements() == 0)
            return new Result(false, StatusCode.OK, "没有找到数据");
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(pageDate.getTotalElements(), pageDate.getContent()));
    }
}
