package com.ali.service;

import com.ali.LessMemory;
import com.ali.domain.Author;
import com.ali.domain.Book;
import com.ali.repo.AuthorRepo;
import com.ali.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    AuthorRepo repo;

    @Transactional
    public List<LessMemory> fetchAuthors() {

        List<LessMemory> dto = repo.fetchAll();
        dto.get(0).getAuthor().setName("Mohammad");

        return dto;
    }
}
