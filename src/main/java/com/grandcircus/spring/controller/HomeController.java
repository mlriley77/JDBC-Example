package com.grandcircus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//step #1
import java.sql.*;
import java.util.ArrayList;


/**
 * Created by MichaelRiley on 5/10/17.
 */


@Controller
public class HomeController {

    @RequestMapping ("/")//handler mapping
    public ModelAndView helloWorld(){//model and view method - has to return a model and view
        return new ModelAndView("welcome", "hello", "hello world");
    }

    // request mapping provides the route to the URL (ex .jsp)
    @RequestMapping(value = "/jdbc")
    public String jdbcEx(Model model) throws ClassNotFoundException, SQLException {//Model - if you want to pass information into something from create, you need to create model object to use model.addattribute

        String url = "jdbc:mysql://localhost:3306/BCBC";//url to database - connector going to pom file dependency  //after local host 3306/database name
        String username = "grant";
        String password = "chirpus";
        //String query = "select * from project";

        ArrayList<String> list = new ArrayList<String>();//attached to while loop


        //step 2
        Class.forName("com.mysql.jdbc.Driver");//throw red to add exception to method signature
        //step 3
        Connection con = DriverManager.getConnection(url, username, password);//add exception to the method signature

        //step 4

        Statement st =  con.createStatement();//allowing us to create a statement which will be used for our result to get values from database

        //Step 5
        ResultSet rs = st.executeQuery("select * from product");// (query) or declare a string variable see example



        while (rs.next()) {//checking to see if there is a row in that database that = null.  it will jump out after

            //step 6 process results - optional
            String productID = Integer.toString(rs.getInt(1));//converting int to a string for the purpose of adding this to an array list.
            String code = rs.getString(2);
            String description = rs.getString(3);

            list.add(productID + ", " + code + ", " + description);//adding to array list from above

        }
        model.addAttribute("addStuff", list);

        //step 7 optional
        rs.close();
        con.close();

        return"jdbc";//needs to match the jsp file "jdbc"
    }

}

//THIS WILL ONLY PRINT ONE VALUE
//package com.grandcircus.spring.controller;
//
//        import org.springframework.stereotype.Controller;
//        import org.springframework.ui.Model;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.servlet.ModelAndView;
////step #1
//        import java.sql.*;
//
//
///**
// * Created by MichaelRiley on 5/10/17.
// */
//
//
//@Controller
//public class HomeController {
//
//    @RequestMapping ("/")//handler mapping
//    public ModelAndView helloWorld(){//model and view method - has to return a model and view
//        return new ModelAndView("welcome", "hello", "hello world");
//    }
//
//    // request mapping provides the route to the URL (ex .jsp)
//    @RequestMapping(value = "/jdbc")
//    public String jdbcEx(Model model) throws ClassNotFoundException, SQLException {//Model - if you want to pass information into something from create, you need to create model object to use model.addattribute
//
//        String url = "jdbc:mysql://localhost:3306/BCBC";//url to database - connector going to pom file dependency  //after local host 3306/database name
//        String username = "grant";
//        String password = "chirpus";
//        //String query = "select * from project";
//
//
//        //step 2
//        Class.forName("com.mysql.jdbc.Driver");//throw red to add exception to method signature
//        //step 3
//        Connection con = DriverManager.getConnection(url, username, password);//add exception to the method signature
//
//        //step 4
//
//        Statement st =  con.createStatement();//allowing us to create a statement which will be used for our result to get values from database
//
//        //Step 5
//        ResultSet rs = st.executeQuery("select * from product");// (query) or declare a string variable see example
//
//        //next() is needed to advance beyond my table header in my database
//        rs.next();
//
//        //step 6 process results - optional
//        int productID = rs.getInt(1);//index starts at 1 not 0.  its not an array
//        String code = rs.getString(2);
//        String description = rs.getString(3);
//
//        String print = productID + ", " + code + ", " + description;
//
//
//        model.addAttribute("addStuff", print);
//
//        //step 7 optional
//        rs.close();
//        con.close();
//
//        return"jdbc";//needs to match the jsp file "jdbc"
//    }
//
//}



