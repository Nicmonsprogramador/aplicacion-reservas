package com.nicmons.Reservations.services;

import com.nicmons.Reservations.dto.ReservationDTO;
import com.nicmons.Reservations.entities.Reservation;

import java.util.Optional;

public interface IReservationService {
    Reservation saveReservation(Reservation reservation);
    void deleteReservation(String id);
    Optional<Reservation> updateReservation(ReservationDTO reservationDTO, String id);

    Optional<Reservation> queryById(String id);

}
