public class RestaurantQueueDemo {
    public static void main(String[] args) {
        // Membuat objek antrian restoran
        RestaurantQueue queue = new RestaurantQueue();
        
        System.out.println("=== DEMONSTRASI SISTEM ANTRIAN RESTORAN ===");
        
        // Menampilkan kondisi awal
        System.out.println("\nKondisi awal:");
        queue.displayQueue();
        
        // Menambahkan beberapa pelanggan ke antrian
        System.out.println("\nMenambahkan pelanggan ke antrian:");
        queue.push("Budi");
        queue.push("Siti");
        queue.push("Rudi");
        queue.push("Dewi");
        queue.push("Joko");
        
        // Melayani pelanggan (mengeluarkan dari antrian)
        System.out.println("\nMelayani pelanggan:");
        queue.pop();
        queue.pop();
        
        // Menambahkan pelanggan lagi
        System.out.println("\nPelanggan baru datang:");
        queue.push("Tono");
        
        // Melayani semua pelanggan yang tersisa
        System.out.println("\nMelayani semua pelanggan yang tersisa:");
        while (!queue.isEmpty()) {
            queue.pop();
        }
        
        // Mencoba melayani pelanggan pada antrian kosong
        System.out.println("\nMencoba melayani pelanggan pada antrian kosong:");
        queue.pop();
        
        // Informasi tentang analisis struktur data
        System.out.println("\n=== ANALISIS STRUKTUR DATA ===");
        System.out.println("1. Single Linked List dipilih untuk implementasi ini karena:");
        System.out.println("   - Operasi push (di belakang) dan pop (di depan) dapat dilakukan dengan O(1)");
        System.out.println("   - Tidak memerlukan alokasi memori yang berlebihan seperti pada array");
        System.out.println("   - Tidak membutuhkan traversal mundur seperti pada Doubly Linked List");
        System.out.println("   - Cocok untuk sistem FIFO (First In First Out) seperti antrian restoran");
    }
} 