package Utils;

import com.Model.AdminModel;
import com.Model.StockModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class StockDataManager {

    public static String filePath = "Resources\\Stock.txt";
    public String separator = "\\|";

    public static ArrayList<StockModel> stocks = new ArrayList<StockModel>();

    public void Load(){
        try{
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){

                String tableRow = scanner.nextLine();
                String[] StockData = tableRow.split(separator);
                StockModel stock = new StockModel();

                //StockName
                stock.setStockName(StockData[0]);

                //StockAmount
                int AmountToInt = Integer.parseInt(StockData[1]);
                stock.setAmount(AmountToInt);

                //StockPrice
                float PriceToFloat = Float.parseFloat(StockData[2]);
                stock.setPrice(PriceToFloat);

                //StockBarcode
                int BarcodeToInt = Integer.parseInt(StockData[3]);
                stock.setBarcode(BarcodeToInt);

                stocks.add(stock);

            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void Save(){
        try{

            FileWriter writer = new FileWriter(filePath);

            for(int i = 0; i < stocks.size(); i++){
                String data = "";

                if(i > 0){
                    data += "\n";
                }

                data += stocks.get(i).getStockName();

                data += "|" + stocks.get(i).getAmount();

                data += "|" + stocks.get(i).getPrice();

                data += "|" + stocks.get(i).getBarcode();

                writer.write(data);
            }
            writer.close();
            System.out.println("File Saved");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void Update(ArrayList<StockModel> stocks){
        int ListSize = stocks.size();

        try{
            PrintWriter pw = new PrintWriter(filePath);
            pw.close();

            FileWriter pw1 = new FileWriter(filePath, false);
            BufferedWriter bw = new BufferedWriter((pw1));

            for(StockModel stock : stocks){
                String data ="";
                data += stock.getStockName();
                data +=  "|" + Integer.toString(stock.getAmount());
                data +=  "|" + Float.toString(stock.getPrice());
                data +=  "|" + Integer.toString(stock.getBarcode());

                bw.write(data);
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public StockModel getStockAt(int index){
        if(index >= stocks.size()){
            return null;
        }
        return stocks.get(index);
    }

    public void addStock(StockModel newStock){
        stocks.add(newStock);
    }

    public void removeStock(StockModel oldStock){
        stocks.remove(oldStock);
    }

    public ArrayList<StockModel> getStockList(){
        return stocks;
    }
}
