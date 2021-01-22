package patterns.behavioral.iterator;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IteratorExample {

    public static void main(String[] args) {
        MyIterableClass myIterableClass = new MyIterableClass();

        //Using Iterable with foreach loop.
        for (Integer i : myIterableClass) {
            System.out.println(i);
        }

        //Using Iterable with manual code
        var iterator = myIterableClass.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class MyIterator implements Iterator<Integer> {

    private MyIterableClass myIterableClass;
    private int index;

    public MyIterator(MyIterableClass myIterableClass) {
        this.myIterableClass = myIterableClass;
    }

    @Override
    public boolean hasNext() {
        return index < myIterableClass.numbers.length;
    }

    @Override
    public Integer next() {
        return myIterableClass.numbers[index++];
    }
}

class MyIterableClass implements Iterable<Integer> {

    Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        //return Arrays.stream(numbers).iterator();
        return new MyIterator(this);
    }
}
