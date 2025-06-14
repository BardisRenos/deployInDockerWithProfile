package com.example.demo.application.resource;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
    @SequenceGenerator(
            name = "address_seq_gen",
            sequenceName = "address_seq",
            allocationSize = 1
    )
    private Long id;

    private String street;
    private String city;
}