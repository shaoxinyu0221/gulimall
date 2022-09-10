package com.gulimall.product.StrategyPattern.impl;

import com.gulimall.product.StrategyPattern.Strategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/9/9 18:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdCard implements Strategy {

    private String idCard;

    @Override
    public Integer doOperation() {
        if ("邵鑫雨".equals(getIdCard())){
            return 1;
        }
        return 0;
    }
}
