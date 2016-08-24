package com.wurensen.freejuhe;

import android.test.ApplicationTestCase;

import com.wurensen.freejuhe.application.CustomApplication;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<CustomApplication> {
    public ApplicationTest() {
        super(CustomApplication.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
    }
}