package com.study._39_Collections.set;

import java.util.Objects;

public class HashUser {
    String name;
    int age;

    HashUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 주석을 풀면 중복 제거됨 (equals/hashCode 구현됨)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashUser)) return false;
        HashUser user = (HashUser) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
