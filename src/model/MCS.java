package model;
public class MCS{
   //Constants
    public final static int MAXUSERS = 10;
    public final static int MAXSONGS = 50;
    public final static int MAXPLAYLISTS = 20;
    //Atributes 
    private Playlist[] playlists;
    private Song[] songs;
    private User[] users;
    public MCS(){
        playlists = new Playlist[MAXPLAYLISTS];
        songs = new Song[MAXSONGS];
        users = new User[MAXUSERS];
    }
    /** usersHasSpace
	* Method to validate user's space. <br>
	*<b>pre: </b> User's array exists already. list!=null
	* <b>post: </b> User objet has been validated in the array. <br>
	* @return boolean space
	*/
    public boolean usersHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAXUSERS; i++){
            if(users[i] == null){
                space = true;
            }
        }
        return space;
    }
    /** usersFindSpace
	* Method to find user's space. <br>
	* <b>post: </b> User objet has been found in the array. <br>
	* @return boolean index
	*/
    public int usersFindSpace(){
        boolean founded = false;
        int index = 0;
        for(int i = 0; i<MAXUSERS && founded == false; i++){
            if(users[i] == null){
                founded = true;
                index = i;
            }
        }
        return index;
    }
    /** songsHasSpace
	* Method to validate song's space. <br>
	*<b>pre: </b> Song's array exists already. list!=null
	* <b>post: </b> Song objet has been validated in the array. <br>
	* @return boolean space
	*/
    public boolean songsHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAXSONGS; i++){
            if(songs[i] == null){
                space = true;
            }
        }
        return space;
    }
    /** songsFindSpace
	* Method to find song's space. <br>
	* <b>post: </b> Song objet has been found in the array. <br>
	* @return boolean index
	*/
    public int songsFindSpace(){
        boolean founded = false;
        int index = 0;
        for(int i = 0; i<MAXSONGS && founded == false; i++){
            if(songs[i] == null){
                founded = true;
                index = i;
            }
        }
        return index;
    }
    /** playlistsHasSpace
	* Method to validate playlist's space. <br>
	*<b>pre: </b> Playlist's array exists already. list!=null
	* <b>post: </b> Playlist objet has been validated in the array. <br>
	* @return boolean space
	*/
    public boolean playlistsHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAXPLAYLISTS && !space; i++){
            if(playlists[i] == null){
                space = true;
            }
        }
        return space;
    }
    /** playlistsFindSpace
	* Method to find playlist's space. <br>
	* <b>post: </b> Playlist objet has been found in the array. <br>
	* @return boolean index
	*/
    public int playlistsFindSpace(){
        boolean founded = false;
        int index = 0;
        for(int i = 0; i<MAXPLAYLISTS && founded == false; i++){
            if(playlists[i] == null){
                founded = true;
                index = i;
            }
        }
        return index;
    }
    /** searchPlaylist
	* Method to find playlist in playlist. <br>
    *<b>pre: </b> Playlist's name exists already. list!=null
    * @param name - playlist's name - name != null
	* @return int position
	*/
    public int searchPlaylist(String name){
        int position=-1;
        boolean founded=false;
        boolean isNull=false;
        for(int i=0; i<playlists.length && !founded && !isNull; i++){
            if(playlists[i]!=null){
                if(playlists[i].getName().equals(name)){
                    position=i;
                    founded=true;
                }
            }else{
                isNull=true;
            }
            
        }
        return position;
    }
    /** searchUser
	* Method to find user in playlist. <br>
    *<b>pre: </b> User's name exists already. list!=null
    * @param name - User's name - name != null
	* @return int position
	*/
    public int searchUser(String name){
        int position=-1;
        boolean founded=false;
        boolean isNull=false;
        for(int i=0; i<playlists.length && !founded && !isNull; i++){
            if(playlists[i]!=null){
                if(playlists[i].getName().equals(name)){
                    position=i;
                    founded=true;
                }
            }else{
                isNull=true;
            }
            
        }
        return position;
    }
    /** searchSong
	* Method to find song in playlist. <br>
    *<b>pre: </b> Song's name exists already. list!=null
    * @param name - Song's name - name != null
	* @return int position
	*/
    public int searchSong(String name){
        int position=-1;
        boolean founded=false;
        boolean isNull=false;
        for(int i=0; i<playlists.length && !founded && !isNull; i++){
            if(playlists[i]!=null){
                if(playlists[i].getName().equals(name)){
                    position=i;
                    founded=true;
                }
            }else{
                isNull=true;
            }
        }
        return position;
    }
    /** searchSong2
	* Method to find song in songs. <br>
    *<b>pre: </b> Song's name exists already. list!=null
    * @param name - Song's name - name != null
	* @return int position
	*/
    public int searchSong2(String title){
        int position2=-1;
        boolean founded=false;
        boolean isNull=false;
        for(int i=0; i<songs.length && !founded && !isNull; i++){
            if(songs[i]!=null){
                if(songs[i].getTitle().equals(title)){
                    position2=i;
                    founded=true;
                }
            }else{
                isNull=true;
            }
        }
        return position2;
    }
    /**addUser
	* Method to add user. <br>
    * <b>pre: </b> User's name, age, password, songLength exists already. list!=null
	* <b>post: </b> User objet has been created successfully. <br>
    * @param name - User's userName - userName != null
    * @param age - User's age - age != 0
    * @param password - User's password - password != null
    * @param songLength - User's songLength - songLength != 0
	*/
    public void addUser(String userName, int age, String password, double songLength){
        int index = playlistsFindSpace();
        users[index] = new User(userName, age, password, songLength);
    }
    /**addSong
	* Method to add song. <br>
    * <b>pre: </b> Song's userName, title, artistName, releasingDate, songLength, songGenre exists already. list!=null
	* <b>post: </b> Song objet has been created successfully. <br>
    * @param name - User song's userName - userName != null
    * @param title - Song's title - title != null
    * @param artistName - Song's artistName - artistName != null
    * @param releasingDate - Song's releasingDate - releasingDate != null
    * @param songLength - Song's songLength - songLength != 0
    * @param songGenre - Song's songGenre - songGenre != null
	*/
    public boolean addSong(String userName, String title, String artistName, String releasingDate, double songLength, String songGenre){
        boolean founded=false;
        for(int i=0; i<songs.length && !founded; i++){
            if(songs[i]==null){
                songs[i] = new Song(userName, title, artistName, releasingDate, songLength, songGenre);
                founded=true;
            }
        }
        return founded;
    } 
    /**addPrivatePlaylist
	* Method to add private playlist. <br>
    * <b>pre: </b> Playlist's name exists already. list!=null
	* <b>post: </b> Playlist objet has been created successfully. <br>
    * @param name - Playlist song's name - name != null
	*/
    public void addPrivatePlaylist(String name) { //PRIVATE
        int index = playlistsFindSpace();
        playlists[index] = new Private(name, null);
    }
    /**addPrivatePlaylist
	* Method to add private playlist. <br>
    * <b>pre: </b> Playlist's position, songLength, genre, arraySongs, position2 exists already. list!=null
	* <b>post: </b> Playlist objet has been created successfully. <br>
    * @param position - Playlist's position - position != 0
    * @param songLength - Playlist's songLength - songLength != 0
    * @param genre - Playlist's genre- genre != null
    * @param arraySongs - Playlist's arraySongs - arraySongs != null
    * @param position2 - Playlist's position2  - position2  != 0
	*/
    public void addPrivatePlaylist(int position, double songLength, String genre, String[] arraySongs, int position2){ //PRIVATE
        playlists[position].setSongs(arraySongs);
    }
    /**addPublicPlaylist
	* Method to add public playlist. <br>
    * <b>pre: </b> Playlist's name exists already. list!=null
	* <b>post: </b> Playlist objet has been created successfully. <br>
    * @param name - Playlist song's name - name != null
	*/
    public void addPublicPlaylist(String name) { //PUBLIC
        int index = playlistsFindSpace();
        playlists[index] = new Public(name, null);
    }
    /**addPublicPlaylist
	* Method to add public playlist. <br>
    * <b>pre: </b> Playlist's position, songLength, genre, rate, arraySongs, position2 exists already. list!=null
	* <b>post: </b> Playlist objet has been created successfully. <br>
    * @param position - Playlist's position - position != 0
    * @param songLength - Playlist's songLength - songLength != 0
    * @param genre - Playlist's genre- genre != null
    * @param rate - Playlist's rate- genre != 0
    * @param arraySongs - Playlist's arraySongs - arraySongs != null
    * @param position2 - Playlist's position2  - position2  != 0
	*/
    public void addPublicPlaylist(int position, double songLength, String genre, int[] rate, String[] arraySongs, int position2){ //PUBLIC
        playlists[position].setSongs(arraySongs);
    }
    /**addPublicPlaylist
	* Method to add restricted playlist. <br>
    * <b>pre: </b> Playlist's name exists already. list!=null
	* <b>post: </b> Playlist objet has been created successfully. <br>
    * @param name - Playlist song's name - name != null
	*/
    public void addRestrictedPlaylist(String name) { //RESTRICTED
        int index = playlistsFindSpace();
        playlists[index] = new Restricted(name, null);
    }
    /**addRestrictedPlaylist
	* Method to add restricted playlist. <br>
    * <b>pre: </b> Playlist's position, songLength, genre, rate, arraySongs, position2 exists already. list!=null
	* <b>post: </b> Playlist objet has been created successfully. <br>
    * @param position - Playlist's position - position != 0
    * @param songLength - Playlist's songLength - songLength != 0
    * @param genre - Playlist's genre- genre != null
    * @param arrayName - Playlist's arrayName- arrayName != null
    * @param arraySongs - Playlist's arraySongs - arraySongs != null
    * @param position2 - Playlist's position2  - position2  != 0
	*/
    public void addRestrictedPlaylist(int position, double songLength, String genre, String[] arrayName, String[] arraySongs, int position2){ //RESTRICTED
        playlists[position].setSongs(arraySongs);
    }
    /**numOfUsers
	* Method to add up num of users. <br>
    * <b>pre: </b> Class User exists already
    * @return int quantity
    */
    public int numOfUsers(){
        int quantity = 0;
        for(int i = 0; i<MAXUSERS; i++){
            if(users[i] instanceof User){
                quantity++;
            }
        }
        return quantity;
    }
    /**numOfSongs
	* Method to add up num of songs. <br>
    * <b>pre: </b> Class Song exists already
    * @return int quantity
    */
    public int numOfSongs(){
        int quantity = 0;
        for(int i = 0; i<MAXSONGS; i++){
            if(songs[i] instanceof Song){
                quantity++;
            }
        }
        return quantity;
    }
    /**numOfPlaylists
	* Method to add up num of playlists. <br>
    * <b>pre: </b> Class Playlist exists already
    * @return int quantity
    */
    public int numOfPlaylists(){
        int quantity = 0;
        for(int i = 0; i<MAXPLAYLISTS; i++){
            if(playlists[i] != null){
                quantity++;
            }
        }
        return quantity;
    }
    /**showUser
	* Method to print out users. <br>
    * @return String showUser
    */
    public String showUser(){
        String showUser = "********Users********\n";
        for(int i = 0; i<numOfUsers(); i++){
                showUser += (i+1)+". Username: "+users[i].getUserName()+"\n   Age: "+users[i].getAge()+"\n   Category: "+users[i].getCategory()+"\n*********************";
        }
        return showUser;
    }
    /**showSongs
	* Method to print out songs. <br>
    * @return String showSongs
    */
    public String showSong(){
        String showSong = "********Songs********\n";
        for(int i = 0; i<numOfSongs();i++){
                showSong += (i+1)+". Title: "+songs[i].getTitle()+"\n   Artist's name: "+songs[i].getArtistName()+"\n   Releasing date: "+songs[i].getReleasingDate()+"\n   Length: "+songs[i].getSongLength()+"\n   Genre: "+songs[i].getSongGenre()+"\n*********************\n";
        }
        return showSong;
    }
    /**showPlaylist1
	* Method to print out playlists. <br>
    * @return String message
    */
    public String showPlaylist1(){
        String message="***************Playlists******************\n";
        boolean isNull=false;
        for(int i=0; i<MAXPLAYLISTS && !isNull; i++){
            if(playlists[i]==null){
                isNull = true;
            }else{
                message += playlists[i].showPlaylist();
            }
        }
        return message;
    }
}
