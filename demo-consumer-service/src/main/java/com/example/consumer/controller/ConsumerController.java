package com.example.consumer.controller;

import com.example.consumer.feign.DemoProviderService;
import com.example.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 模拟消费方去调用服务方的接口
 *
 * @author 言曌
 * @date 2021/1/28 11:48 下午
 */
@RestController
public class ConsumerController {

    @Autowired
    private DemoProviderService demoProviderService;


    /**
     * 调用服务方获取用户列表
     *
     * @return
     */
    @GetMapping("/user")
    public String getUserList() {
        return demoProviderService.getUserList();
    }

    /**
     * 调用服务方根据用户ID查询用户
     *
     * @return
     */
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        return demoProviderService.getUserById(id);
    }


    /**
     * 调用服务方添加用户
     *
     * @return
     */
    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        return demoProviderService.addUser(user);
    }


    /**
     * 调用服务方更新用户
     *
     * @return
     */
    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        return demoProviderService.updateUser(user);
    }


    /**
     * 调用服务方更新用户
     *
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return demoProviderService.deleteUser(id);
    }


}
