package tests.day18_htmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    //amazona gidelim

    @Test
    public void aramaTesti(String aranacakKelime){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }


}
