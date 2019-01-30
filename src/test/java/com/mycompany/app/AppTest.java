package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
public void testFound() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new App().searchInTwoArrays(array1,array2, 2,2));
    }

    public void testNotFound() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().searchInTwoArrays(array1,array2, 5,6));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        assertFalse(new App().searchInTwoArrays(array,array, 1,123));
    }

    public void testNull() {
        assertFalse(new App().searchInTwoArrays(null,null, 1,5));
    }
    public void testDiffrentIndex(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 3, 2, 4));
        assertEquals(false,new App().searchInTwoArrays(array1,array2, 2,3));
    }
}
