package com.study._41_StreamApi;

import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("갤럭시북3 프로", "삼성", 1850000),
                new Product("갤럭시북 이온", "삼성", 1350000),
                new Product("갤럭시탭 S9", "삼성", 950000),
                new Product("갤럭시 S24 울트라", "삼성", 1590000),
                new Product("맥북에어 M2", "애플", 1690000),
                new Product("맥북프로 M3", "애플", 2490000),
                new Product("아이패드 에어 5세대", "애플", 929000),
                new Product("아이폰 15 프로", "애플", 1550000),
                new Product("그램 17", "LG", 2190000),
                new Product("울트라 PC", "LG", 1140000)
        );

        // 실습 1: 특정 브랜드의 특정 가격대 상품 찾기
        System.out.println("=== 실습 1: 삼성 브랜드, 1,500,000원 이하 상품 ===");
        List<Product> result1 = products.stream()
                .filter(product -> product.getBrand().equals("삼성"))
                .filter(product -> product.getPrice() <= 1500000)
                .toList();
        printResult(result1);

        // 실습 2: 특정 단어가 포함된 상품 중 가격 범위 필터링
        System.out.println("\n=== 실습 2: '북'이 포함된 상품 중 1,500,000~2,000,000원 사이 ===");
        List<Product> result2 = products.stream()
                .filter(product -> product.getName().contains("북"))
                .filter(product -> product.getPrice() >= 1500000)
                .filter(product -> product.getPrice() <= 2000000)
                .toList();
        printResult(result2);

        // 실습 3: 여러 브랜드 조건과 가격 조건 조합
        System.out.println("\n=== 실습 3: 애플 또는 LG 브랜드 중 1,000,000원 이상 상품 ===");
        List<Product> result3 = products.stream()
                .filter(product -> product.getBrand().equals("애플") || product.getBrand().equals("LG"))
                .filter(product -> product.getPrice() >= 1000000)
                .filter(product -> !product.getName().contains("아이패드"))  // 아이패드 제외
                .toList();
        printResult(result3);

        // 실습 4: 복합 조건 (브랜드별 최고가 제품 제외한 나머지)
        System.out.println("\n=== 실습 4: 각 브랜드별로 2,000,000원 미만이면서 '프로'가 포함되지 않은 상품 ===");
        List<Product> result4 = products.stream()
                .filter(product -> product.getPrice() < 2000000)
                .filter(product -> !product.getName().contains("프로"))
                .filter(product -> product.getName().length() <= 10)  // 상품명이 10자 이하
                .toList();
        printResult(result4);
    }

    private static void printResult(List<Product> result) {
        if (result.isEmpty()) {
            System.out.println("해당 조건에 만족하는 상품이 없습니다.");
        } else {
            result.forEach(System.out::println);
        }
    }
}
