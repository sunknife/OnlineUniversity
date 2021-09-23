import java.util.*;

public class LinkedListFromScratch<E> extends AbstractList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    public LinkedListFromScratch() {
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
        size = 0;
    }

    public void addLast(E element) {
        Node<E> previous = lastNode;
        previous.setCurrentElement(element);
        lastNode = new Node<E>(null, previous, null);
        previous.setNextElement(lastNode);
        size++;
    }

    public void addFirst(E element) {
        Node<E> next = firstNode;
        next.setCurrentElement(element);
        firstNode = new Node<E>(null, null , next);
        next.setPreviousElement(firstNode);
        size++;
    }

    @Override
    public E get(int index) {
        if (index > size -1  || index < 0) {
            return null;
        }
        Node<E> resultNode = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            resultNode = getNextElement(resultNode);
        }
        return resultNode.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> element) {
        return element.getNextElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return get(counter++);
            }
        };
    }


    private class Node<E> {
            private E currentElement;
            private Node<E> previousElement;
            private Node<E> nextElement;

            private Node(E currentElement, Node<E> previousElement, Node<E> nextElement) {
                this.currentElement = currentElement;
                this.previousElement = previousElement;
                this.nextElement = nextElement;
            }

            public void setCurrentElement(E currentElement) {
                this.currentElement = currentElement;
            }

            public void setNextElement(Node<E> nextElement) {
                this.nextElement = nextElement;
            }

            public void setPreviousElement(Node<E> previousElement) {
                this.previousElement = previousElement;
            }

            public Node<E> getNextElement() {
                return nextElement;
            }

            public E getCurrentElement() {
                return currentElement;
            }
    }


}
