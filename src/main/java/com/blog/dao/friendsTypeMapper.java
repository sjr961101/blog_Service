package com.blog.dao;

import com.blog.pojo.friendsType;

public interface friendsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(friendsType record);

    int insertSelective(friendsType record);

    friendsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(friendsType record);

    int updateByPrimaryKey(friendsType record);
}