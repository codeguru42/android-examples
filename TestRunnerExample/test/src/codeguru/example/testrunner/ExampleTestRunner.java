/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package codeguru.example.testrunner;

import android.test.InstrumentationTestRunner;
import junit.framework.TestSuite;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class ExampleTestRunner extends InstrumentationTestRunner {

    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new TestSuite();
        suite.addTest(new TestRunnerActivityTest());
        return suite;
    }
}
