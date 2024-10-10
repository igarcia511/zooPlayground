package com.ps;

public class Animal {

    private String name;
    private String type;
    private String origin;
    private  int age;
    private boolean isPubliclyAvailable;

    public Animal(String name, String type, int age, String origin, boolean isPubliclyAvailable) {
        this.name = name;
        this.type = type;
        this.origin = origin;
        this.age = age;
        this.isPubliclyAvailable = isPubliclyAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPubliclyAvailable() {
        return isPubliclyAvailable;
    }

    public void setPubliclyAvailable(boolean publiclyAvailable) {
        isPubliclyAvailable = publiclyAvailable;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                ", age=" + age +
                ", isPubliclyAvailable=" + isPubliclyAvailable +
                '}';
    }
}
