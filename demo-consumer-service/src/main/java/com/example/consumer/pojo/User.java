package com.example.consumer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户对象
 * 这个类可以由服务方提供jar包，或者消费方根据服务方的接口文档自己定义类
 *
 * @author 言曌
 * @date 2021/1/28 11:20 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;
}
