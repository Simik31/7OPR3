package cz.osu.student.r19584.kip7opr3jsp;

import java.time.LocalDate;

public class Student {
    private String name;
    private String surname;
    private String student_number;
    private String email;
    private int phone_number;
    private String password;
    private Sex sex;
    private Hobby hobby;
    private LocalDate birthdate;

    public Student(String name, String surname, String student_number, String email, int phone_number, String password, Sex sex, Hobby hobby, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.student_number = student_number;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.sex = sex;
        this.hobby = hobby;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
