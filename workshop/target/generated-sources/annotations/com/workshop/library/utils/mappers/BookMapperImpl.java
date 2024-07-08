package com.workshop.library.utils.mappers;

import com.workshop.library.api.dto.request.BookRequest;
import com.workshop.library.api.dto.response.BookOnlyReservations;
import com.workshop.library.api.dto.response.BookResponse;
import com.workshop.library.api.dto.response.BookResponseFull;
import com.workshop.library.api.dto.response.LoanResponse;
import com.workshop.library.api.dto.response.ReservationResponse;
import com.workshop.library.domain.entities.Book;
import com.workshop.library.domain.entities.Loan;
import com.workshop.library.domain.entities.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T11:00:47-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book RequestToBook(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( bookRequest.getAuthor() );
        book.setGenre( bookRequest.getGenre() );
        book.setId( bookRequest.getId() );
        book.setIsbn( bookRequest.getIsbn() );
        book.setPublicationYear( bookRequest.getPublicationYear() );
        book.setTitle( bookRequest.getTitle() );

        return book;
    }

    @Override
    public BookResponse BookToResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        bookResponse.author( book.getAuthor() );
        bookResponse.genre( book.getGenre() );
        bookResponse.isbn( book.getIsbn() );
        bookResponse.publicationYear( book.getPublicationYear() );
        bookResponse.title( book.getTitle() );

        return bookResponse.build();
    }

    @Override
    public BookOnlyReservations bookToOnlyReservations(Book book) {
        if ( book == null ) {
            return null;
        }

        BookOnlyReservations.BookOnlyReservationsBuilder bookOnlyReservations = BookOnlyReservations.builder();

        bookOnlyReservations.reservations( reservationListToReservationResponseList( book.getReservations() ) );

        return bookOnlyReservations.build();
    }

    @Override
    public BookResponseFull BookToResponseFull(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponseFull.BookResponseFullBuilder bookResponseFull = BookResponseFull.builder();

        bookResponseFull.author( book.getAuthor() );
        bookResponseFull.genre( book.getGenre() );
        bookResponseFull.isbn( book.getIsbn() );
        bookResponseFull.loans( loanListToLoanResponseList( book.getLoans() ) );
        bookResponseFull.publicationYear( book.getPublicationYear() );
        bookResponseFull.reservations( reservationListToReservationResponseList( book.getReservations() ) );
        bookResponseFull.title( book.getTitle() );

        return bookResponseFull.build();
    }

    protected ReservationResponse reservationToReservationResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse.ReservationResponseBuilder reservationResponse = ReservationResponse.builder();

        reservationResponse.book( BookToResponse( reservation.getBook() ) );
        reservationResponse.id( reservation.getId() );
        reservationResponse.reservationDate( reservation.getReservationDate() );
        reservationResponse.status( reservation.getStatus() );

        return reservationResponse.build();
    }

    protected List<ReservationResponse> reservationListToReservationResponseList(List<Reservation> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservationResponse> list1 = new ArrayList<ReservationResponse>( list.size() );
        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationResponse( reservation ) );
        }

        return list1;
    }

    protected LoanResponse loanToLoanResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder loanResponse = LoanResponse.builder();

        loanResponse.loanDate( loan.getLoanDate() );
        loanResponse.returnDate( loan.getReturnDate() );
        loanResponse.status( loan.getStatus() );

        return loanResponse.build();
    }

    protected List<LoanResponse> loanListToLoanResponseList(List<Loan> list) {
        if ( list == null ) {
            return null;
        }

        List<LoanResponse> list1 = new ArrayList<LoanResponse>( list.size() );
        for ( Loan loan : list ) {
            list1.add( loanToLoanResponse( loan ) );
        }

        return list1;
    }
}
