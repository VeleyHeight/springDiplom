package com.example.spring.repository;

import com.example.spring.model.Заказ;
import com.example.spring.model.СпособДоставки;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "Способ_доставки")
public interface СпособДоставкиRepository extends JpaRepository<СпособДоставки,Integer> {
}
//    void deleteById(String id_obem);
//    Obem_product findByIdObem(String id_obem);

