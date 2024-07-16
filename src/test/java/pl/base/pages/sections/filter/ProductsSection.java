package pl.base.pages.sections.filter;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductsSection {

    private List<Locator> products;
    private List<Locator> productsPrice;

    public ProductsSection(Page page) {
        this.products = page.locator(".thumbnail-top").all();
        this.productsPrice = page.locator("span[class=price]").all();
    }

    public List<Double> getProductPricesDouble() {
        return productsPrice.stream().map(s -> s.innerText().substring(2))
                .map(Double::parseDouble).collect(Collectors.toList());
    }
}
