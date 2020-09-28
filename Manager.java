// Name:Dylan Walsh ID: R00167406
// Class: SD2-A 
// Lecturer: Dennis Long Labs: Paul Davern


public class Manager extends Person {
    private String dateofbirth;
    private int rating;

    public Manager(Name name, String phone, String email, String dob, int rating)
    {
        super(name, phone, email);
        this.dateofbirth = dob;
        this.rating = rating;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public String getDateOfBirth()
    {
        return dateofbirth;
    }

    public String toString()
    {
        return super.toString()+"" +
                "Date of Birth: " + dateofbirth+"\n" +
                "Rating: " + getRating()+" Stars\n";
    }
}
