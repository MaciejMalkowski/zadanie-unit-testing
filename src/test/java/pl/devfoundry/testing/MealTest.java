package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {
        Meal meal = new Meal(35);

        int discountedPrice = meal.getDiscountedPrice(7);

        assertEquals(28, discountedPrice);
        assertThat(discountedPrice, equalTo(28));
    }

    @Test
    void referenceToTheSameObjectShouldBeEqual() {
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        assertSame(meal1, meal2);
    }

    @Test
    void referencesToDifferentObjectsShouldNotBeEqual() {
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        assertNotSame(meal1, meal2);
        assertThat(meal1, not(sameInstance(meal2)));
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pizza");

        assertEquals(meal1, meal2, "Checking if two meals are equal");
        assertThat(meal1, equalTo(meal2));
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice() {
        Meal meal = new Meal(8, "Soup");

        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(4));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 18})
    void mealShouldBeLowerThan20(int price) {
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createMealsWithNameAndPrice")
    void burgersShouldHaveCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));
    }

    private static Stream<Arguments> createMealsWithNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheeseburger", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNamesShouldEndWithCake(String name) {
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));
    }

    private static Stream<String> createCakeNames() {
        List<String> cakeNames = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
        return cakeNames.stream();
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 8})
    void mealShouldBeLowerThan10(int price) {
        if(price > 5)
        {
            throw new IllegalArgumentException();
        }
        assertThat(price, lessThan(20));
    }
}