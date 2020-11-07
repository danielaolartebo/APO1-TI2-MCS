package model;
public class Public extends Playlist {
    private int[] rate;
	public Public(String name, String[] arraySongs) {
        super(name);
    }
	public int[] getRate(){
        return rate;
    }
    public void setRate(int[] rate){
        this.rate=rate;
    }
    /** lengthPlaylist
	* Method to add up public playlist´s length. <br>
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
        message="************* Public Playlist ************\n" +
                "**  Title:"+ getName() + "****************\n" +
                "**  Length: "+ (lengthPlaylist())+"*******\n" +
                "**  Genre: "+ getSongGenre() + "**********\n" +
                "**  Rate:"+ getRate() + "*****************\n" +
                "******************************************\n";
        return message;
    }
} 

