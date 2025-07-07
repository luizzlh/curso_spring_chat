package com.cursochat.cursospring;

import java.util.Arrays;
import java.util.Scanner;

public class a {
    public static String[] merge(String[] arr1, String[] arr2) {
        String[] sourceArray = arr1;

        int arraysLength = arr1.length + arr2.length;
        String[] destinationArray = new String[arraysLength];

        System.arraycopy(sourceArray, 0, destinationArray, 0, arraysLength);

        Arrays.sort(destinationArray);
        return destinationArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textArr1 = scanner.nextLine();
        String textArr2 = scanner.nextLine();
        String[] arr1 = textArr1.split(",");
        String[] arr2 = textArr2.split(",");

        String[] mergedArray = merge(arr1, arr2);
        System.out.println(Arrays.toString(mergedArray));
    }
}
