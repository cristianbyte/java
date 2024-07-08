package com.workshop.library.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workshop.library.domain.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM books b WHERE (COALESCE(:author, '') = '' OR b.author LIKE %:author%)"+
                                    "AND (COALESCE(:title, '') = '' OR b.title LIKE %:title%)" +
                                    "AND (COALESCE(:genre, '') = '' OR b.genre LIKE %:genre%)" )
    Page<Book> findByCriteria(String author, String title, String genre, PageRequest pageable);
}