package com.danylostasenko.unfollower.dto;

import java.util.Objects;

public class RequestDto {
    private String url;

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
        RequestDto requestDto = (RequestDto) o;
        return Objects.equals(url, requestDto.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "url='" + url + '\'' +
                '}';
    }
}
