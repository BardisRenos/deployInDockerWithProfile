package com.example.demo.application.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientOrder {
    @Id
    @GeneratedValue
    private Long id;

    private String product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
}