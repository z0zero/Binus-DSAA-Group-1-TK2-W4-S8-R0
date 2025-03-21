public class Node {
    private String customerName; // Nama pelanggan
    private long arrivalTime; // Waktu kedatangan (timestamp)
    private int queueNumber; // Nomor antrian
    private Node next; // Referensi ke node berikutnya

    // Constructor
    public Node(String customerName) {
        this.customerName = customerName;
        this.arrivalTime = System.currentTimeMillis();
        this.queueNumber = 0; // Akan diset nanti
        this.next = null;
    }

    // Constructor dengan nomor antrian
    public Node(String customerName, int queueNumber) {
        this.customerName = customerName;
        this.arrivalTime = System.currentTimeMillis();
        this.queueNumber = queueNumber;
        this.next = null;
    }

    // Getter dan setter
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return customerName + " (#" + queueNumber + ")";
    }
} 