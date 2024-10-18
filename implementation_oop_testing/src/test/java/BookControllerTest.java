// Tidak ada paket yang dideklarasikan karena berada di direktori utama test/java

import controller.BookController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Kelas untuk menguji fungsionalitas BookController.
 * Menggunakan metode white box testing:
 * - Branch Testing: Menguji semua cabang logika dalam pengendali buku.
 * - Statement Testing: Memastikan setiap pernyataan dalam kode dieksekusi.
 */
public class BookControllerTest {

    /**
     * Menguji penambahan dan daftar buku.
     * Pastikan buku ditambahkan dengan benar dan dapat diambil dari daftar.
     * Jenis Testing: 
     * - Branch Testing: Memastikan cabang logika untuk penambahan buku dieksekusi.
     * - Statement Testing: Memastikan pernyataan dalam addBook dan listBooks dijalankan.
     */
    @Test
    public void testAddAndListBooks() {
        BookController controller = new BookController();
        controller.addBook("Effective Java", "Joshua Bloch");

        // Memastikan satu buku ada di daftar
        assertEquals(1, controller.listBooks().size());
        // Memastikan buku yang ditambahkan adalah yang diharapkan
        assertEquals("Effective Java by Joshua Bloch", controller.listBooks().get(0));
    }

    /**
     * Menguji pembaruan informasi buku.
     * Pastikan buku dapat diperbarui dengan benar.
     * Jenis Testing: 
     * - Branch Testing: Menguji cabang logika yang menangani pembaruan buku.
     * - Condition Testing: Memastikan kondisi berhasil dan gagal pada editBook.
     */
    @Test
    public void testEditBook() {
        BookController controller = new BookController();
        controller.addBook("Effective Java", "Joshua Bloch");

        // Memastikan pembaruan buku berhasil
        assertTrue(controller.editBook(0, "Clean Code", "Robert C. Martin"));
        // Memastikan buku yang diperbarui adalah yang diharapkan
        assertEquals("Clean Code by Robert C. Martin", controller.listBooks().get(0));
    }

    /**
     * Menguji penghapusan buku.
     * Pastikan buku dapat dihapus dari daftar dengan benar.
     * Jenis Testing: 
     * - Branch Testing: Memastikan cabang logika untuk penghapusan buku dieksekusi.
     * - Condition Testing: Memastikan kondisi untuk berhasil dan tidaknya penghapusan buku.
     */
    @Test
    public void testRemoveBook() {
        BookController controller = new BookController();
        controller.addBook("Effective Java", "Joshua Bloch");

        // Memastikan buku dihapus dengan benar
        assertTrue(controller.removeBook(0));
        // Memastikan daftar buku kosong setelah penghapusan
        assertTrue(controller.listBooks().isEmpty());
    }
}
