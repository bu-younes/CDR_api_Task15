package com.mohammedAlghafri.CDR.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String username;

    String password;

    String email;

}
