package com.study._41_StreamApi;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentDto {
    private String name;        // 이름
    private String major;       // 전공
    private String grade;       // 계산된 등급 (A, B, C, D, F)
}
