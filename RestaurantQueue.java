public class RestaurantQueue {
    private Node front; // Pelanggan di depan antrian
    private Node rear; // Pelanggan di belakang antrian
    private int size; // Jumlah pelanggan dalam antrian

    // Constructor
    public RestaurantQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Cek apakah antrian kosong
    public boolean isEmpty() {
        return front == null;
    }

    // Mendapatkan jumlah pelanggan dalam antrian
    public int size() {
        return size;
    }

    // Menambahkan pelanggan baru ke antrian (masuk di belakang)
    public void push(String customerName) {
        Node newNode = new Node(customerName);
        
        // Jika antrian kosong, pelanggan baru menjadi front dan rear
        if (isEmpty()) {
            front = newNode;
        } else {
            // Jika tidak kosong, tambahkan pelanggan di belakang
            rear.setNext(newNode);
        }
        
        rear = newNode; // Update rear ke pelanggan baru
        size++;
        
        System.out.println("Pelanggan " + customerName + " masuk ke antrian");
        displayQueue();
    }

    // Mengeluarkan pelanggan dari antrian (keluar dari depan)
    public String pop() {
        if (isEmpty()) {
            System.out.println("Error: Antrian kosong, tidak ada pelanggan yang bisa dilayani");
            return null;
        }
        
        String customerName = front.getCustomerName();
        front = front.getNext(); // Front berpindah ke pelanggan berikutnya
        
        // Jika setelah pop antrian menjadi kosong, rear juga harus null
        if (front == null) {
            rear = null;
        }
        
        size--;
        
        System.out.println("Pelanggan " + customerName + " telah dilayani");
        displayQueue();
        
        return customerName;
    }

    // Menampilkan kondisi antrian saat ini
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        
        System.out.print("Kondisi antrian: [");
        
        Node current = front;
        while (current != null) {
            System.out.print(current.getCustomerName());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        
        System.out.println("]");
    }
} 