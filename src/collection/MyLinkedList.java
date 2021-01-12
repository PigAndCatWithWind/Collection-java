package collection;
class Node{
    Node previous;
    Node next;
    Object element;
    public Node(Object element){
        super();
        this.element = element;
    }
    public Node(Node previous, Node next,Object element){
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }
}

public class MyLinkedList<E> {
    private Node first;
    private Node last;
    private int size;

    private void checkRange(int index){
        if (index<0||index>size-1){
            throw new RuntimeException("index illegal is " +index);
        }
    }

    private Node getNode(int index){
        checkRange(index);
        Node temp = null;
        if (index<=(size>>1)){
            temp = first;
            for (int i=0;i<index;i++){
                temp = temp.next;
            }
        }else {
            temp = last;
            for (int i = size-1;i>index;i--){
                temp = temp.previous;
            }
        }
        return temp;
    }

    public E get(int index){
        checkRange(index);
        Node temp = getNode(index);
        return temp!=null?(E)temp.element:null;
    }

    public void add(int index,E element){
        checkRange(index);
        Node newNode = new Node(element);
        Node temp = getNode(index);
        if (temp!=null){
            Node nowNode = temp.previous;
            nowNode.next = newNode;
            newNode.previous = nowNode;
            newNode.next = temp;
            temp.previous = newNode;
        }
    }

    public void remove(int index){
        checkRange(index);
        Node temp = getNode(index);
        if (temp!=null){
            Node up = temp.previous;
            Node down = temp.next;
            if (up!=null){
                up.next = down;
            }
            if (down!=null){
                down.previous=up;
            }
            if(index==0){
                first=down;
            }
            if(index==size-1){
                last=up;
            }
            size--;
        }
    }

    public void add(E element){
        Node node = new Node(element);
        if (first==null){
            first=node;
            last=node;
        }else {
            node.previous = last;
            node.next = null;
            last.next=node;
            last = node;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node temp = first;
        while (temp!=null){
            stringBuilder.append(temp.element+",");
            temp = temp.next;
        }
        stringBuilder.setCharAt(stringBuilder.length()-1,']');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList();
        myLinkedList.add("a");
        myLinkedList.add("b");
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));
    }
}
