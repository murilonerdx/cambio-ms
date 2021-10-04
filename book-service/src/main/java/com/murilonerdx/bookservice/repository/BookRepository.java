package com.murilonerdx.bookservice.repository;

import com.murilonerdx.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
