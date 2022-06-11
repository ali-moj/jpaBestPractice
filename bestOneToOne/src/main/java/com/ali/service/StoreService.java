package com.ali.service;

import com.ali.domain.Author;
import com.ali.domain.Book;
import com.ali.repo.AuthorRepo;
import com.ali.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StoreService {

    private final AuthorRepo authorRepository;
    private final BookRepo bookRepository;

    @Autowired
    public StoreService(AuthorRepo authorRepository, BookRepo bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Transactional
    public void newBookOfAuthor() {

        Author author = authorRepository.findById(1L).orElseThrow();

        Book book = new Book();
        book.setTitle("Persian Golf");
        book.setPage("111page");

        book.setAuthor(author);

        bookRepository.save(book);
    }

   // @Transactional(readOnly = true)
    public Book getBookByAuthorId() {

        Author author = authorRepository.findById(1L).orElseThrow();

        return bookRepository.findById(author.getId()).orElseThrow();
    }
}
