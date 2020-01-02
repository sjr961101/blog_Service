package com.blog.pojo;

public class FriendsKey {
    private Integer aid;

    private String friendId;

    public FriendsKey(Integer aid, String friendId) {
        this.aid = aid;
        this.friendId = friendId;
    }

    public FriendsKey() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }
}