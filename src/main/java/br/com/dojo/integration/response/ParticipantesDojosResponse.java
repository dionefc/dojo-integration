package br.com.dojo.integration.response;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantesDojosResponse {

	@JsonProperty
	private Long id;
	@JsonProperty
	private Collection<Participante> participantes;

	@Getter
	@Setter
	public static class Participante {
		private String nome;

	}

}
