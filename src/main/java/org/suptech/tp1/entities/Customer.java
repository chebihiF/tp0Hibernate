package org.suptech.tp1.entities;

import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "Client")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom", length = 100, unique = true)
    private String name ;
    private String email ;
}
