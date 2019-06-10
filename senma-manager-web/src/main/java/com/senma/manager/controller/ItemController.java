package com.senma.manager.controller;

import com.senma.manager.interfaces.ItemService;
import com.senma.manager.pojo.Item;
import com.senma.manager.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @name: ItemController
*
* @description: 商品的controller
*
* @author: Yifan Zheng
*
* @Date: 2019/6/9
*
* @Version：1.0
**/
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    public ItemService itemService;

    //http://localhost/item/list/page?page=1&rows=5&sortBy=id&desc=false
    /**
     * 分页查询
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    @GetMapping("/list/page")
    @CrossOrigin
    public ResponseEntity<PageResult<Item>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc
    ){
        PageResult<Item> result = this.itemService.queryItemByPageAndSort(page,rows,sortBy,desc);
        if (result == null || result.getItems().size() == 0) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }


    /**
     * 增加商品
     * @param item
     * @return
     */
    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<Void> saveItem(Item item) {
        this.itemService.saveItem(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @CrossOrigin
    public ResponseEntity<Void> outGoing(@RequestBody Item item){
        this.itemService.outGoing(item);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
