package com.example.provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.provider.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * 服务端接口
 * 这里主要是测试 增删改查几种请求类型
 * 备注：这里为了简单这里返回数据了，就不封装返回结构了
 *
 * @author 言曌
 * @date 2021/1/28 11:22 下午
 */
@RestController
public class ProviderController {

    /**
     * 这里就不创建数据库了
     * 通过内存对象操作，模拟数据库读写
     */
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1L, "熊熊", "女"));
        userList.add(new User(2L, "慈慈", "男"));
        userList.add(new User(3L, "瞾曌", "男"));
        userList.add(new User(4L, "肥肥", "女"));
    }

    /**
     * 模拟获取用户列表
     *
     * @return
     */
    @GetMapping("/user")
    public String getUserList() {
        return JSON.toJSONString(userList);
    }

    /**
     * 模拟根据用户ID查询用户
     *
     * @return
     */
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        for (User user : userList) {
            if (Objects.equals(user.getId(), id)) {
                return JSON.toJSONString(user);
            }
        }
        return null;
    }


    /**
     * 模拟添加用户
     *
     * @return
     */
    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        userList.add(user);
        return "success";
    }


    /**
     * 模拟更新用户
     *
     * @return
     */
    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        for (User u : userList) {
            if (Objects.equals(u.getId(), user.getId())) {
                u = user;
                break;
            }
        }
        return "success";
    }

    /**
     * 模拟更新用户
     *
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        Iterator<User> it = userList.iterator();
        while (it.hasNext()) {
            User e = it.next();
            if (Objects.equals(id, e.getId())) {
                it.remove();
                break;
            }
        }
        return "success";
    }


}
