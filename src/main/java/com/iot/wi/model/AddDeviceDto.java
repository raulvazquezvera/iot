package com.iot.wi.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * AddDeviceDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-18T21:23:58.041237+01:00[Europe/Madrid]")
@Data
public class AddDeviceDto {
	@JsonProperty("serialNumber")
	private Integer serialNumber;

	@JsonProperty("pinCode")
	private String pinCode;

	public AddDeviceDto serialNumber(Integer serialNumber) {
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

	public AddDeviceDto pinCode(String pinCode) {
		this.pinCode = pinCode;
		return this;
	}

	/**
	 * Get pinCode
	 * 
	 * @return pinCode
	 */
	@ApiModelProperty(example = "1234567", required = true, value = "")
	@NotNull
	@Valid
	@Size(min = 7, max = 7, message = "{validation.pinCode.size.errorlength}")

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AddDeviceDto addDevice = (AddDeviceDto) o;
		return Objects.equals(this.serialNumber, addDevice.serialNumber)
				&& Objects.equals(this.pinCode, addDevice.pinCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serialNumber, pinCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AddDeviceDto {\n");

		sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
		sb.append("    pinCode: ").append(toIndentedString(pinCode)).append("\n");
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
