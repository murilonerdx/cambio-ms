package com.murilonerdx.cambioservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cambio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="from_currency")
    private String from;

    @Column(name="to_currency")
    private String to;

    private BigDecimal conversionFactor;

    @Transient
    private BigDecimal convertValue;

    @Transient
    private String environment;
}
