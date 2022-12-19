package com.iot.wi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.wi.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

	public List<Device> findAllByOrderByPinCodeAsc();

	public long deleteBySerialNumber(Integer serialNumber);

	public Device findBySerialNumber(Integer serialNumber);

}
