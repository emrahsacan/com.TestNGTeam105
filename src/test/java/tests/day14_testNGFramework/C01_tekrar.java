package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C01_tekrar {
     /*
        TestNG test method'larini isim sirasina gore calistirir
        priority degeri verilen method'lar priority degeri kucukten buyuge dogru calisir
        esit olan priority degerlerinde harf sirasina gore calisir
        eger priority degeri yazmazsak priority=0 kabul edilir
     */

    @Test(priority = 6)
    public void test01(){
        System.out.println("Ilk test calisti");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci test calisti");
    }
    @Test(priority = -9)
    public void test03(){
        System.out.println("Ucuncu test calisti");
    }
}
