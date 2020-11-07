package model;
public class Private extends Playlist {
    String userName;
	public Private(String name, String[] arraySongs) {
        super(name);
    }
	public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /** lengthPlaylist
	* Method to add up private playlist´s length. <br>
	*<b>pre: </b> Playlist's length exists already. list!=null
	* <b>post: </b> Playlist length has been added successfully. <br>
	* @return double length
	*/
    public double lengthPlaylist(){
        double length = 0;
        for(int i = 0; i<super.numOfPlaylists(); i++){
                length++;
        }
        return length;
    }
    /**showPlaylist
	* Method to print out playlists. <br>
    * @return String message
    */
    @Override
    public String showPlaylist() {
        String message;
        message="************* Private Playlist ***********\n" +
                "**  Title:"+ getName() + "****************\n" +
                "**  Length: "+ (lengthPlaylist())+"*******\n" +
                "**  User name:"+ getUserName() + "********\n" +
                "**  Genre: "+ getSongGenre() + "**********\n" +
                "******************************************\n";
        return message;
    }
}
