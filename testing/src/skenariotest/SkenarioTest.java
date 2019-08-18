package skenariotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagemodel.ContributeInput;
import pagemodel.FunctionalTest;

public class SkenarioTest extends FunctionalTest {
	
	
	//negative test error input donasi berkoma
	@Test
	public void test1() {
		ContributeInput contribute = new ContributeInput(driver);
		assertTrue(contribute.isInitialized());

		contribute.Donasi("12.222,22");
		assertEquals("Jumlah donasi harus lebih besar dari Rp 1.000.", contribute.TextError());
		
	}
	//negative test error input donasi kosong 
	@Test
	public void test2() {
		driver.get(driver.getCurrentUrl());
		ContributeInput contribute = new ContributeInput(driver);
		assertTrue(contribute.isInitialized());
		
		contribute.Donasi("  ");
		assertEquals("Nominal donasi tidak boleh kosong.", contribute.TextError());
		
	}
	//negative test nama lengkap bisa dengan simbol ???
	@Test
	public void test3() {
		driver.get(driver.getCurrentUrl());
		ContributeInput contribute = new ContributeInput(driver);
		assertTrue(contribute.isInitialized());
		
		String nama = "#@$%^&*()";
		contribute.Nama(nama);
		
		WebElement TxtBoxContent = driver.findElement(By.id("Donations_donorName"));
		assertEquals(TxtBoxContent.getAttribute("value"),nama);
	}
	//postive Test user dapat melakukan donasi dan masuk ke halaman pembayaran
	@Test
	public void test4() {	
		ContributeInput contribute = new ContributeInput(driver);
		assertTrue(contribute.isInitialized());

		contribute.Donasi("120000");
		contribute.Payments();
		driver.findElement(By.cssSelector("li.category-select-list__item:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1)")).click();
		contribute.Nama("Testing");
		contribute.EmailorPhone("username@test.com");	
		contribute.Komen("Tis only stratch");
		assertEquals("Instruksi Pembayaran", contribute.Textbayar());
		
	}
	//Create a function to check if there are any same value between two different arrays.
	@Test
	public void test5() {
			int[] a = { 1, 2, 3, 4 };
			int[] b = { 1, 2, 3, 4 };

			if (Arrays.equals(a, b))
				System.out.println("Arrays are equal");
			else
				System.out.println("Arrays are not equal");
		}
	}
