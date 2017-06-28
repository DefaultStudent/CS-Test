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
	public static int insertBorrowinfo(Integer userid, String username, Integer carid, String borrowtime, String areaname){
		int aid = 0, i = 0;
		try{
			String sql = "select areaid from area where areaname='"+areaname+"'";
			ResultSet rs = DAO.executeQuery(sql);
			try{
				while (rs.next()){
					Area ar = new Area();
					aid = rs.getInt("areaid");
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			String sql1 = "insert into borrowinfo values('"+userid+"', '"+username+"', '"+carid+"', '"+aid+"', '"+borrowtime+"')";
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
	
	//按用户编号查询
	public static List<Borrowinfo> selectBorrowinfoByUserId(int userid){
		List<Borrowinfo> list = new ArrayList<Borrowinfo>();
		String sql = "select userid, username, carid, borrowdate, areaname from borrowinfo join area on borrowinfo.areaid = area.areaid where userid = '"+userid+"'";
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
	
	//按用户姓名查询
	public static List<Borrowinfo> selectBorrowInfoByUserName(String username){
		List<Borrowinfo> list = new ArrayList<Borrowinfo>();
		String sql = "select userid, username, carid, borrowdate, areaname from borrowinfo join area on borrowinfo.areaid = area.areaid where username = '"+username+"'";
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
	
	//按车辆编号查询
	public static List<Borrowinfo> selectBorrowInfoByCarId(int carid){
		List<Borrowinfo> list = new ArrayList<Borrowinfo>();
		String sql = "select userid, username, carid, borrowdate, areaname from borrowinfo join area on borrowinfo.areaid = area.areaid where carid = '"+carid+"'";
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
	
	//按地区查询
	public static List<Borrowinfo> selectBorrowInfoByAreaName(String areaname){
		List<Borrowinfo> list = new ArrayList<Borrowinfo>();
		String sql = "select userid, username, carid, borrowdate, areaname from borrowinfo join area on borrowinfo.areaid = area.areaid where areaname = '"+areaname+"'";
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
	
	//按租借日期查询
	public static List<Borrowinfo> selectBorrowInfoByBorrowDate(String date){
		List<Borrowinfo> list = new ArrayList<Borrowinfo>();
		String sql = "select userid, username, carid, borrowdate, areaname from borrowinfo join area on borrowinfo.areaid = area.areaid where borrowdate = '"+date+"'";
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
