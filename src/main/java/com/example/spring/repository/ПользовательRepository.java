package com.example.spring.repository;

import com.example.spring.model.Пользователь;
import com.example.spring.model.Поставщики;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Table(name = "Пользователь")
public interface ПользовательRepository extends JpaRepository<Пользователь,Integer> {
    boolean existsByЛогин(String логин);
    Optional<Пользователь> findByЛогин(String логин);
}
