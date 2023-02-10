package com.example.joyselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class JoySeleniumApplication {
    public static void main(String[] args) {
        //Seleccionamos el controlador y abrimos una instancia del navegador
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\BWL\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        //Damos tiempo de espera para que se muestren los elementos
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Abierta la instancia del navegador abrimos la página a revisar..
        driver.get("http://landcserver.dyndns.org:8081/joy-retail/login");
        //Rellenamos datos de login
        WebElement user_element = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/joy-basic-input/div/div/input"));
        user_element.sendKeys("dbertan");
        WebElement pass_element = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[3]/joy-basic-input/div/div/input"));
        pass_element.sendKeys("demo");
        //Clickeamos en boton de login
        WebElement button = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/joy-basic-button/div/div"));
        button.click();

        // Navegamos a productos
        WebElement selector_level_1 = driver.findElement(By.cssSelector(".joy-e91b"));
        selector_level_1.click();
        WebElement selector_level_2 = driver.findElement(By.xpath("/html/body/app-root/pages/joy-sidebar/div/div[1]/div[2]/div[1]"));
        selector_level_2.click();

        //Alta de un producto
        WebElement new_producto_button = driver.findElement(By.xpath("/html/body/app-root/pages/div/div/product-component/div[1]/div/div[3]/joy-basic-button/div/div[1]"));
        new_producto_button.click();

        /// Llenar campo SKU
        WebElement sku_product = driver.findElement(By.xpath("/html/body/app-root/pages/div/div/product-component/joy-form-product/joy-modal/div/div/div/div[3]/div/div/div[1]/joy-basic-input[1]/div/div/input"));
        Random rand = new Random();
        int sku = rand.nextInt(123456789);
        sku_product.sendKeys( Integer.toString (sku));

        /// Llenar campo descripción
        WebElement description_product = driver.findElement(By.xpath("/html/body/app-root/pages/div/div/product-component/joy-form-product/joy-modal/div/div/div/div[3]/div/div/div[1]/joy-basic-input[2]/div/div/textarea"));
        List descriptions = new List();
        descriptions.add("Lorem ipsum");
        descriptions.add("dolor sit amet");
        descriptions.add("Quis autem vel eum");
        descriptions.add("Finibus Bonorum et Malorum");
        descriptions.add("On the other hand");
        System.out.println(descriptions.getItemCount());
        description_product.sendKeys( descriptions.getItem(rand.nextInt(descriptions.getItemCount())));

        //Seleccionar marca
        WebElement select_brand = driver.findElement(By.xpath("/html/body/app-root/pages/div/div/product-component/joy-form-product/joy-modal/div/div/div/div[3]/div/div/div[1]/joy-select-global[1]/div/div[1]/div[4]"));
        select_brand.click();

        List brand_elements = (List) select_brand.findElements(By.xpath("/html/body/app-root/pages/div/div/product-component/joy-form-product/joy-modal/div/div/div/div[3]/div/div/div[1]/joy-select-global[1]/div/div[2]/cdk-virtual-scroll-viewport/div[1]/div[1]"));
        System.out.println("Break");

    }

}
