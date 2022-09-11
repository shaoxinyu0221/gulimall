package com.gulimall.product.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulimall.product.dao.mysql.CategoryMapper;
import com.gulimall.product.dao.po.Category;
import com.gulimall.product.util.ResponseResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/9/10 19:33
 */
@RestController
public class CategoryController {

    @Resource
    private CategoryMapper categoryMapper;

    public ResponseResult<List<Category>> getCategoryListForMenu(){
        List<Category> categoryList = categoryMapper.selectList(null);
        for (Category parentNode : categoryList) {
            setChildren(parentNode);
        }
        return new ResponseResult<>(categoryList,"success",200);
    }


    private void setChildren(Category parentNode){

        ArrayList<Category> childrenList = new ArrayList<>();

        childrenList.addAll(categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_cid", parentNode.getCatId())));

        if (childrenList.size() == 0){
            return;
        }

        for (Category category : childrenList) {
            setChildren(category);
        }

    }

}
