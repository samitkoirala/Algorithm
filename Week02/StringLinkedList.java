public class StringLinkedList {

    private Node first = null;

    private class Node {
        String value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = first;
        first = newNode;
    }

    public String pop() {
        String poppedVal = first.value;
        first = first.next;
        return poppedVal;
    }

}
