package com.example.spring.model;

import com.example.spring.model.Клиент;
import com.example.spring.model.СпособДоставки;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Заказ\"")
public class Заказ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Код заказа\"", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Код клиента\"", nullable = false)
    private Клиент Field;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Код способа доставки\"", nullable = false)
    private СпособДоставки Field1;

    @Column(name = "\"Статус_оплаты\"", nullable = false, length = 50)
    private String статусОплаты;

}