package musicApp;

public class Album {

    private long albumId;
    private String title;
    private long artistId;

    /**
     * Empty constructor only used by Gson when converting JSON Strings to Java
     * objects. Set to private to prevent creating uninitialized objects.
     */
    @SuppressWarnings("unused")
    private Album() {
    }

    public Album(long albumId, String title, long artistId) {
        this.albumId = albumId;
        this.title = title;
        this.artistId = artistId;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return  title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Album [albumId=" + albumId + ", title=" + title + ", artistId=" + artistId + "]";
    }
    
    
    
    
}
