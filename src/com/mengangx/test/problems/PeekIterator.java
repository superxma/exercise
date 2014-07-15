package com.mengangx.test.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/*Implement peek() using java Iterator
 * */


public class PeekIterator<T> implements Iterator<T> {

    private final Iterator<T> iterator;
    private T nextitem;

    public PeekIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (nextitem != null) {
            return true;
        }

        if (iterator.hasNext()) {
            nextitem = iterator.next();
        }

        return nextitem != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw (new NoSuchElementException("Iterator has no elements left."));
        }

        T toReturn = nextitem;
        nextitem = null;
        return toReturn;
    }

    public T peek() {
        if (!hasNext()) {
            throw (new NoSuchElementException("Iterator has no elements left."));
        }

        return nextitem;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String> ();
        list.add("a");
        list.add("b");
        list.add("c");
        PeekIterator<String> it = new PeekIterator<String>(list.iterator());
        while(it.hasNext()) {
            System.out.println(it.peek());
            System.out.println(it.next());           
        }
    }
}