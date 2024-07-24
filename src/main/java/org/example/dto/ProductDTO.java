package org.example.dto;

import com.microsoft.playwright.Locator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private Locator picture;
    private String productName;
    private double productPrice;
}
