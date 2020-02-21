package com.blog.dao;


import com.blog.model.Friends;

public interface FriendsMapper {


    int insert(Friends record);

    int insertSelective(Friends record);



    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKeyWithBLOBs(Friends record);

    int updateByPrimaryKey(Friends record);
}