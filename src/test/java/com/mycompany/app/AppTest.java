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
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
        assertTrue(new App().searchInTwoArrays(array1,array2, "ahmet","ahmet"));
    }

    public void testNotFound() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().searchInTwoArrays(array1,array2, "ahmet","kemal"));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        assertFalse(new App().searchInTwoArrays(array,array, "",""));
    }

    public void testNull() {
        assertFalse(new App().searchInTwoArrays(null,null, null,null));
    }
    public void testDiffrentIndex(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(4, 2, 1, 0));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 2));
        assertEquals(false,new App().searchInTwoArrays(array1,array2, "ahmet","ahmet"));
    }
    public void testSmallStrLength(){
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(4, 2, 1, 0));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 2));
        assertEquals(false,new App().searchInTwoArrays(array1,array2, "ali","veli"));

    }
}
