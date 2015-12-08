package com.spadatech.nanodegree.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * Created by Ludens Machina on 12/6/2015.
 */

public class AsyncTaskTest extends AndroidTestCase {

    private static final String LOG_TAG = "NonEmptyStringTest";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

}

//public class AsyncTaskTest extends ApplicationTestCase<Application> implements EndpointsAsyncTask.OnJokeRetrievedListener{
//
//    private CountDownLatch mSignal;
//    private String mRetrievedJoke;
//
//    public AsyncTaskTest(Class<Application> applicationClass) {
//        super(applicationClass);
//    }
//
//    @Overrideadb shell pm list instrumentation
//    protected void setUp() throws Exception {
//        mSignal = new CountDownLatch(1);
//        EndpointsAsyncTask task = new EndpointsAsyncTask();
//        task.execute(this);
//        try {
//            mSignal.await();
//            assertFalse("Test Failed. Async Task retrieved an empty string.",
//                    mRetrievedJoke.isEmpty());
//        } catch (Exception ex) {
//            fail();
//        }
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        mSignal.countDown();
//    }
//
//    @Override
//    public void OnJokeRetrieved(String joke) {
//        mRetrievedJoke = joke;
//        mSignal.countDown();
//    }
//}
