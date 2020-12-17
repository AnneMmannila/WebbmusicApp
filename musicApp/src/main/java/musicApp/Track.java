package musicApp;

import java.text.DecimalFormat;

public class Track {

    
    private long trackId;
    private String name;
    private long albumId;
    private long minutes;
   
    
    @SuppressWarnings("unused")
    private Track(){
    }
    
    
    public Track(long trackId, String name, long albumId, long minutes) {
        super();
        this.trackId = trackId;
        this.name = name;
        this.albumId = albumId;
        this.minutes = minutes;
    }


    public long getTrackId() {
        return trackId;
    }


    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public long getAlbumId() {
        return albumId;
    }


    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }


    public String getMinutes() {
        try {
            double a= 60.00;
            double b= 1000.00;
           double minD = (double)minutes;
           minD = minD/b/a;
       
       DecimalFormat des =new DecimalFormat ("0.00");
       String min  = des.format(minD);
        return min;
      
        }catch(Exception e) {
            System.out.println("not working!");
            return null;
        }
        
      
    }


    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }


    @Override
    public String toString() {
        return "Track [trackId=" + trackId + ", name=" + name + ", albumId=" + albumId + ", milliseconds="
                + minutes + "]";
    }
    
    
    
    
}
