package com.example.crud.repository;

import com.example.crud.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
