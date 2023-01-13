package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_tekrar extends TestBaseRapor {
    @Test
    public void test01(){

        extentTest=extentReports.createTest("Nutella","Kullanici amazonda nutella arayabilmeli");
        // amazon' gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");

        //nutella aratalım
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Arama kutusuna Nutella yazip,arama yapildi");
        //sonucların nutella içerdiğini test edelim
        String actualSonuclariYazisi= amazonPage.aramaSonucuElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("Arama sonuclari kaydedildi");


        Assert.assertTrue(actualSonuclariYazisi.contains(expectedKelime));
        extentTest.pass("Arama sonuclarinin Nutella içerdiği test edildi");

    }

}
