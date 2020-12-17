package musicApp;

public class Artist {

 
    private long artistId;
    private String name;
    

    /**
     * Empty constructor only used by Gson when converting JSON Strings to Java
     * objects. Set to private to prevent creating uninitialized objects.
     */
    @SuppressWarnings("unused")
    private Artist(){
    }

    public Artist(long artistId, String name) {
        this.name = name;
        this.artistId = artistId;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist [artistId=" + artistId + ", name=" + name + "]";
    }

    
    
 
    }

    
    
    

