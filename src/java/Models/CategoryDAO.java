
package Models;

import DbConnection.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDAO extends Conexion
{
   public  ArrayList<Category> ShowCategoryList()
   {
       ArrayList<Category> categoryList = new ArrayList<Category>();
       
       try
       {
           this.GetConnection();
           
           String sql = "Select * From category";
           PreparedStatement preparedStatement = this.getConexion().prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           
           while (resultSet.next())
           {               
              Category category = new Category();
              category.setIdCategory(resultSet.getInt(1));
              category.setCategory(resultSet.getString(2));
              
              categoryList.add(category);
           }
           
          
       }
       catch (Exception e)
       {
           System.out.println("ERROR to Show Category List in CategpryDAO: " + e.getMessage());
       }
       finally
       {
          this.Disconnected();    
       }
       
       return categoryList;
       
   }
   
//    public static void main(String[] args)
//    {
//        CategoryDAO categoryDAO = new CategoryDAO();
//        ArrayList<Category> categories = categoryDAO.ShowCategoryList();
//        for (Category category : categories)
//        {
//            System.out.println("Id: " + category.getIdCategory() + " Category Name: " + category.getCategory());
//        }
//    }
}
