package com.shtohryn.ViewAndController;

import com.shtohryn.model.*;
import com.shtohryn.model.metadata.TableMetaData;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");
        menu.put("B", "   B - Select structure of DB");

        menu.put("1", "   1 - Table: Author");
        menu.put("11", "  11 - Create for Author");
        menu.put("12", "  12 - Update Author");
        menu.put("13", "  13 - Delete from Author");
        menu.put("14", "  14 - Select Author");
        menu.put("15", "  15 - Find Author by ID");

        menu.put("2", "   2 - Table: Book");
        menu.put("21", "  21 - Create for Book");
        menu.put("22", "  22 - Update Book");
        menu.put("23", "  23 - Delete from Book");
        menu.put("24", "  24 - Select Book");
        menu.put("25", "  25 - Find Employee by Name(title)");

        menu.put("3", "   3 - Table: Reader");
        menu.put("31", "  31 - Create for Reader");
        menu.put("32", "  32 - Update Reader");
        menu.put("33", "  33 - Delete from Reader");
        menu.put("34", "  34 - Select Reader");
        menu.put("35", "  35 - Find Reader by ID");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);
        methodsMenu.put("B", this::takeStructureOfDB);

        methodsMenu.put("11", this::createForAthor);
        methodsMenu.put("12", this::updateAuthor);
        methodsMenu.put("13", this::deletefromAuthor);
        methodsMenu.put("14", this::selectAuthor);
        methodsMenu.put("15", this::findAuthorByID);

        methodsMenu.put("21", this::createForBook);
        methodsMenu.put("22", this::updateBook);
        methodsMenu.put("23", this::deleteFromBook);
        methodsMenu.put("24", this::selectBook);
        methodsMenu.put("25", this::findBookByID);

        methodsMenu.put("31", this::createForReader);
        methodsMenu.put("32", this::updateReader);
        methodsMenu.put("33", this::deleteFromReader);
        methodsMenu.put("34", this::selectReader);
        methodsMenu.put("35", this::findReaderByID);
    }

    private void selectAllTable() throws SQLException {
        selectAuthor();
        selectBook();
        selectReader();
    }

    private void takeStructureOfDB() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MetaDataService metaDataService = new MetaDataService();
        List<TableMetaData> tables = metaDataService.getTablesStructure();
        System.out.println("TABLE OF DATABASE: " + connection.getCatalog());

        for (TableMetaData table : tables) {
            System.out.println(table);
        }
    }

    //Author Table------------------------------------------------------------------------------
    private void deletefromAuthor() throws SQLException {
        System.out.println("Input ID(author_name) for Author: ");
        String id = input.nextLine();
        AuthorService authorService = new AuthorService();
        int count = authorService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForAthor() throws SQLException {
        System.out.println("Input ID(author_name) for Author: ");
        String name = input.nextLine();
        System.out.println("Input genre for Author: ");
        String genre = input.nextLine();
        AuthorModel authorModel = new AuthorModel(name, genre);
        AuthorService authorService = new AuthorService();
        int count = authorService.create(authorModel);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAuthor() throws SQLException {
        System.out.println("Input ID(author_name) for Author: ");
        String name = input.next();
        System.out.println("Input dept_name for Author: ");
        String genre = input.next();
        AuthorModel authorModel = new AuthorModel(name, genre);
        AuthorService authorService = new AuthorService();
        int count = authorService.update(authorModel);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectAuthor() throws SQLException {
        System.out.println("\nTable: Author");
        AuthorService authorService = new AuthorService();
        List<AuthorModel> authors = authorService.findAll();
        for (AuthorModel entity : authors) {
            System.out.println(entity);
        }
    }

    private void findAuthorByID() throws SQLException {
        System.out.println("Input ID(author_name) for Author: ");
        String id = input.nextLine();
        AuthorService authorService = new AuthorService();
        AuthorModel authorModel = authorService.findById(id);
        System.out.println(authorModel);
    }

    //Table Book------------------------------------------------------------------------

    private void deleteFromBook() throws SQLException {
        System.out.println("Input ID(book_title) for Book: ");
        String id = input.nextLine();
        input.nextLine();
        BookService employeeService = new BookService();
        int count = employeeService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForBook() throws SQLException {
        System.out.println("Input ID(book_title) for Book: ");
        String bookTitle = input.nextLine();
        input.nextLine();
        System.out.println("Input year for Book: ");
        Integer year = input.nextInt();
        System.out.println("Input pages for Book: ");
        Integer pages = input.nextInt();
        BookModel bookModel = new BookModel(bookTitle, year, pages);
        BookService bookService = new BookService();
        int count = bookService.create(bookModel);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateBook() throws SQLException {
        System.out.println("Input ID(book_title) for Book: ");
        String bookTitle = input.nextLine();
        input.nextLine();
        System.out.println("Input year for Book: ");
        Integer year = input.nextInt();
        System.out.println("Input pages for Book: ");
        Integer pages = input.nextInt();
        BookModel bookModel = new BookModel(bookTitle, year, pages);
        BookService bookService = new BookService();
        int count = bookService.update(bookModel);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectBook() throws SQLException {
        System.out.println("\nTable: Book");
        BookService bookService = new BookService();
        List<BookModel> bookModels = bookService.findAll();
        for (BookModel entity : bookModels) {
            System.out.println(entity);
        }
    }

    private void findBookByID() throws SQLException {
        System.out.println("Input ID(book_title) for Book: ");
        String book_title = input.nextLine();
        input.nextLine();
        BookService bookService = new BookService();
        BookModel bookModel = bookService.findById(book_title);
        System.out.println(bookModel);
    }
    //------------------------------------------------------------------------

    private void updateReader() throws SQLException {
        System.out.println("Input ID(reader_name) for Reader: ");
        String readerName = input.nextLine();
        System.out.println("Input  reader's address for Reader: ");
        String addressReader = input.nextLine();
        input.nextLine();
        ReaderModel readerModel = new ReaderModel(readerName, addressReader);
        ReaderService readerService = new ReaderService();
        int count = readerService.update(readerModel);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromReader() throws SQLException {
        System.out.println("Input ID(reader_name) for Reader: ");
        String reader_name = input.nextLine();
        ReaderService readerService = new ReaderService();
        int count = readerService.delete(reader_name);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForReader() throws SQLException {
        System.out.println("Input ID(reader_name) for Reader: ");
        String readerName = input.nextLine();
        System.out.println("Input reader's address for Reader: ");
        String addressReader = input.nextLine();
        input.nextLine();
        ReaderModel readerModel = new ReaderModel(readerName, addressReader);
        ReaderService readerService = new ReaderService();
        int count = readerService.create(readerModel);
        System.out.printf("There are created %d rows\n", count);
    }

    private void selectReader() throws SQLException {
        System.out.println("\nTable: Reader");
        ReaderService readerService = new ReaderService();
        List<ReaderModel> readerModels = readerService.findAll();
        for (ReaderModel entity : readerModels) {
            System.out.println(entity);
        }
    }

    private void findReaderByID() throws SQLException {
        System.out.println("Input ID(reader_name) for Reader: ");
        String reader_name = input.nextLine();
        ReaderService readerService = new ReaderService();
        ReaderModel readerModel = readerService.findById(reader_name);
        System.out.println(readerModel);
    }

    //-------------------------------------------------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
