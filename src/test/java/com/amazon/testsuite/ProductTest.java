package com.amazon.testsuite;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.pages.HomePage;
import com.amazon.pages.FindYourProductPage;
import com.amazon.pages.ProductDescriptionPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class ProductTest extends TestBase
{
    HomePage homePage;
    FindYourProductPage findYourProductPage;
    ProductDescriptionPage productDescriptionPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage=new HomePage();
        findYourProductPage=new FindYourProductPage();
        productDescriptionPage=new ProductDescriptionPage();
    }
    @Test
    public void searchLenovoLaptopSuccessFully() throws InterruptedException {
        homePage.searchProduct("laptop");
        homePage.clickOnSearch();
        findYourProductPage.clickOnLenovo();
        //laptopPage.setLenovoLaptop("2021 Newest Lenovo Flex 5 14.0\" FHD Touchscreen Laptop, AMD Ryzen 3 5300U(up to 3.80 GHz), 4GB RAM 512GB NVMe SSD, Webcam, HDMI, Win 10 S");
        findYourProductPage.setTheProductLaptop("Lenovo ThinkBook 13s Gen 2 Intel Laptop 2022, 13.3\" IPS 300 nits, 11th Intel i7-1165G7(up to 4.7GHz) 16GB RAM, 512GB SSD, Backlit Keyboard, Fingerprint Reader, Win 10 Pro");
        //laptopPage.setLenovoLaptop("2021 Newest Lenovo Flex 5 14.0");
        productDescriptionPage.selectQuantityOfProduct(3);
        productDescriptionPage.clickOnAddToCart();
        productDescriptionPage.verifyAddToCartTextSuccessfully();
    }
    @Test(priority = 1,groups = {"sanity","regression"})
    public void searchMobileSuccessfully() throws InterruptedException {
        homePage.searchProduct("mobile phone");
        homePage.clickOnSearch();
        findYourProductPage.clickOnMobile();
        //findYourProductPage.setTheProductMobile("Nokia XR20 5G | Android 11 | Unlocked Smartphone | Dual SIM | US Version | 6/128GB | 6.67-Inch Screen | 48MP Dual Camera | Polar Night\n");
        findYourProductPage.setTheProductMobile("Nokia 225 | Unlocked | 4G Cell Phone | Black");
        productDescriptionPage.selectQuantityOfProduct(2);
        productDescriptionPage.clickOnAddToCart();
        productDescriptionPage.verifyAddToCartTextForMobile();
    }
}



