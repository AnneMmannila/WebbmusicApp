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
import database.JDBCTrackDao;
import musicApp.Artist;
import musicApp.Album;
import musicApp.Track;

@WebServlet("/musicApp/track")
public class TrackServlet extends HttpServlet {
    private JDBCAlbumDao aldao= new JDBCAlbumDao();
    private JDBCTrackDao trackdao= new JDBCTrackDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    long albumId = Long.parseLong(req.getParameter("AlbumId"));
        
       List <Track> trackList = trackdao.getAlbumTracks(albumId);
       
        req.setAttribute("trackList", trackList);
      
        List <Album> list = aldao.getAlbum(albumId);
       
        
       
       req.setAttribute("list", list);
        
        
        
        req.getRequestDispatcher("/WEB-INF/TrackPage.jsp").forward(req, resp);

    }

   

}