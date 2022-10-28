package org.example.service;

import org.example.exeptions.ElementNotFoundException;
import org.example.exeptions.NullRequestException;
import org.example.exeptions.OutOfListSizeException;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private IntegerList list = new IntegerListImpl();

    @AfterEach
    public void afterEach() {
        list = new IntegerListImpl();
    }

    //add(Integer item);
    @Test
    void shouldReturnCorrectValueAddTest1() {
        Integer expected = list.add(1);
        Assertions.assertEquals(expected, 1);
    }

    @Test
    void shouldReturnCorrectValueAddTest2() {
        list.add(2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{2};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnNullRequestExceptionAddTest3() {
        assertThrows(NullRequestException.class,
                () -> list.add(null));
    }

    //add(int index, Integer item);
    @Test
    void shouldReturnCorrectValueAddWithIndexTest1() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1, 2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2, 1, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnNullRequestExceptionAddWithIndexTest2() {
        list.add(1);
        list.add(1);
        assertThrows(NullRequestException.class,
                () -> list.add(1, null));
    }

    @Test
    void shouldReturnCorrectValueAddWithIndexTest3() {
        list.add(1);
        list.add(1, 2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnOutOfListSizeExceptionAddWithIndexTest4() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.add(7, 2));
    }

    //set(int index, Integer item);
    @Test
    void shouldReturnCorrectValueSetTest1() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.set(1, 2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnOutOfListSizeExceptionSetTest2() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.set(7, 2));
    }

    //remove(Integer item);
    @Test
    void shouldReturnCorrectValueRemoveTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.removeItem(2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnElementNotFoundExceptionRemoveTest2() {
        list.add(1);
        list.add(1);
        assertThrows(ElementNotFoundException.class,
                () -> list.removeItem(2));
    }

    //remove(int index);
    @Test
    void shouldReturnCorrectValueRemoveWithIndexTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.remove(1);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnOutOfListSizeExceptionRemoveTest2() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.remove(7));
    }

    //sort();
    @Test
    void shouldReturnCorrectValueSortTest1() {
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.sort();
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(expectedResult, result);
    }


    //contains(Integer item);
    @Test
    void shouldReturnTrueContainsTest1() {
        list.add(7);
        list.add(9);
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        assertTrue(list.contains(2));
    }

    @Test
    void shouldReturnFalseContainsTest2() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertFalse(list.contains(5));
    }

    //indexOf(Integer item);
    @Test
    void shouldReturnCorrectIndexOfItemIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.indexOf(2), 1);
    }

    @Test
    void shouldReturnMinusOneIfThereAreNoItemIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.indexOf(3), -1);
    }


    //lastIndexOf(Integer item)
    @Test
    void shouldReturnCorrectIndexOfItemLastIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.lastIndexOf(1), 2);
    }

    @Test
    void shouldReturnMinusOneIfThereAreNoItemLastIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.lastIndexOf(3), -1);
    }

    //get(int index);
    @Test
    void shouldReturnCorrectValueGetTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        Assertions.assertEquals(list.get(1), 2);
    }

    @Test
    void shouldReturnOutOfListSizeExceptionGetTest2() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.get(7));
    }

    //equals(StringList otherList);
    @Test
    void shouldReturnTrueIfStringListsAreEqualsEqualsTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        IntegerList expectedList = new IntegerListImpl();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        assertTrue(list.equals(expectedList));
    }

    @Test
    void shouldReturnFalseIfStringListsAreNotEqualsEqualsTest2() {
        list.add(2);
        list.add(2);
        list.add(1);
        IntegerList expectedList = new IntegerListImpl();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        assertFalse(list.equals(expectedList));
    }

    @Test
    void shouldReturnNullRequestExceptionEqualsTest3() {
        list.add(1);
        list.add(1);
        IntegerList expectedList = null;
        assertThrows(NullRequestException.class,
                () -> list.equals(expectedList));
    }


    //size();
    @Test
    void shouldReturnCorrectSizeTest1() {
        list.add(1);
        list.add(1);
        list.add(1, 1);
        list.set(1, 1);
        list.remove(1);

        assertEquals(list.size(), 2);
    }

    //isEmpty();
    @Test
    void shouldReturnTrueIsEmptyTest1() {
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldReturnFalseIsEmptyTest2() {
        list.add(5);
        assertFalse(list.isEmpty());
    }

    //clear();
    @Test
    void shouldRemoveAllItemsAndDecreaseSizeClearTest() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.clear();
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{};
        assertArrayEquals(expectedResult, result);
    }


    //toArray();
    @Test
    void shouldReturnCorrectValueToArrayTest1() {
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnCorrectValueToArrayTest2() {
        list.add(1);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1};
        assertArrayEquals(expectedResult, result);
    }

    //increaseArray();
    @Test
    //при добавлении элементов, большего кол-ва чем длина массива в конструкторе,
    // должен присваивать новый массив с большей длиной и корректно переносить элементы в новый массив.
    void shouldCorrectlyTransferElementValuesToTheNewArrayWhenTheStorageIsIncremented() {
        for (int i = 0; i < 11; i++) {
            Integer expected = list.add(1);
        }
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expectedResult, result);
    }






}