package com.senma.manager.service;

import com.senma.manager.interfaces.CategoryService;
import com.senma.manager.mapper.CategoryMapper;
import com.senma.manager.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
* @name: CategoryService
*
* @description: 分类得具体实现
*
* @author: Yifan Zheng
*
* @Date: 2019/6/7
*
* @Version：1.0
**/
@Service("categoryService")

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 查询商品分类的方法
     * @param pid
     * @return
     */
    @Override
    public List<Category> queryCategoryListByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        List<Category> list = categoryMapper.select(category);
        if(CollectionUtils.isEmpty(list)){
            System.err.println("标记");
        }
        return list;
    }
}
