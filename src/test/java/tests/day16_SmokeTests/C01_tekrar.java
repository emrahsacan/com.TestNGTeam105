package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_tekrar { // kullanıcı adı veya şifre değişmiş passed olmuyor
    @Test
    public void pozitifLoginTest(){
        //qualitydemy ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        ReusableMethods.bekle(3);
        qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(5);
        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());
        Driver.closeDriver();
    }
}
