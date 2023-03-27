package org.zadanie;

import lombok.*;
import org.springframework.stereotype.Component;


@Builder
@Value
@With
public class User implements Comparable<User> {
        private String name;
        private String surname;
        private String email;
        
        @Override
        public int compareTo(User o) {
                return o.email.compareTo(email);
        }
}
