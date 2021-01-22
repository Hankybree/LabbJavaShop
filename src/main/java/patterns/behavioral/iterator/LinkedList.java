package patterns.behavioral.iterator;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

class Test {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Hej");
        linkedList.add("på");
        linkedList.add("dig");

        for (String v : linkedList) {
            System.out.println(v);
        }
    }
}


public class LinkedList<T> implements Iterable<T> {
    private Node first;
    private Node last;

    class Node {
        T value;
        Node next;
    }

    public void add(T value) {
        if (first == null) {
            first = new Node();
            first.value = value;
            last = first;
        } else {
            last.next = new Node();
            last.next.value = value;
            last = last.next;
        }
    }

    class LinkedListIterator implements Iterator<T> {

        LinkedList<T> linkedList;
        Node next;

        public LinkedListIterator(LinkedList<T> list) {
            this.linkedList = list;
            next = first;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            var n = next;
            next = n.next;
            return n.value;
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }
}
