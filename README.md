
# Character Manager – Sprint 3 (TP8)

## MainWindow, Data Dinamis & Analisis MVC

**Mata Kuliah:** Java Visual  
**CPMK:** 2  
**SCPMK:** 3  
**Sprint:** 3  
**Tugas:** TP8 – Character Manager Sprint #3

---

## 1. Deskripsi Proyek

Character Manager merupakan aplikasi berbasis Java yang dikembangkan menggunakan konsep Object-Oriented Programming (OOP) dan Graphical User Interface (GUI) dengan Java Swing.

Pada Sprint 3 ini, aplikasi dikembangkan dengan menambahkan tampilan utama menggunakan class MainWindow. Data karakter ditampilkan secara dinamis melalui perulangan, serta dilengkapi informasi jumlah karakter dan rata-rata level karakter.

Aplikasi juga menerapkan konsep Model-View-Controller (MVC) agar pengelolaan data dan tampilan memiliki tanggung jawab yang terpisah.

## 2. Fitur yang Dikembangkan

1. Menampilkan GUI menggunakan JFrame.
2. Menampilkan daftar karakter secara dinamis.
3. Menampilkan minimal 5 karakter.
4. Menampilkan nama, tipe, level, HP, dan ATK karakter.
5. Menghitung dan menampilkan rata-rata level karakter.
6. Menjalankan GUI menggunakan SwingUtilities.invokeLater().
7. Menerapkan pemisahan tanggung jawab sesuai prinsip MVC.

## 3. Struktur Program

```text
CharacterManager/
│
├── src/
│   ├── Main.java
│   │
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── model/
│               │   ├── Character.java
│               │   ├── CharacterType.java
│               │   └── CharacterManager.java
│               │
│               └── view/
│                   └── MainWindow.java
│
├── screenshots/
│
└── README.md
```

## 4. Data Karakter

Pada Sprint 3 terdapat lima karakter yang ditampilkan dalam aplikasi:

| Nama | Tipe | Level |
|---|---|---:|
| Arjuna | WARRIOR | 5 |
| Merlin | MAGE | 3 |
| Athena | ARCHER | 4 |
| Bima | WARRIOR | 7 |
| Luna | HEALER | 10 |

### Karakter Baru

**Bima**
- Tipe: WARRIOR
- Level: 7
- Alasan: Bima ditambahkan sebagai karakter petarung dengan level lebih tinggi untuk memperkaya variasi data karakter.

**Luna**
- Tipe: HEALER
- Level: 10
- Alasan: Luna ditambahkan sebagai karakter pendukung dengan level tinggi untuk menunjukkan variasi tipe karakter dan perubahan statistik rata-rata.

## 5. Implementasi MVC dan Alur Data

Alur data aplikasi dimulai dari Main.java yang membuat objek CharacterManager dan menambahkan data karakter. Selanjutnya, CharacterManager mengelola kumpulan karakter dan menyediakan data melalui method getAllCharacters() serta perhitungan rata-rata melalui getAverageLevel(). Data tersebut kemudian diteruskan ke MainWindow.java untuk ditampilkan menggunakan komponen GUI Java Swing.

Pemisahan ini menunjukkan bahwa bagian Model bertanggung jawab mengelola data dan proses perhitungan, sedangkan bagian View bertanggung jawab menampilkan informasi kepada pengguna.

## 6. Hasil Pengujian

### Pengujian 1 – Sebelum Perubahan Data

Level Luna: 6

Rata-rata level:

(5 + 3 + 4 + 7 + 6) / 5 = 5.00

![Pengujian pertama](screenshots/tp8-rata-rata-5-00.png)

### Pengujian 2 – Setelah Perubahan Data

Level Luna: 10

Rata-rata level:

(5 + 3 + 4 + 7 + 10) / 5 = 5.80

![Pengujian kedua](screenshots/tp8-rata-rata-5-80.png)

### Tampilan Utama Character Manager

![Tampilan utama](screenshots/tp8-mainwindow-5-karakter.png)

## 7. Kesimpulan

Melalui Sprint 3 TP8, aplikasi Character Manager berhasil dikembangkan menggunakan Java Swing. Aplikasi mampu menampilkan data karakter secara dinamis, menghitung rata-rata level, serta menerapkan pemisahan tanggung jawab antara Model dan View. Pengujian menunjukkan bahwa perubahan data karakter dapat memengaruhi hasil rata-rata level secara otomatis.

## 8. Laporan Google Docs

Link laporan TP8:

[Tempelkan link Google Docs di sini]

---

**Repository GitHub:**  
https://github.com/yanicantik16/JavaVisual-253303621278

**Branch:** sprint-3-tp8
