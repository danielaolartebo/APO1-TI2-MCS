package model;
public class Song extends MCS{
    // Atributes
    private String title;
    private String artistName;
    private String releasingDate;
    private double songLength;
	// Relations
    private Genre songGenre;
    private User userName;
    // Methods
	public Song(String userName, String title, String artistName, String releasingDate, double songLength, String songGenre){
        this.title = title;
        this.artistName = artistName;
        this.releasingDate = releasingDate;
        this.songLength = songLength;
        this.songGenre = Genre.valueOf(songGenre);
    }
    //Getters and setters
    public User getUserName(){
        return userName;
    }
    public void setUserName(User userName){
        this.userName = userName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName){
        this.artistName = artistName;
    }
    public String getReleasingDate(){
        return releasingDate;
    }
    public void setReleasingDate(String releasingDate){
        this.releasingDate = releasingDate;
    }
    public double getSongLength() {
        return songLength;
    }
    public void setSongLength(double songLength) {
        this.songLength = songLength;
    }
    public Genre getSongGenre(){
        return songGenre;
    }
    public void setSongGenre(Genre songGenre){
        this.songGenre = songGenre;
    }
    /**showSong
	* Method to print out songs. <br>
    * @return String message
    */
    public String showSong(){
        String message;
        message="************* Song ***************************\n" +
                "**  Title:"+ getTitle() + "*******************\n" +
                "**  Artist: "+ getArtistName() + "************\n" +
                "**  Releasing date: "+ getReleasingDate() + "*\n" +
                "**  Length: "+ getSongLength() +"*************\n" +
                "**  Genre: "+ getSongGenre() +"***************\n" +
                "**********************************************\n";
        return message;
    }    
}

