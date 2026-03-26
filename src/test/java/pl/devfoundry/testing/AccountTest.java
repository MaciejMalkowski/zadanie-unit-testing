package pl.devfoundry.testing;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Tag("fries")
class AccountTest {
    @Test
    void newlyCreatedAccountShouldNotBeActive()
    {
        Account newAccount = new Account();

        assertFalse(newAccount.isActive());

        assertThat(newAccount.isActive(), equalTo(false));

        assertThat(newAccount.isActive()).isFalse();

    }

    @Test
    void activatedAccountShouldHaveActiveFlagSet(){
        Account newAccount = new Account();

        newAccount.activate();

        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        Account account = new Account();

        Address address = account.getDefaultDeliveryAdress();

        assertNull(address);
        assertThat(address).isNull();
    }
    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){
        Address address = new Address("Kraków", "67c");
        Account account = new Account();
        account.setDefaultDeliveryAdress(address);
        Address defaultAddress = account.getDefaultDeliveryAdress();
        assertNotNull(defaultAddress);
        assertThat(defaultAddress).isNotNull();
    }

    @RepeatedTest(25)
    void newAccountWithNotNullAdressShouldBeActive()
    {
        Address adress = new Address("Puławska", "46/6");
        Account account = new Account(adress);
        assumingThat(adress != null, () -> {
            assertTrue(account.isActive());
        });
    }

}

