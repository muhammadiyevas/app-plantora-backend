package com.example.appplantorabackend.entity;

import com.example.appplantorabackend.enums.Language;
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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    String username;
    @Column(unique = true)
    String email;

    String phoneNumber;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String help;

    @OneToOne
    Attachment photo;

    Language language;


    @ManyToOne
    Order orderid;

}
