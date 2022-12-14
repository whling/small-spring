package com.whling.small.springframework.test.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author whling
 */
public class UserDao implements IUserDao {

    private Map<String, String> userMap;

    static {

    }

    public void init() {
        System.out.println("4. init UserDao");
        userMap = new HashMap<>();
        userMap.put("h1", "world1");
        userMap.put("h2", "world2");
        userMap.put("h3", "world3");
    }

    public void close() {
        System.out.println("12. close UserDao");
        userMap.clear();
    }

    @Override
    public Optional<String> queryUserDescByName(String userName) {
        return Optional.ofNullable(userMap.get(userName));
    }
}
