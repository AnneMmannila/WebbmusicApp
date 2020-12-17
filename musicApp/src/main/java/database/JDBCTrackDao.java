package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import musicApp.Track;

public class JDBCTrackDao implements TrackDao{

    //ymparistomuuttuja asennettu
    private static final String URL = System.getenv("Chinook");

    public Connection connect() {
        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public List<Track> getAlbumTracks(long albumId) {
        List<Track> allItems = new ArrayList<Track>();
        Connection connect = connect();
        
       
        
        try {
          
            PreparedStatement query = connect.prepareStatement("SELECT * FROM Track WHERE AlbumId = ? ORDER BY TrackId;");
            query.setLong(1, albumId);
            ResultSet results = query.executeQuery();

           
             if(results.next()) {
          
              while(results.next()) {
              
                    long trackId = results.getLong("TrackId");
                    String name = results.getString("Name") ; 
                    long album = results.getLong("AlbumId");
                    long milliseconds = results.getLong("Milliseconds");
              
                   Track olio = new Track(trackId, name, album, milliseconds);
                   
               allItems.add(olio);
               
              }
           } 
             else {
                 return null;
             }
            
            connect.close();
            query.close();
            results.close();
      
        } catch (Exception e) {
                return null;
        }

        return allItems;
    }

    
    
    
}
