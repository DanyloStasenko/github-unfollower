package com.danylostasenko.unfollower.dto;

import java.util.Objects;

public class RequestDto {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDto requestDto = (RequestDto) o;
        return Objects.equals(username, requestDto.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
