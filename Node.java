public class Node {
    private String customerName; // Nama pelanggan
    private Node next; // Referensi ke node berikutnya

    // Constructor
    public Node(String customerName) {
        this.customerName = customerName;
        this.next = null;
    }

    // Getter dan setter
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
} 