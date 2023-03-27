package org.tests;

public class ExParamsCoreImpl implements ExParamsCore{
        private ParamsService paramsService;
        @Override
        public void setParams(ParamsService paramsService) {
                this.paramsService = paramsService;
        }
        
        @Override
        public String executeParamsMethod() {
                return paramsService.method1()+" "+paramsService.method2();
        }
}
