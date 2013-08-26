package com.sharethis.bootstrap;

import com.sharethis.bootstrap.model.ModelObject;

public interface Backend {

	public static String QUALIFIER = "mock";

    public ModelObject addSugar(String string);
}
