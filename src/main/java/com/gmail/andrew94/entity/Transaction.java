package com.gmail.andrew94.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Andrew Samoilov
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactional")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "place")
    private String place;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "card")
    private String card;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "client_id")
    @Embedded
    private Client client;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && Objects.equals(place, that.place) && Objects.equals(currency, that.currency) && Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, amount, currency, card);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
