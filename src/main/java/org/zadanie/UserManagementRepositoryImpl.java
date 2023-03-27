package org.zadanie;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository

public class UserManagementRepositoryImpl implements UserManagementRepository{
        private String email;
        private String name;
        private String surname;
//        User user = new User(name, surname, email);
        
        private final Map<String,User> repository = new HashMap<>();
        

        @Override
        public Optional<User> findByEmail(String email) {
      
                                return Optional.ofNullable(repository.get(email));
        
        }
        
        @Override
        public List<User> findByName(String name) {
                for (String key : repository.keySet()) {
                        List list = new ArrayList<>();
                        if(key.equals(name)){
                        list.add(repository.get(key));
                        }
                        return list;
                }
                return Collections.emptyList();
        }
        //2. metoda
//        public List<User> findByName(String name) {
//                return repository.values().stream()
//                               .filter(user->name.equals(user.getName()))
//                               .toList();
//        }

        
        
        
        
        @Override
        public List<User> findAll() {
                return new ArrayList<>( repository.values());
        }
        
        @Override
        public void create(User user) {
        repository.put(user.getEmail(), user);
        }
        
        @Override
        public void update(String email, User user) {
        repository.put(email,user);
        }
        
        @Override
        public void delete(String email) {
        repository.remove(email);
        }
}
