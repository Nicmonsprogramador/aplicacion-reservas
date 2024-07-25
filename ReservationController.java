package com.nicmons.Reservations.controllers;


import com.nicmons.Reservations.dto.ReservationDTO;
import com.nicmons.Reservations.entities.Reservation;
import com.nicmons.Reservations.mapper.ReservationMapper;
import com.nicmons.Reservations.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@CrossOrigin({"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private IReservationService iReservationService;

    @PostMapping("/save-reservation")
    public ResponseEntity<?> saveReservation(@RequestBody ReservationDTO reservationDTO){

        //convertimos de DTO a Clase concreta
        Reservation reservation = ReservationMapper.dtoToReservation(reservationDTO);

        //guardamos la reservación
        Reservation reservationSaved = this.iReservationService.saveReservation(reservation);

        //convertimos de clase concreta a DTO
        ReservationDTO reservationDTOFront = ReservationMapper.reservationToDTO(reservationSaved);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationDTOFront);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        Optional<Reservation> reservation = iReservationService.queryById(id);
        return ResponseEntity.ok(ReservationMapper.OptionalToReservationDTO(reservation));
    }

    @PutMapping("/update-reservation/{id}")
    public ResponseEntity<?> updateReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable("id") String id){
        Optional<Reservation> reservation = iReservationService.updateReservation(reservationDTO,id);
        return ResponseEntity.ok(ReservationMapper.OptionalToReservationDTO(reservation));
    }

    @DeleteMapping("/delete-reservation/{id}")
    public void deleteReservation(@PathVariable("id") String id){
        iReservationService.deleteReservation(id);
    }
}
