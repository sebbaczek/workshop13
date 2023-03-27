package org.tests;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRegistryService {
        
        private final UserRepo userRepo;
        
        public void register(User user){
                if(!user.isValid()||userRepo.contains(user.getPhone())){
                        throw new RuntimeException("invalid user data");
                  }
                userRepo.put(user);
        }
        
        public Optional<User> find(String phone){
                if(phone.isEmpty()){
                        throw new RuntimeException("invalid phone number");
                }
        if (userRepo.contains(phone)){
                return Optional.ofNullable(userRepo.find(phone));
        }
        return Optional.empty();
        }
        
        
        }
        
        
        
        

