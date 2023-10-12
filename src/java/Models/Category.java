
package Models;


public class Category
{
    private int idCategory;
    private String Category;

    public Category()
    {
    }

    public Category(int idCategory, String Category)
    {
        this.idCategory = idCategory;
        this.Category = Category;
    }

    public String getCategory()
    {
        return Category;
    }

    public void setCategory(String Category)
    {
        this.Category = Category;
    }

    public int getIdCategory()
    {
        return idCategory;
    }

    public void setIdCategory(int idCategory)
    {
        this.idCategory = idCategory;
    }
    
    
}
