package com.cab.db;

import com.cab.modle.Car;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.Area;

public class CarDao {
	//添加车辆信息
	public static int insertCar(Integer carid, String cartype, String areaname, String carstate){
		int i = 0;
		try{
			String sql1 = "insert into car values('"+carid+"', '"+cartype+"', '"+areaname+"', '"+carstate+"')";
			i = DAO.executeUpdate(sql1);
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//删除车辆信息
	public static int deleteCar(int carid){
		int i = 0;
		try{
			String sql = "delete from car where carid = '"+carid+"'";
			i = DAO.executeUpdate(sql);
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//修改车辆信息
	public static int updateCar(Integer carid, String cartype, String areaname, String carstate){
		int i = 0;
		try{
			
			String sql1 = "update car set cartype = '"+cartype+"', '"+areaname+"', '"+carstate+"'where carid = '"+carid+"'";
			i = DAO.executeUpdate(sql1);
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//查询全部车辆信息
	public static List<Car> selectCar(){
		List<Car> list = new ArrayList<Car>();
		String sql = "select carid, cartype, areaname, carstate from car";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setCartype(rs.getString("cartype"));
				car.setArename(rs.getString("areaname"));
				car.setCarstate(rs.getString("carstate"));
				list.add(car);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}
	
	//查询指定编号的车辆信息
	public static List<Car> selectCarById(int carid){
		List<Car> list = new ArrayList<Car>();
		String sql = "select * from car where carid = '"+carid+"'";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setCartype(rs.getString("cartype"));
				car.setArename(rs.getString("areaname"));
				car.setCarstate(rs.getString("carstate"));
				list.add(car);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}
	
	//查询指定类型的车辆信息
	public static List<Car> selectCarByType(String cartype){
		List<Car> list = new ArrayList<Car>();
		String sql = "select * from car where cartype = '"+cartype+"'";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setCartype(rs.getString("cartype"));
				car.setArename(rs.getString("areaname"));
				car.setCarstate(rs.getString("carstate"));
				list.add(car);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}
	
	//查询指定状态的车辆信息
	public static List<Car> selectCarByState(String carstate){
		List<Car> list = new ArrayList<Car>();
		String sql = "select * from car where carstate = '"+carstate+"'";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setCartype(rs.getString("cartype"));
				car.setArename(rs.getString("areaname"));
				car.setCarstate(rs.getString("carstate"));
				list.add(car);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}
	
	//查询指定地区的车辆信息
	public static List<Car> selectCarByArea(String areaname){
		List<Car> list = new ArrayList<Car>();
		String sql = "select * from car where areaname = '"+areaname+"'";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setCartype(rs.getString("cartype"));
				car.setArename(rs.getString("areaname"));
				car.setCarstate(rs.getString("carstate"));
				list.add(car);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return list;
	}

}
