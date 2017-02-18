package com.xinlee.demo.controller;

import com.xinlee.demo.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xin.lee on 2017/2/18.
 * 商品控制器
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    /**
     * 编辑商品信息
     * @param id 商品ID
     * @return 成功页面
     */
    @RequestMapping("/editItem")
    public String editItem(String id) throws CustomException {
        // 制造异常进行异常测试
        // 此处用0来模拟商品已经不存在
        if(id.equals("0")) {
            throw new CustomException("商品不存在");
        }

        /**
         * 实际项目中一般是以Ajax请求来修改商品信息，然后返回JSON数据前端判断是否修改成功（此处仅为演示Demo）
         */
        return "success";
    }

    /**
     * 删除商品信息
     * @return 成功页面
     */
    @RequestMapping("/deleteItem")
    public String deleteItem() {
        // 制造异常进行异常测试
        int num = 1/0;
        System.out.println(num);
        return "success";
    }
}
