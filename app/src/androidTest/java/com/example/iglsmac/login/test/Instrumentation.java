package com.example.iglsmac.login.test;

import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;

@CucumberOptions(
        features = "features",
        glue = "com.example.iglsmac.login.test")
public class Instrumentation extends MonitoringInstrumentation {
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        this.instrumentationCore.create(savedInstance);
        this.start();
    }

    @Override
    public void onStart(){
        super.onStart();

        waitForIdleSync();
        instrumentationCore.start();
    }
}
