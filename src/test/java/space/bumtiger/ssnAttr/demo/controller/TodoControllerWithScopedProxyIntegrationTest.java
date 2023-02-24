package space.bumtiger.ssnAttr.demo.controller;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.StringUtils;

import space.bumtiger.ssnAttr.demo.config.TestConfig;
import space.bumtiger.ssnAttr.demo.domain.TodoItem;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(TestConfig.class)
class TodoControllerWithScopedProxyIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	// @formatter:off
	@Test
  public void whenFirstRequest_thenContainsUnintializedTodo() 
  			throws Exception {
    MvcResult result = mockMvc.perform(get("/scopedproxy/form"))
      .andExpect(status().isOk())
      .andExpect(model().attributeExists("todo"))
      .andReturn();

    TodoItem item = (TodoItem) 
    		result.getModelAndView().getModel().get("todo");
    // @formatter:on

		assertFalse(StringUtils.hasLength(item.getDescription()));
	}

}
