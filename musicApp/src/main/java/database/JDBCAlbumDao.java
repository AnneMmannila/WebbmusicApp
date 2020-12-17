package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import musicApp.Album;

public class JDBCAlbumDao implements AlbumDao{

    
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
        public List<Album> getAllItems() {
            List<Album> allItems = new ArrayList<Album>();
            Connection connect = connect();
            
           
            
            try {

                PreparedStatement query = connect.prepareStatement("SELECT * FROM Album ORDER BY ArtistId");

                ResultSet results = query.executeQuery();

               /* tama aiheuttaa ensimmaisen rivin pois jaamisen tulostuksesta
                * 
                * if(!results.next()) {
                   return null;
                      
                } */
                
              
                  while(results.next()) {
                  
                        long albumId = results.getLong("albumId");
                        String title = results.getString("title") ; 
                        long artistId = results.getLong("artistId");
                        Album olio = new Album(albumId, title, artistId);
                       
                     allItems.add(olio);
                   
                  }
                
                
           
             
                
                connect.close();
                query.close();
                results.close();
          
            } catch (Exception e) {
                    return null;
            }

            return allItems;
        }
        

        @Override
        public List<Album> getItem(long artistId) {
      
            
            List <Album> album = new ArrayList <Album>();
            Connection connection= connect();
            
            try {
               PreparedStatement query = connection.prepareStatement("SELECT * FROM Album WHERE ArtistId = ?");
               query.setLong(1, artistId);
                ResultSet results = query.executeQuery();
              
             /*  if(!results.next()) {
                    return null;
                }
             */

                while(results.next()) {
                
                   Album item = new Album(results.getLong("AlbumId"), results.getString("Title"), results.getLong("ArtistId"));
                   album.add(item);
                   
                }
                
         
         
            connection.close();
            query.close();
            results.close();
            
            return album;
                
            } catch (Exception e) {
                
                return null;
           
            }
            }
           
            @Override
            public List<Album> getAlbum(long albumId) {
          
                
                List <Album> artistAlbum = new ArrayList <Album>();
                Connection connection= connect();
                
                try {
                   PreparedStatement query = connection.prepareStatement("SELECT * FROM Album WHERE AlbumId = ?");
                   query.setLong(1, albumId);
                    ResultSet results = query.executeQuery();
                  
                 /*  if(!results.next()) {
                        return null;
                    }
                 */

                    while(results.next()) {
                    
                       Album item = new Album(results.getLong("AlbumId"), results.getString("Title"), results.getLong("ArtistId"));
                       artistAlbum.add(item);
                      
                    }
                    
             
             
                connection.close();
                query.close();
                results.close();
                
                return artistAlbum;
                    
                } catch (Exception e) {
                    
                    return null;
               
                }
            
            
            
            
        }
        
    
}

