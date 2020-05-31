package multithreading;

import java.util.Collections;
import java.util.LinkedList;

import lambda.Hero;

public class MyStackThread implements Stack{

	LinkedList<Hero> heros = (LinkedList<Hero>) Collections.synchronizedList(new LinkedList<Hero>());
    
    public void push(Hero h) {
        heros.addLast(h);
    }
   
    @Override
    public Hero pull() {
        return heros.removeLast();
    }
   
    @Override
    public Hero peek() {
        return heros.getLast();
    }
       
    public static void main(String[] args) {
           
       
    }
}
