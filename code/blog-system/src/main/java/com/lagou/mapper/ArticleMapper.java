package com.lagou.mapper;

import com.lagou.pojo.Article;

import java.util.List;

/**
 * 文章
 *
 * @author wangzhiqiu
 * @date 2020-08-02 19:57
 */
public interface ArticleMapper {
    /**
     * 分页查新
     * @return
     */
    List<Article> selectByPage();
}
