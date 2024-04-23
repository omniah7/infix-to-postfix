/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.postfixconvertor;


/**
 *
 * @author CARNIVAL
 * @param <T>
 */
public class Stack <T>{
    
    Node top;
    //node class
    private class Node {
        T data;
        Node next;
        
        private Node(T v){
            data = v;
            next = null;
        }
    }
    //stack constructor
    public Stack () {
        top = null;
    }
    //methods:-
    //isEmpty
    public boolean isEmpty() {
        return top == null;
    }
    //push
    public void push(T data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }
    //peek
    public T peek(){
        return top.data;
    }
    //pop overloading
    public T pop(){
        if (!isEmpty()){
            Node tmp = top;
            top = top.next;
            return tmp.data;
        }
        return null;
    }
    //print
    public void print(){
        if (isEmpty())
            return;
        T x = top.data;
        pop();
        System.out.println(x + "");
        
        this.print();

        this.push(x);
    }
}
