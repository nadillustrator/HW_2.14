package org.example.service;

import org.example.exeptions.ElementNotFoundException;
import org.example.exeptions.NullRequestException;
import org.example.exeptions.OutOfListSizeException;
public class StringListImpl implements StringList {
    private String[] items;
    private int size;

    public StringListImpl() {
        this.items = new String[10];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullRequestException();
        }
        if (size >= items.length) {
            increaseArray();
        }
        items[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (size <= index) {
            throw new OutOfListSizeException();
        }
        if (item == null) {
            throw new NullRequestException();
        }
        if (size >= items.length) {
            increaseArray();
        }
        for (int i = size; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (size <= index) {
            throw new OutOfListSizeException();
        }
        if (item == null) {
            throw new NullRequestException();
        }
        items[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }
        items[size] = null;
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        if (size <= index) {
            throw new OutOfListSizeException();
        }
        String result = items[index];
        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }
        items[size] = null;
        size--;
        return result;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return true;
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
        if (size <= index) {
            throw new OutOfListSizeException();
        }
        return items[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullRequestException();
        }
        String[] otherArray = otherList.toArray();
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(otherArray[i])) {
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
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
}
