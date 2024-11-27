package com.example.bookzone.Repositories;

import com.example.bookzone.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
