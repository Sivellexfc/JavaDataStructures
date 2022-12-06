package Islemler;

import java.util.*;

public class Islemler {

    public static String infixToPostfix(String girdi){
        Stack<String> opstack=new Stack<>();
        Map<String, Integer> precedence=new HashMap<>();
        precedence.put("+",2);
        precedence.put("-",2);
        precedence.put("*",3);
        precedence.put("/",3);
        precedence.put("(",1);
        precedence.put(")",1);
        String[] gm=splitToTokens(girdi);
        String postfix="";
        for (String s:gm){
            if (Character.isDigit(s.charAt(0)))
                postfix+=s+" ";
            else if(s.equals("("))
                opstack.push(s);
            else if(s.equals(")")) {
                String o=opstack.pop();
                while(!o.equals("(")) {
                    postfix+=o+" ";
                    o=opstack.pop();
                }
            }
            else {
                while (!opstack.isEmpty() && precedence.get(opstack.peek())>precedence.get(s)) {
                    postfix+=opstack.pop()+" ";
                }
                opstack.push(s);
            }

        }
        while (!opstack.isEmpty())
            postfix+=opstack.pop()+" ";
        postfix=postfix.substring(0,postfix.length()-1);
        return postfix;
    }
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];

        tokenList.toArray(tl);
        //for(String s:tl) System.out.println(s);
        for(String s:tokenList) System.out.println(s);
        return tl;
    }
}
