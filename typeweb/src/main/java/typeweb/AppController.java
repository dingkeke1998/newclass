package typeweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private TypeService envService;

    //不同类别环境占比
    @ResponseBody
    @RequestMapping(value = "/get1")
    public Map getCategorys() {
        //List<Map<String, Object>> list = traveService.getBeijing();

        List<Map<String, Object>> list = envService.get1();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        Map returnMap = new HashMap<String, List>();
        for (Map<String, Object> m : list) {
            list1.add(m.get("style"));
            list2.add(m.get("num"));
        }
        returnMap.put("tyreStyle", list1);
        returnMap.put("num", list2);
        return returnMap;
    }

    @ResponseBody
    @RequestMapping(value = "/get2")
    public Map getTopRating() {

        List<Map<String, Object>> list = envService.get2();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        Map returnMap = new HashMap<String, List>();
        for (Map<String, Object> m : list) {
            list1.add(m.get("style"));
            list2.add(m.get("num"));
        }
        returnMap.put("shop", list1);
        returnMap.put("num", list2);
        return returnMap;
    }

    @ResponseBody
    @RequestMapping(value = "/get3")
    public List getLowRating() {
        List<Map<String, Integer>> list = envService.get3();
        List list1 = new ArrayList();
        Map returnMap = new HashMap<String, List>();
        Map<String, Object> shName = new HashMap();
        shName.put("name","上海") ;
        shName.put("value",0) ;

        Map<String, Object> bjName = new HashMap();
        bjName.put("name","北京") ;
        bjName.put("value",0) ;

        Map<String, Object> tjName = new HashMap();
        tjName.put("name","天津") ;
        tjName.put("value",0) ;

        Map<String, Object> gdName = new HashMap();
        gdName.put("name","广东") ;
        gdName.put("value",0) ;

        Map<String, Object> hnName = new HashMap();
        hnName.put("name","河南") ;
        hnName.put("value",0) ;

        Map<String, Object> hn2Name = new HashMap();
        hn2Name.put("name","湖南") ;
        hn2Name.put("value",0) ;

        Map<String, Object> sdName = new HashMap();
        sdName.put("name","山东") ;
        sdName.put("value",0) ;

        Map<String, Object> jsName = new HashMap();
        jsName.put("name","江苏") ;
        jsName.put("value",0) ;

        Map<String, Object> zjName = new HashMap();
        zjName.put("name","浙江") ;
        zjName.put("value",0) ;

        Map<String, Object> hbName = new HashMap();
        hbName.put("name","湖北") ;
        hbName.put("value",0) ;

        Map<String, Object> cqName = new HashMap();
        cqName.put("name","重庆") ;
        cqName.put("value",0) ;

        Map<String, Object> sxName = new HashMap();
        sxName.put("name","陕西") ;
        sxName.put("value",0) ;



        for (Map<String, Integer> m : list) {
            if(String.valueOf(m.get("country")).indexOf("上海")>=0){
                shName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("北京")>=0){
                bjName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("天津")>=0){
                tjName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("广东")>=0){
                gdName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("河南")>=0){
                hnName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("湖南")>=0){
                hn2Name.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("山东")>=0){
                sdName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("江苏")>=0){
                jsName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("重庆")>=0){
                cqName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("浙江")>=0){
                zjName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("湖北")>=0){
                hbName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
            if(String.valueOf(m.get("country")).indexOf("陕西")>=0){
                sxName.put("value",Integer.parseInt(shName.get("value").toString())+m.get("sales"));
            }
        }

        list1.add(shName);
        list1.add(bjName);
        list1.add(tjName);
        list1.add(gdName);
        list1.add(hnName);
        list1.add(hn2Name);
        list1.add(jsName);
        list1.add(cqName);
        list1.add(zjName);
        list1.add(hbName);
        list1.add(sxName);
        return list1;
    }

}
