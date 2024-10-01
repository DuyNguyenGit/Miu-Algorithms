package W1D1;

public class Main {
    public static void main(String[] args) {
//        System.out.println(fibonacy(1));
//        System.out.println(fibonacy(2));
//        System.out.println(fibonacy(3));
//        System.out.println(fibonacy(4));
//        System.out.println(fibonacy(5));
//        System.out.println(fibonacy(6));
//        System.out.println(fibonacy(7));
//        System.out.println(fibonacy(8));
//        System.out.println(fibonacy(9));
//        System.out.println(fibonacy(3));

        Node head = new Node(1);
        head.add(2);
        head.add(3);
        head.add(4);

        head.print();
    }

    private int gcd(int a, int b) {
        int i = b;
        while (i != 0) {
            if (b % i == 0 && a % i == 0) {
                return i;
            }
            i--;
        }
        return 1;
    }

    private int gcd2(int a, int b) {
        int temp = b;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int fibonacy(int n) {
        int i1 = 1;
        int i2 = 1;
        if(n < 3) {
            return 1;
        }
        int temp = i1;
        while (n != 2) {
            temp = i2;
            i2 = temp + i1;
            i1 = temp;
            n--;
        }
        return i2;
    }

    static Node reverse(Node node) {
        Node curr = node;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
    public void add(int data) {
        Node head = this;
        Node newNode = new Node(data);
        while(next != null) {
            head = next;
            next = head.next;
        }
        head.next = newNode;
    }
    public void print() {
        while(next != null) {
            System.out.print(next.data + " ");
            next = next.next;
        }
    }
}