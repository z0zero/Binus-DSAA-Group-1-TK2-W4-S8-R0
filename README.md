# Sistem Antrian Restoran FIFO

Implementasi sistem antrian pelanggan restoran menggunakan struktur data Single Linked List dengan konsep FIFO (First In First Out).

## Komponen Sistem

1. **Node.java** - Kelas untuk merepresentasikan setiap pelanggan dalam antrian
2. **RestaurantQueue.java** - Implementasi operasi antrian (push, pop, displayQueue)
3. **RestaurantQueueDemo.java** - Program utama untuk menjalankan simulasi sistem antrian

## Analisis Pemilihan Struktur Data

### Mengapa Single Linked List dipilih untuk kasus ini?

| Aspek                     | Single Linked List       | Double Linked List       | Circular Linked List             | Array                               |
| ------------------------- | ------------------------ | ------------------------ | -------------------------------- | ----------------------------------- |
| **Overhead Memori**       | Rendah (1 pointer)       | Tinggi (2 pointer)       | Rendah (1 pointer)               | Tidak ada pointer overhead          |
| **Traversal**             | Satu arah                | Dua arah                 | Satu arah (tanpa perlu cek null) | Random access                       |
| **Operasi Push di Rear**  | O(1) dengan pointer rear | O(1) dengan pointer rear | O(1)                             | O(1) dengan index, O(n) jika resize |
| **Operasi Pop di Front**  | O(1)                     | O(1)                     | O(1)                             | O(n) karena shifting                |
| **Kesesuaian untuk FIFO** | Sangat baik              | Baik tetapi berlebihan   | Baik tetapi kompleks             | Kurang efisien untuk operasi pop    |

**Kesimpulan**: Single Linked List dipilih karena:

- Operasi push di belakang dan pop di depan keduanya memiliki kompleksitas waktu O(1)
- Overhead memori lebih rendah dibandingkan Double Linked List
- Traversal mundur tidak diperlukan untuk operasi FIFO
- Lebih sederhana daripada Circular Linked List
- Tidak membutuhkan realokasi memori seperti Array

### Perbandingan Alokasi Memori dan Efisiensi Operasi

| Struktur Data          | Alokasi Memori                          | Kompleksitas Waktu      | Kelebihan                                  | Kekurangan                                                     |
| ---------------------- | --------------------------------------- | ----------------------- | ------------------------------------------ | -------------------------------------------------------------- |
| **Single Linked List** | Dinamis (memori untuk Node + 1 pointer) | Push: O(1), Pop: O(1)   | Efisien untuk FIFO, alokasi memori dinamis | Tidak dapat traversal mundur                                   |
| **Array**              | Statis (fixed size)                     | Push: O(1)\*, Pop: O(n) | Akses data cepat                           | Pemborosan memori jika ukuran tetap, operasi pop tidak efisien |

\*O(1) amortized untuk push pada array dinamis

## Dokumentasi Teknis

### Perbedaan Alokasi Memori antar Jenis Linked List

1. **Single Linked List**:

   - Setiap node memiliki 1 pointer (next)
   - Total memori: data + 1 pointer
   - Cocok untuk kasus antrian yang hanya membutuhkan operasi di depan dan belakang

2. **Double Linked List**:

   - Setiap node memiliki 2 pointer (prev dan next)
   - Total memori: data + 2 pointer
   - Memungkinkan traversal dua arah, tetapi tidak diperlukan untuk antrian FIFO

3. **Circular Linked List**:
   - Node terakhir menunjuk ke node pertama
   - Total memori: data + 1 pointer
   - Memudahkan akses kontinyu tanpa pengecekan null

### Contoh Konkret Penggunaan Memori untuk 5 Pelanggan

Misalkan:

- Nama pelanggan (String): 20 byte per nama
- Pointer di JVM: 4 byte

#### Single Linked List:

- Setiap Node: 20 byte (data) + 4 byte (pointer) = 24 byte
- 5 pelanggan: 5 × 24 byte = 120 byte

#### Double Linked List:

- Setiap Node: 20 byte (data) + 4 byte (next) + 4 byte (prev) = 28 byte
- 5 pelanggan: 5 × 28 byte = 140 byte

#### Array (fixed size 10):

- Data: 5 × 20 byte = 100 byte
- Memori tidak terpakai: 5 × 20 byte = 100 byte (jika ukuran array 10)
- Total: 200 byte

Dari contoh ini, Single Linked List adalah pilihan yang paling efisien untuk antrian restoran FIFO dengan overhead memori yang minimal dan kompleksitas operasi yang optimal.

## Cara Menjalankan Program

### Kompilasi:

```
javac -d bin *.java
```

### Eksekusi:

```
java -cp bin RestaurantQueueDemo
```

## Output Program

Sistem antrian restoran akan menampilkan:

- Kondisi awal (antrian kosong)
- Proses penambahan pelanggan ke antrian
- Proses pelayanan pelanggan (mengeluarkan dari antrian)
- Penambahan pelanggan baru setelah beberapa pelanggan dilayani
- Pelayanan semua pelanggan yang tersisa
- Penanganan kasus saat antrian kosong
- Analisis singkat mengenai pemilihan struktur data
