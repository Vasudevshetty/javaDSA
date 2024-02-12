package dsa.queue;

import dsa.list.DoubleCircularLinkedList;

public class PriorityQueue<T, V>{
    private class Element {
        private T data;
        private V priority;

        Element(T data, V priority) {
            this.data = data;
            this.priority = priority;
        }

        public T getData() {
            return this.data;
        }

        public V getPriority() {
            return this.priority;
        }
    }

    Element defaultElement = new Element(null, null);

    DoubleCircularLinkedList<Element> list = new DoubleCircularLinkedList<>();

    public void enqueue(Element element) {
        list.createOrderedList(element);
    }

    public Element dequeu() {
        return list.deleteHead();
    }

    public Element front() {
        return list.isEmpty()? defaultElement: list.getHead().getData();
    } 

    public Element rear() {
        return list.isEmpty()? defaultElement : list.getTail().getData();
    }

    public T getHighestPrioirtyData() {
        return list.getHead().getData().getData();
    }

    public V getHighestPrioirty() {
        return list.getHead().getData().getPriority();
    }
}