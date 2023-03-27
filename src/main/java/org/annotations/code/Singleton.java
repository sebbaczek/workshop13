package org.annotations.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Singleton {
        private InjectedBean injectedBean;
        
        @Autowired
        public Singleton(InjectedBean injectedBean) {
                this.injectedBean = injectedBean;
        }
        
        public  void singMethod(){
                injectedBean.method();
        }
        
        public InjectedBean getInjectedBean() {
                return injectedBean;
        }
}
