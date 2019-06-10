package com.senma.manager.interfaces;

import com.senma.manager.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> queryCategoryListByPid(Long pid);
}
