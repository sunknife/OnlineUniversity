package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import source.Model;

public class TestModel {
    private static Model model;

    @BeforeClass
    public static void Preparation() {
        model = new Model();
    }


    @Test
    public void checkChosenNumber() {
        model.generateChosenNumber();
        Assert.assertTrue(model.getChosenNumber() < Model.MAX_VALUE);
        Assert.assertTrue(model.getChosenNumber() > Model.MIN_VALUE);
    }
}