package com.cab.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.Area;

public class AreaDao {
	//添加地区信息
	public static int insertArea(Integer areaid, String areaname){
		int i = 0;
		try{
			String sql = "insert into area values('"+areaid+"', '"+areaname+"')";
			i = DAO.executeUpdate(sql);
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//删除地区信息
	public static int deleteArea(Integer areaid){
		int i = 0;
		try{
			String sql = "delete from area where areaid = '"+areaid+"'";
			i = DAO.executeUpdate(sql);
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//修改地区信息
	public static int updateArea(Integer areaid, String areaname){
		int i = 0;
		try{
			String sql = "update area set areaname = '"+areaname+"' where areaid = '"+areaid+"'";
			i = DAO.executeUpdate(sql);
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//查询全部地区信息
	public static List<Area> selectArea(){
		List<Area> list = new ArrayList<Area>();
		String sql = "select * from area";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				Area area = new Area();
				area.setAreaid(rs.getInt("areaid"));
				area.setAreaname(rs.getString("areaname"));
				list.add(area);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}

}
