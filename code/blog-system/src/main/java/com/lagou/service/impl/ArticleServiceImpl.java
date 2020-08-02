package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.mapper.ArticleMapper;
import com.lagou.pojo.Article;
import com.lagou.pojo.ArticlePageVO;
import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章
 *
 * @author wangzhiqiu
 * @date 2020-08-02 19:57
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticlePageVO selectArticleByPage(int pageNum, int pageSize){
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleMapper.selectByPage();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);

        ArticlePageVO articlePageVO = new ArticlePageVO();
        articlePageVO.setArticles(pageInfo.getList());
        articlePageVO.setTotalPageNum(pageInfo.getPages());
        articlePageVO.setCurrentPageNum(pageInfo.getPageNum());

        return articlePageVO;
    }
}
