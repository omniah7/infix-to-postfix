/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.postfixconvertor;

import java.util.Scanner;

/**
 *
 * @author CARNIVAL
 */
public class convertor {

    public static int evaluatePostfix(char postfix[]){
        int len = postfix.length;
        Stack<Integer> valStack = new Stack();
        char next;
        int result, num1, num2;
        int[] values = new int[26];
        for(int i=0; i<26; i++) values[i] = -1000000000;//initialize it to the minimum value possible
        
        for (int i = 0; i < len; i++){
            next = postfix[i];
            //if it is a variable
            if (Character.isAlphabetic(next))
            {
                if (values[next-'a'] == -1000000000) {
                    System.out.println("Enter the value of "+next+": ");
                    Scanner in = new Scanner(System.in);
                    values[next-'a'] = Integer.parseInt(in.nextLine());
                }
                valStack.push(values[next-'a']);
                continue;
            }
            switch (next) {
                    
                case ' ' -> {}
                case '^' -> {
                    num2 = valStack.pop();
                    num1 = valStack.pop();
                    result = operation(num1, num2, next);
                    valStack.push(result);
                }
                    
                case '+', '-', '*', '/' -> {
                        num2 = valStack.pop();
                        num1 = valStack.pop();
                        result = operation(num1, num2, next);
                        valStack.push(result);
//                    }
                }
                default -> { //variable (number)
                    num1 = next - '0';
                    for (int j = i+1; j < len && postfix[j] != ' '; j++, i++)
                    {
                        num1 *= 10;
                        num1 += postfix[j] - '0';
                    }
                    valStack.push(num1);
                }
            }
        }
       return valStack.peek();
    }
    

    // Converts an infix expression to an equivalent postfix expression.
    public static String infixToPostfix(char infix[]){
        
        int len = infix.length;
        Stack opStack = new Stack();
        String postfix = "";
        char next, top = '\0';
        
        for (int i = 0; i < len; i++){
            
            next = infix[i];
            switch (next) {
                    
                case '^' -> opStack.push(next);
                    
                case '+', '-', '*', '/' -> {
                    while(!opStack.isEmpty() &&
                    precedence(next) <= precedence((char)opStack.peek())){
                        postfix += opStack.pop();
                    }
                    opStack.push(next);
                }
                case '(' ->    {
                    opStack.push(next);
                }
                case ')' ->    {
                    top = (char)opStack.pop();
                    while (top != '('){
                        postfix += top;
                        top = (char)opStack.pop();
                    }
                }
                default -> { //variable
                    postfix += next;
                }
            }
        }
       while (!opStack.isEmpty()){
           postfix += (char)opStack.pop();
       }
       return postfix;
    }
    /////////precedence
    public static int precedence(char ch)
    {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }
    //binary perations
    public static int operation(int x, int y, char op){
        return switch (op) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            case '/' -> x / y;
            case '^' -> (int) Math.pow((double)x,(double)y);
            default -> 0;
        };
    }
   
}

