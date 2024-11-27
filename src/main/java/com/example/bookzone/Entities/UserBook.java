package com.example.bookzone.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userBookId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = true)
    private Integer rating;

    @Lob
    private String comment;

    public enum Status {
        PARA_LER, LENDO, LIDO
    }
}

