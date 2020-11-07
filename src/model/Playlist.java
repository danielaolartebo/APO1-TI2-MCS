package model;
abstract public class Playlist extends MCS{
    // Atributes
    private String name;
    private double playlistLength;
    private String songGenre;
    private String[] arraySongs;
    // Relations
    // Methods
    public Playlist(String name) {
        this.name=name;
    }
	//Getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSongGenre(){
        return songGenre;
    }
    public void setSongGenre(String songGenre){
        this.songGenre=songGenre;
    }
    public String[] getSongs(){
        return arraySongs;
    }
    public void setSongs(String[] songs){
        arraySongs=songs;
    }
    public double getPlaylistLength(){
        return playlistLength;
    }
    public void setPlaylistLength(double playlistLength){
        this.playlistLength += playlistLength;
    }
    /** lengthPlaylist
	* Method to add up playlist length. <br>
	*<b>pre: </b> Playlist's length exists already. list!=null
	* <b>post: </b> Playlist length has been added successfully. <br>
	* @return double length
	*/
    public double lengthPlaylist(){
        double length = 0;
        for(int i = 0; i<numOfPlaylists(); i++){
            length+=numOfPlaylists();
            }
            return length;
    }
    /**showPlaylist
	* Method to print out playlists. <br>
    * @return String message
    */
    public String showPlaylist() {
        String message;
        message="************* Playlist *******************\n" +
                "**  Title:"+ getName() + "****************\n" +
                "**  Length: "+ (lengthPlaylist())+"*******\n" +
                "**  Genre: "+ getSongGenre() + "**********\n" +
                "*******************************************";
        return message;
    }
}