package org.example;

import org.example.service.IntegerList;
import org.example.service.IntegerListImpl;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        IntegerList nums = new IntegerListImpl(100_000);
//        System.out.println(Arrays.toString(nums.toArray()));
        nums.sort();
//        System.out.println(Arrays.toString(nums.toArray()));

    }
}