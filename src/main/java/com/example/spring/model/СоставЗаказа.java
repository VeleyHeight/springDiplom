package com.example.spring.model;

import com.example.spring.model.ИнформацияОТоваре;
import com.example.spring.model.Заказ;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "\"Состав_заказа\"")
public class СоставЗаказа {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Код_состава_заказа\"", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Код_информации_о_товаре\"")
    private ИнформацияОТоваре кодИнформацииОТоваре;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Код_заказа\"")
    private Заказ кодЗаказа;

    @ColumnDefault("1")
    @Column(name = "\"Количество\"")
    private Integer количество;

}