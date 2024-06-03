package com.example.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "\"Способ_доставки\"")
public class СпособДоставки {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Код_способа_доставки\"", nullable = false)
    private Integer id;

    @Column(name = "\"Название_способа\"", nullable = false, length = 50)
    private String названиеСпособа;

    @Column(name = "\"Удобное_время_получения_начало\"")
    private LocalTime удобноеВремяПолученияНачало;

    @Column(name = "\"Удобное_время_получения_конец\"")
    private LocalTime удобноеВремяПолученияКонец;

    @Column(name = "\"Адрес_доставки\"", nullable = false, length = 50)
    private String адресДоставки;

}