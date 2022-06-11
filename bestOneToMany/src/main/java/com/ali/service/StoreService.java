package com.ali.service;
import com.ali.domain.Author;
import com.ali.domain.Book;
import com.ali.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {



    @Service
    public class BookstoreService {

        private final AuthorRepo authorRepository;

        @Autowired
        public BookstoreService(AuthorRepo authorRepository) {
            this.authorRepository = authorRepository;
        }


        public void insertAuthorWithBooks() {

            Author author = new Author();
            author.setName("Amir");

            Book book = new Book();
            book.setPage("100p");
            book.setTitle("bar bad rafte");

            author.addBook(book);

            authorRepository.save(author);
        }

        @Transactional
        public void deleteBookOfAuthor() {

            Author author = authorRepository.fetchByTitle("bar bad rafte");
            Book book = author.getBooks().get(0);

            author.removeBook(book);
        }

        @Transactional
        public void deleteAllBooksOfAuthor() {
            Author author = authorRepository.findById(1L).get();
            author.removeBooks();
        }

    }
}
