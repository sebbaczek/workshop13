package org.zadanie;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManagementService {
        
        private final UserManagementRepository userManagementRepository;
        public void create(User user){
                if(userManagementRepository.findByEmail(user.getEmail()).isPresent()){
                        throw new RuntimeException("User with email: %s is already created".formatted(user.getEmail()));
                }
        userManagementRepository.create(user);
        };

        public Optional<User> findByEmail(String email){
        
        return userManagementRepository.findByEmail(email);
        };
        
        public List<User> findByName(String name){
                return userManagementRepository.findByName(name);
        };
        
        public List<User> findAll(){
        return userManagementRepository.findAll();
        };
        

       public void update(String email, User userWithEmail ){
               if(userManagementRepository.findByEmail(email).isEmpty()){
                       throw new RuntimeException("User with email: [%s] doesn't exist".formatted(email));
               }
       userManagementRepository.update(email,userWithEmail);
       };
        
        public void delete(String email ){
                if(userManagementRepository.findByEmail(email).isEmpty()){
                        throw new RuntimeException("User with email: [%s] doesn't exist".formatted(email));
                }
       userManagementRepository.delete(email);
        };
}
