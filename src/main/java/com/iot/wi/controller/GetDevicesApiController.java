package com.iot.wi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.iot.wi.model.DeviceDto;
import com.iot.wi.model.ErrorDto;
import com.iot.wi.service.WIService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-18T21:23:58.041237+01:00[Europe/Madrid]")
@Controller
@RequestMapping("${openapi.wI.base-path:}")
public class GetDevicesApiController implements GetDevicesApi {

	private final NativeWebRequest request;

	@Autowired
	WIService wiService;

	@org.springframework.beans.factory.annotation.Autowired
	public GetDevicesApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	@ApiOperation(value = "Find all devices from inventory", nickname = "getDevicesGet", notes = "", response = DeviceDto.class, responseContainer = "List", tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Device removed", response = DeviceDto.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "BadRequest", response = ErrorDto.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class),
			@ApiResponse(code = 503, message = "Service unavailable", response = ErrorDto.class) })
	@GetMapping(value = "/getDevices", produces = { "application/json" })
	public ResponseEntity<List<DeviceDto>> getDevicesGet() {

		return ResponseEntity.ok(wiService.getDevices());
	}

}
