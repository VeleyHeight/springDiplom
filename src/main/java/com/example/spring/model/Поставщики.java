package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"Поставщики\"")
public class Поставщики {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Код_поставщика\"", nullable = false)
    private Integer id;

    @Column(name = "\"Наименование\"", nullable = false, length = 100)
    private String наименование;

    @Column(name = "\"ИНН\"", nullable = false, length = 15)
    private String инн;

    @Column(name = "\"Основная_организация\"", nullable = false, length = 100)
    private String основнаяОрганизация;

    @Column(name = "\"КПП\"")
    private Integer кпп;

    @Column(name = "\"Юр_физ_лицо\"", nullable = false, length = 50)
    private String юрФизЛицо;

    @Column(name = "\"Адрес\"", length = 200)
    private String адрес;
    @JsonManagedReference
    @OneToMany(mappedBy = "кодПоставщика")
    private Set<ИнформацияОТоваре> информацияОТовареs = new LinkedHashSet<>();

}