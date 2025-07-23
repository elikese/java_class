package com.study._41_StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = Arrays.asList(
                new Product("삼성 갤럭시북3 프로", 1850000),
                new Product("삼성 갤럭시북 이온", 1350000),
                new Product("삼성 갤럭시탭 S9", 950000),
                new Product("삼성 갤럭시 S24 울트라", 1590000),
                new Product("애플 맥북에어 M2", 1690000),
                new Product("애플 맥북프로 M3", 2490000),
                new Product("애플 아이패드 에어 5세대", 929000),
                new Product("애플 아이폰 15 프로", 1550000),
                new Product("LG 그램 17", 2190000),
                new Product("LG 울트라PC", 1140000)
        );

        System.out.print("브랜드 명을 입력해주세요 : ");
        String brand = scanner.nextLine();

        System.out.print("최대 가격을 입력해주세요 : ");
        int maxPrice = scanner.nextInt();

        List<Product> result = products.stream()
                .filter(product -> product.getName().contains(brand))
                .filter(product -> product.getPrice() <= maxPrice)
                .toList();

        System.out.println("결과 출력");
        if(result.isEmpty()){
            System.out.println("해당 조건에 만족하는 상품이 없습니다.");
        } else {
            result.forEach(System.out::println);
        }
    }
}
