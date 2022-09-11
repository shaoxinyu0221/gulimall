package com.gulimall.product.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulimall.product.dao.mysql.CategoryMapper;
import com.gulimall.product.dao.po.Category;
import com.gulimall.product.util.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/category/list/menu")
    public ResponseResult<List<Category>> getCategoryListForMenu(){
        List<Category> categoryList = categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_cid",0));
        for (Category parentNode : categoryList) {
            setChildren(parentNode);
        }
        //树形结构搞定之后还要按照顺序进行排序
        categoryList = categoryList.stream().sorted(Comparator.comparingInt(o -> (o.getSort() == null ? 0 : o.getSort()))).collect(Collectors.toList());
        return new ResponseResult<>(categoryList,"success",200);
    }


    private void setChildren(Category parentNode){

        List<Category> childrenList = new ArrayList<>();

        childrenList = categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_cid", parentNode.getCatId()));

        if (childrenList.size() == 0){
            return;
        }
        childrenList = childrenList.stream().sorted(Comparator.comparingInt(o -> (o.getSort() == null ? 0 : o.getSort()))).collect(Collectors.toList());
        parentNode.setChildrenList(childrenList);

        for (Category category : childrenList) {
            setChildren(category);
        }

    }

}
