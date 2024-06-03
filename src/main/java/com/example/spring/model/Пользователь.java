package com.example.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "\"Пользователь\"")
public class Пользователь {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Код_пользователя\"", nullable = false)
    private Integer id;

    @Column(name = "\"Логин\"", nullable = false, length = 40)
    private String логин;

    @Column(name = "\"Пароль\"", nullable = false, length = 200)
    private String пароль;

    @ColumnDefault("'Пользователь'")
    @Column(name = "\"Название_роли\"", nullable = false, length = 50)
    private String названиеРоли;

}