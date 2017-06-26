package com.cab.db;

import com.cab.modle.Borrowinfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.Area;
import com.cab.modle.Car;
import com.cab.modle.Borrowinfo;

public class BorrowInfoDao {
	//添加租借信息
	public static int insertBorrowinfo(Integer userid, String username, Integer carid, Integer areaid, String borrowtime, String areaname){
		int aid = 0, i = 0;
		try{
			String sql = "select areaname from area where areaid='"+areaname+"'";
			ResultSet rs = DAO.executeQuery(sql);
			try{
				while (rs.next()){
					Area ar = new Area();
					aid = rs.getInt("areaid");
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			String sql1 = "insert into borrowinfo values('"+userid+"', '"+username+"', '"+carid+"', '"+areaid+"', '"+borrowtime+"')";
			i = DAO.executeUpdate(sql1);
		} catch(Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//查询租借信息
	public static List<Borrowinfo> selectBorrowinfo(){
		List<Borrowinfo> list = new ArrayList<Borrowinfo>();
		String sql = "select userid, username, carid, borrowdate, areaname from borrowinfo join area on borrowinfo.areaid = area.areaid";
		ResultSet rs = DAO.executeQuery(sql);
		
		try{
			while (rs.next()){
				Borrowinfo binfo = new Borrowinfo();
				binfo.setUserid(rs.getInt("userid"));
				binfo.setUsername(rs.getString("username"));
				binfo.setCarid(rs.getInt("carid"));
				binfo.setBorrowtime(rs.getString("borrowdate"));
				binfo.setAreaname(rs.getString("areaname"));
				list.add(binfo);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}
}
