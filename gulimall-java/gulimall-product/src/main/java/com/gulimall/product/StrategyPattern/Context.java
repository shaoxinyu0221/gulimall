package com.gulimall.product.StrategyPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/9/9 18:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Context {

    private Strategy strategy;


    public Integer executeStrategy(){
        return strategy.doOperation();
    }


}
