package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
     public static void main(String[] args) {
        /*
        EBook eBook = new EBook("Harry Potter");
        eBook.writeCurrentPage("This story is about a young wizard..");
        Book printedBook = eBook.print();
        eBook.addPage();
        System.out.println(eBook.getCurrentPage());
        eBook.openToPage(-10);
        System.out.println(eBook.getCurrentPage());
        //assertEquals("This story is about a young wizard..", printedBook.readCurrentPage());
        EBookReader eBookReader = new EBookReader();
        eBookReader.openEbook(printedBook.scan());
        //assertEquals("This story is about a young wizard..", eBookReader.readCurrentPage());
    */
        List<String> pages = new ArrayList<>();
        pages.add("C'est l'Histoire");
        pages.add("dufpeak");
        pages.add("OOOKAIS");

        Book book = new Book("Harry Potter", pages);
        EBook eBook = book.scan();
        EBookReader eBookReader = new EBookReader();
        eBook.openToPage(0);
        eBookReader.openEbook(eBook);
        System.out.println(eBookReader.readCurrentPage());

    }

}
