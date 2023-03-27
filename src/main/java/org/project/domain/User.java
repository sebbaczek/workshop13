package org.project.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class User {
        String email;
        String name;
        String publicName;
        LocalDate birthDate;
}
