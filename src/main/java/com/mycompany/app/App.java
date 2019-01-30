package com.mycompany.app;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



    }
    public static boolean searchInTwoArrays(ArrayList<Integer> array1,ArrayList<Integer>array2,int elem1,int elem2) {
        if(elem1!=elem2)
            return false;
        if (array1 == null||array1.size()==0)
            return false;
        if (array2 == null||array2.size()==0)
            return false;
        int index1=Integer.MIN_VALUE;
        for (int i=0;i<array1.size();++i) {
            if (array1.get(i) == elem1){
                index1=i;
                break;
            }
        }
        if(index1==Integer.MIN_VALUE){//could not find elem1
            return false;
        }
        int index2=Integer.MIN_VALUE;
        for (int i=0;i<array2.size();++i) {
            if (array1.get(i) == elem2){
                index2=i;
                break;
            }
        }
        if(index2==Integer.MIN_VALUE){//could not find elem2
            return false;
        }
        return index1 == index2;
    }
}
