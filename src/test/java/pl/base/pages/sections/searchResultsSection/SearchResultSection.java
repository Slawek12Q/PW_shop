package pl.base.pages.sections.searchResultsSection;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.dto.ProductDTO;
import pl.base.pages.SearchResultPage;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SearchResultSection {

    private List<Locator> products;
    Page page;

    public SearchResultSection(Page page) {
        this.page = page;
        this.products = page.locator(".js-product").all();
    }

    public int returnNumberOfProducts() {
        return products.size();
    }

    public SearchResultPage clickOnMug() {
        products.get(0).click();
        return new SearchResultPage(page);
    }

    public void viewProductDetail(String productName) {
        ProductDTO productDTO = productsToDto().stream()
                .filter(p -> p.getProductName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());

        productDTO.getPicture().click();
    }

    public List<ProductDTO> productsToDto() {

        return products.stream()
                .map(p -> ProductDTO.builder()
                        .picture(p.locator(".thumbnail-top"))
                        .productName(p.locator(".product-title").innerText())
                        .productPrice(Double.parseDouble(p.locator(".price").innerText().substring(2)))
                        .build())
                .collect(Collectors.toList());
    }
}
