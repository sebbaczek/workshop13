package org.tests;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleSpyImpl implements ExampleSpy{
        private List<String> sampleList = new ArrayList<>();
        
        @Override
        public void sampleMethod(String... values) {
                for (String value : values) {
                       sampleList.add(value);
                }
        }
}
