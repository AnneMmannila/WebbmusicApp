package database;

import java.util.ArrayList;
import java.util.List;

import musicApp.Artist;

public interface  ArtistDao {

    public List<Artist> getAllItems();
    
    public boolean addItem(Artist newItem);
    
    public List<Artist> getArtistByName(String name);
    
    public List<String> getAlbumName(String albumName); 
    
    public List<Artist> getArtistById(long artistId);
    
    public boolean removeArtist(long a);
}
