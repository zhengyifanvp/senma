package com.senma.manager.interfaces;

import com.senma.manager.pojo.Item;
import com.senma.manager.pojo.PageResult;

public interface ItemService {

    PageResult<Item> queryItemByPageAndSort( Integer page, Integer rows, String sortBy, Boolean desc);

    void saveItem(Item item);

    void outGoing(Item item);
}
