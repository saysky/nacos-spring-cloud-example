package com.example.consumer.feign.fallback;

import com.alibaba.fastjson.JSON;
import com.example.consumer.feign.DemoProviderService;
import com.example.consumer.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 如果demo-provider-service服务宕机了，DemoProviderService无法调用了。
 * 会自动调用 DemoProviderServiceFallback 里的实现
 *
 * @author 言曌
 * @date 2021/1/29 8:27 下午
 */
@Component
@Slf4j
public class DemoProviderServiceFallback implements DemoProviderService {

    @Override
    public String getUserList() {
        log.error("调用demo-provider-service服务，获取用户列表失败");
        return "您操作有点频繁哦，请稍后再试";
    }

    @Override
    public String getUserById(Long id) {
        log.error("调用demo-provider-service服务，获取用户信息失败，id:{}", id);
        return "您操作有点频繁哦，请稍后再试";
    }

    @Override
    public String addUser(User user) {
        log.error("调用demo-provider-service服务，添加用户失败，user:{}", JSON.toJSONString(user));
        // TODO 失败做补偿处理
        return "您操作有点频繁哦，请稍后再试";
    }

    @Override
    public String updateUser(User user) {
        log.error("调用demo-provider-service服务，更新用户失败, user:{}", JSON.toJSONString(user));
        // TODO 失败做补偿处理
        return "您操作有点频繁哦，请稍后再试";
    }

    @Override
    public String deleteUser(Long id) {
        log.error("调用demo-provider-service服务，删除用户失败，id:{}", id);
        // TODO 失败做补偿处理
        return "您操作有点频繁哦，请稍后再试";
    }
}
