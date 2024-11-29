package com.example.bookzone.Controllers;

import com.example.bookzone.Entities.Book;
import com.example.bookzone.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<String> createBook(@RequestParam("title") String title,
                                             @RequestParam("author") String author,
                                             @RequestParam("cover") MultipartFile cover) {
        try {
            byte[] coverBytes = cover.getBytes();
            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setCover(coverBytes);
            bookRepository.save(book);

            return ResponseEntity.status(HttpStatus.CREATED).body("Livro Criado com Sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books); // Retorna a lista de livros
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }
    }

    @GetMapping("/cover/{id}")
    public ResponseEntity<byte[]> getBookCover(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            byte[] cover = book.getCover();

            return ResponseEntity.ok()
                    .header("Content-Type", "image/png") // Ajuste o tipo de conteúdo conforme necessário
                    .body(cover);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Livro deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }
    }


}
