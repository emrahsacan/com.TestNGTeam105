package tests.day15_SoftAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

public class C01_tekrar {
    @Test
    public void test01(){

        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        // amazon anasayfaya gittiginizi dogrulayin
        SoftAssert softAssert= new SoftAssert();
        String expectedUrlKelime= "amazon";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"Url amazon icermiyor!");
        // Nutella aratin
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // arama sonuclarinin nutella icerdigini dogrulayin
        String aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"),"Arama sonuclari Nutella içermiyor!");

        // java ara
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin 1000'den fazla oldugunu dogrulayin
        System.out.println(amazonPage.aramaSonucuElementi.getText());

        // 1-48 of over 6,000 results for "Java"

        aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText();

        String[] sonucArr=aramaSonucYazisi.split(" ");
        // [1-48, of, over, 6,000, results, for, "Java"]

        String javaSonucSayisisStr= sonucArr[3]; //6,000

        javaSonucSayisisStr=javaSonucSayisisStr.replaceAll("\\W",""); //6000
        int sonucSayisiInt= Integer.parseInt(javaSonucSayisisStr);

        softAssert.assertTrue(sonucSayisiInt>1000,"Java için arama sonucu 1000'den fazla değil!");






        softAssert.assertAll();
        Driver.closeDriver();
    }

}
