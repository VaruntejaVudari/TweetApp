package com.cts.tweet;
import java.util.Scanner;

public class Main {

    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Tweet generator = new Tweet(keyboard);
        generator.mainLoop();
        keyboard.close();
    }
}
