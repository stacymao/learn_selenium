import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.ScatteringByteChannel;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class DivGrowthCaculator {
    static String currentDiv, previDiv;

    public static void main(String[] args) {
//        boolean continueloop = false;
        System.setProperty("webdriver.chrome.driver", "/home/lu/Downloads/chromedriver");


        //Initiate a browser
//        ChromeOptions options = new ChromeOptions();
//        ChromeOptions options1 = options.addArguments("--headless");
        WebDriver driver = new ChromeDriver();
        String[] names = {"APA", "APD", "APH", "APOG", "ADS", "AGL", "AGN"};
//        String[] names = {"A", "AAL", "AAP", "AAPL", "ABBV", "ABC", "ABM", "ABMD", "ABT", "ACN", "ACV", "ADBE", "ADI", "ADM", "ADP", "ADS", "ADSK", "AEE", "AEP", "AES", "AFL", "AGL", "AGN", "AIG", "AIT", "AIV", "AIZ", "AJG", "AKAM", "ALB", "ALEX", "ALGN", "ALK", "ALL", "ALLE", "ALXN", "AMAT", "AMCR", "AMD", "AME", "AMGN", "AMN", "AMP", "AMT", "AMZN", "ANET", "ANSS", "ANTM", "AOC", "AON", "AOS", "APA", "APD", "APH", "APOG", "APTV", "ARE", "ARNC", "ASBC", "ATO", "ATVI", "AVB", "AVGO", "AVP", "AVY", "AWK", "AWR", "AXP", "AZO", "B", "BA", "BAC", "BAX", "BBT", "BBY", "BCR", "BDK", "BDX", "BEN", "BEZ", "BF", "BIIB", "BK", "BKNG", "BKR", "BLK", "BLL", "BMI", "BMO", "BMS", "BMY", "BNI", "BOBE", "BOH", "BP", "BR", "BRC", "BRK", "BSX", "BWA", "BXP", "BXS", "C", "CAG", "CAH", "CASS", "CAT", "CB", "CBE", "CBOE", "CBRE", "CBSH", "CCI", "CCL", "CDNS", "CDW", "CE", "CERN", "CF", "CFG", "CHD", "CHRW", "CHTR", "CI", "CINF", "CL", "CLC", "CLX", "CMA", "CMC", "CMCSA", "CME", "CMG", "CMI", "CMS", "CNC", "CNL", "CNP", "COF", "COG", "COO", "COP", "COST", "COTY", "CPB", "CPRI", "CPRT", "CRM", "CSCO", "CSL", "CSX", "CTAS", "CTBI", "CTL", "CTSH", "CTVA", "CTWS", "CTXS", "CVS", "CVX", "CW", "CWCO", "CWT", "CXO", "D", "DAL", "DBD", "DCI", "DD", "DE", "DFS", "DG", "DGX", "DHI", "DHR", "DIS", "DISCA", "DISCK", "DISH", "DLR", "DLTR", "DOV", "DOW", "DPL", "DRE", "DRI", "DTE", "DUK", "DVA", "DVN", "DXC", "E", "EA", "EBAY", "EBF", "ECL", "ED", "EFX", "EGN", "EIX", "EL", "EMN", "EMR", "ENB", "EOG", "EQIX", "EQR", "EQT", "ES", "ESS", "ETFC", "ETN", "ETR", "EV", "EVRG", "EW", "EXC", "EXPD", "EXPE", "EXR", "F", "FANG", "FAST", "FB", "FBHS", "FCX", "FDO", "FDX", "FE", "FFIV", "FIS", "FISV", "FITB", "FLIR", "FLS", "FLT", "FMBI", "FMC", "FOX", "FOXA", "FPL", "FPU", "FRC", "FRME", "FRS", "FRT", "FTI", "FTNT", "FTV", "FULT", "G", "GCI", "GD", "GE", "GEF", "GGG", "GILD", "GIS", "GL", "GLW", "GM", "GMT", "GOOG", "GOOGL", "GPC", "GPN", "GPS", "GRC", "GRMN", "GS", "GVA", "GWW", "HAL", "HAS", "HBAN", "HBHC", "HBI", "HCA", "HD"};

        for (int i = 0; i < names.length; i++) {
            String url = "https://www.nasdaq.com/market-activity/stocks/spgi/dividend-history";
            String newUrl = url.replace("spgi", "" + names[i]);
            driver.get(newUrl);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            Thread.sleep(10000);
            try {
                currentDiv = driver.findElement(xpath
                        ("/html/body/div[4]/div/main/div/div[4]/div/div/div[2]" +
                                "/div[2]/div[2]/table/tbody/tr[1]/td[2]")).
                        getText().substring(1);

                previDiv = driver.findElement(xpath("//html/body/div[4]/div/main" +
                        "/div/div[4]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).
                        getText().substring(1);

                double CurrentNum = Double.parseDouble(currentDiv);
                double PreviNum = Double.parseDouble(previDiv);
                int Difference = (int) ((CurrentNum - PreviNum) / PreviNum * 100);
                System.out.println(i + ": " + names[i] + "" + ": " + Difference + "%");
            } catch (NoSuchElementException nosuchelementexception) {
                System.out.println("There is no histroy for " + names[i] + " company");
            }
        }
        driver.quit();
    }
}