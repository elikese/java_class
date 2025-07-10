package com.study._21_Static.user;

public class User {

    private String name; // 이름
    private String personalNumber; // 주민번호


    public User(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public static String getMaskingName(String name) {
        return name.substring(0, 1) + "*" + name.substring(2);
    }

    public static String getMaskingPersonalNumber(String personalNumber) {
        int dashIndex = personalNumber.indexOf('-');
        return personalNumber.substring(0, dashIndex + 1) + "*******";
    }

    public static void makeMaskingToUser(User user) {
        String maskedName = getMaskingName(user.getName());
        String maskedPersonalNumber = getMaskingPersonalNumber(user.getPersonalNumber());
        user.setName(maskedName);
        user.setPersonalNumber(maskedPersonalNumber);
    }

}
