package Utils;

import com.Model.AdminModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminDataManager {

    public String filePath = "Resources\\Admins.txt";
    public String separator = "\\|";

    public static ArrayList<AdminModel> admins = new ArrayList<AdminModel>();

    public void Load(){
        try{
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){

                String tableRow = scanner.nextLine();
                String[] AdminData = tableRow.split(separator);
                AdminModel admin = new AdminModel();

                //AdminName
                admin.setAdminName(AdminData[0]);

                //AdminPassword
                admin.setPassword(AdminData[1]);

                //Add Loaded Admin to array list of Admins
                admins.add(admin);

            }
            scanner.close();
            System.out.println("File Loaded");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void Save(){
        try{
            FileWriter writer = new FileWriter(filePath);

            for(int i = 0; i < admins.size(); i++){
                String data = "";

                if(i > 0){
                    data += "\n";
                }

                data += admins.get(i).getAdminName();

                data += "|" + admins.get(i).getPassword();

                writer.write(data);
            }
            writer.close();
            System.out.println("File Saved");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public AdminModel getAdminAt(int index){
        if(index >= admins.size()){
            return null;
        }
        return admins.get(index);
    }

    public void addAdmin(AdminModel newAdmin){
        admins.add(newAdmin);
    }

    public void removeAdmin(AdminModel oldAdmin){
        admins.remove(oldAdmin);
    }

    public ArrayList<AdminModel> getAdminsList(){
        return admins;
    }

}
