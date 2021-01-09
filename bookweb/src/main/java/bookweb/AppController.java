package bookweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private BookService bookService;

    //不同类别图书占比
    @ResponseBody
    @RequestMapping(value = "/getCategory")
    public List<Map<String, Object>> getCategorys() {
        List<Map<String, Object>> list = bookService.getCategorys();

        return list;
    }

    // 评分分析，评分最高的10本书
    @ResponseBody
    @RequestMapping(value = "/getTopRating")
    public Map getTopRating() {

        List<Map<String, Object>> list = bookService.getTopRating();
        List key = new ArrayList();
        List val = new ArrayList();
        Map returnMap = new HashMap<String, List>();
        for (Map<String, Object> m : list) {
            key.add(m.get("name"));
            val.add(m.get("rating"));
        }
        returnMap.put("key", key);
        returnMap.put("val", val);
        return returnMap;
    }

    // 评分分析，评分最低的10本书
    @ResponseBody
    @RequestMapping(value = "/getLowRating")
    public Map getLowRating() {
        List<Map<String, Object>> list = bookService.getRatingLow();
        List key = new ArrayList();
        List val = new ArrayList();
        Map returnMap = new HashMap<String, List>();
        for (Map<String, Object> m : list) {
            key.add(m.get("name"));
            val.add(m.get("rating"));
        }
        returnMap.put("key", key);
        returnMap.put("val", val);
        return returnMap;
    }

    // 评分和评价次数的关系
    @ResponseBody
    @RequestMapping(value = "/getComment")
    public List<List> getComment() {
        List<Map<String, Object>> list = bookService.getComment();

        List<List> returnList = new ArrayList<List>();
        for (Map<String, Object> m : list) {
            List i = new ArrayList<Float>();
            i.add(m.get("commentNum"));
            i.add(m.get("rating"));
            returnList.add(i);
        }

        return returnList;
    }


    // 世界范围内图书分布情况
    @ResponseBody // 以json格式返回
    @RequestMapping(value = "/getCountry")
    public List<Map<String, Object>> getCountry() {

        return bookService.getCountry();
    }

    // 各出版社和出版的图书评价次数的关系
    @ResponseBody
    @RequestMapping(value = "/getPublishingHouse")
    public Map getPublishingHouse() {
        List<Map<String, Object>> list = bookService.getBookPublishRating();

        List<String> keyList = new ArrayList<>();
        for (Map<String, Object> m : list) {
            keyList.add(m.get("name").toString());
        }

        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("val", list);
        returnMap.put("key", keyList);
        return returnMap;
    }

    // 图书类型和评分的关系
    @ResponseBody
    @RequestMapping(value = "/getBookTypeAndRating")
    public Map getBookTypeAndRating() {
        List<Map<String, Object>> list = bookService.getBookCatRating();

        List<String> keyList = new ArrayList<String>();
        List<String> valueList = new ArrayList<String>();

        for (Map<String, Object> m : list) {
            keyList.add(m.get("name").toString());
            valueList.add(m.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("val", valueList);
        returnMap.put("key", keyList);

        return returnMap;
    }

    /**
     * 登陆功能
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/login")
    public Map login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        Map<String, String> resultMap = new HashMap<>();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            resultMap.put("data", "账号或密码不能为空");
            return resultMap;
        }

        if (bookService.searchByPassword(username, password)) {
            resultMap.put("data", "sucess");
            return resultMap;
        } else {
            resultMap.put("data", "账号或密码错误");
            return resultMap;
        }
    }
 // 图书类型和价格的关系
    @ResponseBody
    @RequestMapping(value = "/getBookAvgPrice")
    public Map getBookAvgPrice() {
        List<Map<String, Object>> list = bookService.getAvgPrice();

        List<String> keyList = new ArrayList<String>();
        List<String> valueList = new ArrayList<String>();

        for (Map<String, Object> m : list) {
            keyList.add(m.get("type").toString());
            valueList.add(m.get("price").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("val", valueList);
        returnMap.put("key", keyList);

        return returnMap;
    }
    /**
     * 退出功能
     *
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("redirect:/index.html");
    }

    @ResponseBody
    @PostMapping("/registe")
    public Map registe(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("data", "账号或密码不能为空");
            return resultMap;
        }

        return bookService.register(username, password);
    }
}
