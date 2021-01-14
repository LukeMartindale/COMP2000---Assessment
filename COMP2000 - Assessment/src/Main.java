import Utils.AdminDataManager;
import Utils.StockDataManager;
import com.Controller.*;
import com.Model.*;
import com.View.*;

import javax.swing.text.View;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Saving * loading in Java

        AdminDataManager adminManager = new AdminDataManager();

        adminManager.Load();

        //Creates instance of stockManager
        StockDataManager stockManager = new StockDataManager();

        //Loads Stock.txt file into program to allow for it to be used
        stockManager.Load();

        AdminModel model = new AdminModel();

        AbstractView viewLogin = new LoginView();
        AbstractController controller = new LoginController(model, viewLogin);

        AbstractView viewKiosk = new KioskView();

    }

}
