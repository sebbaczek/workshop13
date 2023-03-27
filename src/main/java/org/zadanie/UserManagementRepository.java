package org.zadanie;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserManagementRepository {
        
        
        Optional<User> findByEmail(String email);
        
        List<User> findByName(String name);
        
        List<User> findAll();
        
         void create(User user);
         
         void update(String email, User user);
         void delete(String email);
}
