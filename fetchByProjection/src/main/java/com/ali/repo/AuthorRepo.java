package com.ali.repo;

import com.ali.LessMemory;
import com.ali.domain.Author;
import com.ali.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    @Query("SELECT a AS author, b.title AS title FROM Author a JOIN a.books b")
    List<LessMemory> fetchAll();

}