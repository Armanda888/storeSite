package com.theBeautiful.cassandra.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.google.common.collect.Lists;
import com.theBeautiful.model.Address;
import com.theBeautiful.model.User;

import java.util.List;
import java.util.Set;

@Table(keyspace = "bundles", name = "User")
public class UserEntity implements DBEntityInterface<User>{

    @PartitionKey(0)
    private String id;

    /* user login email */
    @PartitionKey(1)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @Frozen("list<frozen<AddressType>>")
    private List<AddressType> addresses;

    private String phoneNumber;

    /* if the user subscribed the newsletter or not. */
    private Boolean subscriber;

    private Set<String> orders;

    public UserEntity() {
    }

    public UserEntity(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        if (user.getPhoneNumber() != null) {
            this.phoneNumber = user.getPhoneNumber();
        }
        this.subscriber = user.getSubscriber();
        if (user.getOrders() != null) {
            this.orders = user.getOrders();
        }
        if (user.getAddresses() != null) {
            addresses = Lists.newArrayList();
            for (Address address : user.getAddresses()) {
                addresses.add(new AddressType(address));
            }
        }
    }


    @Override
    public User generate() {
        User user = new User();
        user.setId(this.id);
        user.setPassword(this.password);
        user.setEmail(this.email);
        if (this.firstName != null) {
            user.setFirstName(this.firstName);
        }
        if (this.lastName != null) {
            user.setLastName(this.lastName);
        }
        if (this.phoneNumber != null) {
            user.setPhoneNumber(this.phoneNumber);
        }
        if (this.addresses != null && !this.addresses.isEmpty()) {
            List addressList = Lists.newArrayList();
            for (AddressType addressType : this.addresses) {
                addressList.add(addressType.generate());
            }
            user.setAddresses(addressList);
        }
        if (this.orders != null) {
            user.setOrders(this.orders);
        }
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AddressType> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressType> addresses) {
        this.addresses = addresses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Boolean subscriber) {
        this.subscriber = subscriber;
    }

    public Set<String> getOrders() {
        return orders;
    }

    public void setOrders(Set<String> orders) {
        this.orders = orders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
