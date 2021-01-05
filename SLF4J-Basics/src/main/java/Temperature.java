import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Temperature
{
    // CRUD
    // Create , Read , Update , Delete

    final Logger slj4jLogger = LoggerFactory.getLogger(Temperature.class);
    Integer old_temperature;
    Integer new_temperature;

    // Create
    public Integer getOld_temperature() {
        slj4jLogger.info("Old Temperature: {}",old_temperature);
        return old_temperature;
    }

    public void setOld_temperature(Integer old_temperature) {
        slj4jLogger.info("Temperature Successfully  added : {}",old_temperature);
        this.old_temperature = old_temperature;
    }

    public Integer getNew_temperature() {
        slj4jLogger.info("New Temperature: {}",new_temperature);
        return new_temperature;
    }

    public void setNew_temperature(Integer new_temperature) {
        slj4jLogger.info("Temperature Successfully added : {}",new_temperature);
        this.new_temperature = new_temperature;
    }

    // Read
    void display()
    {
        if (getOld_temperature() == null)
        {
            slj4jLogger.warn("old Temperature has not been Declared thus it will return null");
        }
        else if (getNew_temperature() == null)
        {
            slj4jLogger.warn("New Temperature has not been Declared thus it will return null");
        }
        else {
            slj4jLogger.debug("Temperature set to {}. Old temperature was {}.", getNew_temperature(), getOld_temperature());
            System.out.println("New Temperature : = "+getNew_temperature()+"\nold Temperature : = "+getOld_temperature()+ " ");
        }
    }

    // Update
    void update(Integer Temporary_temperature)
    {
        // this method is responsible to change the old temperature to new
        // and set new temperature to temporary Temperature
        if (getNew_temperature() == null)
        {
            slj4jLogger.warn("New Temperature has not been declared Thus setting the old temperature to 0");
            slj4jLogger.debug("New Temperature is {}",getNew_temperature() );
            setOld_temperature(0);
        }
        else
        {
            setOld_temperature(getNew_temperature());
        }
        setNew_temperature(Temporary_temperature);
        slj4jLogger.info("Temperature successfully updated : New Temperature = {}  Old Temperature = {} ",getNew_temperature(),getOld_temperature());
        System.out.println("New Temperature : = "+getNew_temperature()+"\nold Temperature : = "+getOld_temperature()+ " ");
    }

    void delete(char choice )
    {
        switch (choice)
        {
            case '1':         slj4jLogger.info("choice is {}.Delete Old Temperature",choice);
                slj4jLogger.warn("Old Temperatures set to 0 ");
                setOld_temperature(0);
                break;
            case '2': slj4jLogger.info("choice is {}.Delete New Temperature",choice);
                slj4jLogger.warn("New Temperatures set to 0 ");
                setNew_temperature(0);
                break;
            case '3' :slj4jLogger.info("choice is {}.Delete both Temperature",choice);
                slj4jLogger.warn("Both Temperatures set to 0 ");
                setOld_temperature(0);
                setNew_temperature(0);
                break;
            default:
                slj4jLogger.error("Invalid Choice");
                break;
        }
    }
    public static void main(String[] args) {
        Temperature obj = new Temperature();
        System.out.println("_______________________________________________________________");
        System.out.println("_______________________________________________________________");
        System.out.println("_______________________________________________________________");
        obj.setNew_temperature(20);
        System.out.println("_______________________________________________________________");
        System.out.println("_______________________________________________________________");
        obj.setOld_temperature(10);
        System.out.println("_______________________________________________________________");
        System.out.println("_______________________________________________________________");
        obj.display();
        System.out.println("_______________________________________________________________");
        System.out.println("_______________________________________________________________");
        Scanner in =new Scanner(System.in);
        System.out.println("enter Temperature to be updated : ");
        obj.update(30);
        System.out.println("_______________________________________________________________");
        System.out.println("_______________________________________________________________");
        obj.delete('2');
        System.out.println("_______________________________________________________________");
        System.out.println("_______________________________________________________________");

    }
}