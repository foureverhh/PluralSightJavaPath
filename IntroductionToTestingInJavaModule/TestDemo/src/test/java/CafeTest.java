import com.monotonic.testing.m2.Cafe;
import com.monotonic.testing.m2.Coffee;
import com.monotonic.testing.m2.CoffeeType;
import org.hamcrest.Matchers;
import org.junit.*;

public class CafeTest {


    public static final int ESPRESSO_BEANS = 7;
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    private Cafe cafe;
    /*
    public CafeTest(){
        System.out.println("Constructor");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }

     @After
    public void after(){
        System.out.println("after");
    }
    */
    @Before
    public void before(){
        //System.out.println("before");
        cafe = new Cafe();
    }



    @Test
    public void canBrewEspresso(){
        //Given clause, preconditions of the test.
        //Cafe cafe = cafeWithBeans();
        withBeans();

        //When clause, the behavior.
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        //it is a espresso
        //no milk
        //that we've got enough coffee

        //Then clause, the post-condition, to assert
        Assert.assertThat(coffee, Matchers.hasProperty("beans",Matchers.equalTo(ESPRESSO_BEANS)));
        Assert.assertEquals("Wrong number of beans",CoffeeType.Espresso,coffee.getType());
        Assert.assertEquals("Wrong number of milk",NO_MILK,coffee.getMilk());
        Assert.assertEquals("Wrong coffee type",ESPRESSO_BEANS,coffee.getBeans());
    }



    @Test
    public void brewingEspressoConsumeBeans(){
        //Given
       // Cafe cafe = cafeWithBeans();
        withBeans();

        //When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //Then
        Assert.assertEquals(ESPRESSO_BEANS,coffee.getBeans());
        Assert.assertEquals(NO_BEANS,cafe.getBeansInStock());
    }

    //@Test(expected = IllegalArgumentException.class)
    @Test(expected = IllegalStateException.class)
    public void lattesRequiredMilk(){
        //given
        //Cafe cafe = cafeWithBeans();
        withBeans();
        //cafe.restockMilk(17);

        //when
        cafe.brew(CoffeeType.Latte);
    }

    @Test
    public void canBrewLatte(){
        //Given
      //  Cafe cafe = new Cafe();
        cafe.restockMilk(100);
        cafe.restockBeans(100);

        //when
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        //then
        Assert.assertEquals("Wrong coffee type",CoffeeType.Latte,coffee.getType());

    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk(){
        //Given
       // Cafe cafe = new Cafe();

        //When
        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBean(){
        //Given
       // Cafe cafe = new Cafe();

        //When
        cafe.restockBeans(NO_BEANS);
    }

    private void withBeans() {
        cafe.restockBeans(ESPRESSO_BEANS);
    }
}
