package com.senma.manager.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
* @name: PageResult
*
* @description: 封装分页查询所需要的pojo
*
* @author: Yifan Zheng
*
* @Date: 2019/6/9
*
* @Version：1.0
**/
@Data
public class PageResult<T> implements Serializable {


    private static final long serialVersionUID = 9041932154599233103L;

    private Long total;// 总条数
    private Long totalPage;// 总页数
    private List<T> items;// 当前页数据

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
