package model;
public class Restricted extends Playlist {
    String[] arrayUserName;
    public Restricted(String name, String[] arraySongs) {
        super(name);
	}
	public String[] getArrayUserName() {
        return arrayUserName;
    }
    public void setArrayUserName(String[] arrayUserName) {
        this.arrayUserName=arrayUserName;
    }
    /** lengthPlaylist
	* Method to add up restricted playlist´s length. <br>
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
        message="************* Restricted Playlist ********\n" +
                "**  Title:"+ getName() + "****************\n" +
                "**  Length: "+ (lengthPlaylist())+"*******\n" +
                "**  User name:"+ getArrayUserName() + "***\n" +
                "******************************************\n";
        return message;
    }
} 
