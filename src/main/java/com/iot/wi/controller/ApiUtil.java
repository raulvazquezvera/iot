package com.iot.wi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.NativeWebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiUtil {
	public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
		try {
			HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
			res.setCharacterEncoding("UTF-8");
			res.addHeader("Content-Type", contentType);
			res.getWriter().print(example);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String mapperToJson(Object obj) throws JsonProcessingException {
		return (new ObjectMapper()).writeValueAsString(obj);
	}

	public static String mapperToJsonFormatted(Object obj) throws JsonProcessingException {
		return (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	}

}
