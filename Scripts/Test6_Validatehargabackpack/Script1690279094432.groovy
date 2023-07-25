import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

String username1 = "standard_user"
GlobalVariable.username = username1

String password1 = 'secret_sauce'
GlobalVariable.password = password1;

String savedUsername = GlobalVariable.username
String savedPassword = GlobalVariable.password

WebUI.setText(findTestObject('Page_Swag Labs/input_Swag Labs_user-name'), GlobalVariable.username)

WebUI.setText(findTestObject('Page_Swag Labs/input_Swag Labs_password'), GlobalVariable.password)

WebUI.click(findTestObject('Page_Swag Labs/input_Swag Labs_login-button'))

String harga = '$29.99'
GlobalVariable.hargabarang = harga;

String savedharga = GlobalVariable.hargabarang

println("Saved Harga Text: " + savedharga)

WebUI.click(findTestObject('Page_Swag Labs/button_Add to cart'))

WebUI.click(findTestObject('Page_Swag Labs/a_Swag Labs_shopping_cart_link'))

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Checkout'))

WebUI.setText(findTestObject('Page_Swag Labs/input_Checkout Your Information_firstName'), 'vico')

WebUI.setText(findTestObject('Page_Swag Labs/input_Checkout Your Information_lastName'), 'hadi')

WebUI.setText(findTestObject('Page_Swag Labs/input_Checkout Your Information_postalCode'), '40897')

WebUI.click(findTestObject('Page_Swag Labs/input_Cancel_continue'))

def actualPrice = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_29.99'))

def expectedPrice = GlobalVariable.hargabarang

WebUI.verifyMatch(actualPrice, expectedPrice, false)

