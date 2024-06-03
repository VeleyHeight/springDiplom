package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Клиент\"")
@JsonIgnoreProperties({"field3.hibernateLazyInitializer", "field3.handler"})
public class Клиент {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Код клиента\"", nullable = false)
    private Integer id;

    @Column(name = "\"Адрес\"", length = 200)
    private String адрес;

    @Column(name = "\"Наименование\"", length = 100)
    private String наименование;

    @Column(name = "\"ИНН\"", length = 15)
    private String инн;

    @Column(name = "\"Основная организация\"", length = 100)
    private String Field;

    @Column(name = "\"КПП\"")
    private Integer кпп;

    @Column(name = "\"Регион\"", length = 50)
    private String регион;

    @Column(name = "\"Юр. / физ. лицо\"", length = 50)
    private String Field1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Код контактного лица\"")
    private КонтактноеЛицо Field3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Код пользователя\"")
    private Пользователь пользователь;

}