package com.iot.wi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iot.wi.model.ConfigureDeviceDto;
import com.iot.wi.service.WIService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(value = "ConfigureDevice")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST })
@RestController
public class ConfigureDeviceController {

	@Autowired
	WIService wiService;

	/**
	 * Method to configure a device
	 * 
	 * @return DeviceDto
	 */
	@RequestMapping(value = "/configureDevice", method = RequestMethod.POST)
	public ResponseEntity<Boolean> configureDevice(
			@ApiParam(value = "Input value object", required = true) @RequestBody @Valid ConfigureDeviceDto dto) {
		return ResponseEntity.ok(wiService.configureDevice(dto));
	}

}
