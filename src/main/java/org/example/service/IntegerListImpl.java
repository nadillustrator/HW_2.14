package org.example.service;

import org.example.exeptions.ElementNotFoundException;
import org.example.exeptions.NullRequestException;
import org.example.exeptions.OutOfListSizeException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] items;
    private int size;

    public IntegerListImpl() {
        this.items = new Integer[10];
    }

    public IntegerListImpl(int length) {
        this.items = new Integer[length];
        for (int i = 0; i < items.length; i++) {
            items[i] = (int) (Math.random() * 50);
            size++;
        }
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSize();
        items[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        validateSize();
        if (index == size) {
            items[size++] = item;
            return item;
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        items[index] = item;
        return item;
    }

    @Override
    public Integer removeItem(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = items[index];
        if (index != size) {
            System.arraycopy(items, index + 1, items, index, size - index);
        }
        items[size] = null;
        size--;
        return item;
    }

    @Override
    public Integer[] sort() {
//        return bubbleSort();
//        return selectionSort();
        return insertionSort();
    };

    @Override
    public boolean contains(Integer item) {
        sort();
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Objects.equals(item, items[mid])) {
                return true;
            }

            if (item < items[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return items[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullRequestException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        items = new Integer[10];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = items[i];
        }
        return array;
    }

    private void increaseArray() {
        int newLength = (items.length * 3) / 2 + 1;
        Integer[] newArray = new Integer[newLength];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
        System.out.println(items.length);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullRequestException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new OutOfListSizeException();
        }
    }

    private void validateSize() {
        if (size >= items.length)
        increaseArray();
    }

    private Integer[] bubbleSort() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start +" - bubbleSort");
        return items;
    }


    private Integer[] selectionSort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j <size; j++) {
                if (items[j] < items[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int temp = items[minElementIndex];
            items[minElementIndex] = items[i];
            items[i] = temp;
        }
        System.out.println(System.currentTimeMillis() - start + " - selectionSort");
        return items;
    }


    private Integer[] insertionSort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < size; i++) {
            int temp = items[i];
            int j = i;
            while (j > 0 && items[j - 1] >= temp) {
                items[j] = items[j - 1];
                j--;
            }
            items[j] = temp;
        }
        System.out.println(System.currentTimeMillis() - start + " - insertionSort");
        return items;
    }


}
