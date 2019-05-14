package com.danylostasenko.unfollower.dto;

import java.util.List;
import java.util.Objects;

public class ResponseDto {
    private Integer usersSize;
    private List<String> users;

    public Integer getUsersSize() {
        return usersSize;
    }

    public void setUsersSize(Integer usersSize) {
        this.usersSize = usersSize;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto that = (ResponseDto) o;
        return Objects.equals(usersSize, that.usersSize) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersSize, users);
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "usersSize=" + usersSize +
                ", users=" + users +
                '}';
    }
}
