import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Test {

    private MyFirstTest myFirstTest;
    private User anton;

    @BeforeClass
    public void setUpUser() {
        System.out.println("Set up test env");
        anton = new User("Anton", 30, true);
    }

    @org.testng.annotations.Test
    public void testSumm() {
        myFirstTest = new MyFirstTest();
        Assert.assertEquals(myFirstTest.summ(2, 2), 4, errorMessage());
    }

    @org.testng.annotations.Test
    public void testUserName() {
        Assert.assertEquals(anton.getName(), "Anton", errorMessage());

    }

    @org.testng.annotations.Test
    public void testUserAge() {
        Assert.assertEquals(anton.getAge(), 31, errorMessage());
    }

    @org.testng.annotations.Test
    public void testIsRegistered() {
        Assert.assertTrue(anton.getRegistered(), errorMessage());
    }

    @AfterTest
    public void cleanUp() {
        System.out.println("Cleared data");
        anton = null;
    }

    private String errorMessage () {
        return "Something wrong with test data";
    }
}
