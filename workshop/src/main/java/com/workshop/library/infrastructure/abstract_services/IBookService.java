package com.workshop.library.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.workshop.library.api.dto.request.BookRequest;
import com.workshop.library.api.dto.response.BookOnlyReservations;
import com.workshop.library.api.dto.response.BookResponse;

public interface IBookService extends CrudAbstractService<BookRequest, BookResponse, Long> {

    public Page<BookResponse> getAll(int page, int size, String author, String title, String genre);

    public BookOnlyReservations getOnlyReservations(Long id);
}
