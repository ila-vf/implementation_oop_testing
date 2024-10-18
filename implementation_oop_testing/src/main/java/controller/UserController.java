package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas ini mengatur logika untuk manajemen pengguna,
 * termasuk menambah, mengedit, menghapus, dan mendapatkan daftar pengguna.
 */
public class UserController {
    private List<User> users = new ArrayList<>(); // Daftar pengguna

    // Menambahkan pengguna baru ke dalam daftar
    public void addUser(String name, String email) {
        users.add(new User(name, email));
    }

    // Mendapatkan daftar semua pengguna
    public List<User> listUsers() {
        return users;
    }

    // Mengedit pengguna berdasarkan index
    public boolean editUser(int index, String name, String email) {
        if (index >= 0 && index < users.size()) {
            users.set(index, new User(name, email));
            return true; // Pengeditan berhasil
        }
        return false; // Pengeditan gagal
    }

    // Menghapus pengguna berdasarkan index
    public boolean removeUser(int index) {
        if (index >= 0 && index < users.size()) {
            users.remove(index);
            return true; // Penghapusan berhasil
        }
        return false; // Penghapusan gagal
    }
}
