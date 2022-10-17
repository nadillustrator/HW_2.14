package org.example.service;

import org.example.exeptions.ElementNotFoundException;
import org.example.exeptions.NullRequestException;
import org.example.exeptions.OutOfListSizeException;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private String[] items;
    private int size;

    public StringListImpl() {
        this.items = new String[10];
    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        items[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateItem(item);
        validateSize();
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        items[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = items[index];
        if (index != size) {
            System.arraycopy(items, index + 1, items, index, size - index);
        }
        items[size] = null;
        size--;
        return item;
    }

    @Override
    public String[] sort() {
        return insertionSort();
    }

    ;

    @Override
    public boolean contains(String item) {
        sort();
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Objects.equals(item, items[mid])) {
                return true;
            }

            if (item.equals(items[mid])) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return items[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        items = new String[10];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = items[i];
        }
        return array;
    }

    private void increaseArray() {
        int newLength = (items.length * 3) / 2 + 1;
        String[] newArray = new String[newLength];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
        System.out.println(items.length);
    }

    private void validateItem(String item) {
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
//    j > 0 && items[j - 1] >= temp
    private String[] insertionSort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < size; i++) {
            String temp = items[i];
            int j = i;
            while (j > 0 && items[j - 1].equals(temp) || j > 0 && items[j - 1].compareTo(temp) > 0) {
                items[j] = items[j - 1];
                j--;
            }
            items[j] = temp;
        }
        System.out.println(System.currentTimeMillis() - start + " - insertionSort");
        return items;
    }
}
