package com.nicmons.Reservations.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "reservations")
public class Reservation {

    @Id
    private String id;
    private String codeReserve;
    private String name;
    private String dateInit;
    private String serviceUser;

}
