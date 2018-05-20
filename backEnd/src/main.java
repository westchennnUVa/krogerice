/**
 * Created by Westchennn on 4/2/18.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.Random;

public class main {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://krogerice.ci3jnwfxaijm.us-east-1.rds.amazonaws.com:3306/krogerice";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "22222222";

    private static ResultSet ret = null;


    public static String randomDateBetweenMinAndMax(){
        Calendar calendar = Calendar.getInstance();
        //注意月份要减去1
        calendar.set(1990,11,31);
        calendar.getTime().getTime();
        //根据需求，这里要将时分秒设置为0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        long min = calendar.getTime().getTime();;
        calendar.set(2013,11,31);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.getTime().getTime();
        long max = calendar.getTime().getTime();
        //得到大于等于min小于max的double值
        double randomDate = Math.random()*(max-min)+min;
        //将double值舍入为整数，转化成long类型
        calendar.setTimeInMillis(Math.round(randomDate));
        return calendar.getTime().toString();
    }


    public static String getRandomString(int length){
        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement stmt = null;


    }



    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);



            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Start Query");
            stmt = conn.createStatement();
//
//            System.out.print(randomDateBetweenMinAndMax());
//            System.out.print(randomDateBetweenMinAndMax());


            String[] department = {"human resource","logistic","cashier","purchase","storage management","PR"};

            String sql = "Select * from Supplier as s, Product as p, Transaction as t where s.SupplierID=p.SupplierID and t.ProductID=p.ProductID and t.TransactionID=51";
            ret = stmt.executeQuery(sql);
            while(ret.next()){
                System.out.println(ret.getString("SupplierName"));
                System.out.println(ret.getString("SupplierID"));
            }

//            int random = (int)(Math.random()*6);

//            String sql = "insert into Employee (DepartmentName) values '"+department[random]+"';";

////            添加 Employee
//            for(int i=0;i<500;i++){
//                int salary = 30000+(int)(Math.random()*50000);
//                String sql = "INSERT INTO Employee (DepartmentName,EmployeeName,EmployeePhone,EmployeeAddress,Salary) " +
//                        "VALUES ('"+department[(int)(Math.random()*6)]+"','"+RandomStringUtils.randomAlphanumeric(10)+"','"+getRandomString(10)
//                        +"','" + RandomStringUtils.randomAlphanumeric(20)+"',"+salary+")";
//                stmt.executeUpdate(sql);
//            }



/////加数据到Supplier, 只加Employee中Department是logistic的
//            List<Integer> supplierID = new ArrayList<>();
//            String selectSQL ="select * from Employee where DepartmentName = 'logistic';";
//            ret = stmt.executeQuery(selectSQL);
//            while(ret.next()){
//                supplierID.add(ret.getInt("EmployeeID"));
//            }
//
//            for(int i=0;i<500;i++){
////                int salary = 30000+(int)(Math.random()*50000);
//                String sql = "INSERT INTO Supplier (SupplierName,EmployeeID,SupplierAddress) " +
//                        "VALUES ('"+RandomStringUtils.randomAlphanumeric(10)+"',"+supplierID.get((int)(Math.random()*supplierID.size()))+",'"+RandomStringUtils.randomAlphanumeric(20)+"')";
//                stmt.executeUpdate(sql);
//            }


////            添加数据到comment
//            List<Integer> commentID = new ArrayList<>();
//            String selectSQL ="select * from Employee;";
//            ret = stmt.executeQuery(selectSQL);
//            while(ret.next()){
//                commentID.add(ret.getInt("EmployeeID"));
//            }
//            for(int i=0;i<commentID.size();i=i+(int)(Math.random()*5+1)){
////                int salary = 30000+(int)(Math.random()*50000);
//                String sql = "INSERT INTO Comment (Content,PostBy) " +
//                        "VALUES ('"+RandomStringUtils.randomAlphanumeric(100)+"',"+commentID.get(i)+")";
//                stmt.executeUpdate(sql);
//            }



////            添加数据到product
//            List<Integer> supplierID = new ArrayList<>();
//            String selectSQL ="select * from Supplier;";
//            ret = stmt.executeQuery(selectSQL);
//            while(ret.next()){
//                supplierID.add(ret.getInt("SupplierID"));
//            }
//            for(int i=0;i<300;i++){
//
//                int buy = 5+(int)(Math.random()*50);
//                int sell = buy + (int)(Math.random()*3);
//                String sql = "INSERT INTO Product (ProductName,StorageAmount,BuyingPrice,SellingPrice,Category,SupplierID,Description) " +
//                        "VALUES ('"+RandomStringUtils.randomAlphanumeric(10)+"',"+(int)(Math.random()*100)+","+buy+","+sell+",'"
//                        +RandomStringUtils.randomAlphanumeric(10)+"',"+supplierID.get((int)(Math.random()*supplierID.size()))+ ",'" + RandomStringUtils.randomAlphanumeric(100)+"')";
//                stmt.executeUpdate(sql);
//            }


////            添加数据到transaction
//            List<Integer> ProductID = new ArrayList<>();
//            List<Integer> SellingPrice = new ArrayList<>();
//            List<Integer> EmployeeID = new ArrayList<>();
//            int[] PN = {-1,1};
//            for (int i = 0 ; i < 50 ; i++) {
//                ProductID.add((int)(Math.random()*83));
//            }
//            for(int i=0;i<50;i++){
//                EmployeeID.add((int)(342+Math.random()*500));
//            }
//            for(int j =0; j < ProductID.size(); j++) {
//                String selectSQL = "select * from Product where ProductID =" + ProductID.get(j) + ";";
//                ret = stmt.executeQuery(selectSQL);
//                while (ret.next()) {
//                    SellingPrice.add(ret.getInt("SellingPrice"));
//                }
//            }
//
//            for(int i=0;i<ProductID.size();i++){
//                int amountChanged = (int)(100-(Math.random()*200));
//                long offset = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
//                long end = Timestamp.valueOf("2018-01-01 00:00:00").getTime();
//                long diff = end - offset + 1;
//                Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
//                String sql = "INSERT INTO Transaction (ProductID,EmployeeID,AmountModification,ModificationTime,TotalPrice) " +
//                        "VALUES ("+ProductID.get(i)+","+EmployeeID.get(i)+","+amountChanged+",'"+rand+"',"
//                        +(((int)(SellingPrice.get(i)*amountChanged))*(-1))+")";
//                stmt.executeUpdate(sql);
//            }

//            System.out.println("testetstestest");
//            long offset = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
//            long end = Timestamp.valueOf("2018-01-01 00:00:00").getTime();
//            long diff = end - offset + 1;
//            Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
//            System.out.println(rand);


////  添加数据到profit
//            int random = (int)(Math.random()*10);
//
//            for(int i=0;i<100;i++) {
//                double MonthlyExpenses = (double) (Math.random() * 10000);
//                double MonthlyIncome = (double) (Math.random() * 10000);
//                double MonthlyProfit = (double) (MonthlyIncome - MonthlyExpenses);
//                int Month = (random % 12) +1;
//                String sql = "INSERT INTO Profit (MonthlyExpenses, MonthlyIncome, MonthlyProfits, Month)" + "VALUES(" + MonthlyExpenses + ","
//                        + MonthlyIncome + "," + MonthlyProfit + "," + Month + ")";
//                random++;
//                stmt.executeUpdate(sql);
//            }


//            //添加数据到 Modifies
//
//            List<Integer> ProductID = new ArrayList<>();
//            List<Integer> EmployeeID = new ArrayList<>();
//            String selectSQL = "select * from Product";
//            ret = stmt.executeQuery(selectSQL);
//            while(ret.next()){
//                ProductID.add(ret.getInt("ProductID"));
//            }
//            selectSQL ="select * from Employee;";
//            ret = stmt.executeQuery(selectSQL);
//            while(ret.next()){
//                EmployeeID.add(ret.getInt("EmployeeID"));
//            }
//            int pointerEmployeeID = 0;
//            int pointerProductID = 0;
//            for(int i=0;i<100;i++){
//                long offset = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
//                long end = Timestamp.valueOf("2018-01-01 00:00:00").getTime();
//                long diff = end - offset + 1;
//                Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
//
////                pointerProductID += (int)(Math.random()*(ProductID.size()/2));
////                if(pointerProductID>=ProductID.size()){
////                    pointerEmployeeID += (int)Math.random()*5;
////                    if(pointerEmployeeID >= EmployeeID.size())
////                        break;
////                    pointerProductID = (int)Math.random()*ProductID.size();
////                }
////                System.out.print(rand);
////                EmployeeID.get((int)Math.random()*EmployeeID.size())
////                ProductID.get((int)Math.random()*ProductID.size())
//                String sql = "INSERT INTO `Modifies` (ModifyTime, EmployeeID, ProductID)" + "VALUES('" + rand + "',"
//                        + EmployeeID.get((int)Math.random()*EmployeeID.size()) + "," + ProductID.get((int)Math.random()*ProductID.size()) + ")";
////                String sql = "INSERT INTO Modifies (ModifyTime, EmployeeID, ProductID)" + "VALUES('" + rand + "',"
////                        + 333 + "," + 22 + ")";
//                stmt.executeUpdate(sql);
//            }


            }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Finish!");
    }//end main
}//end JDBCExample


//import java.sql.*;
///**
// * Created by Westchennn on 4/2/18.
// */
//public class main {
//    public static final String urlDatabase = "jdbc:mysql://krogerice.ci3jnwfxaijm.us-east-1.rds.amazonaws.com:3306/krogerice?verifyServerCertificate=false&useSSL=false";
//    public static final String name = "com.mysql.jdbc.Driver";
//    public static final String user = "root";
//    public static final String passwordDatabase = "2222";
//
//    public static Connection conn = null;
//    public static PreparedStatement pst = null;
//
//    public static void main(String[] args){
//
//
//
//        String[] department = {"human resource","logistic","cashier","purchase","storage management","PR"};
//        int random = (int)(Math.random()*6);
//
//
//        String sql = "insert into krogerice.Employee (DepartmentName) values '"+department[random]+"';";
//
//        try {
//            Class.forName(name);
//            conn = DriverManager.getConnection(urlDatabase, user, passwordDatabase);
//            pst = conn.prepareStatement(sql);
//            pst.executeQuery(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}

