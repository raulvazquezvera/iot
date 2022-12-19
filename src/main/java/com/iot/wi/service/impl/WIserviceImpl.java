package com.iot.wi.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.iot.wi.entities.Device;
import com.iot.wi.entities.Status;
import com.iot.wi.model.AddDeviceDto;
import com.iot.wi.model.ConfigureDeviceDto;
import com.iot.wi.model.DeviceDto;
import com.iot.wi.model.RemoveDeviceDto;
import com.iot.wi.repository.DeviceRepository;
import com.iot.wi.service.WIService;
import com.iot.wi.util.Constants;

@Service
public class WIserviceImpl implements WIService {

	@Autowired
	DeviceRepository deviceRepo;

	@Override
	public List<DeviceDto> getDevices() {
		return deviceRepo.findAllByOrderByPinCodeAsc().stream().map(DeviceDto::new).collect(Collectors.toList());
	}

	@Override
	public boolean addDevice(AddDeviceDto device) throws SQLException, MethodArgumentNotValidException {
		return deviceRepo.save(
				Device.builder().serialNumber(device.getSerialNumber()).pinCode(device.getPinCode()).build()) != null;
	}

	@Override
	@Transactional
	public boolean removeDevice(RemoveDeviceDto removeDeviceDto) {
		return deviceRepo.deleteBySerialNumber(removeDeviceDto.getSerialNumber()) > 0;
	}

	@Override
	public boolean configureDevice(ConfigureDeviceDto dto) {
		Device device = deviceRepo.findBySerialNumber(dto.getSerialNumber());

		if (device != null && device.getTemperature() < 0) {
			device.setStatus(Status.builder().id(Constants.STATUS_ACTIVE).build());
			device.setTemperature((new Random()).nextInt(10) + 1);

			return (deviceRepo.save(device)).getTemperature() > 0;
		}

		return false;
	}

}
