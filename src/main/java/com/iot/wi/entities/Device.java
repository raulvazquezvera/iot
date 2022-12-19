package com.iot.wi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iot.wi.util.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "devices")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "SERIAL_NUMBER", nullable = false, unique = true)
	private int serialNumber;

	@Column(name = "PIN_CODE", nullable = false, unique = true, length = 7)
	private String pinCode;

	@Column(name = "TEMPERATURE", nullable = false)
	private Integer temperature;

	@OneToOne(cascade = CascadeType.DETACH, orphanRemoval = false)
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	private Status status;

	@PrePersist
	public void prePersist() {
		if (temperature == null) {
			temperature = Constants.TEMPERATURE_READY;
		}
		if (status == null) {
			status = Status.builder().id(Constants.STATUS_READY).build();
		}
	}

}
