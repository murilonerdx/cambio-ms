package com.murilonerdx.bookservice.proxy;

import com.murilonerdx.bookservice.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name="cambio-service", url = "localhost:8000")
public interface CambioProxy {

    @GetMapping(value="/cambio-service/{amount}/{from}/{to}")
    Cambio getCambio(
            @PathVariable("amount") Double amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to

    );
}
