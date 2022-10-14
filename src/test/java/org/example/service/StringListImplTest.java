package org.example.service;

import org.example.exeptions.ElementNotFoundException;
import org.example.exeptions.NullRequestException;
import org.example.exeptions.OutOfListSizeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringList list = new StringListImpl();

    @AfterEach
    public void afterEach() {
        list = new StringListImpl();
    }

    //add(String item);
    @Test
    void shouldReturnCorrectValueAddTest1() {
        String expected = list.add("1");
        Assertions.assertEquals(expected, "1");
    }

    @Test
    void shouldReturnCorrectValueAddTest2() {
        list.add("Test");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"Test"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnNullRequestExceptionAddTest3() {
        assertThrows(NullRequestException.class,
                () -> list.add(null));
    }

    //add(int index, String item);
    @Test
    void shouldReturnCorrectValueAddWithIndexTest1() {
        list.add("1");
        list.add("1");
        list.add("1");
        list.add(1, "2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "2", "1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnNullRequestExceptionAddWithIndexTest2() {
        list.add("1");
        list.add("1");
        assertThrows(NullRequestException.class,
                () -> list.add(1, null));
    }

    @Test
    void shouldReturnOutOfListSizeExceptionAddWithIndexTest3() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.add(7, "2"));
    }

    //set(int index, String item);
    @Test
    void shouldReturnCorrectValueSetTest1() {
        list.add("1");
        list.add("1");
        list.add("1");
        list.set(1, "2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "2", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnOutOfListSizeExceptionSetTest2() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.set(7, "2"));
    }

    //remove(String item);
    @Test
    void shouldReturnCorrectValueRemoveTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.remove("2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnElementNotFoundExceptionRemoveTest2() {
        list.add("1");
        list.add("1");
        assertThrows(ElementNotFoundException.class,
                () -> list.remove("2"));
    }

    //remove(int index);
    @Test
    void shouldReturnCorrectValueRemoveWithIndexTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.remove(1);
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnOutOfListSizeExceptionRemoveTest2() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.remove(7));
    }

    //contains(String item);
    @Test
    void shouldReturnTrueContainsTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertTrue(list.contains("2"));
    }

    @Test
    void shouldReturnFalseContainsTest2() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertFalse(list.contains("5"));
    }

    //indexOf(String item);
    @Test
    void shouldReturnCorrectIndexOfItemIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.indexOf("2"), 1);
    }

    @Test
    void shouldReturnMinusOneIfThereAreNoItemIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.indexOf("3"), -1);
    }


    //lastIndexOf(String item)
    @Test
    void shouldReturnCorrectIndexOfItemLastIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.lastIndexOf("1"), 2);
    }

    @Test
    void shouldReturnMinusOneIfThereAreNoItemLastIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.lastIndexOf("3"), -1);
    }

    //get(int index);
    @Test
    void shouldReturnCorrectValueGetTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        Assertions.assertEquals(list.get(1), "2");
    }

    @Test
    void shouldReturnOutOfListSizeExceptionGetTest2() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.get(7));
    }

    //equals(StringList otherList);
    @Test
    void shouldReturnTrueIfStringListsAreEqualsEqualsTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        StringList expectedList = new StringListImpl();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("1");
        assertTrue(list.equals(expectedList));
    }

    @Test
    void shouldReturnFalseIfStringListsAreNotEqualsEqualsTest2() {
        list.add("2");
        list.add("2");
        list.add("1");
        StringList expectedList = new StringListImpl();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("1");
        assertFalse(list.equals(expectedList));
    }

    @Test
    void shouldReturnNullRequestExceptionEqualsTest3() {
        list.add("1");
        list.add("1");
        StringList expectedList = null;
        assertThrows(NullRequestException.class,
                () -> list.equals(expectedList));
    }


    //size();
    @Test
    void shouldReturnCorrectSizeTest1() {
        list.add("1");
        list.add("1");
        list.add(1, "1");
        list.set(1, "1");
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
        list.add("5");
        assertFalse(list.isEmpty());
    }

    //clear();
    @Test
    void shouldRemoveAllItemsAndDecreaseSizeClearTest() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.clear();
        String[] result = list.toArray();
        String[] expectedResult = new String[]{};
        assertArrayEquals(expectedResult, result);
    }


    //toArray();
    @Test
    void shouldReturnCorrectValueToArrayTest1() {
        String[] result = list.toArray();
        String[] expectedResult = new String[]{};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnCorrectValueToArrayTest2() {
        list.add("1");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1"};
        assertArrayEquals(expectedResult, result);
    }

    //increaseArray();
    @Test
    //при добавлении элементов, большего кол-ва чем длина массива в конструкторе,
    // должен присваивать новый массив с большей длиной и корректно переносить элементы в новый массив.
    void shouldCorrectlyTransferElementValuesToTheNewArrayWhenTheStorageIsIncremented() {
        for (int i = 0; i < 11; i++) {
            String expected = list.add("1");
        }
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
        assertArrayEquals(expectedResult, result);
    }
}