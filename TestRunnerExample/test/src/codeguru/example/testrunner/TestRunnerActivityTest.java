/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package codeguru.example.testrunner;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import junit.framework.Assert;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class TestRunnerActivityTest extends ActivityInstrumentationTestCase2<TestRunnerActivity> {

    public TestRunnerActivityTest() {
        super(TestRunnerActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.activity = this.getActivity();
    }

    public void testPreconditions() {
        Assert.assertNotNull(this.activity);
    }
    private Activity activity = null;
}
