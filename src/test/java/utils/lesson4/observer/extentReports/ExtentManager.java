package utils.lesson4.observer.extentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}
