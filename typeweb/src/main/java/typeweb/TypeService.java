package typeweb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TypeService {
	
	@Autowired
	private TypeDao envDao;
	
	public List<Map<String,Object>> get1(){
		return envDao.get1();
	}
	
	public List<Map<String,Object>> get2(){
		return envDao.get2();
	}
	
	public List<Map<String,Integer>> get3(){
		return envDao.get3();
	}

}
