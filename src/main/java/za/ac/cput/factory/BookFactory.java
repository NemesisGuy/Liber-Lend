package za.ac.cput.factory;
/**
 * BookFactory.java
 * Class for the BookFactory
 * Author: Peter Buckingham (220165289)
 * Date: 17 March 2021
 */





import org.springframework.stereotype.Component;
import za.ac.cput.domain.impl.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookFactory{

    public Book createBook(int id, String title, String author, String publisher, String ISBN, String imageLink, String description, String genre, String language, int edition)
 {

        return Book.builder()
                .id(1)
                .title("Harry Potter")
                .author("J.K. Rowling")
                .publisher("Bloomsbury Publishing")
                .ISBN("978-0-7475-3269-6")
                .imageLink("https://images-na.ssl-images-amazon.com/images/I/51UoqRAxwEL._SX331_BO1,204,203,200_.jpg")
                .description("Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry.")
                .genre("Fantasy")
                .language("English")
                .edition(1)
                .build();
    }


}