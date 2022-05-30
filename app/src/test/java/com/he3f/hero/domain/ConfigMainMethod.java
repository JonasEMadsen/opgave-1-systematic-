package com.he3f.hero.domain;

public class ConfigMainMethod {

    public static void main(String[] args) {
        System.setProperty(Config.CONFIG_PATH, "/src/test/resources/config.properties");
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println(Config.getInstance());

            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                System.out.println(Config.getInstance());

            }
        };
        Thread thread3 = new Thread() {
            public void run() {
                System.out.println(Config.getInstance());

            }
        };

    }

}
