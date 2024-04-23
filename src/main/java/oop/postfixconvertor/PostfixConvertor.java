/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package oop.postfixconvertor;
import java.util.Scanner;
/**
 *
 * @author CARNIVAL
 */
public class PostfixConvertor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String infix, postfix;
        int mode, result;

        System.out.println(); 
        while (true){
            
            System.out.println("1. Converting from infix to postfix");
            System.out.println("2. evaluating a posfix expression");
            
            mode = Integer.parseInt(in.nextLine());
            switch (mode){
                case 1:
                    System.out.println("Enter the infix expression: ");
                    infix = in.nextLine().replaceAll(" ", "");
          

                    postfix = convertor.infixToPostfix(infix.toCharArray());

                    System.out.println("output: "+"["+postfix+"]");
                    System.out.println("---------------------");
                    break;
                    
                case 2:
                    System.out.println("Enter the postfix expression: ");
                    postfix = in.nextLine();


                    result = convertor.evaluatePostfix(postfix.toCharArray());

                    System.out.println("output: "+"["+result+"]");
                    System.out.println("---------------------");
                    break;
            }
            
        }
        
    }
}
