package model;
public class User extends MCS{
    // Atributes
    private String userName;
    private String password;
    private int age;
    private String category;
    // Relations
    private double songLength;
    // Methods
	public User(String userName, int age, String password, double songLength)
	{
        this.songLength= songLength;
        this.userName = userName;
        this.age = age;
        this.password=password;
    }
    //Getters and setters
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
	}
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCategory(String category){
        this.category = category;
    }
    /**getCategory
	* Method to define category. <br>
    * @return String category
    */
    public String getCategory() {
        if(songLength<=3){
           category="NEWBIE";
        }else if(songLength>=3 && songLength<=10){
            category="TITTLE";
        }else if(songLength>=10 && songLength<=30){
            category="MILD";
        }else if(songLength>=30){
            category="STAR";
        }
        return category;
    }
    /**showUser
	* Method to print out users. <br>
    * @return String message
    */
    public String showUser(){
        String message;
        message="************* User *******************\n" +
                "**  UserName:"+ getUserName() + "*****\n" +
                "**  Age: "+ getAge() + "**************\n" +
                "**  Category: "+ getCategory() +"*****\n" +
                "**************************************\n";
        return message;
    }
}

