import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zadaniestronka {

    private static WebDriver driver;
    private String url = "https://antycaptcha.amberteam.pl/exercises/exercise1";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void zadanieTest1() throws InterruptedException {
        driver.navigate().to(url);
        for (int i = 2; i < 5; i++){
            WebElement firstButton = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + i + "]/td[2]/code"));
            if (firstButton.getText().equals("B1")) {
                driver.findElement(By.name("btnButton1")).click();
            }

            else {
                driver.findElement(By.name("btnButton2")).click();
            }

        }
        /* WebElement secondButton = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]/code"));
        if (secondButton.getText().equals("B1")) {
            driver.findElement(By.name("btnButton1")).click();
        }

        else {
            driver.findElement(By.name("btnButton2")).click();
        }

        WebElement thirdButton = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[2]/code"));
        if (thirdButton.getText().equals("B1")) {
            driver.findElement(By.name("btnButton1")).click();
        }

        else {
            driver.findElement(By.name("btnButton2")).click();
        }
        */

        driver.findElement(By.name("end")).click();

        Thread.sleep(2000);

        Assert.assertEquals("OK. Good answer", driver.findElement(By.id("trail")).getText());

        driver.close();
    }








}
