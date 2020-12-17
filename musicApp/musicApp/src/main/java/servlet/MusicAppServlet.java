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

@WebServlet("/musicApp")
public class MusicAppServlet extends HttpServlet {

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
        
        
        req.getRequestDispatcher("/WEB-INF/FrontPage.jsp").forward(req, resp);

    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
     
      
        resp.sendRedirect("/musicApp"); 
        
        
    }
    
   
};