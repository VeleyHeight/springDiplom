package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "\"Информация_о_товаре\"")
public class ИнформацияОТоваре {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Информация_о_товаре_id_gen")
    @SequenceGenerator(name = "Информация_о_товаре_id_gen", sequenceName = "Информация_о_то_Код_информации__seq", allocationSize = 1)
    @Column(name = "\"Код_информации_о_товаре\"", nullable = false)
    private Integer id;

    @Column(name = "\"Полное_наименование\"", nullable = false, length = 200)
    private String полноеНаименование;

    @Column(name = "\"Группа_товара\"", length = 50)
    private String группаТовара;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Код_поставщика\"", nullable = false)
    private Поставщики кодПоставщика;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Код_объема_продукции\"")
    private ОбъемПродукции кодОбъемаПродукции;

    @Column(name = "\"Типоразмер\"", nullable = false, length = 30)
    private String типоразмер;

    @Column(name = "\"Модель\"", length = 100)
    private String модель;

    @Column(name = "\"Цена_шины_с_НДС\"", nullable = false, precision = 10, scale = 2)
    private BigDecimal ценаШиныСНдс;

    @Column(name = "\"Сезонность\"", length = 30)
    private String сезонность;

}