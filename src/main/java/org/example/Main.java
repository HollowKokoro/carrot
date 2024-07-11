package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] bedsOfCarrot = new int[]{1, 2, 3, 4, 5};
        int leftIndex = 0;
        int lastIndex = bedsOfCarrot.length - 1;
        int rightIndex = lastIndex;
        int approach = 1;
        while (approach <= 10) {
            int leftVal = bedsOfCarrot[leftIndex];
            int rightVal = bedsOfCarrot[rightIndex];
            int sum = leftVal + rightVal;
            if (leftIndex == lastIndex || rightIndex == 0) {
                System.out.println("Группировка по грядкам заняла " + approach + " ходок");
                System.out.println(Arrays.toString(bedsOfCarrot));
                break;
            }
            if (sum > 5) {
                rightIndex--;
            } else {
                bedsOfCarrot[rightIndex] = sum;
                bedsOfCarrot[leftIndex] = 0;
                if (sum == 5) {
                    rightIndex--;
                }
                leftIndex++;
                approach++;
            }
        }
        long filledBeds = Arrays.stream(bedsOfCarrot).filter(e -> e != 0).count();
        for (int i = 1; i <= filledBeds; i++) {
            approach++;
        }
        System.out.println("Перенос морковки домой занял " + filledBeds + " ходок");
        System.out.println("Весь процесс занял " + approach + " ходок");
    }
}