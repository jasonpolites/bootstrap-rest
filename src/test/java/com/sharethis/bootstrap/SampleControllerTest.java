package com.sharethis.bootstrap;

import com.sharethis.bootstrap.model.ModelObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class})
public class SampleControllerTest {

    private MockMvc mockMvc;

	@InjectMocks
	private SampleController sampleController;

    @Mock
	private Backend backend;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(sampleController).build();
	}

    @Test
    public void testMobileEndpoint() throws Exception {

	    String id = "foobar";

        ModelObject data = new ModelObject();

        data.setOriginalString("foo");
        data.setSugaredString("bar");

        Mockito.when(backend.addSugar(id)).thenReturn(data);

	    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/sample");

	    builder.param("value", id);

	    mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
			    .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.originalString").value("foo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sugaredString").value("bar"));

	    Mockito.verify(backend, Mockito.times(1)).addSugar(id);
    }
}
