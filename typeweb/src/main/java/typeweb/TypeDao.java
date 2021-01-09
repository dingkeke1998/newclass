package typeweb;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TypeDao {

	@Select("SELECT ie.style , ie.num FROM part1 ie ")
	public List<Map<String,Object>> get1();
	
	@Select("SELECT p.style,p.num  FROM part2 p ORDER BY p.num DESC ; ")
	public List<Map<String,Object>> get2();
	
	@Select("SELECT p.country,p.num as sales  FROM part3 p ")
	public List<Map<String,Integer>> get3();

}
