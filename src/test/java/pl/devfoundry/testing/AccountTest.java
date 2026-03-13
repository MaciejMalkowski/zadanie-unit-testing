package pl.devfoundry.testing;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.devfoundry.unittestingjava.Account;
import pl.devfoundry.unittestingjava.Address;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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



}

