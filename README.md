
# Character Manager – Sprint 6 (TP14)

## Form Input, Validasi & Analisis MVC

**Mata Kuliah:** Java Visual  
**Package:** `com.unpri.charactermanager`  
**Sprint:** 6  
**Tugas Praktik:** TP14  
**Versi Aplikasi:** Character Manager v0.6

---

## 1. Deskripsi Project

Character Manager merupakan aplikasi berbasis Java Swing yang digunakan untuk mengelola data karakter. Pada Sprint 6 (TP14), aplikasi dikembangkan dengan menambahkan form input karakter, validasi data, serta penerapan validasi pada dua lapisan, yaitu View dan Model.

Pengembangan ini bertujuan agar pengguna dapat memasukkan data karakter dengan lebih mudah dan aplikasi dapat mencegah data yang tidak sesuai sebelum disimpan.

## 2. Tujuan Praktikum

1. Membuat form input karakter menggunakan komponen Java Swing.
2. Menerapkan validasi nama karakter.
3. Mencegah nama karakter kosong, terlalu pendek, terlalu panjang, atau duplikat.
4. Menerapkan validasi pada Model menggunakan `IllegalArgumentException`.
5. Menampilkan pesan kesalahan secara langsung pada form.
6. Memperbarui daftar karakter setelah data berhasil ditambahkan.

## 3. Fitur yang Dikembangkan

- Input nama karakter menggunakan `JTextField`.
- Pemilihan role menggunakan `JComboBox`.
- Pengaturan level menggunakan `JSpinner`.
- Validasi nama karakter.
- Validasi nama duplikat.
- Validasi batas level karakter.
- Validasi maksimal 20 karakter.
- Validasi khusus MAGE dengan level maksimal 60.
- Penolakan nama yang memiliki spasi ganda.
- Pesan kesalahan dan keberhasilan pada form.
- Daftar karakter diperbarui secara otomatis setelah penambahan berhasil.

## 4. Struktur Project

```text
CharacterManager/
├── src/
│   ├── Main.java
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── model/
│               │   ├── Character.java
│               │   ├── CharacterManager.java
│               │   └── CharacterType.java
│               └── view/
│                   ├── MainWindow.java
│                   ├── CharacterFormPanel.java
│                   └── AppTheme.java
├── screenshots/
│   ├── TP14_validasi_nama_kosong.png
│   ├── TP14_validasi_nama_duplikat.png
│   └── TP14_berhasil_tambah_karakter.png
├── out/
└── README.md
```

## 5. Implementasi Validasi

Validasi dilakukan pada dua lapisan:

### A. View

Validasi pada View dilakukan sebelum data dikirim ke Model. Pemeriksaan meliputi:

- Nama tidak boleh kosong.
- Nama harus memiliki panjang 3–20 karakter.
- Nama hanya boleh berisi huruf dan spasi.
- Nama tidak boleh memiliki spasi ganda.
- Nama tidak boleh sama dengan karakter yang sudah terdaftar.

### B. Model

Validasi pada Model dilakukan melalui constructor `Character` dan class `CharacterManager`.

Aturan yang diterapkan:

- Nama karakter tidak boleh kosong.
- Role tidak boleh bernilai null.
- Level harus berada pada rentang 1–99.
- Karakter MAGE memiliki level maksimal 60.
- Jumlah karakter maksimal 20.
- Nama karakter tidak boleh duplikat.

Jika data tidak memenuhi aturan, Model akan menghasilkan `IllegalArgumentException` dengan pesan yang sesuai.

## 6. Screenshot Hasil Pengujian

### A. Validasi Nama Kosong

![Validasi nama kosong](screenshots/TP14_validasi_nama_kosong.png)

### B. Validasi Nama Duplikat

![Validasi nama duplikat](screenshots/TP14_validasi_nama_duplikat.png)

### C. Berhasil Menambahkan Karakter

![Berhasil menambahkan karakter](screenshots/TP14_berhasil_tambah_karakter.png)

## 7. Tabel Pengujian

| No. | Input/Pengujian | Hasil yang Diharapkan | Hasil Aktual | Status |
|---|---|---|---|---|
| 1 | Nama kosong | Ditolak | Ditolak dengan pesan nama wajib diisi | Berhasil |
| 2 | Nama duplikat | Ditolak | Ditolak dengan pesan nama sudah digunakan | Berhasil |
| 3 | Nama mengandung angka | Ditolak | Ditolak oleh validasi format | Berhasil |
| 4 | Nama memiliki spasi ganda | Ditolak | Ditolak oleh validasi format | Berhasil |
| 5 | Nama kurang dari 3 karakter | Ditolak | Ditolak oleh validasi panjang nama | Berhasil |
| 6 | MAGE dengan level 70 | Ditolak | Ditolak oleh validasi Model | Berhasil |
| 7 | Menambahkan karakter valid | Data berhasil ditambahkan | Karakter berhasil ditambahkan dan daftar diperbarui | Berhasil |
| 8 | Menambahkan karakter ke-21 | Ditolak | Ditolak karena batas maksimal 20 karakter | Berhasil |

## 8. Analisis Penerapan MVC

Penerapan konsep MVC pada Sprint 6 dilakukan dengan memisahkan tanggung jawab setiap bagian aplikasi.

- **Model:** Mengelola data karakter dan aturan validasi.
- **View:** Menampilkan form input, pesan validasi, dan daftar karakter.
- **Main:** Menjalankan aplikasi dan menghubungkan komponen yang diperlukan.

Validasi pada View membantu memberikan respons langsung kepada pengguna. Sementara itu, validasi pada Model memastikan data tetap terlindungi meskipun berasal dari sumber lain selain form.

## 9. Analisis Kompromi Sementara

Pada implementasi ini, `ActionListener` masih menggunakan lambda agar kode lebih sederhana dan mudah dipahami. Selain itu, View masih memanggil `CharacterManager` secara langsung untuk menambahkan karakter. Pendekatan tersebut digunakan sebagai penyederhanaan sementara dalam praktikum. Pada pengembangan berikutnya, pengelolaan event dan komunikasi antara View dan Model dapat dipisahkan menggunakan Controller agar penerapan MVC menjadi lebih terstruktur.

## 10. Kesimpulan

Pada Sprint 6 (TP14), aplikasi Character Manager berhasil dikembangkan dengan fitur form input dan validasi data. Validasi dilakukan pada lapisan View dan Model untuk memastikan data yang dimasukkan sesuai dengan aturan aplikasi.

Aplikasi juga berhasil menerapkan aturan tambahan berupa larangan spasi ganda, batas maksimal 20 karakter, dan level maksimal 60 untuk role MAGE. Dengan pengembangan ini, aplikasi menjadi lebih terstruktur, aman terhadap input yang tidak valid, dan lebih mudah digunakan.

---

**Repository GitHub:**  
https://github.com/yanicantik16/JavaVisual-253303621278

**Branch:** `sprint-6-tp14`

**Dokumentasi Google Docs:**  
https://docs.google.com/document/d/1sSHOjwkWokx_mcNWHP-WodImAn1oR7ubOwGhtyOYAEQ/edit?usp=sharing
