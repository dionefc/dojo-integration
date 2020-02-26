package br.com.dojo.integration;

import java.util.Arrays;
import java.util.Collection;

import br.com.dojo.integration.request.ConsultaParticipantesRequest;
import br.com.dojo.integration.request.DojoRequest;

public class DojoSplitter {

	public Collection<Object> split(final DojoRequest dojoRequest) {
		return Arrays.asList(dojoRequest, ConsultaParticipantesRequest.of(dojoRequest.getId()));
	}

}
