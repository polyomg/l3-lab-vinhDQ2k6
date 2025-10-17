package poly.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple product data holder.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private Double price;
}