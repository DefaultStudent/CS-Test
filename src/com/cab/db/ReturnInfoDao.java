package com.cab.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.Area;
import com.cab.modle.Returninfo;

public class ReturnInfoDao {
	//��ӹ黹��Ϣ
	public static int insertReturninfo(Integer userid, String username, Integer carid, String returndate, String areaname){
		int arid = 0, i = 0;
		try{
			String sql = "delete from borrowinfo where userid = '"+userid+"'";
			DAO.executeUpdate(sql);
			String sql1 = "select areaid from area where areaname = '"+areaname+"'";
			ResultSet rs = DAO.executeQuery(sql1);
			try{
				while (rs.next()){
					Area ar = new Area();
					arid = rs.getInt("areaid");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			String sql2 = "insert into returninfo values('"+userid+"', '"+username+"', '"+carid+"', '"+arid+"', '"+returndate+"')";
			i = DAO.executeUpdate(sql2);
		}catch(Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//��ѯ���й黹��Ϣ
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
	
	//���û���Ų�ѯ
	public static List<Returninfo> selectReturnInfoByUserId(int userid){
		List<Returninfo> list = new ArrayList<Returninfo>();
		String sql = "select userid, username, carid, returndate, areaname from returninfo join area on returninfo.areaid = area.areaid where userid = '"+userid+"'";
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
	
	//���û�������ѯ
	public static List<Returninfo> selectReturnInfoByUserName(String username){
		List<Returninfo> list = new ArrayList<Returninfo>();
		String sql = "select userid, username, carid, returndate, areaname from returninfo join area on returninfo.areaid = area.areaid where username = '"+username+"'";
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
	
	//��������Ų�ѯ
	public static List<Returninfo> selectReturnInfoByUserName(int carid){
		List<Returninfo> list = new ArrayList<Returninfo>();
		String sql = "select userid, username, carid, returndate, areaname from returninfo join area on returninfo.areaid = area.areaid where carid = '"+carid+"'";
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
	
	//���黹������ѯ
	public static List<Returninfo> selectReturnInfoByArea(String area){
		List<Returninfo> list = new ArrayList<Returninfo>();
		String sql = "select userid, username, carid, returndate, areaname from returninfo join area on returninfo.areaid = area.areaid where areaname = '"+area+"'";
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
	
	//���黹���ڲ�ѯ
	public static List<Returninfo> selectReturnInfoByDate(String date){
		List<Returninfo> list = new ArrayList<Returninfo>();
		String sql = "select userid, username, carid, returndate, areaname from returninfo join area on returninfo.areaid = area.areaid where returndate = '"+date+"'";
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
