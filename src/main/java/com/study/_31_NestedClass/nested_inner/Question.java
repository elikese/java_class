package com.study._31_NestedClass.nested_inner;

public class Question {
    // 내부클래스
    /*
     * 내부 클래스 특징:
     * - static 키워드가 없음
     * - 바깥 클래스의 인스턴스에 속함 (소속됨)
     *
     * 언제 사용하는가?
     * 특정 클래스가 오직 하나의 클래스 안에서만 사용될 때
     * 두 클래스가 아주 긴밀하게 연결되어 있을 때(라이프 사이클도 동일할 때)
     * -> 외부의 여러 클래스에서 사용한다면 내부 클래스로 만들면 안됨
     *
     * - Choice는 Question 없이는 존재할 의미가 없음
     * - Question과 Choice는 같은 라이프사이클을 가짐
     *
     */
    private String questionText; // 문제 내용
    private Choice[] choices;    // 선택지 4개를 담을 배열
    private int correctAnswer;   // 정답 번호 (1~4 중 하나)
    private int questionNumber;  // 문제 번호

    // 생성자 - 문제의 기본 정보를 담을 생성자를 만들거예요
    public Question(int questionNumber, String questionText) {
        this.questionText = questionText;
        this.questionNumber = questionNumber;
        this.choices = new Choice[4]; // 선택지는 항상 4개로 고정 (빈 배열로 초기화)
    }

    // 선택지를 추가하는 메서드를 만들 거예요
    // 몇 번째에 어떤 선택지를 넣을지 지정할 수 있게 만들거예요
    public void addChoice(int index, String choiceText) {
        if (index >= 0 && index < 4) {
            // Choice 객체를 새로 만들어서 배열에 저장
            choices[index] = new Choice(choiceText, index + 1); // 번호는 1부터 시작하게
        }
    }

    // 정답을 설정하는 메서드를 만들 거예요
    // 정답 번호는 1번부터 4번까지로 제한할게요
    public void setCorrectAnswer(int answerNumber) {
        if (answerNumber >= 1 && answerNumber <= 4) {
            this.correctAnswer = answerNumber;
        }
    }

    // 문제와 선택지를 출력하는 메서드를 만들 거예요
    // 콘솔에 보기 좋게 출력해 줄게요
    public void printQuestion() {
        System.out.println("문제 " + questionNumber + ": " + questionText);
        System.out.println("=".repeat(50)); // 구분선
        for (Choice choice : choices) {
            if (choice != null) {
                choice.printChoice(); // 각 선택지 출력
            }
        }
        System.out.println();
    }

    // 정답을 확인하는 메서드를 만들 거예요
    // 사용자의 답과 비교해서 정답인지 알려줄게요
    public boolean checkAnswer(int userAnswer) {
        boolean isCorrect = (userAnswer == correctAnswer);

        System.out.println("당신의 답: " + userAnswer + "번");
        System.out.println("정답: " + correctAnswer + "번");
        System.out.println("결과: " + (isCorrect ? "정답!" : "틀렸습니다."));

        // 선택지 내용을 정답 해설로 보여줄게요
        if (isCorrect && choices[correctAnswer - 1] != null) {
            System.out.println("정답 해설: '" + choices[correctAnswer - 1].text + "'입니다.");
        }
        return isCorrect;
    }

    // 내부 클래스 Choice를 만들 거예요
    // 하나의 선택지를 나타내는 객체입니다
    class Choice {
        private String text;   // 선택지의 내용
        private int number;    // 몇 번째 선택지인지 번호

        // 생성자 - 선택지 내용을 받아서 초기화할 거예요
        private Choice(String text, int number) {
            this.text = text;
            this.number = number;
        }

        // 선택지를 출력하는 메서드를 만들 거예요
        public void printChoice() {
            System.out.println(number + ") " + text);
        }

        // 바깥 클래스의 정보를 접근해보는 메서드입니다
        // 내부 클래스라서 바깥 클래스의 private 필드에도 접근 가능해요
        public void showParentQuestion() {
            System.out.println("이 선택지는 문제 " + questionNumber + "에 속합니다.");
            System.out.println("문제 내용: " + questionText);
        }
    }
}
