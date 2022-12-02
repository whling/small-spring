package com.whling.small.springframework.test.beans;

/**
 * @author whling
 */
public class UserService {

    private String serviceName;

    private UserDao userDao;

    public String queryUserName(String userName) {
        return userDao.queryUserDescByName(userName)
                .orElse(serviceName);
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
