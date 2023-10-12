
package Models;


public class Customer
{
    private int idCustomer;
    private String Name;
    private int Age;
    private int idCategory;
    private String category;

    public Customer()
    {
    }

    public Customer(int idCustomer, String Name, int Age, int idCategory, String category)
    {
        this.idCustomer = idCustomer;
        this.Name = Name;
        this.Age = Age;
        this.idCategory = idCategory;
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public int getIdCustomer()
    {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer)
    {
        this.idCustomer = idCustomer;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public int getAge()
    {
        return Age;
    }

    public void setAge(int Age)
    {
        this.Age = Age;
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
