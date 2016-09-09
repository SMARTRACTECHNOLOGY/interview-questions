package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author voor
 */
@JsonIgnoreProperties(ignoreUnknown = false)
public class Stuff {

    private String firstName;

    private String lastName;

    private Integer age;

    public static Stuff.StuffBuilder builder() {
        return new Stuff.StuffBuilder();
    }

    public static class StuffBuilder {

        private String firstName;

        private String lastName;

        private Integer age;

        public StuffBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StuffBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StuffBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public Stuff build() {
            Stuff stuff = new Stuff();
            stuff.setAge(age);
            stuff.setFirstName(firstName);
            stuff.setLastName(lastName);
            return stuff;
        }
    }

    @Override
    public String toString() {
        return "Stuff{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName
                + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Stuff stuff = (Stuff) o;

        if (firstName != null ?
                !firstName.equals(stuff.firstName) :
                stuff.firstName != null)
            return false;
        if (lastName != null ? !lastName.equals(stuff.lastName) : stuff.lastName != null)
            return false;
        return age != null ? age.equals(stuff.age) : stuff.age == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
