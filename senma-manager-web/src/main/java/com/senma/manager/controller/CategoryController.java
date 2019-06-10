package com.senma.manager.controller;

import com.senma.manager.interfaces.CategoryService;
import com.senma.manager.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
* @name: CategoryController
*
* @description: 商品分类controller
*
* @author: Yifan Zheng
*
* @Date: 2019/6/7
*
* @Version：1.0
**/
@RestController
@RequestMapping("/item/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询商品分类的方法
     * @param pid
     * @return
     */
    @GetMapping("/list")
    @CrossOrigin
    public ResponseEntity<List<Category>> queryCategoryListByPid(@RequestParam("pid")Long pid){
        List<Category> categories = categoryService.queryCategoryListByPid(pid);
        System.out.println("-------------------------------------------------------------------");
        return ResponseEntity.ok(categories);
    }
}
