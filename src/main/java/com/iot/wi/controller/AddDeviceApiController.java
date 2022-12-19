package com.iot.wi.controller;

import java.sql.SQLException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.iot.wi.model.AddDeviceDto;
import com.iot.wi.model.ErrorDto;
import com.iot.wi.service.WIService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-18T21:23:58.041237+01:00[Europe/Madrid]")
@Controller
@RequestMapping("${openapi.wI.base-path:}")
public class AddDeviceApiController implements AddDeviceApi {

	private final NativeWebRequest request;

	@Autowired
	WIService wiService;

	@org.springframework.beans.factory.annotation.Autowired
	public AddDeviceApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	@ApiOperation(value = "Add device to inventory", nickname = "addDevicePost", notes = "", tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Device added"),
			@ApiResponse(code = 400, message = "BadRequest", response = ErrorDto.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class),
			@ApiResponse(code = 503, message = "Service unavailable", response = ErrorDto.class) })
	@PostMapping(value = "/addDevice", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<?> addDevicePost(
			@ApiParam(value = "", required = true) @Valid @RequestBody AddDeviceDto addDeviceDto) {
		try {
			if (!wiService.addDevice(addDeviceDto)) {
				return ResponseEntity.badRequest().body(HttpStatus.EXPECTATION_FAILED);
			}
		} catch (MethodArgumentNotValidException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (SQLException e) {
			return ResponseEntity.badRequest().body("Incorrect params in request");
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
