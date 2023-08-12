package dev.receipt.processor.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Receipt {

    private UUID id;
    private String retailer;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private BigDecimal total;
    private List<Item> items;

}
