package pl.devfoundry.unittestingjava;

public class Account {
    private boolean active;
    private Address defaultDeliveryAdress;

    public Account()
    {
        this.active = false;
    }

    public Address getDefaultDeliveryAdress()
    {
        return defaultDeliveryAdress;
    }

    public void activate()
    {
        this.active = true;
    }

    public boolean isActive()
    {
        return this.active;
    }
}
