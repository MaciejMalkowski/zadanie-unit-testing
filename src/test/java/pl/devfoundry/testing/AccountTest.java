package pl.devfoundry.testing;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.devfoundry.unittestingjava.Account;
import pl.devfoundry.unittestingjava.Address;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void newlyCreatedAccountShouldNotBeActive()
    {
        Account newAccount = new Account();

        assertFalse(newAccount.isActive());

        assertThat(newAccount.isActive(), equalTo(false));

        assertThat(newAccount.isActive(), is(false));

    }

    @Test
    void activatedAccountShouldHaveActiveFlagSet(){
        Account newAccount = new Account();

        newAccount.activate();

        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(), equalTo(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        Account account = new Account();

        Address address = account.getDefaultDeliveryAddress();

        assertNull(address);
    }



    @Test
    void givenAccountWhenCreatedThenNotActivate(){
        Account newAccount = new Account();

        assertFalse(newAccount.isActive(), "Check if new account is not active");
        assertThat
    }
    @Test
    void AccountShouldNotBeActiveAfterActivation()
    {

        Account newAccount = new Account();

        newAccount.isActive();

        assertTrue(newAccount.isActive());
    }
    }

