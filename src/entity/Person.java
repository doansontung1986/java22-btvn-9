package entity;

import java.util.Scanner;

public abstract class Person implements Inputable, Displayable {
    protected String name;
    protected String address;
    protected String phoneNumber;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập họ tên: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.println("Nhập số điện thoại: ");
        this.setPhoneNumber(new Scanner(System.in).nextLine());
    }

    @Override
    public abstract void displayInfo();
}
