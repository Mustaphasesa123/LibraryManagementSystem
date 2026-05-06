package librarymanagementsystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BookDAO bookDAO = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();
        BorrowRecordDAO borrowDAO = new BorrowRecordDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Update Member");
            System.out.println("8. Delete Member");
            System.out.println("9. Add Borrow Record");
            System.out.println("10. View Borrow Records");
            System.out.println("11. Update Borrow Record");
            System.out.println("12. Delete Borrow Record");
            System.out.println("13. Search Book");
            System.out.println("14. View Overdue Books");
            System.out.println("15. Search Member");
            System.out.println("16. Search Borrow Record");
            System.out.println("17. Exit");

            System.out.print("Choose option: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Title: ");
                    String title = input.nextLine();

                    System.out.print("Enter Author: ");
                    String author = input.nextLine();

                    System.out.print("Enter Category: ");
                    String category = input.nextLine();

                    System.out.print("Enter Status: ");
                    String status = input.nextLine();

                    Book book = new Book(bookId, title, author, category, status);
                    bookDAO.addBook(book);
                    break;

                case 2:
                    bookDAO.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to update: ");
                    int updateBookId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new title: ");
                    String newTitle = input.nextLine();

                    bookDAO.updateBook(updateBookId, newTitle);
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteBookId = input.nextInt();

                    bookDAO.deleteBook(deleteBookId);
                    break;

                case 5:
                    System.out.print("Enter Member ID: ");
                    int memberId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Member Name: ");
                    String memberName = input.nextLine();

                    System.out.print("Enter Email: ");
                    String email = input.nextLine();

                    if (!Validation.isValidEmail(email)) {
                        System.out.println("Invalid email format!");
                        break;
                    }

                    System.out.print("Enter Membership Type: ");
                    String membershipType = input.nextLine();

                    Member member = new Member(memberId, memberName, email, membershipType);
                    memberDAO.addMember(member);
                    break;

                case 6:
                    memberDAO.viewMembers();
                    break;

                case 7:
                    System.out.print("Enter Member ID to update: ");
                    int updateMemberId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = input.nextLine();

                    memberDAO.updateMember(updateMemberId, newEmail);
                    break;

                case 8:
                    System.out.print("Enter Member ID to delete: ");
                    int deleteMemberId = input.nextInt();

                    memberDAO.deleteMember(deleteMemberId);
                    break;

                case 9:
                    System.out.print("Enter Record ID: ");
                    int recordId = input.nextInt();

                    System.out.print("Enter Book ID: ");
                    int borrowBookId = input.nextInt();

                    System.out.print("Enter Member ID: ");
                    int borrowMemberId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Borrow Date (YYYY-MM-DD): ");
                    String borrowDate = input.nextLine();

                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
                    String dueDate = input.nextLine();

                    if (!Validation.isValidDates(borrowDate, dueDate)) {
                        System.out.println("Due date must be after borrow date!");
                        break;
                    }

                    System.out.print("Enter Status: ");
                    String returnStatus = input.nextLine();

                    BorrowRecord record = new BorrowRecord(
                            recordId,
                            borrowBookId,
                            borrowMemberId,
                            borrowDate,
                            dueDate,
                            returnStatus
                    );

                    borrowDAO.addBorrowRecord(record);
                    break;

                case 10:
                    borrowDAO.viewBorrowRecords();
                    break;

                case 11:
                    System.out.print("Enter Record ID to update: ");
                    int updateRecordId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new status: ");
                    String newStatus = input.nextLine();

                    borrowDAO.updateBorrowStatus(updateRecordId, newStatus);
                    break;

                case 12:
                    System.out.print("Enter Record ID to delete: ");
                    int deleteRecordId = input.nextInt();

                    borrowDAO.deleteBorrowRecord(deleteRecordId);
                    break;

                case 13:
                    input.nextLine();

                    System.out.print("Enter book title to search: ");
                    String searchTitle = input.nextLine();

                    bookDAO.searchBook(searchTitle);
                    break;

                case 14:
                    borrowDAO.viewOverdueBooks();
                    break;

                case 15:
    input.nextLine();

    System.out.print("Enter member name to search: ");
    String searchName = input.nextLine();

    memberDAO.searchMember(searchName);
    break;

case 16:
    System.out.print("Enter Member ID to search borrow records: ");
    int searchMemberId = input.nextInt();

    borrowDAO.searchBorrowRecord(searchMemberId);
    break;

case 17:
    System.out.println("Goodbye!");
    input.close();
    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}