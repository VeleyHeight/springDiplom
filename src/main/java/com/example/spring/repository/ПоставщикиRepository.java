package com.example.spring.repository;

import com.example.spring.model.Поставщики;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
@Table(name = "Поставщики")
public interface ПоставщикиRepository extends JpaRepository<Поставщики,Integer> {
}
