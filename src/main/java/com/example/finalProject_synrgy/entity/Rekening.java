package com.example.finalProject_synrgy.entity;

import com.example.finalProject_synrgy.entity.base.BaseDate;
import com.example.finalProject_synrgy.entity.oauth2.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "rekening")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rekening extends BaseDate {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @JsonIgnore
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "jenis_rekening")
    private String jenisRekening;

    @Column(name = "rekening_active_date")
    private String rekeningActiveDate;

    @Column(name = "rekening_expired_date")
    private String rekeningExpiredDate;

    @JsonIgnore
    private String pin;

    @JsonIgnore
    private String balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
