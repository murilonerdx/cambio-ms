package com.murilonerdx.bookservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cambio {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private Double convertedValue;
    private String environment;
}
