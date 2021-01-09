package bookweb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public List<Map<String,Object>> getCategorys(){
		return bookDao.getCategorys();
	}
	
	public List<Map<String,Object>> getTopRating(){
		return bookDao.getTopRating();
	}
	public List<Map<String,Object>> getAvgPrice(){
		List<Map<String,Object>> list = bookDao.getAvgPrice();
		return list;
	}
	public List<Map<String,Object>> getRatingLow(){
		return bookDao.getRatingLow();
	}
	
	public List<Map<String,Object>> getComment(){
		return bookDao.getComment();
	}
	
	
	public List<Map<String,Object>> getCountry() {
		List<Map<String,Object>> list = bookDao.getCountry();
 
		return list;
	}
	 	
	public List<Map<String,Object>> getBookPublishRating(){
		List<Map<String,Object>> list = bookDao.getBookPublishRating();
		return list;
	}
	
	public List<Map<String,Object>> getBookCatRating(){
		List<Map<String,Object>> list = bookDao.getBookCatRating();
		return list;
	}

	public boolean searchByPassword(String username, String password) {
		String searchUsernmae = bookDao.searchByPassword(password);

		if (username.equals(searchUsernmae)) {
			return true;
		}

		return false;
	}
	
	public Map register(String username, String password) {
		String searchUsernmae = bookDao.searchByUsername(username);
		Map<String, String> resultMap = new HashMap<>();
		if (!StringUtils.isEmpty(searchUsernmae)) {
			resultMap.put("data", "账号已存在");
			return resultMap;
		}
		int i = bookDao.insert(username, password);

		if (i > 0) {
			resultMap.put("data", "sucess");
			return resultMap;
		}

		resultMap.put("data", "注册失败");
		return resultMap;

	}
}
