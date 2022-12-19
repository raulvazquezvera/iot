package com.iot.wi.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.wi.entities.Device;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DeviceDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-18T21:23:58.041237+01:00[Europe/Madrid]")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {
	@JsonProperty("serialNumber")
	private Integer serialNumber;

	@JsonProperty("temperature")
	private Integer temperature;

	@JsonProperty("status")
	private String status;

	public DeviceDto serialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	/**
	 * Get serialNumber
	 * 
	 * @return serialNumber
	 */
	@ApiModelProperty(example = "1234567", required = true, value = "")
	@NotNull

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Get temperature
	 * 
	 * @return temperature
	 */
	@ApiModelProperty(example = "3", required = true, value = "")
	@NotNull

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public DeviceDto status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 */
	@ApiModelProperty(example = "READY", required = true, value = "")
	@NotNull

	@Valid

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DeviceDto device = (DeviceDto) o;
		return Objects.equals(this.serialNumber, device.serialNumber)
				&& Objects.equals(this.temperature, device.temperature) && Objects.equals(this.status, device.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serialNumber, temperature, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DeviceDto {\n");

		sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
		sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public DeviceDto(Device d) {
		this.serialNumber = d.getSerialNumber();
		this.temperature = d.getTemperature();
		this.status = d.getStatus().getStatus();
	}

}
