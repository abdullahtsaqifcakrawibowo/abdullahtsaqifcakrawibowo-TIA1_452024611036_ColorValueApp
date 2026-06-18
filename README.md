# 🎨 ColorValue App - Tugas 9

Aplikasi Android berbasis **Jetpack Compose** untuk menyimpan dan mengelola daftar warna beserta kode Hex-nya menggunakan **Room Database** secara lokal. Proyek ini dibuat sebagai pemenuhan Tugas 9.

---

## ✨ Fitur Utama
* **Input Warna:** Pengguna dapat memasukkan Kode Hex (contoh: `#FF0000`) dan Nama Warna (contoh: `Merah`).
* **Simpan ke Database:** Data warna disimpan secara permanen di dalam penyimpanan lokal perangkat menggunakan arsitektur *Room Database*.
* **Tampilan Dinamis:** Menampilkan daftar warna yang tersimpan beserta *preview* kotak warna aslinya secara *real-time*.
* **Hapus Data:** Pengguna dapat menghapus warna dari daftar dan database.
* **Unit Testing:** Telah dilengkapi dengan pengujian otomatis (*Unit Test*) untuk memastikan fungsi *Insert* dan *Read* pada database berjalan dengan baik.

---

## 🛠️ Teknologi yang Digunakan
* **Bahasa Pemrograman:** Kotlin
* **UI Framework:** Jetpack Compose (Material Design 3)
* **Local Database:** Room Database
* **Asynchronous Programming:** Coroutines & ViewModel
* **Testing:** JUnit4 & AndroidX Test

---

## 📸 Tangkapan Layar (Screenshots)

*(Dosen, berikut adalah bukti aplikasi berjalan dan hasil unit test)*

**1. Tampilan Aplikasi di Perangkat**
> [!NOTE] 
> <img width="576" height="1280" alt="image" src="https://github.com/user-attachments/assets/26cabb01-2676-4b7b-9c2f-d7d4f43beb4c" />


**2. Bukti Unit Test (Passed)**
> [!NOTE]
> <img width="959" height="599" alt="Screenshot 2026-06-18 151350" src="https://github.com/user-attachments/assets/3b380f2a-eba5-41b4-9a58-22d645f2497d" />


---
*Dibuat untuk memenuhi Tugas Pemrograman Perangkat Bergerak.*
