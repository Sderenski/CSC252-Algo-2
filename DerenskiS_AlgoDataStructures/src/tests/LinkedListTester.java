package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import algo.data.structures.LinkedLists.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinkedListTester {

    private SingleLinkedList<Integer> CreateSLLOne()
    {
        SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
        sll.add(24);

        return sll;
    }

    private SingleLinkedList<Integer> CreateSLLTen()
    {
        SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
        sll.add(24);
        sll.add(3);
        sll.add(6);
        sll.add(0);
        sll.add(6);
        sll.add(17);
        sll.add(100);
        sll.add(2014);
        sll.add(122778);
        sll.add(42);

        return sll;
    }

    private DoubleLinkedList<Integer> CreateDLLOne()
    {
        DoubleLinkedList<Integer> sll = new DoubleLinkedList<Integer>();
        sll.add(24);

        return sll;
    }

    private DoubleLinkedList<Integer> CreateDLLTen()
    {
        DoubleLinkedList<Integer> sll = new DoubleLinkedList<Integer>();
        sll.add(24);
        sll.add(3);
        sll.add(6);
        sll.add(0);
        sll.add(6);
        sll.add(17);
        sll.add(100);
        sll.add(2014);
        sll.add(122778);
        sll.add(42);

        return sll;
    }

    protected String ArrayToString(Object[] a)
    {
        StringBuilder sb = new StringBuilder();

        if (a.length > 0)
        {
            sb.append(a[0]);
            for (Integer i = 1; i < a.length; i++)
            {
                sb.append(", ");
                sb.append(a[i]);
            }

        }

        return sb.toString();
    }

    @Test
    public void SLL_EmptyList()
    {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        Integer expectedCount = 0;
        Integer actualCount = list.count();

        String expectedString = "";
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfOne()
    {
        SingleLinkedList<Integer> list = CreateSLLOne();
        Integer expectedCount = 1;
        String expectedString = "24";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfOne_Remove()
    {
        SingleLinkedList<Integer> list = CreateSLLOne();
        Integer expectedReturn = 24;
        Integer expectedCount = 0;
        String expectedString = "";

        Integer actualReturn = list.remove();
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_remove()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 24;
        Integer expectedCount = 9;
        String expectedString = "3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.remove();
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_RemoveAll()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer[] ints = { 24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42 }; 
        ArrayList<Integer> vals = new ArrayList<>();
        for(Integer num : ints)
        {
        	vals.add(num);
        }
        
        Integer expectedReturn = 0;
        Integer expectedCount = 9;
        String expectedString;

        for (Integer i = 0; i < 10; i++)
        {
            expectedReturn = vals.get(0);
            vals.remove(0);
            expectedCount = vals.size();
            expectedString = ArrayToString(vals.toArray());

            Integer actualReturn = list.remove();
            Integer actualCount = list.count();
            String actualString = list.toString();

            assertEquals(expectedReturn, actualReturn);
            assertEquals(expectedCount, actualCount);
            assertEquals(expectedString, actualString);
        }
    }

    @Test
    public void SLL_ListOfTen_RemoveThenadd()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        list.remove();
        list.add(404);
        Integer expectedCount = 10;
        String expectedString = "3, 6, 0, 6, 17, 100, 2014, 122778, 42, 404";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_RemoveAt0()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 24;
        Integer expectedCount = 9;
        String expectedString = "3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.removeAt(0);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_RemoveAt5()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 17;
        Integer expectedCount = 9;
        String expectedString = "24, 3, 6, 0, 6, 100, 2014, 122778, 42";

        Integer actualReturn = list.removeAt(5);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_RemoveAt9()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 42;
        Integer expectedCount = 9;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778";

        Integer actualReturn = list.removeAt(9);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SLL_ListOfTen_RemoveAt10Exception()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();

        list.removeAt(10);
    }

    @Test
    public void SLL_ListOfTen_InsertAt0()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedCount = 11;
        String expectedString = "711, 24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        list.insert(711, 0);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_InsertAt5()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedCount = 11;
        String expectedString = "24, 3, 6, 0, 6, 711, 17, 100, 2014, 122778, 42";

        list.insert(711, 5);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_InsertAt9()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedCount = 11;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 711, 42";

        list.insert(711, 9);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SLL_ListOfTen_InsertAt10Exception()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();

        list.insert(711, 10);
    }

    @Test
    public void SLL_ListOfTen_GetAt0()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 24;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.get(0);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_GetAt5()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 17;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.get(5);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_GetAt9()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 42;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.get(9);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SLL_ListOfTen_GetAt10Exception()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();

        list.get(10);
    }

    @Test
    public void SLL_ListOfTen_SearchForValueAtHead()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 0;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(24);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_SearchForValueAtTail()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 9;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(42);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_SearchForValueAppearsTwice()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = 2;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(6);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_SearchForValueNotInList()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        Integer expectedReturn = -1;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(999);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_ListOfTen_SearchForValueInEmptyList()
    {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        Integer expectedReturn = -1;
        Integer expectedCount = 0;
        String expectedString = "";

        Integer actualReturn = list.search(24);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void SLL_Clear()
    {
        SingleLinkedList<Integer> list = CreateSLLTen();
        list.clear();
        Integer expectedCount = 0;
        String expectedString = "";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_EmptyList()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Integer expectedCount = 0;
        Integer actualCount = list.count();

        String expectedString = "";
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfOne()
    {
        DoubleLinkedList<Integer> list = CreateDLLOne();
        Integer expectedCount = 1;
        String expectedString = "24";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfOne_Remove()
    {
        DoubleLinkedList<Integer> list = CreateDLLOne();
        Integer expectedReturn = 24;
        Integer expectedCount = 0;
        String expectedString = "";

        Integer actualReturn = list.remove();
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_remove()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 24;
        Integer expectedCount = 9;
        String expectedString = "3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.remove();
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_RemoveAll()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer[] ints = { 24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42 }; 
        ArrayList<Integer> vals = new ArrayList<>();
        for(Integer num : ints)
        {
        	vals.add(num);
        }

        Integer expectedReturn = 0;
        Integer expectedCount = 9;
        String expectedString;

        for (Integer i = 0; i < 10; i++)
        {
            expectedReturn = vals.get(0);
            vals.remove(0);
            expectedCount = vals.size();
            expectedString = ArrayToString(vals.toArray());

            Integer actualReturn = list.remove();
            Integer actualCount = list.count();
            String actualString = list.toString();

            assertEquals(expectedReturn, actualReturn);
            assertEquals(expectedCount, actualCount);
            assertEquals(expectedString, actualString);
        }
    }

    @Test
    public void DLL_ListOfTen_RemoveThenadd()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        list.remove();
        list.add(404);
        Integer expectedCount = 10;
        String expectedString = "3, 6, 0, 6, 17, 100, 2014, 122778, 42, 404";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_RemoveAt0()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 24;
        Integer expectedCount = 9;
        String expectedString = "3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.removeAt(0);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_RemoveAt5()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 17;
        Integer expectedCount = 9;
        String expectedString = "24, 3, 6, 0, 6, 100, 2014, 122778, 42";

        Integer actualReturn = list.removeAt(5);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_RemoveAt9()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 42;
        Integer expectedCount = 9;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778";

        Integer actualReturn = list.removeAt(9);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test (expected=IndexOutOfBoundsException.class)
    public void DLL_ListOfTen_RemoveAt10Exception()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();

        list.removeAt(10);
    }

    @Test
    public void DLL_ListOfTen_InsertAt0()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedCount = 11;
        String expectedString = "711, 24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        list.insert(711, 0);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_InsertAt5()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedCount = 11;
        String expectedString = "24, 3, 6, 0, 6, 711, 17, 100, 2014, 122778, 42";

        list.insert(711, 5);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_InsertAt9()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedCount = 11;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 711, 42";

        list.insert(711, 9);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void DLL_ListOfTen_InsertAt10Exception()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();

        list.insert(711, 10);
    }

    @Test
    public void DLL_ListOfTen_GetAt0()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 24;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.get(0);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_GetAt5()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 17;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.get(5);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_GetAt9()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 42;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.get(9);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void DLL_ListOfTen_GetAt10Exception()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();

        list.get(10);
    }

    @Test
    public void DLL_ListOfTen_SearchForValueAtHead()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 0;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(24);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_SearchForValueAtTail()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 9;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(42);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_SearchForValueAppearsTwice()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = 2;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(6);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_SearchForValueNotInList()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        Integer expectedReturn = -1;
        Integer expectedCount = 10;
        String expectedString = "24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42";

        Integer actualReturn = list.search(999);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_ListOfTen_SearchForValueInEmptyList()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Integer expectedReturn = -1;
        Integer expectedCount = 0;
        String expectedString = "";

        Integer actualReturn = list.search(24);
        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void DLL_Clear()
    {
        DoubleLinkedList<Integer> list = CreateDLLTen();
        list.clear();
        Integer expectedCount = 0;
        String expectedString = "";

        Integer actualCount = list.count();
        String actualString = list.toString();

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedString, actualString);
    }
}
