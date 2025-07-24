package com.study._42_OptionalApi;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private Address address;
}
