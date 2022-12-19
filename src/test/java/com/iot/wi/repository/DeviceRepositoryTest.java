package com.iot.wi.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iot.wi.entities.Device;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class DeviceRepositoryTest {

	@Resource
	private DeviceRepository deviceRepo;

	@Test
	public void crudTest() {
		Device entity = deviceRepo.save(Device.builder().pinCode("0000000").serialNumber(11111111).build());

		assertNotNull(entity);
		assertNotNull(entity.getId());

		List<Device> deviceList = deviceRepo.findAllByOrderByPinCodeAsc();

		assertNotNull(deviceList);
		assertTrue(deviceList.size() == 1);

		entity = deviceRepo.save(Device.builder().pinCode("0000001").serialNumber(11111112).build());

		assertNotNull(entity);
		assertNotNull(entity.getId());

		deviceList = deviceRepo.findAllByOrderByPinCodeAsc();

		assertNotNull(deviceList);
		assertTrue(deviceList.size() == 2);

		assertTrue(deviceRepo.deleteBySerialNumber(entity.getSerialNumber()) > 0);

		entity = deviceRepo.findBySerialNumber(11111111);

		assertNotNull(entity);
	}

}
