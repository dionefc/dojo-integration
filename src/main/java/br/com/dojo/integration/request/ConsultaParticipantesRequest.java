package br.com.dojo.integration.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class ConsultaParticipantesRequest {

	@JsonProperty
	private String id;

}
