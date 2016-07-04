package tech.niuchuang.mall.entity;

public class Person {

    private String gender;
    private String firstName;
    private String lastName;
    private int age;
    private int iconResId;

    public Person(String firstName, String lastName, int iconResId) {
        this.firstName = firstName;
        this.iconResId = iconResId;
        this.lastName = lastName;
    }

    public int getIconResId() {

        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}