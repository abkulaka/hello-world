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

    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        if (prevNode.next != null)
            prevNode.next.prev = newNode;
        prevNode.next = newNode;
        newNode.prev = prevNode;
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

        doublyLinkedList.addNode(5);
        doublyLinkedList.addNode(7);
        doublyLinkedList.addNode(18);

        doublyLinkedList.displayList();

        // 1 утга нэмэх
        doublyLinkedList.addNodeToFront(10);
        doublyLinkedList.displayList();

        // зангилаа нэмэх
        doublyLinkedList.addNodeAfter(10, 17);
        doublyLinkedList.displayList();

        // зангилаа устгах
        doublyLinkedList.deleteNode(18);
        doublyLinkedList.displayList();

        // insert node after specific node
        Node prevNode = doublyLinkedList.head.next; // Insert after node with value 7
        doublyLinkedList.insertAfter(prevNode, 25);
        doublyLinkedList.displayList();

        // дараалал доторх нийт тоон хэмжээ
        System.out.println("Дарааллын хэмжээ: " + doublyLinkedList.getSize());

        // Хоосон эсэхийг шалгах
        System.out.println("Дараалал хоосон эсэх? " + doublyLinkedList.isEmpty());

        // Урвуу дараалал
        doublyLinkedList.reverseList();
        doublyLinkedList.displayList();
    }
}


