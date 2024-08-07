package pl.base.pages.sections.searchResultsSection;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.dto.ProductDTO;
import pl.base.pages.BasePage;
import pl.base.pages.ProductDetailsPage;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SearchResultSection extends BasePage {

    private List<Locator> products;

    public SearchResultSection(Page page) {
        super(page);
        this.products = page.locator(".js-product").all();
    }

    public int returnNumberOfProducts() {
        return products.size();
    }


    public ProductDetailsPage viewProductDetail(String productName) {
        ProductDTO productDTO = productsToDto().stream()
                .filter(p -> p.getProductName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());

        productDTO.getPicture().click();
        return new ProductDetailsPage(page);
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
