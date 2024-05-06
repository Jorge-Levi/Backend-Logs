package com.example.crud.service;

import com.example.crud.entity.Log;
import com.example.crud.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    // Obtener todos los logs
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    // Crear un nuevo log
    public Log createLog(Log log) {
        log.setTimestamp(Timestamp.from(Instant.now()));
        return logRepository.save(log);
    }

    // Obtener un log por su ID
    public Optional<Log> getLogById(Long id) {
        return logRepository.findById(id);
    }

    // Eliminar un log por su ID
    public boolean deleteLogById(Long id) {
        if (logRepository.existsById(id)) {
            logRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
