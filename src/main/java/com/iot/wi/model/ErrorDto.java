package com.iot.wi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ErrorDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-18T21:23:58.041237+01:00[Europe/Madrid]")
public class ErrorDto {
	@JsonProperty("code")
	private Integer code;

	@JsonProperty("message")
	private String message;

	@JsonProperty("description")
	private String description;

	public ErrorDto code(Integer code) {
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 */
	@ApiModelProperty(value = "")

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public ErrorDto message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 */
	@ApiModelProperty(value = "")

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorDto description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 */
	@ApiModelProperty(value = "")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ErrorDto error = (ErrorDto) o;
		return Objects.equals(this.code, error.code) && Objects.equals(this.message, error.message)
				&& Objects.equals(this.description, error.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorDto {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
