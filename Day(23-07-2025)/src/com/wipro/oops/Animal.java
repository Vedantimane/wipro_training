package com.wipro.oops;

public abstract class Animal {
    private String name;
    private int age;
    private float size;
    private String gender;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public abstract void eating(String food);
    public abstract void drinking(String drink);

    // Non-abstract method (common for all animals)
    public void sleep() {
        System.out.println(getName() + " is sleeping.");
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", gender=" + gender + ", age=" + age + ", size=" + size + "]";
    }
}
