package com.example.crud.controller;

import com.example.crud.entity.Log;
import com.example.crud.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogRepository logRepository;

    // Obtener todos los logs
    @GetMapping
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    // Crear un nuevo log
    @PostMapping
    public ResponseEntity<Log> createLog(@RequestBody Log log) {
        // Asegurarnos de que el timestamp sea el momento actual
        log.setTimestamp(Timestamp.from(Instant.now()));
        Log savedLog = logRepository.save(log);
        return ResponseEntity.ok(savedLog);
    }

    // Obtener un log por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Log> getLogById(@PathVariable Long id) {
        return logRepository.findById(id)
                .map(log -> ResponseEntity.ok(log))
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un log por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogById(@PathVariable Long id) {
        if (logRepository.existsById(id)) {
            logRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
