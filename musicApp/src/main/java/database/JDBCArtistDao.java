package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import musicApp.Album;
import musicApp.Artist;

public class JDBCArtistDao implements ArtistDao{
    
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
        public List<Artist> getAllItems() {
            List<Artist> allItems = new ArrayList<Artist>();
            Connection connect = connect();
            
           
            
            try {

                PreparedStatement query = connect.prepareStatement("SELECT * FROM Artist ORDER BY Name");

                ResultSet results = query.executeQuery();

              
                  while(results.next()) {
                  
                        long artistId = results.getLong("artistId");
                        String name = results.getString("name") ; 
                   
                        Artist olio = new Artist(artistId, name);
                       
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
        public boolean addItem(Artist newItem) {
            
            String name = newItem.getName();
            Connection connection = connect();
            
            try {

                PreparedStatement insertItem = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                insertItem.setString(1, name);

                insertItem.executeUpdate();
                ResultSet rs = insertItem.getGeneratedKeys();
                rs.next();
               int automaticallyGeneratedId = rs.getInt(1); 
                System.out.println("You added an item on the list. Its id is: "+ automaticallyGeneratedId);
                
              
                connection.close();
                insertItem.close();
                
                return true;
                
            } catch (Exception e) {

               return false;
            }

        }
        
        @Override
        public List<Artist> getArtistByName(String name) {
            List<Artist> findArtist = new ArrayList<Artist>();
            Connection connect = connect();
            
           
            
            try {

                PreparedStatement query = connect.prepareStatement("SELECT ArtistId, Name FROM Artist WHERE Name LIKE ? ORDER BY Name ASC;");
                query.setString(1, "%" + name + "%");
                ResultSet results = query.executeQuery();
               
           
              
                  while(results.next()) {
                  
                        long artistId = results.getLong("artistId");
                        String artistName = results.getString("name") ; 
                   
                        Artist olio = new Artist(artistId, artistName);
                       
                     findArtist.add(olio);
                   
                  }
               
                
                connect.close();
                query.close();
                results.close();
          
            } catch (Exception e) {
                    return null;
            }

            return findArtist;
        }
        
        @Override
        public List<String> getAlbumName(String albumName) {
            List<String> findArtistAlbum = new ArrayList<String>();
            Connection connect = connect();
            
           
            
            try {

                PreparedStatement query = connect.prepareStatement("SELECT AlbumId, Album.ArtistId, Album.Title, Artist.Name "
                        + "FROM Album LEFT JOIN Artist ON Artist.ArtistId = Album.ArtistId  WHERE Title LIKE ? ORDER BY Title ASC;");
                query.setString(1, "%" + albumName + "%");
                ResultSet results = query.executeQuery();
               
            
                  
                while(results.next()) {
                    
                  
                    
                        String title = results.getString("Title");
                        String artistName = results.getString("Name") ; 
                        long artistId = results.getLong("ArtistId");
                        
                        findArtistAlbum.add(artistId+" "+artistName+"/"+title);
                       
                     
                   
                  }
           
               
                
                connect.close();
                query.close();
                results.close();
          
            } catch (Exception e) {
                    return null;
            }

            return findArtistAlbum;
        }
        
        @Override
        public List<Artist> getArtistById(long artistId) {
            List<Artist> allItems = new ArrayList<Artist>();
            Connection connect = connect();
         
           
            
            try {

                PreparedStatement query = connect.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ? ");
                query.setLong(1, artistId);
                ResultSet results = query.executeQuery();

                  
                  while(results.next()) {
                  
                        long aId = results.getLong("artistId");
                        String name = results.getString("Name") ; 
                   
                        Artist olio = new Artist(aId, name);
                       
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
        public boolean removeArtist(long id) {
            Connection connection = connect();
       

            try {
                PreparedStatement remove = connection.prepareStatement("DELETE FROM Artist WHERE ArtistId = ?");

                remove.setLong(1, id);
                remove.executeUpdate();
          
                connection.close();
                remove.close();
                System.out.println("you deleted an artist");
                return true;
                
            } catch (Exception e) {
                return false;
            }
     
          
        }
        
        

} 
    

