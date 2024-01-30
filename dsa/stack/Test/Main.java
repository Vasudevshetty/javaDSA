package dsa.stack.Main;

import dsa.stack.NotationConvertor;
import dsa.stack.NotationConvertor.NotationType;

public class Main {
    public static void main(String[] args) {
        String infix = "8+(8/4)*5";
        System.out.println(NotationConvertor.postfix(infix, NotationType.infix) + " "
                + NotationConvertor.prefix(NotationConvertor.postfix(infix, NotationType.infix), NotationType.postfix));
    }
}
