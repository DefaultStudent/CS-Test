package com.cab.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.Area;

public class AreaDao {
	//��ӵ�����Ϣ
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
	
	//ɾ��������Ϣ
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
	
	//�޸ĵ�����Ϣ
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
	
	//��ѯȫ��������Ϣ
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
