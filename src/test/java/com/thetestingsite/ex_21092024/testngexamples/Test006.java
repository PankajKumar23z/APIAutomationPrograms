package com.thetestingsite.ex_21092024.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test006 {

    @Test(groups = {"qa","preprod", "reg"})
    public void sanityRun() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true); // just to showcase Assert used
    }
    @Test(groups = {"dev", "Stage"})
    public void RegRun() {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups =  {"sanity", "qa", "preprod"})
    public void sanityRun1() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test(groups = {"qa","preprod", "reg"})
    public void RegRun2(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups = {"dev","stage"})
    public void SmokeRun3() {
        System.out.println("Smoke");
        Assert.assertTrue(false);


    }



}

