package dsa.stack.Main;

import dsa.stack.PostfixConverter;

public class Main {
    public static void main(String[] args) {
        String infix = "a+b+c*(d/e)"; 
        System.out.println(PostfixConverter.postfix(infix));
    }  
}
