package br.com.dojo.integration.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DojoRequest {

	@JsonProperty
	private String id;

}
