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
    public static boolean searchInTwoArrays(ArrayList<Integer> array1,ArrayList<Integer>array2,String str1,String str2) {
        if(array1==null||array2==null||str1==null||str2==null)
            return false;
        if(str1.length()==0||str2.length()==0)
            return false;
        if(array1.size()>str1.length()||array2.size()>str2.length())
            return false;
        if(array1.size()==0||array2.size()==0)
            return false;
        int indexNum=array1.size();
        for (int i=0;i<indexNum;++i) {
            char charFromStr1AtIndexI=str1.charAt(array1.get(i));
            char charFromStr2AtIndexI=str2.charAt(array2.get(i));
            if(charFromStr1AtIndexI!=charFromStr2AtIndexI){
                return false;
            }
        }
        return true;

    }
}
