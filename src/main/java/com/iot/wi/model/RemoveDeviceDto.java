package com.iot.wi.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RemoveDeviceDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-18T21:23:58.041237+01:00[Europe/Madrid]")
public class RemoveDeviceDto {
	@JsonProperty("serialNumber")
	private Integer serialNumber;

	public RemoveDeviceDto serialNumber(Integer serialNumber) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RemoveDeviceDto removeDevice = (RemoveDeviceDto) o;
		return Objects.equals(this.serialNumber, removeDevice.serialNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serialNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RemoveDeviceDto {\n");

		sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
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
}
