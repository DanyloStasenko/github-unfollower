package com.danylostasenko.unfollower.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDto {
    private String login;
    private long id;
    private String url;
    private String name;
    private long followers;
    private long following;
    private List<FollowersDto> followersDto = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getFollowing() {
        return following;
    }

    public void setFollowing(long following) {
        this.following = following;
    }

    public List<FollowersDto> getFollowersDto() {
        return followersDto;
    }

    public void setFollowersDto(List<FollowersDto> followersDto) {
        this.followersDto = followersDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id &&
                followers == userDto.followers &&
                following == userDto.following &&
                Objects.equals(login, userDto.login) &&
                Objects.equals(url, userDto.url) &&
                Objects.equals(name, userDto.name) &&
                Objects.equals(followersDto, userDto.followersDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, id, url, name, followers, following, followersDto);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", followersDto=" + followersDto +
                '}';
    }
}
