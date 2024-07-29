package pl.base.pages.sections.filter;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductsSection extends BasePage {
    private List<Locator> products;

    public ProductsSection(Page page) {
        super(page);
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
