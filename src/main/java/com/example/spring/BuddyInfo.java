package com.example.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Alexandre Hassan
 * @version March 03, 2022
 */
@Entity
public class BuddyInfo {
    private String name;
    private String phone;
    private Long addressBookId;

    @Id
    @GeneratedValue
    private Long id;

    public BuddyInfo() {
        this.name = "";
        this.phone = "";
        this.addressBookId = 0L;
    }

    public BuddyInfo(String name, String phone, Long addressBookId) {
        this.name = name;
        this.phone = phone;
        this.addressBookId = addressBookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressBookId() {
        return addressBookId;
    }

    public void setAddressBookId(Long addressBookId) {
        this.addressBookId = addressBookId;
    }

    @Override
    public String toString() {
        return "BuddyInfo [name=" + name + ", phone=" + phone + ", addressBookId=" + addressBookId + ", id=" + id + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo that = (BuddyInfo) o;
        return name.equals(that.name) &&
                phone.equals(that.phone) &&
                addressBookId.equals(that.addressBookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, addressBookId, id);
    }
}
