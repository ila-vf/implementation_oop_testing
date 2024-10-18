package view;

import model.User;

import java.util.List;

/**
 * Kelas ini bertanggung jawab untuk menampilkan informasi tentang pengguna.
 */
public class UserView {
    // Menampilkan daftar pengguna
    public void printUsers(List<User> users) {
        System.out.println("=== List of Users ===");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". Name: " + users.get(i).getName() + ", Email: " + users.get(i).getEmail());
        }
    }

    // Menampilkan pesan sukses
    public void printSuccessMessage(String message) {
        System.out.println(message);
    }
}
