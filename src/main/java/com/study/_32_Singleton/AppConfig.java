package com.study._32_Singleton;

public class AppConfig {
    // AppConfig 클래스를 싱글톤을 적용하여 구현해 주세요

    private static AppConfig instance;

    private String apiKey;
    private String appMode;

    private AppConfig() {
        this.apiKey = "DEFAULT-KEY";
        this.appMode = "PRODUCTION";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

}
