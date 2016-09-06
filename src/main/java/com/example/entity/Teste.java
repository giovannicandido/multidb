package com.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Giovanni Silva
 */
@Entity
public class Teste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime date;

    @PrePersist
    public void curentDate(){
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Teste{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
