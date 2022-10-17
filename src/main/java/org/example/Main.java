package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int size = 100_000;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 31);

        }
//        System.out.println(Arrays.toString(array));
        System.out.println();

        int[] array2 = Arrays.copyOf(array, size);
        int[] array3 = Arrays.copyOf(array, size);
        int[] array4 = Arrays.copyOf(array, size);
        int[] array5 = Arrays.copyOf(array, size);
        int[] array6 = Arrays.copyOf(array, size);

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

        long start5 = System.currentTimeMillis();
        Main.quickSort(array5, 0, array5.length - 1);
        System.out.println(System.currentTimeMillis() - start5 + " - recurs");
//        System.out.println(Arrays.toString(array5));

        long start6 = System.currentTimeMillis();
        Main.mergeSort(array6);
        System.out.println(System.currentTimeMillis() - start6 + " - recursMerge");
//        System.out.println(Arrays.toString(array6));
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

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

}