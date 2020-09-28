// Name:Dylan Walsh ID: R00167406
// Class: SD2-A 
// Lecturer: Dennis Long Labs: Paul Davern


public class Person {
    private Name name;
    private String phone;
    private String email;

    public Person(Name name, String phone, String email)
    {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Name:\n" + getName().toString() + "" +
                "Phone: " + getPhone() + "\n" +
                "Email: " + getEmail() + "\n";
    }
}
