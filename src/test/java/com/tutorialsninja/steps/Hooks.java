package com.tutorialsninja.steps;


import com.tutorialsninja.propertyreader.PropertyReader;
import com.tutorialsninja.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));

    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] sceenshot = getScreenShot();
            scenario.attach(sceenshot,"image/png", scenario.getName());
        }

        closeBrowser();
    }

}
