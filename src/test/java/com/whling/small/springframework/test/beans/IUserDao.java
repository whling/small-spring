package com.whling.small.springframework.test.beans;

import java.util.Optional;

/**
 * @author whling
 */
public interface IUserDao {

    Optional<String> queryUserDescByName(String userName);
}
