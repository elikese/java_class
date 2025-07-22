package com.study._39_Collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain {
    /*
     * [필기] Map - 키-값 쌍을 저장하는 자료구조
     *
     * 1. Map이란?
     *    - 키(Key)와 값(Value)의 쌍을 저장하는 자료구조
     *    - 키는 중복을 허용하지 않음 (Set과 동일한 특성)
     *    - 값은 중복을 허용함
     *    - 키를 통해 값에 빠르게 접근 가능 (O(1))
     *
     * 2. Map의 특징
     *    - 키는 유일해야 함 (Set의 특성)
     *    - 같은 키로 다시 저장하면 기존 값을 덮어씀
     *    - null 키 하나까지 허용 (HashMap 기준)
     *    - null 값 여러 개 허용
     *
     * 3. Map과 Set의 관계
     *    - Map의 키 = Set과 동일한 구조
     *    - 실제로 HashSet은 내부적으로 HashMap을 사용
     *    - Map에서 Value만 제거하면 Set이 됨
     *
     * 4. Map 주요 메서드
     *    - put(key, value): 키-값 쌍 저장
     *    - get(key): 키로 값 조회
     *    - remove(key): 키로 삭제
     *    - containsKey(key): 키 존재 여부
     *    - keySet(): 모든 키를 Set으로 반환
     *    - values(): 모든 값을 Collection으로 반환
     */

    public static void main(String[] args) {
        System.out.println("=== Map 기본 사용법 ===");

        // Map 인터페이스로 선언 - 다형성 활용 (업캐스팅)
        Map<String, Integer> studentMap = new HashMap<>();

        System.out.println("--- 1단계: 키-값 저장과 조회 ---");

        // 학생 성적 데이터 저장 - put() 메서드 사용
        studentMap.put("김자바", 90);
        studentMap.put("이파이썬", 85);
        studentMap.put("박스프링", 92);
        studentMap.put("최리액트", 88);

        System.out.println("전체 학생 성적: " + studentMap);
        System.out.println("총 학생 수: " + studentMap.size());

        // 개별 학생 성적 조회 - get() 메서드 사용
        System.out.println("김자바 성적: " + studentMap.get("김자바"));
        System.out.println("이파이썬 성적: " + studentMap.get("이파이썬"));
        System.out.println("없는 학생: " + studentMap.get("홍길동")); // null 반환

        System.out.println();
        System.out.println("--- 2단계: 키 중복과 값 덮어쓰기 ---");

        // 같은 키로 다시 저장 - 기존 값이 덮어써짐을 보여줌
        System.out.println("김자바 성적 변경 전: " + studentMap.get("김자바"));
        studentMap.put("김자바", 95); // 90 → 95로 변경
        System.out.println("김자바 성적 변경 후: " + studentMap.get("김자바"));
        System.out.println("전체 맵: " + studentMap); // 여전히 4명 (키 중복 안됨)

        System.out.println();
        System.out.println("--- 3단계: 검색과 제거 ---");

        // 키 존재 여부 확인
        System.out.println("박스프링 있음? " + studentMap.containsKey("박스프링"));
        System.out.println("홍길동 있음? " + studentMap.containsKey("홍길동"));

        // 특정 값 존재 여부 확인 (비효율적 - O(n))
        System.out.println("성적 88점인 학생 있음? " + studentMap.containsValue(88));

        // 학생 제거
        Integer removedScore = studentMap.remove("최리액트");
        System.out.println("제거된 학생의 성적: " + removedScore);
        System.out.println("제거 후: " + studentMap);

        System.out.println();
        System.out.println("--- 4단계: 안전한 조회 메서드 ---");

        // getOrDefault() - 키가 없을 때 기본값 반환
        System.out.println("홍길동 성적 (기본값 0): " +
                studentMap.getOrDefault("홍길동", 0));
        System.out.println("김자바 성적: " +
                studentMap.getOrDefault("김자바", 0));

        // putIfAbsent() - 키가 없을 때만 저장
        studentMap.putIfAbsent("홍길동", 75); // 새로 추가됨
        studentMap.putIfAbsent("김자바", 100); // 이미 있으므로 무시됨
        System.out.println("putIfAbsent 후: " + studentMap);

        System.out.println();
        System.out.println("--- 5단계: Map 순회 방법들 ---");

        // 1) keySet() 사용 - 키를 통해 순회
        System.out.println("방법1 - keySet() 사용:");
        Set<String> keys = studentMap.keySet(); // 모든 키를 Set으로 반환
        for (String key : keys) {
            Integer value = studentMap.get(key);
            System.out.println("  " + key + ": " + value + "점");
        }

        System.out.println();

        // 2) entrySet() 사용 - 키-값 쌍으로 순회 (효율적)
        System.out.println("방법2 - entrySet() 사용 (권장):");
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("  " + key + ": " + value + "점");
        }

        System.out.println();
        System.out.println("--- 6단계: 실용 예제 - 단어 빈도수 계산 ---");

        // 문장에서 각 단어의 등장 횟수 계산
        String text = "java is good java is powerful java is fun";
        String[] words = text.split(" ");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            // 기존 값에 1을 더하거나, 없으면 1로 설정
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("원본 문장: " + text);
        System.out.println("단어 빈도수:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("  '" + entry.getKey() + "': " + entry.getValue() + "번");
        }

    }
}
