package com.senma.manager.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @name: Category
 *
 * @description: 商品分类得pojo
 *
 * @author: Yifan Zheng
 *
 * @Date: 2019/6/7
 *
 * @Version：1.0
 **/
@Table(name = "sm_category")
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = -6292558193877382324L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
}
