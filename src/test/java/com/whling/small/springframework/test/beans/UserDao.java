package com.whling.small.springframework.test.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author whling
 */
public class UserDao {

    private Map<String, String> userMap;

    static {

    }

    public void init() {
        System.out.println("init UserDao");
        userMap = new HashMap<>();
        userMap.put("h1", "world1");
        userMap.put("h2", "world2");
        userMap.put("h3", "world3");
    }

    public void close() {
        System.out.println("close UserDao");
        userMap.clear();
    }

    public Optional<String> queryUserDescByName(String userName) {
        return Optional.ofNullable(userMap.get(userName));
    }
}
