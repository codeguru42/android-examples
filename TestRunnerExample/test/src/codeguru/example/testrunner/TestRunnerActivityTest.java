package codeguru.example.testrunner;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class codeguru.example.testrunner.TestRunnerActivityTest \
 * codeguru.example.testrunner.tests/android.test.InstrumentationTestRunner
 */
public class TestRunnerActivityTest extends ActivityInstrumentationTestCase2<TestRunnerActivity> {

    public TestRunnerActivityTest() {
        super("codeguru.example.testrunner", TestRunnerActivity.class);
    }

}
