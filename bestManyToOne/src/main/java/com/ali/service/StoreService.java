package com.ali.service;

import com.ali.domain.Author;
import com.ali.domain.Book;
import com.ali.repo.AuthorRepo;
import com.ali.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;

public class StoreService {


    private final AuthorRepo authorRepository;
    private final BookRepo bookRepository;

    @Autowired
    public StoreService(AuthorRepo authorRepository, BookRepo bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }




    @Transactional
    public void insertNewBook() {
        Author author = authorRepository.findById(4L).get();
        // or, less efficient since a SELECT is triggered
        // Author author = authorRepository.findByName("Joana Nimar");

        Book book = new Book();
        book.setPage(100+"");
        book.setTitle("Q");
        book.setAuthor(author);

        bookRepository.save(book);
    }

    public void fetchBooksOfAuthorById() {
        List<Book> books = bookRepository.fetchBooksOfAuthorById(4L);

        System.out.println(books);
    }

    public void fetchPageBooksOfAuthorById() {
        Page<Book> books = bookRepository.fetchPageBooksOfAuthorById(4L,
                PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "title")));

        books.get().forEach(System.out::println);
    }

    @Transactional
    public void fetchBooksOfAuthorByIdAndAddNewBook() {
        List<Book> books = bookRepository.fetchBooksOfAuthorById(4L);

        Book book = new Book();
        book.setTitle("Hoboot");
        book.setAuthor(books.get(0).getAuthor());

        books.add(bookRepository.save(book));

        System.out.println(books);
    }

    @Transactional
    public void fetchBooksOfAuthorByIdAndDeleteFirstBook() {
        List<Book> books = bookRepository.fetchBooksOfAuthorById(4L);

        bookRepository.delete(books.remove(0));

        System.out.println(books);
    }
}
