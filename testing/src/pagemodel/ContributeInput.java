package pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContributeInput extends PageObject {

	public ContributeInput(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy( css = "#target-donasi")
	private WebElement  targetdonasi;
	
	@FindBy( css = ".align-left__i")
	private WebElement txterror;
	
	@FindBy( css = "div.form__row:nth-child(5) > div:nth-child(1)")
	private WebElement txtnama;
	
	@FindBy( css = "#Donations_donorName")
	private WebElement namadonasi;
	
	@FindBy( css = "#emailOrPhone")
	private WebElement emailorphone;
	
	@FindBy( css = "#Donations_comment")
	private WebElement commentdonasi;
	
	@FindBy( css = ".btn")
	private WebElement submitbtn;
	
	@FindBy( css = ".checkbox-content" )
	private WebElement checkanonim;
	
	@FindBy( xpath = "//*[text() = 'Metode Pembayaran']")
	private WebElement payments;
	
	@FindBy( css = "#Donations_comment")
	private WebElement komen;
	
	@FindBy( css = ".text-18")
	private WebElement textpembayaran;
	
	public String Textbayar() {
		return textpembayaran.getText();
	}
	
	public boolean isInitialized() {
		return targetdonasi.isDisplayed();
	}
	
	public void Donasi( String targetdonasi ) {
		this.targetdonasi.clear();
		this.targetdonasi.sendKeys(targetdonasi);
	}
	
	public void Nama(String namadonasi) {
		this.namadonasi.clear();
		this.namadonasi.sendKeys(namadonasi);
	}
	
	public void EmailorPhone(String emailorphone) {
		this.emailorphone.clear();
		this.emailorphone.sendKeys(emailorphone);
	}
	
	public String  namatxt() {
		return txtnama.getText();
	}
	
	public String  TextError() {
		return txterror.getText();
	}
	
	public void Payments() {
		this.payments.click();
	}
	
	public void Komen(String komen) {
		this.komen.clear();
		this.komen.sendKeys(komen);
		this.submitbtn.click();
	}
	
	public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            	}
            attempts++;
        }
        return result;
}
	
}
