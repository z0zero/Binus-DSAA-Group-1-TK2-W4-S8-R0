/**
 * Program demo otomatis untuk sistem antrian restoran menggunakan Single Linked List
 */
public class RestaurantQueueAutomaticDemo {
    public static void main(String[] args) {
        // Jalankan demo otomatis
        runAutomaticDemo();
    }
    
    /**
     * Demo otomatis yang menunjukkan semua fitur sistem antrian restoran
     */
    private static void runAutomaticDemo() {
        // Membuat objek antrian restoran
        RestaurantQueue queue = new RestaurantQueue();
        
        System.out.println("=== DEMONSTRASI SISTEM ANTRIAN RESTORAN OTOMATIS ===");
        System.out.println("Implementasi menggunakan Single Linked List dengan konsep FIFO\n");
        
        // Menampilkan kondisi awal
        System.out.println("Kondisi awal:");
        queue.displayQueue();
        
        // Menambahkan beberapa pelanggan ke antrian
        System.out.println("\n--- Menambahkan pelanggan ke antrian ---");
        Node budi = queue.push("Budi");
        Node siti = queue.push("Siti");
        Node rudi = queue.push("Rudi");
        Node dewi = queue.push("Dewi");
        Node joko = queue.push("Joko");
        
        // Menampilkan statistik antrian
        System.out.println("\n--- Statistik antrian setelah menambahkan 5 pelanggan ---");
        queue.displayQueueStatistics();
        
        // Mencari posisi pelanggan
        System.out.println("\n--- Mencari posisi pelanggan dalam antrian ---");
        System.out.println("Posisi " + budi + " dalam antrian: " + queue.findPosition(budi.getQueueNumber()));
        System.out.println("Posisi " + siti + " dalam antrian: " + queue.findPosition(siti.getQueueNumber()));
        System.out.println("Posisi " + rudi + " dalam antrian: " + queue.findPosition(rudi.getQueueNumber()));
        System.out.println("Posisi " + dewi + " dalam antrian: " + queue.findPosition(dewi.getQueueNumber()));
        System.out.println("Posisi " + joko + " dalam antrian: " + queue.findPosition(joko.getQueueNumber()));
        
        // Mencari posisi pelanggan yang tidak ada
        System.out.println("\nMencari pelanggan dengan nomor antrian 99: " + 
                          (queue.findPosition(99) != -1 ? "Ditemukan" : "Tidak ditemukan"));
        
        // Melayani pelanggan (mengeluarkan dari antrian)
        System.out.println("\n--- Melayani 2 pelanggan pertama ---");
        Node servedCustomer1 = queue.pop();
        System.out.println("Pelanggan pertama yang dilayani: " + servedCustomer1);
        
        Node servedCustomer2 = queue.pop();
        System.out.println("Pelanggan kedua yang dilayani: " + servedCustomer2);
        
        // Menambahkan pelanggan lagi
        System.out.println("\n--- Pelanggan baru datang ---");
        Node tono = queue.push("Tono");
        System.out.println("Menambahkan " + tono + " ke antrian");
        
        // Statistik antrian setelah perubahan
        System.out.println("\n--- Statistik antrian setelah perubahan ---");
        queue.displayQueueStatistics();
        
        // Melayani semua pelanggan yang tersisa
        System.out.println("\n--- Melayani semua pelanggan yang tersisa ---");
        while (!queue.isEmpty()) {
            Node served = queue.pop();
            System.out.println("Melayani: " + served);
        }
        
        // Kondisi setelah semua pelanggan dilayani
        System.out.println("\n--- Kondisi setelah semua pelanggan dilayani ---");
        queue.displayQueue();
        
        // Mencoba melayani pelanggan pada antrian kosong
        System.out.println("\n--- Mencoba melayani pelanggan pada antrian kosong ---");
        Node nullNode = queue.pop();
        System.out.println("Hasil: " + (nullNode == null ? "Tidak ada pelanggan yang bisa dilayani" : nullNode));
        
        // Menambahkan pelanggan baru setelah antrian kosong
        System.out.println("\n--- Menambahkan pelanggan baru setelah antrian kosong ---");
        queue.push("Andi");
        queue.push("Bintang");
        
        // Menampilkan kondisi akhir
        System.out.println("\n--- Kondisi akhir antrian ---");
        queue.displayQueueStatistics();
        
        // Tampilkan analisis struktur data
        printStructureAnalysis();
    }
    
    /**
     * Menampilkan analisis struktur data
     */
    private static void printStructureAnalysis() {
        System.out.println("\n\n=== ANALISIS STRUKTUR DATA LINKED LIST ===\n");
        System.out.println("1. Single Linked List dipilih untuk implementasi ini karena:");
        System.out.println("   - Operasi push (di belakang) dan pop (di depan) memiliki kompleksitas waktu O(1)");
        System.out.println("   - Overhead memori lebih rendah dibandingkan Double Linked List");
        System.out.println("   - Traversal mundur tidak diperlukan untuk operasi FIFO antrian");
        System.out.println("   - Lebih sederhana daripada Circular Linked List untuk implementasi antrian");
        System.out.println("   - Tidak membutuhkan realokasi memori seperti Array");
        
        System.out.println("\n2. Perbandingan dengan struktur data lain:");
        System.out.println("   - Double Linked List: Memiliki overhead tambahan untuk pointer prev yang tidak diperlukan");
        System.out.println("   - Circular Linked List: Lebih kompleks untuk implementasi antrian sederhana");
        System.out.println("   - Array: Tidak efisien untuk operasi pop karena memerlukan pergeseran O(n) elemen");
        
        System.out.println("\n3. Alokasi Memori untuk struktur data:");
        System.out.println("   - Single Linked List: data + 1 pointer per node");
        System.out.println("   - Double Linked List: data + 2 pointer per node (prev dan next)");
        System.out.println("   - Circular Linked List: data + 1 pointer per node (node terakhir → pertama)");
        System.out.println("   - Array: alokasi memori bersebelahan, terbatas pada ukuran predefined");
        
        System.out.println("\n4. Contoh penggunaan memori untuk 5 pelanggan:");
        System.out.println("   Misalkan: nama (20 byte), timestamp (8 byte), nomor antrian (4 byte), pointer (4 byte)");
        System.out.println("   - Single Linked List: 5 × (20+8+4+4) = 5 × 36 = 180 byte");
        System.out.println("   - Double Linked List: 5 × (20+8+4+8) = 5 × 40 = 200 byte");
        System.out.println("   - Array tetap (ukuran 10): 10 × (20+8+4) = 10 × 32 = 320 byte (50% memori tidak terpakai)");
        
        System.out.println("\n=== KESIMPULAN ===");
        System.out.println("Single Linked List adalah pilihan optimal untuk implementasi antrian FIFO restoran,");
        System.out.println("memberikan efisiensi memori dan kompleksitas waktu yang optimal untuk operasi yang diperlukan.");
    }
} 