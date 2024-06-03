package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Контактное_лицо\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class КонтактноеЛицо {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Код_контактного_лица\"", nullable = false)
    private Integer id;

    @Column(name = "\"Фамилия\"", nullable = false, length = 50)
    private String фамилия;

    @Column(name = "\"Имя\"", nullable = false, length = 50)
    private String имя;

    @Column(name = "\"Отчество\"", length = 50)
    private String отчество;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "\"Телефон\"", nullable = false, length = 11)
    private String телефон;

}