package br.com.dojo.integration.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaDojosResponse {

	@JsonProperty
	private Long id;
	@JsonProperty
	private String descricao;
	@JsonProperty
	private String responsavel;

}
