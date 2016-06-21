class Node {

    public int iData;
    public Node next;

    public Node(int x) {
        iData = x;
    }

    public void displayNode() {
        System.out.print(iData + " ");

    }

}
class CircularList {

    private Node first;
    private Node last;
    private Node current;
    private int count; // total items in the list
    public CircularList getCurrent;

    public CircularList() {
        first = null;
        last = null;
        current = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void step() {
        current = current.next;
    }

    public Node getCurrent() {
        return current;
    }

    public Node getFirst() {
        return first;
    }

    public void insert(int x) {
        Node newNode = new Node(x);

        if (isEmpty()) {
            first = newNode;
            current = first;
        } else {
            current.next = newNode;
        }

        newNode.next = first;
        last = newNode;
        step();
        count++;
    }

    public boolean search(int x) {
        Node search = first;
        int y = 0;

        while (search.iData != x && y < count) {
            search = search.next;
            y++;
        }

        if (search.iData == x) {
            System.out.println("Found the value: " + search.iData);
            return true;
        } else {
            System.out.println("Value not found in list");
            return false;
        }

    }

    public void delete(int x) {
        Node prev = first;
        Node curr = first.next;

        while (curr.iData != x) {
            prev = curr;
            curr = curr.next;

        }

        if (count == 1) {
            first = null;
            count--;
        } else if (curr == first) {
            prev.next = curr.next;
            first = curr.next;
            count--;
        } else {
            prev.next = curr.next;
            count--;
        }

    }

    public void displayList() {
        int x = 0;
        Node printer = first;

        while (x < count) {
            printer.displayNode();
            printer = printer.next;
            x++;
        }
        System.out.println("");

    }

}
class Josephus {

    private int numOfPeople; // number of people in a circle
    private int countNum; // number used for counting off
    private Node head;
    private Node tail;
    CircularList circle;

    public Josephus() {
        circle = new CircularList();
        numOfPeople = 0;
        countNum = 0;

    }

    public void setNumOfPeople(int x) {
        numOfPeople = x;

    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setCountNum(int x) {
        countNum = x;
    }

    public int getCountNum() {
        return countNum;
    }

    public void addPeople() {
        for (int i = 1; i < numOfPeople; i++) {
            circle.insert(i);
        }
    }

    public void move() {

        for (int i = 0; i < countNum; i++) {
            tail = head;
            head = head.next;
        }

        System.out.println("KILLED : " + head.iData);

    }

    public void execute() {
        tail = null;
        head = circle.getFirst();
        while (numOfPeople != 2) {

            move();
            circle.delete(head.iData);
            tail = tail.next;
            head = head.next;
            numOfPeople--;
            display();
        }

    }

    public void display() {
        System.out.print("Alive:  ");
        circle.displayList();
    }




    public static void main(String[] args) {
        Josephus suicide = new Josephus();

        suicide.setNumOfPeople(8);
        suicide.addPeople();
        suicide.display();

        suicide.setCountNum(3);
        suicide.execute();

    }


}
