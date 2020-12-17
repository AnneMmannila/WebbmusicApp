package database;

import java.util.List;

import musicApp.Album;

public interface  AlbumDao {

    public List<Album> getAllItems();
    
    public List<Album> getItem(long artistId);
    
    public List<Album> getAlbum(long albumId);
}
