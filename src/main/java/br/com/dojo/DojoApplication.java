package br.com.dojo;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ImportResource("spring/*.xml")
public class DojoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DojoApplication.class, args);
	}

	@Bean
	public HttpClient httpClient() throws KeyManagementException, NoSuchAlgorithmException {
		final SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[] { new NullX509TrustManager()
		}, null);

		final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setSSLContext(sslContext);
		httpClientBuilder.setSSLHostnameVerifier(new NullHostnameVerifier());
		return httpClientBuilder.build();
	}

	@Bean
	public HttpComponentsClientHttpRequestFactory httpRequestFactory(@Autowired final HttpClient httpClient) {
		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}

	@Bean
	public RestTemplate restTemplate(@Autowired final ClientHttpRequestFactory requestFactory) {
		return new RestTemplate(requestFactory);
	}

	@Bean
	public HttpMessageConverter<Object> httpMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

	@Bean
	public LocalValidatorFactoryBean restValidator() {
		return new LocalValidatorFactoryBean();
	}

	private static class NullX509TrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
			// does nothing.
		}

		@Override
		public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
			// does nothing.
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}

	}

	private static class NullHostnameVerifier implements HostnameVerifier {

		@Override
		public boolean verify(final String hostname, final SSLSession session) {
			return true;
		}

	}

}
