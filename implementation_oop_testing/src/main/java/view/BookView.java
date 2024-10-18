package view;

import model.Book;

import java.util.List;

/**
 * Kelas ini bertanggung jawab untuk menampilkan informasi tentang buku.
 */
public class BookView {
    // Menampilkan daftar buku
    public void printBooks(List<Book> books) {
        System.out.println("=== List of Books ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". Title: " + books.get(i).getTitle() + ", Author: " + books.get(i).getAuthor());
        }
    }

    // Menampilkan pesan sukses
    public void printSuccessMessage(String message) {
        System.out.println(message);
    }
}
