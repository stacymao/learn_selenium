import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DivGrowthCaculator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/lu/Downloads/chromedriver");
        //Initiate a browser
//        ChromeOptions options = new ChromeOptions();
//        ChromeOptions options1 = options.addArguments("--headless");
        WebDriver driver = new ChromeDriver();
        for(int i = 0; i < 100; i++) {
            driver.get("https://www.nasdaq.com/market-activity/stocks/spgi/dividend-history");
            //      String CurrentDiv = driver.findElement(By.xpath("/html/body/div[4]/div/main/div/div[4]/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]")).
            //              getText().substring(1).replaceAll("/=","");;
            //      String PreviDiv = driver.findElement(By.xpath("/html/body/div[4]/div/main/div/div[4]/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).
            //              getText().substring(1).replaceAll("/=","");;
            String CurrentDiv = driver.findElement(By.xpath("/html/body/div[4]/div/main/div/div[4]/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]")).
                    getText().substring(1);
            ;
            String PreviDiv = driver.findElement(By.xpath("/html/body/div[4]/div/main/div/div[4]/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).
                    getText().substring(1);
            double CurrentNum = Double.parseDouble(CurrentDiv);
            double PreviNum = Double.parseDouble(PreviDiv);
            int Difference = (int) ((CurrentNum - PreviNum) / CurrentNum * 100);
            System.out.println(Difference + "%");
        }
        driver.quit();
    }
}