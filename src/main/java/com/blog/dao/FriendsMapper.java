package com.blog.dao;

import com.blog.pojo.Friends;
import com.blog.pojo.FriendsKey;

public interface FriendsMapper {
    int deleteByPrimaryKey(FriendsKey key);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(FriendsKey key);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKeyWithBLOBs(Friends record);

    int updateByPrimaryKey(Friends record);
}