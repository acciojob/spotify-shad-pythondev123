package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class SpotifyRepository {
    public HashMap<Artist, List<Album>> artistAlbumMap;
    public HashMap<Album, List<Song>> albumSongMap;
    public HashMap<Playlist, List<Song>> playlistSongMap;
    public HashMap<Playlist, List<User>> playlistListenerMap;
    public HashMap<User, Playlist> creatorPlaylistMap;
    public HashMap<User, List<Playlist>> userPlaylistMap;
    public HashMap<Song, List<User>> songLikeMap;

    public List<User> users;
    public List<Song> songs;
    public List<Playlist> playlists;
    public List<Album> albums;
    public List<Artist> artists;

    public SpotifyRepository(){
        //To avoid hitting apis multiple times, initialize all the hashmaps here with some dummy data
        artistAlbumMap = new HashMap<>();
        albumSongMap = new HashMap<>();
        playlistSongMap = new HashMap<>();
        playlistListenerMap = new HashMap<>();
        creatorPlaylistMap = new HashMap<>();
        userPlaylistMap = new HashMap<>();
        songLikeMap = new HashMap<>();

        users = new ArrayList<User>();
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        albums = new ArrayList<>();
        artists = new ArrayList<Artist>();
    }

    public User createUser(String name, String mobile) {
        User user= new User(name, mobile);
       users.add(user);
       return user;

    }

    public Artist createArtist(String name) {
        Artist artist= new Artist(name);
        artists.add(artist);
        return artist;


    }

    public Album createAlbum(String title, String artistName) {
        if(!artists.contains(artistName)){
            createArtist(artistName);
        }
        Album album= new Album(title, artistName);
        albums.add(album);

        return album;


    }

    public Song createSong(String title, String albumName, int length) throws Exception{
        if(!albums.contains(albumName)){
            throw new Exception("album not found");

        }
        Song song= new Song(title,albumName,length);
        songs.add(song);

        return song;
    }

    public Playlist createPlaylistOnLength(String mobile, String title, int length) throws Exception {
if(!users.contains(mobile)){
    throw new Exception("User does not exist");
}
int index=users.indexOf(mobile);
User user= users.get(index);
Playlist playlist= new Playlist(title);
for(Song song: )
    }

    public Playlist createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception {

    }

    public Playlist findPlaylist(String mobile, String playlistTitle) throws Exception {

    }

    public Song likeSong(String mobile, String songTitle) throws Exception {

    }

    public String mostPopularArtist() {
        int maxLikes=0;
        Artist mostpopularartist= null;
        for(int i=0; i<artists.size(); i++){
            if(artists.get(i).getLikes()>maxLikes){
                maxLikes= artists.get(i).getLikes();
               mostpopularartist= artists.get(i);
            }


        }
        return mostpopularartist.getName();
    }

    public String mostPopularSong() {
        int maxLikes=0;
        Song mostpopularsong= null;
        for(int i=0; i<songs.size(); i++){
            if(songs.get(i).getLikes()>maxLikes){
               maxLikes= songs.get(i).getLikes();
               mostpopularsong= songs.get(i);
            }
        }
        return mostpopularsong.getTitle();
    }
}
