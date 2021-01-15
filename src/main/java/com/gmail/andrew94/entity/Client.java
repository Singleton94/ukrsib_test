package com.gmail.andrew94.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Andrew Samoilov
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
//@Entity
//@Table(name = "client")
public class Client {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "inn")
    private int inn;

//    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
//    private List<Transaction> transactions;


}
