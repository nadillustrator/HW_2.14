package org.example;

import org.example.service.IntegerList;
import org.example.service.IntegerListImpl;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 5;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 31);

        }
//        System.out.println(Arrays.toString(array));
        System.out.println();

        int[] array2 = Arrays.copyOf(array, size);
        int[] array3 = Arrays.copyOf(array, size);
        int[] array4 = Arrays.copyOf(array, size);

        long start = System.currentTimeMillis();
        Main.sortBubble(array);
        System.out.println(System.currentTimeMillis() - start + " - bubble");
//        System.out.println(Arrays.toString(array));

        long start2 = System.currentTimeMillis();
        Main.sortSelection(array2);
        System.out.println(System.currentTimeMillis() - start2 + " - selection");
//        System.out.println(Arrays.toString(array2));

        long start3 = System.currentTimeMillis();
        Main.sortInsertion(array3);
        System.out.println(System.currentTimeMillis() - start3 + " - insertion");
//        System.out.println(Arrays.toString(array3));

        long start4 = System.currentTimeMillis();
        Main.sortInsertion(array4);
        System.out.println(System.currentTimeMillis() - start4 + " - bubble2");
//        System.out.println(Arrays.toString(array4));


    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    public static void sortSelection(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // min is the index of the smallest element with an index greater or equal to i
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int swap = nums[i];
            nums[i] = nums[min];
            nums[min] = swap;
        }
    }


    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void sortBubble2(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}