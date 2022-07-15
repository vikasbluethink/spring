package com.SpringDemo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
    	
    	App mainApp = new App();
    	
        System.out.println( "Hello World!" );
        
//        mainApp.getDependencyInjection();
       
        //database connection using jdbc
        mainApp.getData();
        
    }
    
    /*
    jdbc connection using
    DrivaerManagerDataSource
    */
    private void getData() throws SQLException {
    	Connection con = this.connectDb();
        
        Statement st = (Statement) con.createStatement();
        
        String selectquery = "SELECT * FROM institute_docebo_category";
        String insertquery ="INSERT INTO `institute_docebo_category` (`magento_category_id`, `docebo_category_id`, `map_status`, `docebo_category_name`)\n" + 
        		"VALUES (NULL, '5', '0', 'Tutor')";
        String updatequery = "UPDATE `institute_docebo_category` SET\n" + 
        		"`entity_id` = '15',\n" + 
        		"`magento_category_id` = NULL,\n" + 
        		"`docebo_category_id` = '5',\n" + 
        		"`map_status` = '0',\n" + 
        		"`docebo_category_name` = 'New Category'\n" + 
        		"WHERE `entity_id` = '15'";
        
        String deletequery = "Delete from institute_docebo_category where `entity_id`='15'";
        
//        int insert = st.executeUpdate(insertquery);
        int update = st.executeUpdate(updatequery);
//        st.executeUpdate(deletequery);
        ResultSet rs = st.executeQuery(selectquery);
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        
        while(rs.next()) {
        	for(int i=1; i<=rsmd.getColumnCount();i++) {
        		System.out.print(rs.getString(i)+" ");
        	}	
        	System.out.println(" ");
        	
        }
    }
    
    private Connection connectDb() throws SQLException {
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/staging2DB_27062022");
        dataSource.setUsername("magento");
        dataSource.setPassword("magento123");
        
		Connection con = (Connection) dataSource.getConnection();
		
		return con;
    }
    
    
    /*
     * Dependency Injection
     * using java based configuration
     */
    private void getDependencyInjection() {
    	@SuppressWarnings("resource")
    	
    	/*ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringDemo/conf.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();*/

        ApplicationContext cxt = new AnnotationConfigApplicationContext(TriangleConfig.class);
//        cxt.start();
        Point p1 = (Point)cxt.getBean(Point.class);
        Point p2 = (Point)cxt.getBean(Point.class);
        Point p3 = (Point)cxt.getBean(Point.class);
        Triangle t = (Triangle)cxt.getBean(Triangle.class);
        p1.setX(2);
        p1.setY(3);
        
        p2.setX(0);
        p2.setY(4);
        
        p3.setX(-1);
        p3.setY(-2);
        
        t.setPointA(p1);
        
        t.setPointB(p2);
        
        t.setPointC(p3);
        t.draw();
    }
    
}
