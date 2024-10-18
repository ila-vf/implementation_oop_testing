
import controller.BookController;
import controller.UserController;
import view.BookView;
import view.UserView;

import java.util.Scanner;

/**
 * Kelas utama untuk menjalankan aplikasi manajemen buku dan pengguna.
 */
public class Main {
    public static void main(String[] args) {
        BookController bookController = new BookController(); // Inisialisasi BookController
        UserController userController = new UserController(); // Inisialisasi UserController
        Scanner scanner = new Scanner(System.in); // Scanner untuk input pengguna

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Manage Books");
            System.out.println("2. Manage Users");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    manageBooks(scanner, bookController); // Menu manajemen buku
                    break;
                case 2:
                    manageUsers(scanner, userController); // Menu manajemen pengguna
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close(); // Menutup scanner
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageBooks(Scanner scanner, BookController bookController) {
        BookView bookView = new BookView(); // Inisialisasi BookView
        
        while (true) {
            System.out.println("=== Manage Books ===");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("0. Back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine(); // Input judul buku
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine(); // Input pengarang buku
                    bookController.addBook(title, author); // Menambah buku
                    bookView.printSuccessMessage("Book added successfully!"); // Menampilkan pesan sukses
                    break;
                case 2:
                    bookView.printBooks(bookController.listBooks()); // Menampilkan daftar buku
                    break;
                case 3:
                    System.out.print("Enter Book Index to update: ");
                    int indexToUpdate = scanner.nextInt() - 1; // Input index buku untuk diperbarui
                    scanner.nextLine(); // Clear the buffer
                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine(); // Input judul baru
                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine(); // Input pengarang baru
                    if (bookController.editBook(indexToUpdate, newTitle, newAuthor)) {
                        bookView.printSuccessMessage("Book updated successfully!"); // Menampilkan pesan sukses
                    } else {
                        System.out.println("Book not found."); // Menampilkan pesan jika buku tidak ditemukan
                    }
                    break;
                case 4:
                    System.out.print("Enter Book Index to delete: ");
                    int indexToDelete = scanner.nextInt() - 1; // Input index buku untuk dihapus
                    if (bookController.removeBook(indexToDelete)) {
                        bookView.printSuccessMessage("Book deleted successfully!"); // Menampilkan pesan sukses
                    } else {
                        System.out.println("Book not found."); // Menampilkan pesan jika buku tidak ditemukan
                    }
                    break;
                case 0:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Invalid choice. Try again."); // Pesan kesalahan jika pilihan tidak valid
            }
        }
    }

    private static void manageUsers(Scanner scanner, UserController userController) {
        UserView userView = new UserView(); // Inisialisasi UserView
        
        while (true) {
            System.out.println("=== Manage Users ===");
            System.out.println("1. Add User");
            System.out.println("2. List Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("0. Back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine(); // Input nama pengguna
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine(); // Input email pengguna
                    userController.addUser(name, email); // Menambah pengguna
                    userView.printSuccessMessage("User added successfully!"); // Menampilkan pesan sukses
                    break;
                case 2:
                    userView.printUsers(userController.listUsers()); // Menampilkan daftar pengguna
                    break;
                case 3:
                    System.out.print("Enter User Index to update: ");
                    int indexToUpdate = scanner.nextInt() - 1; // Input index pengguna untuk diperbarui
                    scanner.nextLine(); // Clear the buffer
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine(); // Input nama baru
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine(); // Input email baru
                    if (userController.editUser(indexToUpdate, newName, newEmail)) {
                        userView.printSuccessMessage("User updated successfully!"); // Menampilkan pesan sukses
                    } else {
                        System.out.println("User not found."); // Menampilkan pesan jika pengguna tidak ditemukan
                    }
                    break;
                case 4:
                    System.out.print("Enter User Index to delete: ");
                    int indexToDelete = scanner.nextInt() - 1; // Input index pengguna untuk dihapus
                    if (userController.removeUser(indexToDelete)) {
                        userView.printSuccessMessage("User deleted successfully!"); // Menampilkan pesan sukses
                    } else {
                        System.out.println("User not found."); // Menampilkan pesan jika pengguna tidak ditemukan
                    }
                    break;
                case 0:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Invalid choice. Try again."); // Pesan kesalahan jika pilihan tidak valid
            }
        }
    }
}
