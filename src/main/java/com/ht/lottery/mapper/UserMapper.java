package com.ht.lottery.mapper;

import com.ht.lottery.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int update(User record);

    User selectByUsercode(String usercode);

    Integer batchDealZeroUserNum();
}