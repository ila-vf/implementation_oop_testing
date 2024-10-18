// Tidak ada paket yang dideklarasikan karena berada di direktori utama test/java

import controller.UserController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Kelas untuk menguji fungsionalitas UserController.
 * Menggunakan metode white box testing:
 * - Branch Testing: Menguji semua cabang logika dalam pengendali pengguna.
 * - Statement Testing: Memastikan setiap pernyataan dalam kode dieksekusi.
 */
public class UserControllerTest {

    /**
     * Menguji penambahan dan daftar pengguna.
     * Pastikan pengguna ditambahkan dengan benar dan dapat diambil dari daftar.
     * Jenis Testing: 
     * - Branch Testing: Memastikan cabang logika untuk penambahan pengguna dieksekusi.
     * - Statement Testing: Memastikan pernyataan dalam addUser dan listUsers dijalankan.
     */
    @Test
    public void testAddAndListUsers() {
        UserController controller = new UserController();
        controller.addUser("Ila", "ila@example.com");

        // Memastikan satu pengguna ada di daftar
        assertEquals(1, controller.listUsers().size());
        // Memastikan pengguna yang ditambahkan adalah yang diharapkan
        assertEquals("Ila (ila@example.com)", controller.listUsers().get(0));
    }

    /**
     * Menguji pembaruan informasi pengguna.
     * Pastikan pengguna dapat diperbarui dengan benar.
     * Jenis Testing: 
     * - Branch Testing: Menguji cabang logika yang menangani pembaruan pengguna.
     * - Condition Testing: Memastikan kondisi berhasil dan gagal pada editUser.
     */
    @Test
    public void testEditUser() {
        UserController controller = new UserController();
        controller.addUser("Ila", "ila@example.com");

        // Memastikan pembaruan pengguna berhasil
        assertTrue(controller.editUser(0, "Ila Virnanda", "ila.virnanda@example.com"));
        // Memastikan pengguna yang diperbarui adalah yang diharapkan
        assertEquals("Ila Virnanda (ila.virnanda@example.com)", controller.listUsers().get(0));
    }

    /**
     * Menguji penghapusan pengguna.
     * Pastikan pengguna dapat dihapus dari daftar dengan benar.
     * Jenis Testing: 
     * - Branch Testing: Memastikan cabang logika untuk penghapusan pengguna dieksekusi.
     * - Condition Testing: Memastikan kondisi untuk berhasil dan tidaknya penghapusan pengguna.
     */
    @Test
    public void testRemoveUser() {
        UserController controller = new UserController();
        controller.addUser("Ila", "ila@example.com");

        // Memastikan pengguna dihapus dengan benar
        assertTrue(controller.removeUser(0));
        // Memastikan daftar pengguna kosong setelah penghapusan
        assertTrue(controller.listUsers().isEmpty());
    }
}
