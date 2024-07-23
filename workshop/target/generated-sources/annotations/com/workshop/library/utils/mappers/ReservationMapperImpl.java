package com.workshop.library.utils.mappers;

import com.workshop.library.api.dto.request.ReservationRequest;
import com.workshop.library.api.dto.response.ReservationResponse;
import com.workshop.library.api.dto.response.ReservationResponseFull;
import com.workshop.library.domain.entities.Book;
import com.workshop.library.domain.entities.Reservation;
import com.workshop.library.domain.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:17:31-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void updateFromReservationRequest(ReservationRequest request, Reservation reservation) {
        if ( request == null ) {
            return;
        }

        reservation.setStatus( request.getStatus() );
    }

    @Override
    public Reservation reservationRequestToReservation(ReservationRequest request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.user( reservationRequestToUser( request ) );
        reservation.book( reservationRequestToBook( request ) );
        reservation.status( request.getStatus() );

        return reservation.build();
    }

    @Override
    public ReservationResponse reservationToReservationResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse.ReservationResponseBuilder reservationResponse = ReservationResponse.builder();

        reservationResponse.book( bookMapper.BookToResponse( reservation.getBook() ) );
        reservationResponse.id( reservation.getId() );
        reservationResponse.reservationDate( reservation.getReservationDate() );
        reservationResponse.status( reservation.getStatus() );

        return reservationResponse.build();
    }

    @Override
    public ReservationResponseFull reservationToReservationResponseFull(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponseFull.ReservationResponseFullBuilder reservationResponseFull = ReservationResponseFull.builder();

        reservationResponseFull.book( bookMapper.BookToResponse( reservation.getBook() ) );
        reservationResponseFull.id( reservation.getId() );
        reservationResponseFull.reservationDate( reservation.getReservationDate() );
        reservationResponseFull.status( reservation.getStatus() );
        reservationResponseFull.user( userMapper.entityToResponse( reservation.getUser() ) );

        return reservationResponseFull.build();
    }

    protected User reservationRequestToUser(ReservationRequest reservationRequest) {
        if ( reservationRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( reservationRequest.getUserId() );

        return user;
    }

    protected Book reservationRequestToBook(ReservationRequest reservationRequest) {
        if ( reservationRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( reservationRequest.getBookId() );

        return book;
    }
}
