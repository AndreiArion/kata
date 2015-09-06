package kata.supermarket;


import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SupermarketTest {

    Supermarket market = new Supermarket();

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMin() {
        Assertions.assertThat(market.min()).isEqualTo(true);
    }
}