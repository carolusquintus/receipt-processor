package dev.receipt.processor.domain.entity;

import java.math.BigDecimal;

public record Item(String shortDescription, BigDecimal price) {}
