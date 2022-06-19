package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CompanyonService;
import vo.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CompanyonController {

    @Autowired
    private CompanyonService companyonService;

    @GetMapping("/")
    public String redirect() throws Exception{
        return "redirect:product"; //?????????????????????????????????????????????????????????????????????????
    }

    //http://localhost:3333/product
    @RequestMapping("/product")
    @ResponseBody
    public List<Project> getAllProducts() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://acdc.dev:10601/";
        String id = "heejaedev";
        String pw = "heejaedev";
        Connection con = DriverManager.getConnection(url,id,pw);
        String sql = "SELECT * FROM member";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<Project> result = new ArrayList<>();
        while (rs.next()) {
            Project p = new Project(); //?
            /*
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setPrice(rs.getInt(3));
            p.setRemain(rs.getInt(4));
            p.setDiscount(rs.getDouble(5));
            p.setStockDate(rs.getString(6));
             */
            result.add(p);
        }
        rs.close();
        con.close();
        return result;
    }

}
