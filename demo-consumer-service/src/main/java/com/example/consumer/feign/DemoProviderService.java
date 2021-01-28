package com.example.consumer.feign;

import com.example.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * 这个 feign 接口一般由服务提供方提供jar
 * 或者消费方根据服务方的接口文档，自己写这个feign接口
 *
 * @author 言曌
 * @date 2021/1/28 11:42 下午
 */
@FeignClient("demo-provider-service")
public interface DemoProviderService {
    /**
     * 模拟获取用户列表
     *
     * @return
     */
    @GetMapping("/user")
    String getUserList();

    /**
     * 模拟根据用户ID查询用户
     *
     * @return
     */
    @GetMapping("/user/{id}")
    String getUserById(@PathVariable("id") Long id);


    /**
     * 模拟添加用户
     *
     * @return
     */
    @PostMapping("/user")
    String addUser(@RequestBody User user);


    /**
     * 模拟更新用户
     *
     * @return
     */
    @PutMapping("/user")
    String updateUser(@RequestBody User user);

    /**
     * 模拟更新用户
     *
     * @return
     */
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable("id") Long id);


}
