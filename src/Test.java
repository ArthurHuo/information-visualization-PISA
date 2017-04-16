import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by huoar on 2015/10/31.
 */
public class Test {
    public static void main(String[] args) {
        String sourceFile = "countries.csv";

        BufferedReader br = null;

        String line = "";
        String cvsSplitBy = ",";
        int index = 1;

        try {
            br = new BufferedReader(new FileReader(sourceFile));
//            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                System.out.println("<label><input type=\"checkbox\" name=\"choice\" id=\"choice"+index+"\" value="+(index-1)+" />"+sample[0].replaceAll("\"", "")+"</label><p></p>");

                index +=1;


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
