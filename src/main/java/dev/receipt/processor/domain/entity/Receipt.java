package dev.receipt.processor.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Receipt {

    private UUID id;

    private String retailer;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate purchaseDate;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalTime purchaseTime;

    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal total;

    private List<Item> items;

}
