package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.Log;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.LogRepository;
import edu.school21.cinema.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LogServiceImpl implements LogService {

    private LogRepository logRepository;

    @Override
    public void createNewLogForUser(User authenticatedUser, String remoteAddress) {
        Log newLog = Log.builder()
                .ip(remoteAddress)
                .userId(authenticatedUser.getId())
                .date(new Date())
                .build();
        logRepository.save(newLog);
    }

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }

    @Override
    public Optional<Log> getLog(Long id) {
        return logRepository.getById(id);
    }

    @Override
    public List<Log> getLogsListByUserId(Long id) {
        return logRepository.getListByField("user_id", id);
    }
}
