package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
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
public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/", (req, res) -> "Hello, World");
        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
	  //System.out.println(req.queryParams("input3"));
	  //System.out.println(req.queryParams("input4"));
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
	 String input2=req.queryParams("input2");
		java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
	java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
      
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          String input3 = req.queryParams("input3").replaceAll("\\s","");
          String input4 = req.queryParams("input4").replaceAll("\\s","");

          boolean result = App.searchInTwoArrays(inputList,inputList2,input3,input4);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}