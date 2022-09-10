package com.gulimall.product.StrategyPattern;

import com.gulimall.product.StrategyPattern.impl.FaceId;
import com.gulimall.product.StrategyPattern.impl.FingerId;
import com.gulimall.product.StrategyPattern.impl.IdCard;


/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/9/9 18:36
 */
public class TestContext {

    public static void main(String[] args) {

        Context fingerId = new Context(new FingerId("邵鑫雨"));
        Integer result1 = fingerId.executeStrategy();
        Context idCard = new Context(new IdCard("邵鑫雨"));
        Integer result2 = idCard.executeStrategy();
        Context faceId = new Context(new FaceId("邵鑫雨"));
        Integer result3 = faceId.executeStrategy();

        if ((result1 + result2 + result3) >= 2){
            System.out.println("员工验证通过");
        }else {
            System.out.println("验证失败");
        }

    }
}
