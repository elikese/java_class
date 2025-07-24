package com.study._41_StreamApi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String major;
    private int score;
    private String phoneNumber;
    private String email;
}
