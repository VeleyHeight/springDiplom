package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"Объем_продукции\"")
public class ОбъемПродукции {

    @Id
    @Column(name = "\"Код_объема\"", nullable = false, length = 15)
    private String кодОбъема;

    @Column(name = "\"Вес\"", precision = 10, scale = 2)
    private BigDecimal вес;

    @Column(name = "\"Объем\"", precision = 10, scale = 2)
    private BigDecimal объем;
    @JsonManagedReference
    @OneToMany(mappedBy = "кодОбъемаПродукции")
    private Set<ИнформацияОТоваре> информацияОТовареs = new LinkedHashSet<>();

}