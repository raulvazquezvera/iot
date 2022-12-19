package com.iot.wi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.iot.wi.model.AddDeviceDto;
import com.iot.wi.model.ConfigureDeviceDto;
import com.iot.wi.model.DeviceDto;
import com.iot.wi.model.RemoveDeviceDto;

public interface WIService {

	List<DeviceDto> getDevices();

	boolean addDevice(AddDeviceDto device) throws SQLException, MethodArgumentNotValidException;

	boolean removeDevice(RemoveDeviceDto removeDeviceDto);

	boolean configureDevice(ConfigureDeviceDto dto);

}
