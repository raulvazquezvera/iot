package com.iot.wi.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iot.wi.model.AddDeviceDto;
import com.iot.wi.service.WIService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class AddDeviceApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private WIService wiService;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void addDevicePostTest_ok() {
		try {
			when(wiService.addDevice(any(AddDeviceDto.class))).thenReturn(true);

			AddDeviceDto dto = new AddDeviceDto();
			dto.setPinCode("9876543");
			dto.setSerialNumber(1234);

			this.mockMvc.perform(post("/addDevice").contentType(contentType).content(ApiUtil.mapperToJson(dto)))
					.andDo(print()).andExpect(status().isOk());
		} catch (JsonProcessingException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void addDevicePostTest_ko() {
		try {
			when(wiService.addDevice(any(AddDeviceDto.class))).thenReturn(false);

			AddDeviceDto dto = new AddDeviceDto();
			dto.setPinCode("9876543");
			dto.setSerialNumber(1234);

			this.mockMvc.perform(post("/addDevice").contentType(contentType).content(ApiUtil.mapperToJson(dto)))
					.andDo(print()).andExpect(status().isBadRequest());
		} catch (JsonProcessingException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
