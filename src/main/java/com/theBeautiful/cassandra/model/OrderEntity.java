package com.theBeautiful.cassandra.model;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.theBeautiful.model.Order;
import com.theBeautiful.model.OrderStatus;

import java.util.Date;
import java.util.List;

@Table(keyspace = "bundles", name = "Orders")
public class OrderEntity implements DBEntityInterface<Order>{

    @PartitionKey
    private String id;

    /* id of the products for this order */
    private List<String> items;

    /* id of the user */
    private String userId;

    private String address;

    private Date orderDate;

    private String status;

    public OrderEntity() {
    }

    public OrderEntity(Order order, String partitionId, String partitionType) {
        this.id = order.getId();
        this.items = order.getItems();
        this.userId = order.getUserId();
        this.address = order.getAddress();
        this.orderDate = order.getOrderDate();
        if (order.getStatus() != null) {
            this.status = order.getStatus().toString();
        }
    }

    @Override
    public Order generate() {
        Order order = new Order();
        order.setId(this.id);
        order.setAddress(this.address);
        order.setUserId(this.userId);
        order.setOrderDate(this.orderDate);
        if (this.status != null) {
            order.setStatus(OrderStatus.valueOf(this.status));
        }
        order.setItems(this.items);

        return order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
