package com.gulimall.product.StrategyPattern.impl;

import com.gulimall.product.StrategyPattern.Strategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/9/9 18:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaceId implements Strategy {

    private String FaceId;

    @Override
    public Integer doOperation() {
        if ("邵鑫雨".equals(getFaceId())){
            return 1;
        }
        return 0;
    }

}
