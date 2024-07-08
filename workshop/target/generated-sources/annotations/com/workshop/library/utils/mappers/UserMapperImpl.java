package com.workshop.library.utils.mappers;

import com.workshop.library.api.dto.request.UserRequest;
import com.workshop.library.api.dto.response.BookResponse;
import com.workshop.library.api.dto.response.LoanResponse;
import com.workshop.library.api.dto.response.ReservationResponse;
import com.workshop.library.api.dto.response.UserOnlyLoans;
import com.workshop.library.api.dto.response.UserOnlyReservations;
import com.workshop.library.api.dto.response.UserResponse;
import com.workshop.library.api.dto.response.UserResponseFull;
import com.workshop.library.domain.entities.Book;
import com.workshop.library.domain.entities.Loan;
import com.workshop.library.domain.entities.Reservation;
import com.workshop.library.domain.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T12:48:54-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse entityToResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.email( user.getEmail() );
        userResponse.fullName( user.getFullName() );
        userResponse.id( user.getId() );
        userResponse.role( user.getRole() );
        userResponse.userName( user.getUserName() );

        return userResponse.build();
    }

    @Override
    public UserResponseFull entityToResponseFull(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseFull.UserResponseFullBuilder userResponseFull = UserResponseFull.builder();

        userResponseFull.email( user.getEmail() );
        userResponseFull.fullName( user.getFullName() );
        userResponseFull.loans( loanListToLoanResponseList( user.getLoans() ) );
        userResponseFull.reservations( reservationListToReservationResponseList( user.getReservations() ) );
        userResponseFull.role( user.getRole() );
        userResponseFull.userName( user.getUserName() );

        return userResponseFull.build();
    }

    @Override
    public UserOnlyLoans entityToResponseLoans(User user) {
        if ( user == null ) {
            return null;
        }

        UserOnlyLoans.UserOnlyLoansBuilder userOnlyLoans = UserOnlyLoans.builder();

        userOnlyLoans.loans( loanListToLoanResponseList( user.getLoans() ) );

        return userOnlyLoans.build();
    }

    @Override
    public UserOnlyReservations entityToResponseReservations(User user) {
        if ( user == null ) {
            return null;
        }

        UserOnlyReservations.UserOnlyReservationsBuilder userOnlyReservations = UserOnlyReservations.builder();

        userOnlyReservations.reservations( reservationListToReservationResponseList( user.getReservations() ) );

        return userOnlyReservations.build();
    }

    @Override
    public User requestToEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( request.getEmail() );
        user.setFullName( request.getFullName() );
        user.setPassword( request.getPassword() );
        user.setRole( request.getRole() );
        user.setUserName( request.getUserName() );

        return user;
    }

    protected LoanResponse loanToLoanResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder loanResponse = LoanResponse.builder();

        loanResponse.id( loan.getId() );
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

    protected BookResponse bookToBookResponse(Book book) {
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

    protected ReservationResponse reservationToReservationResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse.ReservationResponseBuilder reservationResponse = ReservationResponse.builder();

        reservationResponse.book( bookToBookResponse( reservation.getBook() ) );
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
}
