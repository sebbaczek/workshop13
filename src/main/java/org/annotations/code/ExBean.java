package org.annotations.code;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExBean {
        
        private InjectedBean injectedBean;
        private AnotherInjectedBean anotherInjectedBean;
        
        public ExBean() {
                System.out.println("ExBean noautowired");
        }
        
        @Autowired  //oznaczenie konstruktora lub settera lub pola który ma być wstrzyknięty, można dodać kilka
        // Autowired;
        // Autowired wiąże też ten bean z innymi beanami
        public ExBean(InjectedBean injectedBean, AnotherInjectedBean anotherInjectedBean) {
                this.injectedBean = injectedBean;
                this.anotherInjectedBean = anotherInjectedBean;
                System.out.println("ExBean autowired");
        }
}
