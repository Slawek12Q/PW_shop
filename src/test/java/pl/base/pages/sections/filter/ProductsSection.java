package pl.base.pages.sections.filter;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductsSection {
    Page page;
    private List<Locator> products;

    public ProductsSection(Page page) {
        this.page = page;
        this.products = page.locator(".thumbnail-top").all();
    }

    private List<Locator> getProductsPricesList() {
        return page.locator("span[class=price]").all();
    }

    public List<Double> getProductPricesDouble() {

        return getProductsPricesList().stream().map(s -> s.innerText().substring(2))
                .map(Double::parseDouble).collect(Collectors.toList());
    }
}
