## 접근 제어자의 종류

1. private
    - 가장 제한적, 자기 클래스 내부에서만 접근(".") 가능
    - 외부에서 접근하지 못하도록 완전히 숨기기

2. default
   - 같은 패키지 내부에서만 접근(".") 가능 - pakage private라고도 함
   - 패키지 단위로 묶인 내부 구현끼리는 공유

3. protected
   - 같은 패키지 내부 + 상속관계 일때만 접근 가능 - 나중에
   - 상속 구조에서 일부만 공개할 때 사용

4. public
   - 가장 개방적, 어디서든 접근(".") 가능
   - 외부에 완전히 공개되는 API나 라이브러리 등에 사용

## 접근 제어자를 사용하는 이유
- 데이터 보호: 중요한 데이터를 외부에서 함부로 변경하지 못하게 함
- 코드 안정성: 정해진 방법으로만 데이터를 변경하게 하여 오류 방지