package multithreading;

import java.util.LinkedList;

import lambda.Hero;

public class MyStackThread implements Stack{

	LinkedList<Hero> heros = new LinkedList<Hero>();
    
    public synchronized void push(Hero h) {
        heros.addLast(h);
    }
   
    @Override
    public synchronized Hero pull() {
        return heros.removeLast();
    }
   
    @Override
    public Hero peek() {
        return heros.getLast();
    }
       
    public static void main(String[] args) {
           
       
    }
}
