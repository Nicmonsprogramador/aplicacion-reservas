package com.nicmons.Reservations.repositories;

import com.nicmons.Reservations.entities.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation,String> {

    Reservation findByCodeReserve(String codeReserve);
}
