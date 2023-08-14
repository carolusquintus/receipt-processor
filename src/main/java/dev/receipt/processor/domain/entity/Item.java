package dev.receipt.processor.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;

public record Item(

    String shortDescription,

    @JsonSerialize(using = ToStringSerializer.class)
    BigDecimal price

) {}
