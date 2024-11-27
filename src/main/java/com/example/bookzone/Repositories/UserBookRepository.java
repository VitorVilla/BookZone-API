package com.example.bookzone.Repositories;

import com.example.bookzone.Entities.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    List<UserBook> findByUserIdAndBookId(Long userId, Long bookId);

}
