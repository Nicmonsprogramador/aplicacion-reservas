package com.nicmons.Reservations.mapper;

import com.nicmons.Reservations.dto.ReservationDTO;
import com.nicmons.Reservations.entities.Reservation;

import java.util.Optional;

public class ReservationMapper {

    public static ReservationDTO reservationToDTO(Reservation reservation){
        return ReservationDTO.builder()
                .id(reservation.getId())
                .codeReserve(reservation.getCodeReserve())
                .name(reservation.getName())
                .dateInit(reservation.getDateInit())
                .serviceUser(reservation.getServiceUser())
                .build();
    }

    public static Reservation dtoToReservation(ReservationDTO reservationDTO){
        return Reservation.builder()
                .codeReserve(reservationDTO.getCodeReserve())
                .name(reservationDTO.getName())
                .dateInit(reservationDTO.getDateInit())
                .serviceUser(reservationDTO.getServiceUser())
                .build();
    }

    public static ReservationDTO OptionalToReservationDTO(Optional<Reservation> reservation){
        return ReservationDTO.builder()
                .id(reservation.orElseThrow().getId())
                .codeReserve(reservation.orElseThrow().getCodeReserve())
                .name(reservation.orElseThrow().getName())
                .dateInit(reservation.orElseThrow().getDateInit())
                .serviceUser(reservation.orElseThrow().getServiceUser())
                .build();
    }

}
