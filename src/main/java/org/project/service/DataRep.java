package org.project.service;

import lombok.extern.slf4j.Slf4j;
import org.project.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class DataRep {
        public List<User> readUsers() {
                try {
                        return Files.readAllLines(ResourceUtils.getFile("classpath:users.csv").toPath()).stream()
                                       .map(line -> mapUser(line))
                                       .filter(user -> user.isPresent())
                                       .map(user -> user.get())
                                       .toList();
                } catch (IOException e) {
                        log.error("some loading error" + e.getMessage());
                        return List.of();
                }
        
        }
        
        private Optional<User> mapUser(String line) {
                if (!line.contains("@")) {
                        return Optional.empty();
                } else {
                        List<String> lineAsList = Arrays.asList(line.split(";"));
                        return Optional.of(User.builder()
                                                   .email(lineAsList.get(0))
                                                   .name(lineAsList.get(1))
                                                   .publicName(lineAsList.get(2))
                                                   .birthDate(LocalDate.parse(lineAsList.get(3)))
                                                   .build());
                }
        }
        
        public void save(final List<String> processed) {
                try {
                
                        Files.write(Paths.get("build/result.txt"), processed);
                } catch (IOException e) {
                        log.error("some saving error" + e.getMessage());
                }
        }
}