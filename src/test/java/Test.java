import org.testng.Assert;

public class Test {

    @org.testng.annotations.Test
    public void testSumm() {
        MyFirstTest myFirstTest = new MyFirstTest();
        Assert.assertEquals(myFirstTest.summ(2,4),4, "Sum is wrong" );
    }
}
