package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;
import pl.devfoundry.unittestingjava.Meal;

import javax.swing.plaf.metal.MetalLabelUI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {
        Meal meal = new Meal(35);

        int discountedPrice = meal.getDiscountedPrice(7);

        assertEquals(28, discountedPrice);
        assertThat(discountedPrice).isEqualTo(28)
    }

    @Test
    void referenceToTheSameObjectShouldBeEqaul()
    {
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        assertSame(meal1, meal2);
    }

    @Test
    void referencesToDiffrentObjectsShouldNotBeEqual()
    {
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        assertNotSame(meal1,meal2);
        assertThat(meal1).isNotSameAs(meal2);
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame()
    {
        Meal meal1 = new Meal(10,"Pizza");
        Meal meal2 = new Meal(10,"Pizza");

        assertEquals(meal1, meal2, "Checking if two meals are equal");
        assertThat(meal1).isEqualTo(meal2);
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice()
    {
        Meal meal = new Meal(8, "Soup");


        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(4))
    }
}