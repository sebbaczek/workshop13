package org.tests;

public class InjectedBeanServiceImpl implements InjectedBeanService{
        @Override
        public String sampleMethod(String some) {
                return "some"+some;
        }
        

}
