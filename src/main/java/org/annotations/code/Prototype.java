package org.annotations.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("prototype")
public class Prototype {
        private InjectedBean injectedBean;
        
        @Autowired
        public Prototype(InjectedBean injectedBean) {
                this.injectedBean = injectedBean;
        }
        
        public void protMethod(){
                injectedBean.method();
        }
        
        public InjectedBean getInjectedBean() {
                return injectedBean;
        }
}