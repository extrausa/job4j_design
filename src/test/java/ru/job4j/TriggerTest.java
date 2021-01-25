package ru.job4j;


import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class TriggerTest extends TestCase {

    @Test
    public void test() {
        Assert.assertEquals(1, new Trigger().someLogic());
    }

}