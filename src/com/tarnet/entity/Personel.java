package com.tarnet.entity;

import com.tarnet.MenuItem;

public class Personel {
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private Department department;

    public Personel() { }

    public Personel(int id, String firstName, String lastName, String title, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return this.firstName +" "+ this.lastName;
    }

    public static class BuilderPersonel {
        private Personel personel;

        public BuilderPersonel() {
            this.personel = new Personel();
        }

        public Personel.BuilderPersonel withId(int id){
            this.personel.setId(id);
            return this;
        }
        public Personel.BuilderPersonel first(String first) {
            this.personel.setFirstName(first);
            return this;
        }
        public Personel.BuilderPersonel last(String last) {
            this.personel.setLastName(last);
            return this;
        }

        public Personel.BuilderPersonel title(String title) {
            this.personel.setTitle(title);
            return this;
        }



        public Personel.BuilderPersonel title(Department department) {
            this.personel.setDepartment(department);
            return this;
        }
    }

}
