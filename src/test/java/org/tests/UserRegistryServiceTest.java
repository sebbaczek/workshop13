package org.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
//testy BDD - przypadki definiowane słownie

@ExtendWith(MockitoExtension.class)
class UserRegistryServiceTest {
        @InjectMocks
        private UserRegistryService userRegistryService;
        
        @Mock
        //zachowanie repozytorium jest mockowane
        private UserRepo userRepo;
        
        @Test
        @DisplayName("Adding users works correctly")
        void test1(){
        final var user = User.builder()
                                 .name("Tom")
                                 .surname("Tomski")
                                 .phone("333022")
                                 .build();
        
                // metoda contains z klasy UsersRepo
                //sprawdzenie fragmentu kodu userRepo.contains(user.getPhone()) zwracająca false
        BDDMockito.given((userRepo.contains(user.getPhone()))).willReturn(false);
        
        //when
        //czy jak rejestrujemy usera, to będzie prawidłowo zarejestrowany
                userRegistryService.register(user);
                
                //czy user został dodany do repo
                // metoda put z klasy UsersRepo
        BDDMockito.then(userRepo)
                .should()
                .put(user);
                
                
                
        }
        
                @Test
        @DisplayName("Adding users with the same phone twice fails")
        void test2(){
    final var user = User.builder()
                                                 .name("Tom2")
                                                 .surname("Tomski")
                                                 .phone("33543022")
                                                 .build();
    
    //sprawdzenie fragmentu kodu userRepo.contains(user.getPhone()) zwracająca true
    BDDMockito.given(userRepo.contains(user.getPhone())).willReturn(true);
        
                        //when
    //jeżeli zwróci true to nam wyrzuci wyjątek z userRepo
    try {
            //tutaj powinien zostać wyjątek rzucony:
            userRegistryService.register(user);
            
            //ta linijka powinna się nie wykonać
            Assertions.fail("exception");
    } catch (RuntimeException ignore){}
        
                        //then
//                        sprawdzamy czy metoda put nie zostanie wykonana
    BDDMockito.then(userRepo)
            .should(Mockito.never())
            .put(user);
                
                
                
                
                
                
        }
        
                @Test
        @DisplayName("Adding users with too long phone number fails")
        void test3(){
                        final var user = User.builder()
                                                 .name("Tom2")
                                                 .surname("Tomski")
                                                 .phone("33543022")
                                                 .build();
        
        BDDMockito.given(userRepo.contains(user.getPhone())).willReturn(false);
    
     //jeśli wywołamy metodę put z takim userem to zaślepka powinna rzucić taki wyjątek
     BDDMockito.willThrow(new RuntimeException("too long phone number"))
             .given(userRepo)
             .put(user);
     
                        //when
                        try {
                                //tutaj powinien zostać wyjątek rzucony:
                                userRegistryService.register(user);
                
                                //ta linijka powinna się nie wykonać, a jak się wykona to przerywamy test
                                Assertions.fail("exception");
                                //nie robimy nic z wyjątkiem
                        } catch (RuntimeException ignore){}
        
                        //then
//                        sprawdzamy czy metoda put zostanie wykonana
                        BDDMockito.then(userRepo)
                                .should()
                                .put(user);
                
                
                
                
                
        }
        
        
        
        
        
        
        
        
        
}