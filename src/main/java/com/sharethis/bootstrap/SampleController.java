package com.sharethis.bootstrap;

import com.sharethis.bootstrap.model.ModelObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class SampleController {

	@Autowired
    @Qualifier(value = Backend.QUALIFIER)
	private Backend backend;

	@RequestMapping(value = "/sample", method = RequestMethod.POST)
	public @ResponseBody
    ModelObject addSugar( @RequestParam String value) {
		return backend.addSugar(value);
	}
}