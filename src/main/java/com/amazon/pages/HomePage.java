package com.amazon.pages;

import com.amazon.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * By Dimple Patel
 **/
public class HomePage extends Utility
{
    //Locators search bar send keys laptop, click search btn

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement SearchbarLink;

    @CacheLookup
    @FindBy(id = "nav-search-submit-button")
    WebElement searchLink;

    public void searchProduct(String product)
    {
        sendTextToElement(SearchbarLink, product);
    }

    public void clickOnSearch()
    {
        clickOnElement(searchLink);
    }
}


