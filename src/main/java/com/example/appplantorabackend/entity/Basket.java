package com.example.appplantorabackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "backet")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    int counter;

    boolean status;


    @ManyToOne
    Product productId;
}
