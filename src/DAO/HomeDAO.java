package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.SlideBanner;

public class HomeDAO {
	public static List<SlideBanner> DisplaySlideBanner(Connection conn) {
		List<SlideBanner> list = new ArrayList<>();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM slidebanner";
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				SlideBanner sb = new SlideBanner(); 
				
				String slidename = rs.getString("slidename");
				String slidecontent = rs.getString("slidecontent");
				String slideimage = rs.getString("slideimage");
				
				sb.setSlidename(slidename);
				sb.setSlidecontent(slidecontent);
				sb.setSlideimage(slideimage);
				
				list.add(sb);
			}
			
			ptmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
