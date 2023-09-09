package Java.Project_1;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Profile {
    private String name;
    private int IDNumber;
    private String dateOfCreation;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
    private LocalDateTime now = LocalDateTime.now(); 

    public Profile(String name, int ID)
    {
        this.name = name;
        this.IDNumber = ID;
        this.dateOfCreation = dtf.format(now); 
    }
    
    public Profile(Profile other)
    {
        this.name = other.name;
        this.IDNumber = other.getIDNumber();
        this.dateOfCreation = other.dateOfCreation;  
    }

    public String getName()
    {
        return name;
    }
    
    public int getIDNumber()
    {
        return IDNumber;
    }
    
    public String getDateOfCreation()
    {
        return dateOfCreation;
    }
}
