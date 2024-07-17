package pl.base.pages.sections.filter;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Arrays;

public class FilterBySection {

    private Page page;
    private Locator leftSlider;
    private Locator priceLabel;

    public FilterBySection(Page page) {
        this.page = page;
        this.leftSlider = page.locator(".ui-slider-handle").first();
        this.priceLabel = page.locator("#search_filters li p");
    }

    public void showLeftSlider() {
        System.out.println(leftSlider.boundingBox().x);
        System.out.println(leftSlider.boundingBox().y);
        System.out.println(leftSlider.boundingBox().height);
        System.out.println(leftSlider.boundingBox().width);
    }

    public void filterProductsByPriceMouse(double fromPrice) {
        while (fromPrice != getFromPrice()) {
            double x = leftSlider.boundingBox().x;
            double y = leftSlider.boundingBox().y;

            double middleX = x + leftSlider.boundingBox().width / 2;
            double middleY = y + leftSlider.boundingBox().height / 2;

            leftSlider.scrollIntoViewIfNeeded();
            page.mouse().move(middleX, middleY);
            page.mouse().down();
            page.mouse().move(x + 7.00, y);
            page.mouse().up();
            page.waitForCondition(() -> page.locator(".overlay__content").isHidden());
        }
    }

    private double getFromPrice() {
       return Arrays.asList(page.locator("#search_filters li p").innerText().split(" "))
               .stream()
               .map(s -> s.replaceAll("zł", ""))
               .mapToDouble(Double::parseDouble)
               .findFirst()
               .orElseThrow(() -> new RuntimeException("No price found"));

    }
}
