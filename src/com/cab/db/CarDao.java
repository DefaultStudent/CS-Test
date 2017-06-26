package com.cab.db;

import com.cab.modle.Car;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.Area;

public class CarDao {
	//添加车辆信息
	public static int insertCar(Integer carid, String cartype, Integer areaid, String carstate){
		int arid = 0, i = 0;
		try{
			String sql = "select arename from area where areaid = '"+areaid+"'";
			ResultSet rs = DAO.executeQuery(sql);
			try{
				while (rs.next()){
					Area ar = new Area();
					arid = rs.getInt("areaid");
				}
			}catch (Exception e){
				e.printStackTrace();
			}
			String sql1 = "insert into car values('"+carid+"', '"+cartype+"', '"+areaid+"', '"+carstate+"')";
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
	public static int updateCar(Integer carid, String cartype, Integer areaid, String carstate){
		int arid = 0, i = 0;
		try{
			String sql = "select areaname from area where areaid = '"+areaid+"'";
			ResultSet rs = DAO.executeQuery(sql);
			try{
				while (rs.next()){
					Area ar = new Area();
					arid = rs.getInt("areaid");
				}
			} catch (Exception e){
				e.printStackTrace();
			}
			String sql1 = "update car set cartype = '"+cartype+"', '"+areaid+"', '"+carstate+"'where carid = '"+carid+"'";
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
		String sql = "select carid, cartype, areaname, carstate from car join area on car.areaid = area.areaid";
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
