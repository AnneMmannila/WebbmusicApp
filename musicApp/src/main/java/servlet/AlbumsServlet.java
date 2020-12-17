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

@WebServlet("/albums")
public class AlbumsServlet extends HttpServlet {
    
    private JDBCArtistDao ardao= new JDBCArtistDao();
    private JDBCAlbumDao aldao= new JDBCAlbumDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        String stringOfParameters = req.getParameter("ArtistId");
        
        String[] parametersList = stringOfParameters.split(" ");
        long artistId = Long.parseLong(parametersList[0]);
       List <Album> list = aldao.getItem(artistId);
       List <Artist> artistName = ardao.getArtistById(artistId);
       
       req.setAttribute("artistName", artistName);
      req.setAttribute("list", list);
      
        req.getRequestDispatcher("/WEB-INF/ArtistAlbums.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
     
      
        resp.sendRedirect("/albums"); 
        
        
    }
};