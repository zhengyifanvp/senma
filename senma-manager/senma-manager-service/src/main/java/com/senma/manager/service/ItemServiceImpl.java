package com.senma.manager.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senma.manager.interfaces.ItemService;
import com.senma.manager.mapper.ItemMapper;
import com.senma.manager.pojo.Item;
import com.senma.manager.pojo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

/**
* @name: ItemServiceImpl
*
* @description: 关于商品的服务
*
* @author: Yifan Zheng
*
* @Date: 2019/6/9
*
* @Version：1.0
**/
@Service("itemService")

public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemMapper itemMapper;


    /**
     * 分页查询商品
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    @Override
    public PageResult<Item> queryItemByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Item.class);
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<Item> list = itemMapper.selectByExample(example);
        //解析分页结果
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    /**
     * 增加商品的服务
     * @param item
     */
    @Override
    public void saveItem(Item item) {
        itemMapper.insert(item);
    }

    /**
     * 出货的服务
     * @param item
     */
    @Override
    public void outGoing(Item item) {
        Item oldItem = itemMapper.selectByPrimaryKey(item.getItemId());
        int i = oldItem.getItemNum() - item.getItemNum();
        Item item1 = new Item();
        item1.setItemNum(i);
        item1.setItemId(oldItem.getItemId());
        itemMapper.updateByPrimaryKeySelective(item1);
    }
}
