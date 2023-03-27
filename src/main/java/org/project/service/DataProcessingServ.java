package org.project.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.domain.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class DataProcessingServ {
        private final StringPreparationServ stringPreparationServ;
        
        public List<String> process(final List<User> users){
        return users.stream()
                       .sorted(Comparator.comparing(User::getBirthDate))
                       .map(user->stringPreparationServ.prepare(user))
                       .peek(line->log.info("[{}]",line))
                       .toList();
        }
}
