package com.example.bookzone.Controllers;

import com.example.bookzone.Entities.UserBook;
import com.example.bookzone.Repositories.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users-books")
public class UserBookController {
    @Autowired
    private UserBookRepository userBookRepository;

    // Busca todos os registros
    @GetMapping
    public List<UserBook> getAllUserBooks() {
        return userBookRepository.findAll();
    }

    // Cria um novo registro
    @PostMapping
    public UserBook createUserBook(@RequestBody UserBook userBook) {
        return userBookRepository.save(userBook);
    }

    // Exclui um registro por ID
    @DeleteMapping("/{id}")
    public void deleteUserBookById(@PathVariable Long id) {
        userBookRepository.deleteById(id);
    }

}
