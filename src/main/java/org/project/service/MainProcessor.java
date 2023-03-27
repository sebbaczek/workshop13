package org.project.service;

import lombok.AllArgsConstructor;
import org.project.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MainProcessor {
        private final DataRep dataRep;
        private final DataProcessingServ dataProcessingServ;
        
        public void calc(){
                List<User> users = dataRep.readUsers();
                List<String > processed = dataProcessingServ.process(users);
                dataRep.save(processed);
        }
        
        
        
        
        
}
