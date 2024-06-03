package com.example.spring.repository;

import com.example.spring.model.Заказ;
import com.example.spring.model.Клиент;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "Заказ")
public interface ЗаказRepository extends JpaRepository<Заказ,Integer> {
}
//    void deleteById(String id_obem);
//    Obem_product findByIdObem(String id_obem);

