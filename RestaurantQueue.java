public class RestaurantQueue {
    private Node front; // Pelanggan di depan antrian
    private Node rear; // Pelanggan di belakang antrian
    private int size; // Jumlah pelanggan dalam antrian
    private int nextQueueNumber; // Nomor antrian berikutnya
    private static final int AVG_SERVICE_TIME = 5; // Estimasi waktu layanan dalam menit

    // Constructor
    public RestaurantQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.nextQueueNumber = 1; // Mulai dari nomor 1
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
    public Node push(String customerName) {
        Node newNode = new Node(customerName, nextQueueNumber++);
        
        // Jika antrian kosong, pelanggan baru menjadi front dan rear
        if (isEmpty()) {
            front = newNode;
        } else {
            // Jika tidak kosong, tambahkan pelanggan di belakang
            rear.setNext(newNode);
        }
        
        rear = newNode; // Update rear ke pelanggan baru
        size++;
        
        System.out.println("Pelanggan " + newNode + " masuk ke antrian");
        System.out.println("Estimasi waktu tunggu: " + getEstimatedWaitingTime(newNode) + " menit");
        displayQueue();
        
        return newNode;
    }

    // Mengeluarkan pelanggan dari antrian (keluar dari depan)
    public Node pop() {
        if (isEmpty()) {
            System.out.println("Error: Antrian kosong, tidak ada pelanggan yang bisa dilayani");
            return null;
        }
        
        Node servedNode = front;
        front = front.getNext(); // Front berpindah ke pelanggan berikutnya
        
        // Jika setelah pop antrian menjadi kosong, rear juga harus null
        if (front == null) {
            rear = null;
        }
        
        size--;
        
        System.out.println("Pelanggan " + servedNode + " telah dilayani");
        System.out.println("Waktu tunggu: " + getWaitingTime(servedNode) + " menit");
        displayQueue();
        
        return servedNode;
    }
    
    // Mencari posisi pelanggan dalam antrian berdasarkan nomor antrian
    public int findPosition(int queueNumber) {
        if (isEmpty()) {
            return -1;
        }
        
        Node current = front;
        int position = 1;
        
        while (current != null) {
            if (current.getQueueNumber() == queueNumber) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        
        return -1; // Tidak ditemukan
    }
    
    // Menghitung estimasi waktu tunggu untuk pelanggan (dalam menit)
    public int getEstimatedWaitingTime(Node customer) {
        int position = findPosition(customer.getQueueNumber());
        if (position == -1) {
            return -1; // Pelanggan tidak ditemukan
        }
        return (position - 1) * AVG_SERVICE_TIME; // Posisi pertama = 0 menit, posisi kedua = 5 menit, dst.
    }
    
    // Menghitung waktu tunggu pelanggan berdasarkan waktu kedatangan
    public int getWaitingTime(Node customer) {
        if (customer == null) {
            return -1;
        }
        long waitingTimeMs = System.currentTimeMillis() - customer.getArrivalTime();
        return (int) (waitingTimeMs / (1000 * 60)); // Konversi dari ms ke menit
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
            System.out.print(current);
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        
        System.out.println("]");
    }
    
    // Menampilkan statistik antrian
    public void displayQueueStatistics() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada statistik");
            return;
        }
        
        System.out.println("=== STATISTIK ANTRIAN ===");
        System.out.println("Jumlah pelanggan dalam antrian: " + size);
        System.out.println("Nomor antrian berikutnya: " + nextQueueNumber);
        System.out.println("Estimasi total waktu untuk mengosongkan antrian: " + (size * AVG_SERVICE_TIME) + " menit");
    }
} 