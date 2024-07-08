package com.workshop.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.library.api.dto.request.ReservationRequest;
import com.workshop.library.api.dto.response.ReservationResponseFull;
import com.workshop.library.domain.entities.Reservation;
import com.workshop.library.domain.repositories.ReservationRepository;
import com.workshop.library.infrastructure.abstract_services.IReservationService;
import com.workshop.library.utils.enums.exceptions.BadRequestException;
import com.workshop.library.utils.enums.message.ErrorMessage;
import com.workshop.library.utils.mappers.ReservationMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationResponseFull getById(Long id) {
        return reservationMapper.reservationToReservationResponseFull(this.find(id));
    }

    @Override
    public ReservationResponseFull create(ReservationRequest request) {
        Reservation reservationToSave = reservationMapper.reservationRequestToReservation(request);
        return reservationMapper.reservationToReservationResponseFull(this.reservationRepository.save(reservationToSave));
    }

    @Override
    public ReservationResponseFull update(Long id, ReservationRequest request) {
        Reservation reservationToUpdate = this.find(id);
        reservationMapper.updateFromReservationRequest(request, reservationToUpdate);
        return reservationMapper.reservationToReservationResponseFull(this.reservationRepository.save(reservationToUpdate));
    }

    @Override
    public void delete(Long id) {
        this.find(id);
        this.reservationRepository.deleteById(id);
    }

    private Reservation find(Long id){
        return this.reservationRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("reservation")));
    }
    
    
}
