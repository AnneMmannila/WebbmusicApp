package servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import database.JDBCArtistDao;

import database.JDBCAlbumDao;
import musicApp.Artist;
import musicApp.Album;

@WebServlet("/musicApp/add")
public class AddArtistServlet extends HttpServlet {

    private JDBCArtistDao ardao= new JDBCArtistDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       List <Artist> list = ardao.getAllItems();

        req.setAttribute("list", list);
      
         String name = req.getParameter("artistName");
        List <Artist> findArtist = ardao.getArtistByName(name);

        req.setAttribute("findArtist", findArtist);
        
        String album = req.getParameter("albumName");
        List <String> findAlbum = ardao.getAlbumName(album);
        
        
        req.setAttribute("findAlbum", findAlbum);
        
        
        req.getRequestDispatcher("/WEB-INF/AddArtist.jsp").forward(req, resp);

    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        
        // todo: get the product title from request parameters
        String name = req.getParameter("name");
        // todo: use the title to create a new product object
        long artistId = 0;
        Artist newItem = new Artist(artistId, name);
        

        // todo: use the DAO to store the product object into the database
        ardao.addItem(newItem);
      
        resp.sendRedirect("/musicApp/add"); 
        
        
    }
    
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      
       long id = Long.parseLong(req.getParameter("ArtistId"));
       
        
     List <Artist> artistId = ardao.getArtistById(id);

      if (artistId != null) {
            ardao.removeArtist(id);
        }
        
        List<Artist> list = ardao.getAllItems();

        
        String json = new Gson().toJson(list);

        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().println(json);
        
    }

    
};