
package Models;


import DbConnection.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO extends Conexion
{
    public int InsertCustomer(Customer customer)
    {
        int result = 0;
        
        try
        {
            this.GetConnection();
            String sql = "Insert Into customer (Name, Age, IdCategory) Values (?,?,?)";
            PreparedStatement preparedStatement = this.GetConnection().prepareCall(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, customer.getAge());
            preparedStatement.setInt(3, customer.getIdCategory());
            
            result = preparedStatement.executeUpdate();
            
        }
        catch (SQLException e)
        {
            System.out.println("ERROR to Insert Customer in CustomerDAO: " + e.getMessage());
        }
        finally
        {
            this.Disconnected();
        }
        
        return result;
    }
    
    public ArrayList<Customer> ShowCustomers()
    {
        var CustomerList = new ArrayList<Customer>();
        
        try
        {
            this.GetConnection();
            
            var sql = "Select * From customer as cu INNER JOIN category as ca ON cu.IdCategory=ca.IdCategory";
            PreparedStatement preparedStatement = this.GetConnection().prepareCall(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Customer customer = new Customer();
                customer.setIdCustomer(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setAge(resultSet.getInt(3));
                customer.setIdCategory(resultSet.getInt(4));
                customer.setCategory(resultSet.getNString(6));
                
                CustomerList.add(customer);
                
            }           
           
        }
        catch (SQLException e)
        {
            System.out.println("ERROR to Show Customeers in CustomerDAO: " + e.getMessage());
        }
        finally
        {
            this.Disconnected();
        }
        
        return CustomerList;
    }
    
    public int EditCustomer(Customer customer)
    {
        int result = 0;
        
        try
        {
            this.GetConnection();
            //UPDATE `customer` SET `IdCustomer`='[value-1]',`Name`='[value-2]',`Age`='[value-3]',`IdCategory`='[value-4]' WHERE 1
            var sql = "UPDATE customer SET Name=?,Age=?,IdCategory=? WHERE IdCustomer=?";
            
            PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setInt(2, customer.getAge());
            preparedStatement.setInt(3, customer.getIdCategory());
            preparedStatement.setInt(4, customer.getIdCustomer());
            result = preparedStatement.executeUpdate();
            
        }
        catch (SQLException e)
        {
         System.out.println("ERROR to Edit Customer in CuatomerDAO: " + e.getMessage());

        }    
        finally
        {
          this.Disconnected();
        }
    
        return result;
    }
    
    public int DeleteCustomer(Customer customer)
    {
        int result = 0;
        
        try
        {
            this.GetConnection();
            
            var sql = "DELETE FROM customer WHERE IdCustomer=?";
            PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
            preparedStatement.setInt(1, customer.getIdCustomer());
            result = preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("ERROR to Delete Customer in CustomerDAO: " + e.getMessage());
        }
        finally
        {
            this.Disconnected();
        }
        
        return result;
    }   
    

    
//    public static void main(String[] args)
//    {
//        CustomerDAO customerDAO = new CustomerDAO();
//        
//        
//        for ( Customer customer : customerDAO.ShowCustomers())
//        {
//            System.out.println("Id       : " + customer.getIdCustomer() 
//                             + " Name    : " + customer.getName() 
//                             + " Age     : " + customer.getAge() 
//                             + " Category: " + customer.getCategory() );
//        }
//        
////        CustomerDAO customerDAO = new CustomerDAO();
////        Customer customer = new Customer();
////        customer.setName("Mary");
////        customer.setAge(35);
////        customer.setIdCategory(2);
////        
////        customerDAO.InsertCustomer(customer);
////        
////        System.out.println("New Customer Insert in the DB.");
////        System.out.println("----------------------------------------");
//       
//        
//    }
}
