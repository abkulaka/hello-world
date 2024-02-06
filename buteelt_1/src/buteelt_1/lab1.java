package buteelt_1;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class lab1 {

    Node head;
    Node tail;

    public lab1() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addNodeToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void addNodeAfter(int key, int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                newNode.next = current.next;
                if (current.next != null)
                    current.next.prev = newNode;
                current.next = newNode;
                newNode.prev = current;
                if (current == tail)
                    tail = newNode;
                break;
            }
            current = current.next;
        }
    }

    public void deleteNode(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                if (current == head) {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                    if (head == null)
                        tail = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void reverseList() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public void displayList() {
        Node current = head;
        System.out.print("Doubly Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        lab1 doublyLinkedList = new lab1();

        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);

        doublyLinkedList.displayList();

        // 1 утга нэмэх
        doublyLinkedList.addNodeToFront(0);
        doublyLinkedList.displayList();

        // зангилаа нэмэх
        doublyLinkedList.addNodeAfter(2, 4);
        doublyLinkedList.displayList();

        // зангилаа устгах
        doublyLinkedList.deleteNode(3);
        doublyLinkedList.displayList();

        // дараалал доторх нийт тоон хэмжээ
        System.out.println("Дарааллын хэмжээ: " + doublyLinkedList.getSize());

        // Check if list is empty
        System.out.println("Дараалал хоосон эсэх? " + doublyLinkedList.isEmpty());

        // Reverse the list
        doublyLinkedList.reverseList();
        doublyLinkedList.displayList();
    }
}
