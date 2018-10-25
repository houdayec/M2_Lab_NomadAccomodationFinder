package com.universita.corsica.nomadaccomodationfinder.model;

/**
 * Class that describes a user
 */
public class User {

    /**
     * INTERN STATE
     */
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private int phoneNumber;
    private String urlPhoto;
    private String address;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public User() {
    }

    /**
     * GETTERS AND SETTERS
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * FLUENT API
     */
    public User withId(String id){
        setId(id);
        return this;
    }

    public User withFirstname(String firstname){
        setFirstName(firstname);
        return this;
    }

    public User withEmail(String email){
        setEmail(email);
        return this;
    }

    /**
     * OVERRIDED METHODS
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (phoneNumber != user.phoneNumber) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (urlPhoto != null ? !urlPhoto.equals(user.urlPhoto) : user.urlPhoto != null) return false;
        return address != null ? address.equals(user.address) : user.address == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + phoneNumber;
        result = 31 * result + (urlPhoto != null ? urlPhoto.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
