package database;
import musicApp.Artist;
import musicApp.Track;
import java.util.ArrayList;
import java.util.List;

public interface TrackDao {

    public List<Track> getAlbumTracks(long albumId);
    
}
