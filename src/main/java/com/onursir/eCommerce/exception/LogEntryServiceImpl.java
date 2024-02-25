package com.onursir.eCommerce.exception;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogEntryServiceImpl implements LogEntryService {

    private final LogEntryRepository logEntryRepository;

    @Override
    public void saveLogEntry(LogEntry logEntry) {

        logEntryRepository.save(logEntry);
    }
}

