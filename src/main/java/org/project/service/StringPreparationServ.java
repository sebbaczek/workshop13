package org.project.service;

import org.project.domain.User;
import org.springframework.stereotype.Service;

@Service
public class StringPreparationServ {
        public String prepare(final User user){
                return String.format("%s;%s",user.getBirthDate(),user.getEmail());
        }
}
