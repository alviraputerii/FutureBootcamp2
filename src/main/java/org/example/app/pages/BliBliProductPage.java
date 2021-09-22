package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.utils.Utility;

public class BliBliProductPage extends Utility {

    @FindBy(xpath = "//div[@class='product__card product__card__five'][1]//div[@class='product__description']")
    WebElementFacade firstProduct;

    @FindBy(xpath = "//div[@class='product__card product__card__five'][1]//div[@class='product__description']//div[@class='product__title']")
    WebElementFacade productNameDisplay;

    @FindBy(xpath = "//strong[@class='modal__body__price-qty__price__display']")
    WebElementFacade productPriceDisplay;

    @FindBy(xpath = "//div[@id='gdn-popup-shopping-bag']//a[@class='bag-product-title']")
    WebElementFacade productNameInBag;

    @FindBy(xpath = "//div[@id='gdn-popup-shopping-bag']//span[@class='bag-price--new']")
    WebElementFacade productPriceInBag;

    @FindBy(xpath = "//button[@class='product__body__button']")
    WebElementFacade buttonTambahKeBag;

    @FindBy(xpath = "//div[@class='modal__body__add-to-cart']/button")
    WebElementFacade modalButtonTambahKeBag;

    @FindBy(xpath = "//div[@class='cart__amt']")
    WebElementFacade iconBag;

    @FindBy(xpath = "//div[@class='category tooltip__trigger']")
    WebElementFacade buttonCategory;

    @FindBy(xpath = "//i[@class='fa fa-times element-close-button']")
    WebElementFacade buttonClose;

    @FindBy(xpath = "//a[@id='link-image-1631273855723']")
    WebElementFacade imgAds;

    @FindBy(xpath = "//a[@class='categories__menu-item']")
    WebElementFacade menuItemBlimart;

    @FindBy(xpath = "//div[@class='b-ellipsis']/a[contains(text(),'Kuliner Jepang')]")
    WebElementFacade menuItemKulinerJepang;

    @FindBy(xpath = "//div[@class='cart__amt']")
    WebElementFacade amountItemInBag;

    public void hoverProduct() {
        if(isElementVisibleByWebElementFacade(buttonClose)){
            clickByWebElementFacade(buttonClose);
        }
        moveToXpath(firstProduct);
    }

    public void clickButtonTambahKeBag() {
        if(isElementVisibleByWebElementFacade(buttonClose)){
            clickByWebElementFacade(buttonClose);
        }
        clickByWebElementFacade(buttonTambahKeBag);
    }

    public void clickModalButtonTambahKeBag() {
        clickByWebElementFacade(modalButtonTambahKeBag);
    }

    public void hoverBag() {
        moveToXpath(iconBag);
    }

    public String getProductNameInBag() {
        return getTextByWebElementFacade(productNameInBag);
    }

    public String getProductPriceInBag() {
        return getTextByWebElementFacade(productPriceInBag);
    }

    public String getProductNameDisplay() {
        if(isElementVisibleByWebElementFacade(buttonClose)){
            clickByWebElementFacade(buttonClose);
        }
        return getTextByWebElementFacade(productNameDisplay);
    }

    public String getProductPriceDisplay() {
        return getTextByWebElementFacade(productPriceDisplay);
    }

    public void clickButtonCategory() {
        clickByWebElementFacade(buttonCategory);
    }

    public void hoverMenuItemBlimart() {
        moveToXpath(menuItemBlimart);
    }

    public void clickMenuItemKulinerJepang() {
        clickByWebElementFacade(menuItemKulinerJepang);
    }

    public String getAmountItemInBag() {
        return getTextByWebElementFacade(amountItemInBag);
    }
}