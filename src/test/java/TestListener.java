import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.SeleniumHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On test success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test failure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test failed but with success percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
    }
}
