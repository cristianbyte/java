package com.workshop.library.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.library.api.dto.request.BookRequest;
import com.workshop.library.api.dto.response.BookOnlyReservations;
import com.workshop.library.api.dto.response.BookResponse;
import com.workshop.library.infrastructure.abstract_services.IBookService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
@Tag(name="Books")
public class BookController {

    @Autowired
    private final IBookService bookService;

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "" ) String author,
        @RequestParam(defaultValue = "" ) String title,
        @RequestParam(defaultValue = "" ) String genre) {

        return ResponseEntity.ok(this.bookService.getAll(page - 1, size, author, title , genre));
    }

    @GetMapping(path = "/{id}/reservations")
    public ResponseEntity<BookOnlyReservations> getOnlyReservations(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.bookService.getOnlyReservations(id));
    }

    @GetMapping(path = "/{book_id}")
    public ResponseEntity<BookResponse> get(@PathVariable(name = "book_id") Long id) {
        return ResponseEntity.ok(this.bookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(BookRequest bookRequest) {
        return ResponseEntity.ok(this.bookService.create(bookRequest));
    }

    @PutMapping(path = "/{book_id}")
    public ResponseEntity<BookResponse> update(@PathVariable(name = "book_id") Long id, BookRequest bookRequest) {
        return ResponseEntity.ok(this.bookService.update(id, bookRequest));
    }   

    @DeleteMapping(path = "/{book_id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "book_id") Long id) {
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
