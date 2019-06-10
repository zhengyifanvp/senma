package com.senma.manager.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @name: Item
 *
 * @description: 商品信息的pojo
 *
 * @author: Yifan Zheng
 *
 * @Date: 2019/6/9
 *
 * @Version：1.0
**/

@Table(name = "sm_item")
@Data
public class Item implements Serializable {
    private static final long serialVersionUID = 2994729006171537451L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer itemId;
    private String itemName;
    private String itemCategory;
    private Integer itemNum;

}
