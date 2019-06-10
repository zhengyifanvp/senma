package com.senma.manager.mapper;

import com.senma.manager.pojo.Item;
import com.senma.manager.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper extends MyMapper<Item> {
}
