package httpManager;

import database.DBManager;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Westchennn on 3/27/18.
 */
public class Login extends HttpServlet {

    private static ResultSet ret = null;
    private ResultSetMetaData rsmd = null;

    public Login() {
        super();
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



//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        String operation = request.getParameter("operation");
        String sql = "";
        //Employee Product Supplier Transaction
        if(operation.equals("Supplier")) {
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            sql = "select * from Supplier";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> SupplierID = new ArrayList<>();
                List<String> SupplierName = new ArrayList<>();
                List<String> EmployeeID = new ArrayList<>();
                List<String> SupplierAddress = new ArrayList<>();
                int counter = 0;
                while(ret.next()){
                    counter++;
                    SupplierID.add(ret.getString("SupplierID"));
                    SupplierName.add(ret.getString("SupplierName"));
                    EmployeeID.add(ret.getString("EmployeeID"));
                    SupplierAddress.add(ret.getString("SupplierAddress"));

                    if(counter == 100)
                        break;
                }
                status.accumulate("SupplierID",SupplierID);
                status.accumulate("SupplierName",SupplierName);
                status.accumulate("EmployeeID",EmployeeID);
                status.accumulate("SupplierAddress",SupplierAddress);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(operation.equals("Product")){
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            sql = "select * from Product";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> ProductID = new ArrayList<>();
                List<String> ProductName = new ArrayList<>();
                List<String> StorageAmount = new ArrayList<>();
                List<String> BuyingPrice = new ArrayList<>();
                List<String> SellingPrice = new ArrayList<>();
                List<String> Category = new ArrayList<>();
                List<String> SupplierID = new ArrayList<>();
                List<String> Description = new ArrayList<>();

                int counter = 0;
                while(ret.next()){
                    counter++;
                    ProductID.add(ret.getString("ProductID"));
                    ProductName.add(ret.getString("ProductName"));
                    StorageAmount.add(ret.getString("StorageAmount"));
                    BuyingPrice.add(ret.getString("BuyingPrice"));
                    SellingPrice.add(ret.getString("SellingPrice"));
                    Category.add(ret.getString("Category"));
                    SupplierID.add(ret.getString("SupplierID"));
                    Description.add(ret.getString("Description"));
                    if(counter == 100)
                        break;
                }
                System.out.print(ProductID.get(1));
                status.accumulate("ProductID",ProductID);
                status.accumulate("ProductName",ProductName);
                status.accumulate("StorageAmount",StorageAmount);
                status.accumulate("BuyingPrice",BuyingPrice);
                status.accumulate("SellingPrice",SellingPrice);
                status.accumulate("Category",Category);
                status.accumulate("SupplierID",SupplierID);
                status.accumulate("Description",Description);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(operation.equals("Employee")){
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            sql = "select * from Employee";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> EmployeeID = new ArrayList<>();
                List<String> DepartmentName = new ArrayList<>();
                List<String> EmployeeName = new ArrayList<>();
                List<String> EmployeePhone = new ArrayList<>();
                List<String> EmployeeAddress = new ArrayList<>();
                List<String> Salary = new ArrayList<>();

                int counter = 0;
                while(ret.next()){
                    counter++;
                    EmployeeID.add(ret.getString("EmployeeID"));
                    DepartmentName.add(ret.getString("DepartmentName"));
                    EmployeeName.add(ret.getString("EmployeeName"));
                    EmployeePhone.add(ret.getString("EmployeePhone"));
                    EmployeeAddress.add(ret.getString("EmployeeAddress"));
                    Salary.add(ret.getString("Salary"));
                    if(counter == 100)
                        break;
                }
                status.accumulate("EmployeeID",EmployeeID);
                status.accumulate("DepartmentName",DepartmentName);
                status.accumulate("EmployeeName",EmployeeName);
                status.accumulate("EmployeePhone",EmployeePhone);
                status.accumulate("EmployeeAddress",EmployeeAddress);
                status.accumulate("Salary",Salary);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(operation.equals("Transaction")){
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            sql = "select * from Transaction";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> TransactionID = new ArrayList<>();
                List<String> ProductID = new ArrayList<>();
                List<String> EmployeeID = new ArrayList<>();
                List<String> AmountModification = new ArrayList<>();
                List<String> ModificationTime = new ArrayList<>();
                List<String> TotalPrice = new ArrayList<>();

                int counter = 0;
                while(ret.next()){
                    counter++;
                    TransactionID.add(ret.getString("TransactionID"));
                    ProductID.add(ret.getString("ProductID"));
                    EmployeeID.add(ret.getString("EmployeeID"));
                    AmountModification.add(ret.getString("AmountModification"));
                    ModificationTime.add(ret.getString("ModificationTime"));
                    TotalPrice.add(ret.getString("TotalPrice"));
                    if(counter == 100)
                        break;
                }
                status.accumulate("TransactionID",TransactionID);
                status.accumulate("ProductID",ProductID);
                status.accumulate("EmployeeID",EmployeeID);
                status.accumulate("AmountModification",AmountModification);
                status.accumulate("ModificationTime",ModificationTime);
                status.accumulate("TotalPrice",TotalPrice);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (operation.equals("Query4")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            String TransactionIDValue = request.getParameter("TransactionID");
            sql = "Select s.SupplierID, s.SupplierName from Supplier as s, Product as p, Transaction as t " +
                    "where s.SupplierID=p.SupplierID and t.ProductID=p.ProductID and t.TransactionID=" + Integer.valueOf(TransactionIDValue) + ";";
            DBManager db = new DBManager(sql);
            try {
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> SupplierID = new ArrayList<>();
                List<String> SupplierName = new ArrayList<>();

                int counter = 0;
                while (ret.next()) {
                    counter++;
                    SupplierID.add(ret.getString("SupplierID"));
                    SupplierName.add(ret.getString("SupplierName"));
                    if (counter == 100)
                        break;
                }
                status.accumulate("SupplierID", SupplierID);
                status.accumulate("SupplierName", SupplierName);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }        else if (operation.equals("Query6")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            String employeeIDValue = request.getParameter("employeeID");
            sql = "Select s.SupplierName from Supplier as s where exists( select * from Employee as e " +
                    "where e.EmployeeID = s.EmployeeID and e.EmployeeID=" + Integer.valueOf(employeeIDValue) + ");";
            DBManager db = new DBManager(sql);
            try {
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> supplierName = new ArrayList<>();

                int counter = 0;
                while (ret.next()) {
                    counter++;
                    supplierName.add(ret.getString("SupplierName"));
                    if (counter == 100)
                        break;
                }
                status.accumulate("SupplierName", supplierName);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }



        else if (operation.equals("Query7")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            String amountModificationNumber = request.getParameter("AmountModification");
            String modificationTimeValue = request.getParameter("ModificationTime");
            modificationTimeValue = modificationTimeValue + "%";

            sql = "Select Product.ProductName, Transaction.ModificationTime from Product inner join Transaction " +
                    "on Product.ProductID = Transaction.ProductID where Transaction.ModificationTime like '" + modificationTimeValue +
                    "' group by Product.ProductID having sum(Transaction.AmountModification) = " + Integer.valueOf(amountModificationNumber) + ";";
            DBManager db = new DBManager(sql);
            try {
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> productName = new ArrayList<>();
                List<String> modificationTime = new ArrayList<>();

                int counter = 0;
                while (ret.next()) {
                    counter++;
                    productName.add(ret.getString("ProductName"));
                    modificationTime.add(ret.getString("ModificationTime"));
                    if (counter == 100)
                        break;
                }

                status.accumulate("ProductName", productName);
                status.accumulate("ModificationTime", modificationTime);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        else if (operation.equals("Query8")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            String supplierIDValue = request.getParameter("supplierID");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");

            sql = "Select p.ProductName, sum(t.AmountModification) from Product as p inner join Supplier as s " +
                    " on s.SupplierID = p.SupplierID inner join  Transaction as t on p.ProductID = t.ProductID " +
                    " where s.SupplierID=" + Integer.valueOf(supplierIDValue) + " and year(t.ModificationTime)= '" + year +
                    "' and month(t.ModificationTime)='" + month + "' and day(t.ModificationTime)= '" + day +
                    "' group by t.ModificationTime and p.ProductName;";
            DBManager db = new DBManager(sql);
            try {
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> productName = new ArrayList<>();
                List<String> sumAmountModification = new ArrayList<>();

                int counter = 0;
                while (ret.next()) {
                    counter++;
                    productName.add(ret.getString("ProductName"));
                    sumAmountModification.add(ret.getString("sum(t.AmountModification)"));
                    if (counter == 100)
                        break;
                }
                status.accumulate("ProductName", productName);
                status.accumulate("Amount", sumAmountModification);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        else if(operation.equals("insertEmployee")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            String CurrentDepartmentName = request.getParameter("CurrentDName");
            String DepartmentName = request.getParameter("DepartmentName");
            String EmployeeName = request.getParameter("EmployeeName");
            String EmployeePhone = request.getParameter("EmployeePhone");
            String EmployeeAddress = request.getParameter("EmployeeAddress");
            String Salary = request.getParameter("Salary");
            sql = "INSERT INTO Employee (DepartmentName,EmployeeName,EmployeePhone,EmployeeAddress,Salary) " +
                    "VALUES ('"+DepartmentName+"','"+EmployeeName+"','"+EmployeePhone
                    +"','" + EmployeeAddress+"',"+Double.valueOf(Salary)+")";

            try{
                JSONObject status = new JSONObject();
                if(!CurrentDepartmentName.equals("human resource")){
                    status.accumulate("status",-1);
                }else{
                    DBManager db = new DBManager(sql);
                    db.pst.executeUpdate();
                    status.accumulate("status",1);
                }
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(operation.equals("insertProduct")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            String CurrentDepartmentName = request.getParameter("CurrentDName");
            String ProductName = request.getParameter("ProductName");
            String StorageAmount = request.getParameter("StorageAmount");
            String BuyingPrice = request.getParameter("BuyingPrice");
            String SellingPrice = request.getParameter("SellingPrice");
            String Category = request.getParameter("Category");
            String SupplierID = request.getParameter("SupplierID");
            String Description = request.getParameter("Description");

            sql = "INSERT INTO Product (ProductName,StorageAmount,BuyingPrice,SellingPrice,Category,SupplierID,Description) " +
                    "VALUES ('"+ProductName+"',"+Integer.valueOf(StorageAmount)+","+Double.valueOf(BuyingPrice)+","+Double.valueOf(SellingPrice)+",'"
                    +Category+"',"+Integer.valueOf(SupplierID)+ ",'"
                    + Description+"')";

            try{

                JSONObject status = new JSONObject();
                if(CurrentDepartmentName.equals("logistic")){
                    DBManager db = new DBManager(sql);
                    db.pst.executeUpdate();
                    status.accumulate("status",1);
                }else {
                    status.accumulate("status",-1);
                }
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(operation.equals("insertTransaction")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            String CurrentDepartmentName = request.getParameter("CurrentDName");
            String ProductID = request.getParameter("ProductID");
            String EmployeeID = request.getParameter("EmployeeID");
            String AmountModification = request.getParameter("AmountModification");
            String ModificationTime = request.getParameter("ModificationTime");
            String TotalPrice = request.getParameter("TotalPrice");

            sql = "INSERT INTO Transaction (ProductID,EmployeeID,AmountModification,ModificationTime,TotalPrice) " +
                    "VALUES ("+Integer.valueOf(ProductID)+","+Integer.valueOf(EmployeeID)+","+Integer.valueOf(AmountModification)+
                    ",'"+ModificationTime+"'," +Integer.valueOf(TotalPrice)+")";

            try{
                JSONObject status = new JSONObject();
                if(CurrentDepartmentName.equals("logistic")){
                    DBManager db = new DBManager(sql);
                    db.pst.executeUpdate();
                    status.accumulate("status",1);
                }else {
                    status.accumulate("status",-1);
                }
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(operation.equals("insertSupplier")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            String SupplierName = request.getParameter("SupplierName");
            String EmployeeID = request.getParameter("EmployeeID");
            String SupplierAddress = request.getParameter("SupplierAddress");


            sql = "INSERT INTO Supplier (SupplierName,EmployeeID,SupplierAddress) " +
                    "VALUES ('"+SupplierName+"',"
                    +Integer.valueOf(EmployeeID)+",'"+SupplierAddress+"')";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                db.pst.executeUpdate();
                status.accumulate("status",1);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(operation.equals("insertComment")){

            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            String EmployeeID = request.getParameter("PostBy");
            String Content = request.getParameter("Content");


            sql = "INSERT INTO Comment (Content,PostBy) " +
                    "VALUES ('"+Content+"', "
                    +Integer.valueOf(EmployeeID)+")";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                db.pst.executeUpdate();
                status.accumulate("status",1);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (operation.equals("employeeUpdate")){
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
//            String ProductID = request.getParameter("ProductID");
//            String ProductName = request.getParameter("ProductName");
//            String StorageAmount = request.getParameter("StorageAmount");
//            String SupplierID = request.getParameter("SupplierID");
//            String BuyingPrice = request.getParameter("BuyingPrice");
//            String SellingPrice = request.getParameter("SellingPrice");
//            String Category = request.getParameter("Category");
//            String Description = request.getParameter("Description");


            String DepartmentName = request.getParameter("DepartmentName");
//            String EmployeeID = request.getParameter("EmployeeID");
            String sql1 = "";


            if (DepartmentName.equals("human resource")){
                try{
                    JSONObject status = new JSONObject();
                    String changedEmployeeID = request.getParameter("EmployeeID");
                    DBManager db = new DBManager(sql1);
                    sql1 = "select * from Employee where EmployeeID = " + changedEmployeeID;
                    DBManager db1 = new DBManager(sql1);
                    ret = db1.pst.executeQuery();
                    String ChangedDepartmentName = "";
                    String ChangedEmployeeName = "";
                    String ChangedEmployeePhone = "";
                    String ChangedEmployeeAddress = "";
                    String ChangedSalary = "";
                    while(ret.next()){
                        ChangedDepartmentName = ret.getString("DepartmentName");
                        if(ChangedDepartmentName.equals("human resource")){
                            status.accumulate("status",-1);


                            break;
                        }
                        ChangedEmployeeName = ret.getString("EmployeeName");
                        ChangedEmployeePhone = ret.getString("EmployeePhone");
                        ChangedEmployeeAddress = ret.getString("EmployeeAddress");
                        ChangedSalary = ret.getString("Salary");
                    }
                    if(ChangedDepartmentName.equals("human resource")){
                        out.print(status);
                    }else{
                        String ChangedEmployeeNameNew = request.getParameter("EmployeeName");
                        String ChangedDepartmentNameNew = request.getParameter("changedDepartmentName");
                        String ChangedEmployeePhoneNew = request.getParameter("EmployeePhone");
                        String ChangedEmployeeAddressNew = request.getParameter("EmployeeAddress");
                        String ChangedSalaryNew = request.getParameter("Salary");
                        if(ChangedEmployeeNameNew.equals(""))
                            ChangedEmployeeNameNew = ChangedEmployeeName;
                        if(ChangedDepartmentNameNew.equals(""))
                            ChangedDepartmentNameNew = ChangedDepartmentName;
                        if(ChangedEmployeePhoneNew.equals(""))
                            ChangedEmployeePhoneNew = ChangedEmployeePhone;
                        if(ChangedEmployeeAddressNew.equals(""))
                            ChangedEmployeeAddressNew = ChangedEmployeeAddress;
                        if(ChangedSalaryNew.equals(""))
                            ChangedSalaryNew = ChangedSalary;
                        String sql2 = "update Employee Set DepartmentName = '"+ ChangedDepartmentNameNew +"', EmployeeName = '"+ChangedEmployeeNameNew +
                                "', EmployeePhone = '" + ChangedEmployeePhoneNew + "', EmployeeAddress = '" + ChangedEmployeeAddressNew + "', Salary = " + Double.valueOf(ChangedSalaryNew)+ " where EmployeeID = "
                                +changedEmployeeID;
                        DBManager db2 = new DBManager(sql2);
                        db2.pst.executeUpdate();
                        status.accumulate("status",1);
                        out.print(status);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    JSONObject status = new JSONObject();
                    status.accumulate("status",-1);
                    out.print(status.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else if (operation.equals("productUpdate")){
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            String ProductID = request.getParameter("ProductID");
            String ProductName = request.getParameter("ProductName");
            String StorageAmount = request.getParameter("StorageAmount");
            String SupplierID = request.getParameter("SupplierID");
            String BuyingPrice = request.getParameter("BuyingPrice");
            String SellingPrice = request.getParameter("SellingPrice");
            String Category = request.getParameter("Category");
            String Description = request.getParameter("Description");


            String DepartmentName = request.getParameter("DepartmentName");
            String EmployeeID = request.getParameter("EmployeeID");
            String sql1 = "select * from Product where ProductID = " + ProductID;
            DBManager db = new DBManager(sql1);

            if(DepartmentName.equals("logistic") || DepartmentName.equals("cashier")){
                try{
                    JSONObject status = new JSONObject();
                    ret = db.pst.executeQuery();
                    String ProductNameOld = "";
                    String StorageAmountOld = "";
                    String SupplierIDOld = "";
                    String BuyingPriceOld = "";
                    String SellingPriceOld = "";
                    String CategoryOld = "";
                    String DescriptionOld = "";
                    boolean changedStorage = true;
                    if(ret.first()){
                        ProductNameOld = (ret.getString("ProductName"));
                        StorageAmountOld = (ret.getString("StorageAmount"));
                        SupplierIDOld = (ret.getString("SupplierID"));
                        BuyingPriceOld = (ret.getString("BuyingPrice"));
                        SellingPriceOld = (ret.getString("SellingPrice"));
                        CategoryOld = (ret.getString("Category"));
                        DescriptionOld = (ret.getString("Description"));
                    }

                    int AmountModification = 0;
                    if(ProductName.equals(""))
                        ProductName = ProductNameOld;
                    if(StorageAmount.equals("")){
                        StorageAmount = StorageAmountOld;
                        changedStorage = false;
                    }else{
                        AmountModification = Integer.valueOf(StorageAmount) - Integer.valueOf(StorageAmountOld);
                    }
                    if(SupplierID.equals(""))
                        SupplierID = SupplierIDOld;
                    if(BuyingPrice.equals(""))
                        BuyingPrice = BuyingPriceOld;
                    if(SellingPrice.equals(""))
                        SellingPrice = SellingPriceOld;
                    if(Category.equals(""))
                        Category = CategoryOld;
                    if(Description.equals(""))
                        Description = DescriptionOld;




                    String sql2 = "update Product Set ProductName = '"+ ProductName +"', StorageAmount = "+Integer.valueOf(StorageAmount) +
                            ", SupplierID = " + Integer.valueOf(SupplierID) + ", BuyingPrice = " + Double.valueOf(BuyingPrice) + ", SellingPrice = " + Double.valueOf(SellingPrice) +
                            ", Category = '" + Category + "', Description = '" + Description + "' where ProductID = " + Integer.valueOf(ProductID);

                    DBManager db2 = new DBManager(sql2);
                    db2.pst.executeUpdate();
                    if(changedStorage){
                        Timestamp ModificationTime = new Timestamp(System.currentTimeMillis());
                        String sql3 = "INSERT INTO Transaction (ProductID,EmployeeID,AmountModification,ModificationTime,TotalPrice) " +
                                "VALUES ("+Integer.valueOf(ProductID)+","+Integer.valueOf(EmployeeID)+","+Integer.valueOf(AmountModification)+
                                ",'"+ModificationTime+"'," +(Double.valueOf(BuyingPrice)*(double)AmountModification)+")";
                        DBManager db3 = new DBManager(sql3);
                        db3.pst.executeUpdate();
                    }
                    status.accumulate("status",1);
                    out.print(status.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                try{
                    JSONObject status = new JSONObject();
                    status.accumulate("status",-1);
                    out.print(status.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else if(operation.equals("Login")){
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            sql = "select * from Employee where EmployeeID = " + username + " and EmployeePhone = '" + password + "'";
            DBManager db = new DBManager(sql);
            try {
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                String DepartmentName = "";
                if(ret.first()){
                    DepartmentName = ret.getString("DepartmentName");
                    status.accumulate("status",1);
                    status.accumulate("DepartmentName",DepartmentName);
                }else {
                    status.accumulate("status",-1);
                }
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if(operation.equals("Comment")) {
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            sql = "select * from Comment order by CommentID desc limit 100";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> commentID = new ArrayList<>();
                List<String> content = new ArrayList<>();
                List<String> postBy = new ArrayList<>();
                int counter = 0;
                while(ret.next()){
                    commentID.add(ret.getString("CommentID"));
                    content.add(ret.getString("Content"));
                    postBy.add(ret.getString("PostBy"));

                }
                Collections.reverse(commentID);
                Collections.reverse(content);
                Collections.reverse(postBy);
                status.accumulate("CommentID", commentID);
                status.accumulate("Content",content);
                status.accumulate("PostBy",postBy);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        else if(operation.equals("Profit")) {
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            sql = "select * from Profit";
            DBManager db = new DBManager(sql);
            try{
                JSONObject status = new JSONObject();
                ret = db.pst.executeQuery();
                List<String> profitID = new ArrayList<>();
                List<String> mExpenses = new ArrayList<>();
                List<String> mIncome = new ArrayList<>();
                List<String> mProfit = new ArrayList<>();
                int counter = 0;
                while(ret.next()){
                    counter++;
                    profitID.add(ret.getString("ProfitID"));
                    mExpenses.add(ret.getString("MonthlyExpenses"));
                    mIncome.add(ret.getString("MonthlyIncome"));
                    mProfit.add(ret.getString("MonthlyProfit"));
                    if(counter == 100)
                        break;
                }
                status.accumulate("ProfitID", profitID);
                status.accumulate("MonthlyExpenses",mExpenses);
                status.accumulate("MonthlyIncome",mIncome);
                status.accumulate("MonthlyProfit",mProfit);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        else if(operation.equals("DeleteEmployee")) {
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            String EmployeeDepartment = request.getParameter("EmployeeDepartmentName");
            String employeeID = request.getParameter("EmployeeID");
            int deleteOrNot = -1;
//            String deletionStatus = "Deletion Failed";

            sql = "delete from Employee where EmployeeID = " + employeeID + ";";

            try{
                JSONObject status = new JSONObject();
                if(EmployeeDepartment.equals("human resource")){
                    DBManager db = new DBManager(sql);
                    db.pst.executeUpdate();
                    deleteOrNot = 1;
                }
                status.accumulate("status",deleteOrNot);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        else if(operation.equals("DeleteProduct")) {
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            String EmployeeDepartment = request.getParameter("EmployeeDepartmentName");
            String productID = request.getParameter("ProductID");
            int deleteOrNot = -1;
//            String deletionStatus = "Deletion Failed";

            sql = "delete from Product where ProductID = " + productID + ";";

            try{
                JSONObject status = new JSONObject();
                if(EmployeeDepartment.equals("logistic")){
                    DBManager db = new DBManager(sql);
                    db.pst.executeUpdate();
                    deleteOrNot = 1;
                }
                status.accumulate("status",deleteOrNot);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(operation.equals("DeleteSupplier")) {
            HttpSession session = request.getSession(true);
            String sessionID = session.getId();

            String EmployeeDepartment = request.getParameter("EmployeeDepartmentName");
            String supplierID = request.getParameter("SupplierID");
            int deleteOrNot = -1;
//            String deletionStatus = "Deletion Failed";

            sql = "delete from Supplier where SupplierID = " + supplierID + ";";

            try{
                JSONObject status = new JSONObject();
                if(EmployeeDepartment.equals("logistic")){
                    DBManager db = new DBManager(sql);
                    db.pst.executeUpdate();
                    deleteOrNot = 1;
                }
                status.accumulate("status",deleteOrNot);
                out.print(status.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }
}

