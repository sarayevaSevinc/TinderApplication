package MyProject.entity;

import java.util.Objects;

public class User {
     int id;
     String fullName;
     String gender;
     String password;
     String email;
     String urlPhoto;
     String position;

    public String getUrlPhoto() {
        return this.urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String fullName, String gender,String password,  String email, String urlPhoto, String position  ) {
        this.fullName = fullName;
        this.gender = gender;
        this.position = position;
        this.password = password;
        this.email = email;
        this.urlPhoto = urlPhoto;
    }

    public User(int id, String fullName, String gender, String password, String email, String urlPhoto, String position) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.urlPhoto = urlPhoto;
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id" + id+
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", position='" + position + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                this.fullName.equals(user.fullName) &&
                this.gender.equals( user.gender) &&
                this.password.equals(user.password) &&
                this.email.equals( user.email) &&
        this.urlPhoto.equals( user.urlPhoto) &&
                this.position.equals( user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, gender, password, email, urlPhoto, position);
    }
}
