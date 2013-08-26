package com.sharethis.bootstrap.mock;

import com.sharethis.bootstrap.Backend;
import com.sharethis.bootstrap.model.ModelObject;
import org.springframework.stereotype.Component;

@Component("mock")
public class MockBackend implements Backend {
    @Override
    public ModelObject addSugar(String string) {
        ModelObject object = new ModelObject();
        object.setOriginalString(string);
        object.setSugaredString(string + " with sugar!");
        return object;
    }
}
