package com.whling.small.springframework.test.beans;

/**
 * @author whling
 */
public class UserService {

    private String serviceName;

    private UserDao userDao;

    public String queryUserName(String userName) {
        return userDao.queryUserDescByName(userName)
                .orElse("userService Name is" + serviceName);
    }
}
