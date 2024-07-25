package com.nicmons.Reservations.mapper;

import com.nicmons.Reservations.dto.ReservationDTO;
import com.nicmons.Reservations.entities.Reservation;
import org.mapstruct.Mapper;
@Mapper
public interface ReservationTransformer {

    Reservation reservationToDTO(ReservationDTO reservationDTO);
    ReservationDTO dtoToReservation(Reservation reservation);

}
