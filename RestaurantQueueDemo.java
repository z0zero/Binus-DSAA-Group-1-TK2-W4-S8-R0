import java.util.Scanner;

public class RestaurantQueueDemo {
    public static void main(String[] args) {
        // Pesan pembuka
        System.out.println("=== SISTEM ANTRIAN RESTORAN ===");
        System.out.println("Implementasi menggunakan Single Linked List dengan konsep FIFO");
        System.out.println("Untuk demo otomatis tanpa interaksi, jalankan RestaurantQueueAutomaticDemo\n");
        
        // Jalankan demo interaktif
        interactiveDemo();
    }
    
    /**
     * Demo interaktif yang memungkinkan pengguna untuk berinteraksi dengan sistem antrian
     */
    private static void interactiveDemo() {
        Scanner scanner = new Scanner(System.in);
        RestaurantQueue queue = new RestaurantQueue();
        boolean running = true;
        
        System.out.println("=== SISTEM ANTRIAN RESTORAN INTERAKTIF ===");
        System.out.println("Implementasi menggunakan Single Linked List");
        
        while (running) {
            System.out.println("\nMENU:");
            System.out.println("1. Tambah pelanggan ke antrian");
            System.out.println("2. Layani pelanggan (keluarkan dari antrian)");
            System.out.println("3. Tampilkan kondisi antrian");
            System.out.println("4. Tampilkan statistik antrian");
            System.out.println("5. Cari posisi pelanggan berdasarkan nomor antrian");
            System.out.println("6. Tampilkan analisis struktur data");
            System.out.println("7. Jalankan demo otomatis");
            System.out.println("0. Keluar");
            
            System.out.print("\nPilihan Anda: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.print("Masukkan nama pelanggan: ");
                    String name = scanner.nextLine();
                    Node newCustomer = queue.push(name);
                    System.out.println("Pelanggan ditambahkan: " + newCustomer);
                    break;
                case "2":
                    Node servedCustomer = queue.pop();
                    if (servedCustomer != null) {
                        System.out.println("Pelanggan " + servedCustomer + " telah dilayani");
                    }
                    break;
                case "3":
                    System.out.println("\nKondisi antrian saat ini:");
                    queue.displayQueue();
                    break;
                case "4":
                    queue.displayQueueStatistics();
                    break;
                case "5":
                    System.out.print("Masukkan nomor antrian yang dicari: ");
                    try {
                        int queueNumber = Integer.parseInt(scanner.nextLine());
                        int position = queue.findPosition(queueNumber);
                        if (position != -1) {
                            System.out.println("Pelanggan dengan nomor antrian " + queueNumber + 
                                " berada di posisi ke-" + position);
                        } else {
                            System.out.println("Pelanggan dengan nomor antrian " + queueNumber + 
                                " tidak ditemukan");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid. Harap masukkan angka.");
                    }
                    break;
                case "6":
                    printAnalysis();
                    break;
                case "7":
                    System.out.println("\nMenjalankan demo otomatis...");
                    // Buat antrian baru untuk demo otomatis
                    automaticDemo();
                    System.out.println("\nDemo otomatis selesai. Kembali ke menu interaktif.");
                    break;
                case "0":
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem antrian restoran!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Demo otomatis yang menunjukkan semua fitur sistem antrian restoran
     */
    private static void automaticDemo() {
        // Membuat objek antrian restoran
        RestaurantQueue queue = new RestaurantQueue();
        
        System.out.println("\n=== DEMONSTRASI SISTEM ANTRIAN RESTORAN OTOMATIS ===");
        
        // Menampilkan kondisi awal
        System.out.println("\nKondisi awal:");
        queue.displayQueue();
        
        // Menambahkan beberapa pelanggan ke antrian
        System.out.println("\nMenambahkan pelanggan ke antrian:");
        Node budi = queue.push("Budi");
        Node siti = queue.push("Siti");
        queue.push("Rudi");
        queue.push("Dewi");
        queue.push("Joko");
        
        // Menampilkan statistik antrian
        System.out.println("\nStatistik antrian setelah menambahkan 5 pelanggan:");
        queue.displayQueueStatistics();
        
        // Mencari posisi pelanggan
        System.out.println("\nMencari posisi pelanggan:");
        System.out.println("Posisi " + budi + " dalam antrian: " + queue.findPosition(budi.getQueueNumber()));
        System.out.println("Posisi " + siti + " dalam antrian: " + queue.findPosition(siti.getQueueNumber()));
        
        // Melayani pelanggan (mengeluarkan dari antrian)
        System.out.println("\nMelayani pelanggan:");
        queue.pop();
        queue.pop();
        
        // Menambahkan pelanggan lagi
        System.out.println("\nPelanggan baru datang:");
        queue.push("Tono");
        
        // Statistik antrian setelah perubahan
        System.out.println("\nStatistik antrian setelah perubahan:");
        queue.displayQueueStatistics();
        
        // Melayani semua pelanggan yang tersisa
        System.out.println("\nMelayani semua pelanggan yang tersisa:");
        while (!queue.isEmpty()) {
            queue.pop();
        }
        
        // Mencoba melayani pelanggan pada antrian kosong
        System.out.println("\nMencoba melayani pelanggan pada antrian kosong:");
        queue.pop();
    }
    
    /**
     * Menampilkan analisis struktur data
     */
    private static void printAnalysis() {
        System.out.println("\n=== ANALISIS STRUKTUR DATA ===");
        System.out.println("1. Single Linked List dipilih untuk implementasi ini karena:");
        System.out.println("   - Operasi push (di belakang) dan pop (di depan) dapat dilakukan dengan O(1)");
        System.out.println("   - Overhead memori lebih rendah dibandingkan Double Linked List");
        System.out.println("   - Traversal mundur tidak diperlukan untuk operasi FIFO");
        System.out.println("   - Lebih sederhana daripada Circular Linked List untuk implementasi antrian");
        System.out.println("   - Tidak membutuhkan realokasi memori seperti Array");
        System.out.println("\n2. Perbandingan dengan struktur data lain:");
        System.out.println("   - Double Linked List: Memiliki overhead tambahan untuk pointer prev");
        System.out.println("   - Circular Linked List: Lebih kompleks untuk implementasi antrian sederhana");
        System.out.println("   - Array: Tidak efisien untuk operasi pop karena memerlukan pergeseran elemen");
        
        System.out.println("\n3. Alokasi Memori:");
        System.out.println("   - Single Linked List: satu pointer per node");
        System.out.println("   - Double Linked List: dua pointer per node (prev dan next)");
        System.out.println("   - Circular Linked List: satu pointer per node (tapi node terakhir menunjuk ke pertama)");
        System.out.println("   - Array: alokasi blok memori bersebelahan, tidak fleksibel untuk ukuran dinamis");
    }
} 