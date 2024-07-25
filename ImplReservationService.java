package com.nicmons.Reservations.services;

import com.nicmons.Reservations.dto.ReservationDTO;
import com.nicmons.Reservations.entities.Reservation;
import com.nicmons.Reservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ImplReservationService implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> updateReservation(ReservationDTO reservationDTO, String id) {
        Optional<Reservation> byId = reservationRepository.findById(id);
        if(byId.isPresent()){
            byId.get().setName(reservationDTO.getName());
            byId.get().setDateInit(reservationDTO.getDateInit());
            byId.get().setServiceUser(reservationDTO.getServiceUser());
            reservationRepository.save(byId.get());
        }
        return byId;
    }

    @Override
    public Optional<Reservation> queryById(String id) {
        Reservation byCodeReserve = reservationRepository.findByCodeReserve(id);
        return Optional.of(byCodeReserve);
    }
}
