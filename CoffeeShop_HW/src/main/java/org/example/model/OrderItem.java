package org.example.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private int id;
    private int orderId;
    private int idAssortement;
    private int quantity;
    private double price;
}
