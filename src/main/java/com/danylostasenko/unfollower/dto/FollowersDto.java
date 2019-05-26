package com.danylostasenko.unfollower.dto;

import java.util.Objects;

public class FollowersDto {

    private String login;
    private String id;
    private String url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowersDto that = (FollowersDto) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(id, that.id) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, id, url);
    }

    @Override
    public String toString() {
        return "FollowersDto{" +
                "login='" + login + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
