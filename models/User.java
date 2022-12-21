package models;

public class User {
    private String name;
    private int age;
    private Rating rating;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.rating = new Rating();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Rating getRating() {
        return this.rating;
    }
}
