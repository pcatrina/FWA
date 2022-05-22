package edu.school21.cinema.services;

import edu.school21.cinema.models.Log;
import edu.school21.cinema.models.User;

import java.util.List;
import java.util.Optional;

public interface LogService {

    void saveLog(Log log);

    Optional<Log> getLog(Long id);

    List<Log> getLogsListByUserId(Long id);

    void createNewLogForUser(User authenticatedUser, String remoteAddress);
}
