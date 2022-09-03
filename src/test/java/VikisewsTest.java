import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class VikisewsTest extends AbstractTest {

    @Test
    @DisplayName("Test1")
    public void LoginToYourPersonalAccountTest() {
        driver.get("https://vikisews.com");
        driver.findElement(By.cssSelector(".container > .right-icons > .d-none > .icon")).click();
        driver.findElement(By.id("email_login")).click();
        driver.findElement(By.id("email_login")).sendKeys("gz1k0prvg3kc@mail.ru");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("6185");
        driver.findElement(By.id("buttonLogin")).click();
        Assertions.assertEquals("Vikisews — интернет-магазин готовых выкроек одежды, онлайн курсы шитья и мастер классы", getDriver().getTitle());
    }

    @Test
    @DisplayName("Test2")
    public void ChangeSettingsTest() {
        driver.get("https://vikisews.com/profile/");
        driver.findElement(By.cssSelector(".mb-3 > .align-items-center:nth-child(1) > .fa")).click();
        driver.findElement(By.name("chest_girth")).sendKeys("90");
        driver.findElement(By.cssSelector(".mb-3 > .align-items-center:nth-child(1) > .btn")).click();
        driver.findElement(By.cssSelector(".mb-3 > .align-items-center:nth-child(2) > .fa")).click();
        driver.findElement(By.name("waist")).sendKeys("60");
        driver.findElement(By.cssSelector(".mb-3 > .align-items-center:nth-child(2) > .btn")).click();
        driver.findElement(By.cssSelector(".mb-3 > .align-items-center:nth-child(3) > .fa")).click();
        driver.findElement(By.name("hip_girth")).sendKeys("90");
        driver.findElement(By.cssSelector(".mb-3 > .align-items-center:nth-child(3) > .btn")).click();
        Assertions.assertEquals("Vikisews | Профиль", getDriver().getTitle());
    }

    @Test
    @DisplayName("Test3")
    public void ClickOnMenuTest() {
        driver.get("https://vikisews.com/profile/");
        driver.findElement(By.linkText("Заказы")).click();
        driver.findElement(By.xpath("//a[contains(@href, '/my-orders/')])[2]")).click();
        driver.findElement(By.cssSelector(".align-items-baseline > .mr-auto")).click();
        driver.findElement(By.linkText("Сертификаты")).click();
    }

    @Test
    @DisplayName("Test4")
    public void ProductSearchTest() {
        driver.get("https://vikisews.com/my-certificates/");
        driver.findElement(By.cssSelector(".search")).click();
        driver.findElement(By.id("search-pattern")).sendKeys("Худи Джейкоб");
        driver.findElement(By.cssSelector(".btn-search")).click();
        driver.findElement(By.cssSelector(".col-6:nth-child(1) .position-relative .popular-slide-img")).click();
        Assertions.assertEquals("Выкройка Худи Джейкоб - Vikisews", getDriver().getTitle());
    }


    @Test
    @DisplayName("Test5")
    public void AddingRemovingItemsToTheCartTest() {
        driver.get("https://vikisews.com/vykrojki/muzhskie-vykrojki/hudi-dzhejkob/");
        //js.executeScript("window.scrollTo(0,51.20000076293945)");
        //js.executeScript("window.scrollTo(0,1300)");
        driver.findElement(By.cssSelector(".product-param:nth-child(6)")).click();
        driver.findElement(By.id("addToCart")).click();
        driver.findElement(By.linkText("Перейти в корзину")).click();
        driver.findElement(By.cssSelector(".cart-icon__rm")).click();
        Assertions.assertEquals("Vikisews | Корзина", getDriver().getTitle());
    }

    @Test
    @DisplayName("Test6")
    public void ExitProfileTest() {
        driver.get("https://vikisews.com/cart/");
        driver.findElement(By.cssSelector(".account")).click();
        driver.findElement(By.linkText("Выйти")).click();
        Assertions.assertEquals("https://vikisews.com/cart/", getDriver().getCurrentUrl());
    }
}
