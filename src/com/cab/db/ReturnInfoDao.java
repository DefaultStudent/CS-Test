package com.cab.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.Area;
import com.cab.modle.Returninfo;

public class ReturnInfoDao {
	//添加归还信息
	public static int insertReturninfo(Integer userid, String username, Integer carid, String returndate, Integer areaid, String areaname){
		int arid = 0, i = 0;
		try{
			String sql = "delete from borrowinfo where userid = '"+userid+"'";
			DAO.executeUpdate(sql);
			String sql1 = "select areaname from area where areaid = '"+areaid+"'";
			ResultSet rs = DAO.executeQuery(sql1);
			try{
				while (rs.next()){
					Area ar = new Area();
					arid = rs.getInt("areaid");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			String sql2 = "insert into returninfo('"+userid+"', '"+username+"', '"+carid+"', '"+returndate+"', '"+areaid+"')";
			i = DAO.executeUpdate(sql2);
		}catch(Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//查询所有归还信息
	public static List<Returninfo> selectReturnInfo(){
		List<Returninfo> list = new ArrayList<Returninfo>();
		String sql = "select userid, username, carid, returndate, areaname from returninfo join area on returninfo.areaid = area.areaid";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				Returninfo rinfo = new Returninfo();
				rinfo.setUserid(rs.getInt("userid"));
				rinfo.setUsername(rs.getString("username"));
				rinfo.setCarid(rs.getInt("carid"));
				rinfo.setReturntime(rs.getString("returndate"));
				rinfo.setAreaname(rs.getString("areaname"));
				list.add(rinfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}
}
