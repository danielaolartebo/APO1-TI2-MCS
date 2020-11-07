/**
 * Universidad Icesi (Cali - Colombia)
 * Algoritmos y programacion I
 * Tarea Integradora 2
 * @Author: Daniela Olarte Borja A00368359
 * @Date: 07/11/2020
 */
package ui;
import java.util.Scanner;
import model.MCS;
public class Main {
    private MCS thisMcs;
    private Scanner lector;
    private double songLength;
    private String genre;
    public Main(){
        lector = new Scanner(System.in);
        songLength=0;
        genre="";
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.thisMcs = new MCS();
        int option = 0;
        do{
            main.showMenu();
            option = main.lector.nextInt();
            main.executeOperation(option);
        } while(option != 0);
    }
    /** showMenu
	* Method to show main menu. <br>
	*/
    public void showMenu(){
        System.out.print("Choose an option to proceed:    \n" +
                        "(1) register users               \n" +
                        "(2) register songs               \n" +
                        "(3) create playlist              \n" +
                        "(4) add song to playlist         \n" +
                        "(5) show users                   \n" +
                        "(6) show songs                   \n" +
                        "(7) show playlists               \n" +
                        "(8) EXIT                         \n");
    }
    /** executeOperation
    * Method to execute menu´s option selection by user. <br>
    * @param option - User's option - option != 
	*/
    public void executeOperation(int option){
        lector.nextLine();
        boolean space = false;
        switch(option){
            case 1:
                space = thisMcs.usersHasSpace();
                if(space == true){
                    showUserTypeMenu();
                } else{
                    System.out.println("Not enough space");
                }
            break;
            case 2:
                space = thisMcs.songsHasSpace();
                if(space == true){
                    showSongTypeMenu();
                    option = lector.nextInt();
                } else{
                    System.out.println("Not enough space");
                }
            break;
            case 3:
                space = thisMcs.playlistsHasSpace();
                    if(space == true){
                        showPlaylistTypeMenu();
                        option = lector.nextInt();
                        executePlaylistOperation(option);
                    } 
                    else{
                        System.out.println("Not enough space");
                    }
            break;
            case 4: 
                space = thisMcs.playlistsHasSpace();
                        if(space == true){
                            showPlaylistTypeMenu();
                            option = lector.nextInt();
                            executeAddPlaylistOperation(option);
                        } 
                        else{
                            System.out.println("Not enough space");
                        }
            break;
            case 5:showUser();
            break;
            case 6:showSong();
            break;
            case 7:showPlaylist2();
            break;
            case 8: System.out.println("Have a great day!");
			break;
			default: System.out.println("Error. Select a valid option");
        }
    }
    /** showUserTypeMenu
	* Method to show user registration menu. <br>
	*/
    public void showUserTypeMenu() {
        System.out.println("Type in username or nick name");
    	String userName=lector.nextLine().toUpperCase();
    	System.out.println("Type in password");
        String password=lector.nextLine().toUpperCase();
        System.out.println("Type in age");
        int age=lector.nextInt();
        lector.nextLine();
        thisMcs.addUser(userName, age, password, songLength);
    }
    /** showSongTypeMenu
	* Method to show song registration menu. <br>
	*/
    public String showSongTypeMenu(){
        System.out.println("Type in username or nick name");
    	String userName=lector.nextLine().toUpperCase();
        System.out.println("Type in title");
    	String title=lector.nextLine().toUpperCase();
    	System.out.println("Type in artist name");
        String artistName=lector.nextLine().toUpperCase();
        System.out.println("Type in releasing date");
        String releasingDate=lector.nextLine().toUpperCase();
        System.out.println("Type in song length");
        songLength=lector.nextDouble();
        System.out.println("Type in gender:\n" +
                            "(1) METAL         \n" +
                            "(2) SALSA         \n" + 
                            "(3) REGGAE        \n" +
                            "(4) HIPHOP        \n" + 
                            "(5) ROCK          \n" +
                            "(6) POP           \n" +
                            "(7) CLASSIC       \n" );
        int option=lector.nextInt();
        String genre="";
        switch(option){
            case 1:    
                genre = "METAL";
            break;
            case 2: 
                genre = "SALSA";
            break;
            case 3: 
                genre = "REGGAE";
            break;
            case 4:
                genre = "HIPHOP";
            break;
            case 5:
                genre = "ROCK";
            break;
            case 6:
                genre = "POP";
            break;
            case 7:
                genre = "CLASSIC";
            break;
        }
        thisMcs.addSong(userName, title, artistName, releasingDate, songLength, genre);
        return title;
    }
    /** showPlaylistTypeMenu
	* Method to show playlist registration menu. <br>
	*/
    public void showPlaylistTypeMenu(){
        System.out.print("Type in service:      \n" +
                        "(1) PRIVATE            \n" +
                        "(2) PUBLIC             \n" + 
                        "(3) RESTRICTED         \n" );
    }
    /** executePlaylistOperation
	* Method to execute playlist's option menu to create a certain playlist. <br>
	*/
    public void executePlaylistOperation(int option){
        lector.nextLine();
        switch (option){
            case 1: createPrivatePlaylist();
            break;
            case 2: createPublicPlaylist();
            break;
            case 3: createRestrictedPlaylist();
            break;
            default: 
            System.out.println("Type in valid option");
        }
    }
    /** executeAddPlaylistOperation
	* Method to execute playlist's option menu to add song to playlist. <br>
	*/
    public void executeAddPlaylistOperation(int option){
        lector.nextLine();
        switch (option){
            case 1: addPrivatePlaylist();
            break;
            case 2: addPublicPlaylist();
            break;
            case 3: addRestrictedPlaylist();
            break;
            default: 
            System.out.println("Type in valid option");
        }
    }
    /** createPrivatePlaylist
    * Method to show playlist's private menu. <br>
    * @return String name
	*/
    public String createPrivatePlaylist(){ //PRIVATE
        int position=0;
        String name;
        do{
            System.out.println("Type in name for the playlist");
            name = lector.nextLine().toUpperCase();
            position = thisMcs.searchPlaylist(name);
            if(position!=-1){
                System.out.println("There is a playlist with the name "+name);
            }
        }while(position!=-1);
        thisMcs.addPrivatePlaylist(name);
        return name;  
    }
    /** addPrivatePlaylist
    * Method to show playlist's private menu to add song to playlist. <br>
	*/
    public void addPrivatePlaylist(){ //PRIVATE
        int position=0;
        int position2=0;
        do{
            System.out.println("Type in the name of the playlist");
            String name = lector.nextLine().toUpperCase();
            position = thisMcs.searchPlaylist(name);
            if(position==-1){
                System.out.println("There is no playlist with the name "+name);
            }
        }while(position==-1);
        String[]arraySongs = new String [50];
        System.out.println("How many songs would you like to add? (Maximum 50 songs)");
        int amountSongs=lector.nextInt();
        lector.nextLine();
        for(int i=0; i<amountSongs && i<50; i++) {
        do{
            System.out.println("Type in the name of song #"+(i+1)+"");
            arraySongs[i] = lector.nextLine().toUpperCase();
            lector.nextLine();
            position2=thisMcs.searchSong2(arraySongs[i]);
            if(position2==-1){
                System.out.println("There is no song with the name "+arraySongs[i]);
            }
        }while(position2==-1);
        thisMcs.addPrivatePlaylist(position, songLength, genre, arraySongs, position2);
        }
    }
    /** createPublicPlaylist
    * Method to show playlist's public menu. <br>
    * @return String name
	*/
    public String createPublicPlaylist(){ //PUBLIC 
        int position=0;
        String name;
        do{
            System.out.println("Type in name for the playlist");
            name = lector.nextLine().toUpperCase();
            position = thisMcs.searchPlaylist(name);
            if(position!=-1){
                System.out.println("There is a playlist with the name "+name);
            }
        }while(position!=-1);
        thisMcs.addPublicPlaylist(name);
        return name;
    }
    /** addPublicPlaylist
    * Method to show playlist's public menu to add song to playlist. <br>
	*/
    public void addPublicPlaylist(){ //PUBLIC 
        int position=0;
        int position2=0;
        String title="";
        do{
            System.out.println("Type in the name of the playlist");
            String name = lector.nextLine().toUpperCase();
            position = thisMcs.searchPlaylist(name);
            if(position==-1){
                System.out.println("There is no playlist with the name "+name);
            }
        }while(position==-1);
        int[]rate = new int [position];
        System.out.println("Type in rate of the playlist (1 to 5)");
        for(int i=0; i<position; i++){
            rate[position] = lector.nextInt();
        }
        while(rate[position]!=1 && rate[position]!=2 && rate[position]!=3 && rate[position]!=4 && rate[position]!=5){
            System.out.println("Type in valid option");
            lector.nextInt();
        }
        String[]arraySongs = new String [50];
        System.out.println("How many songs would you like to add? (Maximum 50 songs)");
        int amountSongs=lector.nextInt();
        for(int i=0; i<amountSongs && i<50; i++) {
            do{  
                System.out.println("Type in the name of song #"+(i+1)+"");
                arraySongs[i] = lector.nextLine().toUpperCase();
                lector.nextLine();
                position2=thisMcs.searchSong2(title);
                if(position2==-1){
                    System.out.println("There is no song with the name "+title);
                }
        }while(position2==-1);
        thisMcs.addPublicPlaylist(position, songLength, genre, rate, arraySongs, position2);
        }
    }
    /** createRestrictedPlaylist
    * Method to show playlist's restricted menu. <br>
    * @return String name
	*/
    public String createRestrictedPlaylist(){ //RESTRICTED
        int position=0;
        String name;
        do{
            System.out.println("Type in name for the playlist");
            name = lector.nextLine().toUpperCase();
            position = thisMcs.searchPlaylist(name);
            if(position!=-1){
                System.out.println("There is a playlist with the name "+name);
            }
        }while(position!=-1);
        thisMcs.addRestrictedPlaylist(name);
        return name;
    }
    /** addRestrictedPlaylist
    * Method to show playlist's restricted menu to add song to playlist. <br>
	*/
    public void addRestrictedPlaylist(){ //RESTRICTED
        int position=0;
        int position2=0;
        String title="";
        do{
            System.out.println("Type in the name of the playlist");
            String name = lector.nextLine().toUpperCase();
            position = thisMcs.searchPlaylist(name);
            if(position==-1){
                System.out.println("There is no playlist with the name "+name);
            }
        }while(position==-1);
        String[]arrayName = new String [5];
        String[]arraySongs = new String [50];
        System.out.println("How many users would you like to share your playlist with? (Maximum 5)");
        int playlistUsers=lector.nextInt();
        for(int i=0; i<playlistUsers && i<5; i++) {
            System.out.println("Type in username #"+(i+1)+"");
            arrayName[i] = lector.nextLine().toUpperCase();
            lector.nextLine();
        }
        System.out.println("How many songs would you like to add? (Maximum 50 songs)");
        int amountSongs=lector.nextInt();
        for(int i=0; i<amountSongs && i<50; i++) {
            System.out.println("Type in the name of song #"+(i+1)+"");
            arraySongs[i] = lector.nextLine().toUpperCase();
            position2=thisMcs.searchSong2(title);
            if(position2==-1){
                System.out.println("There is no song with the name "+title);
            }
        }while(position2==-1);
        this.thisMcs.addRestrictedPlaylist(position, songLength, genre, arrayName, arraySongs, position2);
    }
    /**showUser
	* Method to print out users. <br>
    */
    public void showUser(){
        String message = thisMcs.showUser();
        System.out.println(message);
    }
    /**showSong
	* Method to print out songs. <br>
    */
    public void showSong(){
        String message = thisMcs.showSong();
        System.out.println(message);
    }
    /**showPlaylist2
	* Method to print out playlists. <br>
    */
    public void showPlaylist2(){
        System.out.print(thisMcs.showPlaylist1());
    }
}

