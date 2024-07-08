package com.workshop.library.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.workshop.library.api.dto.request.ReservationRequest;
import com.workshop.library.api.dto.response.ReservationResponse;
import com.workshop.library.api.dto.response.ReservationResponseFull;
import com.workshop.library.domain.entities.Reservation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {UserMapper.class, BookMapper.class})
public interface ReservationMapper {

    @Mapping(target = "id", ignore = true)
    void updateFromReservationRequest(ReservationRequest request, @MappingTarget Reservation reservation);

    @Mapping(target = "user.id" , source = "userId")
    @Mapping(target = "book.id" , source = "bookId")
    Reservation reservationRequestToReservation(ReservationRequest request);
    
    ReservationResponse reservationToReservationResponse(Reservation reservation);
    
    ReservationResponseFull reservationToReservationResponseFull(Reservation reservation);
}
