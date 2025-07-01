package com.study._07_Switch;

public class Switch {
    public static void main(String[] args) {
        int ranking = 2;

        if (ranking == 1) {
            System.out.println("전액 장학금!!");
        } else if (ranking == 2) {
            System.out.println("반액 장학금!!");
        } else if (ranking == 3) {
            System.out.println("소정의 상품!!");
        } else {
            System.out.println("짝짝짝짝!!");
        }
        System.out.println("수여 끝~");

        switch (ranking) {
            case 1:
                System.out.println("전액 장학금!!");
                break; // break switch문(중괄호) 탈출
            case 2:
                System.out.println("반액 장학금!!");
                break;
            case 3:
                System.out.println("소정의 상품");
                break;
            default:
                System.out.println("짝짝짝짝!!!");
        }
        System.out.println("수여 끝~");


        // break로 case 여러개에 대해 같은 분기 가능
        switch (ranking) {
            case 1:
                System.out.println("전액 장학금!!");
                break;
            case 2:
            case 3:
                System.out.println("반액 장학금!!");
                break;
            default:
                System.out.println("짝짝짝짝!!!");
        }
        System.out.println("수여 끝~");


        // 봄: 3,4,5 => 봄입니다.
        // 여름: 6,7,8 => 여름입니다.
        // 가을: 9,10,11 => 가을입니다.
        // 겨울: 12,1,2 => 겨울입니다.
        int month = 2;

        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("봄입니다.");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름입니다.");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을입니다.");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("겨울입니다.");
        }
    }

}
