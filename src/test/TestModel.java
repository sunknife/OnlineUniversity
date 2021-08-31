package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import source.Model;

public class TestModel {
    private static Model model = new Model();

    @Test
    public void checkChosenNumber() {
        RunThousandTimes runThousandTimes = new RunThousandTimes();
        runThousandTimes.runThousandTimes();
    }

    @RunWith(Parameterized.class)
    public static class RunThousandTimes {

        @Parameterized.Parameters
        public static Object[][] data() {
            return new Object[1000][0];
        }

        public RunThousandTimes(){

        }

        @Test
        public void runThousandTimes(){
            model.generateChosenNumber();
            Assert.assertTrue(model.getChosenNumber() < Model.MAX_VALUE);
            Assert.assertTrue(model.getChosenNumber() > Model.MIN_VALUE);
        }
    }
}
