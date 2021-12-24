package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * By Dimple Patel
 **/
public class ProductDescriptionPage extends Utility
{
    public ProductDescriptionPage()
    {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    //@FindBy(xpath = "//span[@class='a-button-inner']")
    @FindBy(xpath = "//select[@id='quantity']")
    WebElement QuantitySelectLink;

    @CacheLookup
    //@FindBy(xpath = "//span[@class='a-button-inner']//input[@name='submit.add-to-cart']")
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement AddToCartButton;

    @CacheLookup
    //@FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
    @FindBy(xpath = "//h4[contains(text(),'Added to Cart')]")
    WebElement AddToCrtTxt;
    @CacheLookup
    //@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    @FindBy(xpath = "//div[@class='a-section a-spacing-none a-padding-none']//span")
    WebElement addToCartTextMob;

    public void selectQuantityOfProduct(int Qty) {
        CustomListeners.node.log(Status.PASS, "selecting the quantity: " + QuantitySelectLink.getText());
        Reporter.log("selecting the quantity: " + QuantitySelectLink.getText() + "<br>");
        selectByIndexFromDropDown(QuantitySelectLink, Qty);
    }

    public void clickOnAddToCart() {
        CustomListeners.node.log(Status.PASS, "Clicking on Add Cart button: " + AddToCartButton.getText());
        Reporter.log("Clicking on Add Cart button: " + AddToCartButton.getText() + "<br>");
        clickOnElement(AddToCartButton);
    }
    public void verifyAddToCartTextSuccessfully()
    {
        CustomListeners.node.log(Status.PASS, "verifying the add to cart text on page: " + AddToCrtTxt.getText());
        Reporter.log("verifying the add to cart text on page: " + AddToCrtTxt.getText() + "<br>");
        verifyThatTextIsDisplayed( AddToCrtTxt, "Added to Cart");
    }
    public void verifyAddToCartTextForMobile()
    {
        CustomListeners.node.log(Status.PASS, "verifying the add to cart text on page: " + addToCartTextMob.getText());
        Reporter.log("verifying the add to cart text on page: " + addToCartTextMob.getText() + "<br>");
        verifyThatTextIsDisplayed( addToCartTextMob, "Added to Cart");
    }
}



