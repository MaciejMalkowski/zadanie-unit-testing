package pl.devfoundry.testing;

public class Account {
    private boolean active;
    private Address defaultDeliveryAddress;

    public Account()
    {
        this.active = false;
    }

    public Account(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        if(defaultDeliveryAddress != null)
        {
            activate();
        }
        else
        {
            this.active = false;
        }
    }

    public Address getDefaultDeliveryAdress()
    {
        return defaultDeliveryAddress;
    }
    public void setDefaultDeliveryAdress(Address adress)
    {
        defaultDeliveryAddress = adress;
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
