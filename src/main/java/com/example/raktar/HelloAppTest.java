package com.example.raktar;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloAppTest {
    public static Boolean isRunningTest = false;

    @BeforeClass
    public  static void testBeforeOnce() {
        System.out.println("BeforeClass");
        isRunningTest = true;
    }

    @AfterClass
    public static void testAfterOnce() {
        System.out.println("AfterClass");
        isRunningTest = false;
    }

    @Test
    public void  testMain() {
        HelloApplication.main(null);
    }

    @Test
    public void testStart() {
        HelloApplication app = new HelloApplication();
        try {
            app.start(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testController() {
        HelloController controller = new HelloController();
        controller.initialize();

        controller.AddRaktar1(null);
        controller.AddRaktar2(null);
        controller.OnCsere1(null);
        controller.OnCsere2(null);
        controller.OnMentes(null);
        controller.OnTorol1(null);
        controller.OnTorol2(null);
    }
}
