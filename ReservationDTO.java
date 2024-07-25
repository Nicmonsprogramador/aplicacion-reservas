package com.nicmons.Reservations.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationDTO {
    private String id;
    private String codeReserve;
    private String name;
    private String dateInit;
    private String serviceUser;
}
