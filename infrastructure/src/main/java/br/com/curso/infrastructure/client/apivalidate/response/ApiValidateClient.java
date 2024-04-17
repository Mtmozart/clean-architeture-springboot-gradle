package br.com.curso.infrastructure.client.apivalidate.response;

import br.com.curso.infrastructure.client.dto.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "ApiValidateClient", url = "${client.url}")
public interface ApiValidateClient {
    @GetMapping
    ApiValidateResponse validate();

}
