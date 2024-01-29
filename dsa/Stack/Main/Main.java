package dsa.stack.Main;

import dsa.stack.NotationConvertor;
import dsa.stack.NotationConvertor.NotationType;

public class Main {
    public static void main(String[] args) {
        String infix = "8+(8/4)*5"; 
        System.out.println(NotationConvertor.postfix(infix) + " " + NotationConvertor.prefix(infix));
        System.out.println(NotationConvertor.evaulate(NotationConvertor.prefix(infix), NotationType.prefix));
        System.out.println(NotationConvertor.evaulate(NotationConvertor.postfix(infix), NotationType.postfix));
        System.out.println(
                NotationConvertor.infix(NotationConvertor.prefix(infix), NotationType.prefix) + " " +  
                NotationConvertor.infix(NotationConvertor.postfix(infix), NotationType.postfix));
    }  
}
