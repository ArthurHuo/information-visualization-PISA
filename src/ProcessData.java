import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by huoar on 2015/10/28.
 */
public class ProcessData {
    public void processData(){
//        processData_Countries();
//        processData_CountryCodes();
//        processData_Scores();
        processData_AverageScore();
//        processData_BarAll(1);//math
//        processData_BarAll(2);//read
//        processData_BarAll(3);//science
//        processData_BarAverage(1);//math
//        processData_BarAverage(2);//read
//        processData_BarAverage(3);//science
//        processData_BarFinal();
//        processData_MapAll(1);//math
//        processData_MapAll(2);//read
//        processData_MapAll(3);//science
//        processData_MapAverage(1);//math
//        processData_MapAverage(2);//read
//        processData_MapAverage(3);//science
//        processData_RadarMathReadScie();
    }


    public void processData_Countries() {
        String sourceFile = "scoredItem2012.csv";
        String targetFile = "countries.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("country");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                if (!al.contains(sample[1])) {
                    al.add(sample[1]);
                }
            }
            for (int i = 0; i < al.size(); i++) {
                writer.write(al.get(i));
                writer.newLine();
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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void processData_CountryCodes(){
        String sourceFile = "scoredItem2012.csv";
        String targetFile = "countryCodes.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("countryCode");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                if(!al.contains(sample[3].substring(1,4))){
                    al.add(sample[3].substring(1,4));
                }
            }
            for(int i = 0; i < al.size(); i++){
                writer.write(al.get(i));
                writer.newLine();
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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }


    public void processData_RadarMathReadScie(){
//        String sourceFile = "scoredItem2012.csv";
//        String targetFile = "countryCodes.csv";
        String sMath = "mathScoreAverage.csv";
        String sRead = "readScoreAverage.csv";
        String sScie = "scieScoreAverage.csv";
//        String targetFile = "scoreAverage_radar.csv";//score
        String targetFile = "scorePercentage_radar.csv";//percentage

        BufferedReader brM = null;
        BufferedReader brR = null;
        BufferedReader brS = null;
        BufferedWriter writer = null;

        String lineM = "";
        String lineR = "";
        String lineS = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,Mathematics,Reading,Science");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            brM = new BufferedReader(new FileReader(sMath));
            brR = new BufferedReader(new FileReader(sRead));
            brS = new BufferedReader(new FileReader(sScie));
//            ArrayList<String> al = new ArrayList<String>();
            brM.readLine();
            brR.readLine();
            brS.readLine();
            while ((lineM = brM.readLine()) != null) {
                DecimalFormat df = new DecimalFormat("0.00");
                String[] sampleM = lineM.split(cvsSplitBy);
                lineR = brR.readLine();
                String[] sampleR = lineR.split(cvsSplitBy);
                lineS = brS.readLine();
                String[] sampleS = lineS.split(cvsSplitBy);

                writer.write(sampleM[0]+","+df.format(Double.valueOf(sampleM[1]) / 120.0d)+","+df.format(Double.valueOf(sampleR[1])/45.0d)+","+df.format(Double.valueOf(sampleS[1])/56.0d));
                writer.newLine();

            }
//            for(int i = 0; i < al.size(); i++){
//                writer.write(al.get(i));
//                writer.newLine();
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (brM != null) {
                try {
                    brM.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (brR != null) {
                try {
                    brR.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (brS != null) {
                try {
                    brS.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }




    public void processData_AverageScore(){
        String sourceFile = "scoresByCountry.csv";
        String targetFile = "scoreAverageByCountry.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("country,average_score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                if(!al.contains(sample[0])){
                    al.add(sample[0]);
                }
            }
            for(int i = 0; i < al.size(); i++){
//                writer.write(al.get(i));
//                writer.newLine();
                br = new BufferedReader(new FileReader(sourceFile));
                line = br.readLine();
                int sum = 0;
                int count = 0;
                while ((line = br.readLine()) != null) {
                    String[] sample = line.split(cvsSplitBy);
                    if(sample[0].equals(al.get(i))){
                        sum +=Integer.valueOf(sample[1]);
                        count +=1;
                    }

                }
                double result = (double)sum/(double)count;
                DecimalFormat df = new DecimalFormat("#.00");

                writer.write(al.get(i).replaceAll("\"","")+","+df.format(result));
//                int result = sum/count;
//                writer.write(al.get(i)+","+result);
                writer.newLine();


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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }



    public void processData_BarFinal(){
        String sourceFile = "mathScoreAverage.csv";
        String targetFile = "barScoreAverage.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("country,Channel,average_score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] sample = line.split(cvsSplitBy);
                writer.write(sample[0]+",Mathematics,"+sample[1]);
                writer.newLine();
            }

            sourceFile = "readScoreAverage.csv";
            br = new BufferedReader(new FileReader(sourceFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] sample = line.split(cvsSplitBy);
                writer.write(sample[0]+",Reading,"+sample[1]);
                writer.newLine();
            }

            sourceFile = "scieScoreAverage.csv";
            br = new BufferedReader(new FileReader(sourceFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] sample = line.split(cvsSplitBy);
                writer.write(sample[0]+",Science,"+sample[1]);
                writer.newLine();
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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }




    public void processData_Scores(){
        String sourceFile = "scoredItem2012.csv";
        String targetFile = "scoresByCountry.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("country,score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
//            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            int sum = 0;
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                sum = 0;
                for(int i = 0; i < sample.length;i++){
                    if(sample[i].equals("\"Score 1\"")){
                        sum += 1;
                    }else if(sample[i].equals("\"Score 2\"")){
                        sum += 2;
                    }
                }

                writer.write(sample[1]+","+sum);
//                writer.write(sample[1].replaceAll("\"","")+","+sum);
                writer.newLine();
//                if(!al.contains(sample[1])){
//                    al.add(sample[1]);
//                }
            }
//            for(int i = 0; i < al.size(); i++){
//                writer.write(al.get(i));
//                writer.newLine();
//            }

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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }



    public void processData_BarAll(int index){
        String sourceFile = "scoredItem2012.csv";
        String targetFile = "";
        if(index == 1){
            targetFile = "mathScoreAll.csv";
        }else if(index == 2){
            targetFile = "readScoreAll.csv";
        }else if(index == 3){
            targetFile = "scieScoreAll.csv";
        }


        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("country,score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
//            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            int sum = 0;
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                sum = 0;
//                for(int i = 0; i < sample.length;i++){
//                    if(sample[i].equals("\"Score 1\"")){
//                        sum += 1;
//                    }else if(sample[i].equals("\"Score 2\"")){
//                        sum += 2;
//                    }
//                }
                //math
                if(index == 1){
                    for(int i = 9; i <= 117;i++){
                        if(sample[i].equals("\"Score 1\"")){
                            sum += 1;
                        }else if(sample[i].equals("\"Score 2\"")){
                            sum += 2;
                        }
                    }
                }

                if(index == 2){
                    //read
                    for(int i = 118; i <= 161;i++){
                        if(sample[i].equals("\"Score 1\"")){
                            sum += 1;
                        }else if(sample[i].equals("\"Score 2\"")){
                            sum += 2;
                        }
                    }
                }

                if(index == 3){
                    //science
                    for(int i = 162; i <= 214;i++){
                        if(sample[i].equals("\"Score 1\"")){
                            sum += 1;
                        }else if(sample[i].equals("\"Score 2\"")){
                            sum += 2;
                        }
                    }
                }



//                writer.write(sample[3].substring(1,4)+","+sum);
                writer.write(sample[1].replaceAll("\"","")+","+sum);
                writer.newLine();
//                if(!al.contains(sample[1])){
//                    al.add(sample[1]);
//                }
            }
//            for(int i = 0; i < al.size(); i++){
//                writer.write(al.get(i));
//                writer.newLine();
//            }

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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }


    public void processData_MapAll(int index){
        String sourceFile = "scoredItem2012.csv";
        String targetFile = "";
        if(index == 1){
            targetFile = "mathScoreAll_map.csv";
        }else if(index == 2){
            targetFile = "readScoreAll_map.csv";
        }else if(index == 3){
            targetFile = "scieScoreAll_map.csv";
        }


        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("ISO,score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
//            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            int sum = 0;
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                sum = 0;
//                for(int i = 0; i < sample.length;i++){
//                    if(sample[i].equals("\"Score 1\"")){
//                        sum += 1;
//                    }else if(sample[i].equals("\"Score 2\"")){
//                        sum += 2;
//                    }
//                }
                //math
                if(index == 1){
                    for(int i = 9; i <= 117;i++){
                        if(sample[i].equals("\"Score 1\"")){
                            sum += 1;
                        }else if(sample[i].equals("\"Score 2\"")){
                            sum += 2;
                        }
                    }
                }

                if(index == 2){
                    //read
                    for(int i = 118; i <= 161;i++){
                        if(sample[i].equals("\"Score 1\"")){
                            sum += 1;
                        }else if(sample[i].equals("\"Score 2\"")){
                            sum += 2;
                        }
                    }
                }

                if(index == 3){
                    //science
                    for(int i = 162; i <= 214;i++){
                        if(sample[i].equals("\"Score 1\"")){
                            sum += 1;
                        }else if(sample[i].equals("\"Score 2\"")){
                            sum += 2;
                        }
                    }
                }



                writer.write(sample[3].substring(1, 4)+","+sum);
//                writer.write(sample[1].replaceAll("\"","")+","+sum);
                writer.newLine();
//                if(!al.contains(sample[1])){
//                    al.add(sample[1]);
//                }
            }
//            for(int i = 0; i < al.size(); i++){
//                writer.write(al.get(i));
//                writer.newLine();
//            }

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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }



    public void processData_BarAverage(int index){
        String sourceFile = "";
        String targetFile = "";
        if(index == 1){
            sourceFile = "mathScoreAll.csv";
        }else if(index == 2){
            sourceFile = "readScoreAll.csv";
        }else if(index == 3){
            sourceFile = "scieScoreAll.csv";
        }
        if(index == 1){
            targetFile = "mathScoreAverage.csv";
        }else if(index == 2){
            targetFile = "readScoreAverage.csv";
        }else if(index == 3){
            targetFile = "scieScoreAverage.csv";
        }


        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("country,score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                if(!al.contains(sample[0])){
                    al.add(sample[0]);
                }
            }
            for(int i = 0; i < al.size(); i++){
//                writer.write(al.get(i));
//                writer.newLine();
                br = new BufferedReader(new FileReader(sourceFile));
                line = br.readLine();
                int sum = 0;
                int count = 0;
                while ((line = br.readLine()) != null) {
                    String[] sample = line.split(cvsSplitBy);
                    if(sample[0].equals(al.get(i))){
                        sum +=Integer.valueOf(sample[1]);
                        count +=1;
                    }

                }
                double result = (double)sum/(double)count;
                DecimalFormat df = new DecimalFormat("#.00");

                writer.write(al.get(i)+","+df.format(result));
//                int result = sum/count;
//                writer.write(al.get(i)+","+result);
                writer.newLine();


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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }


    public void processData_MapAverage(int index){
        String sourceFile = "";
        String targetFile = "";
        if(index == 1){
            sourceFile = "mathScoreAll_map.csv";
        }else if(index == 2){
            sourceFile = "readScoreAll_map.csv";
        }else if(index == 3){
            sourceFile = "scieScoreAll_map.csv";
        }
        if(index == 1){
            targetFile = "mathScoreAverage_map.csv";
        }else if(index == 2){
            targetFile = "readScoreAverage_map.csv";
        }else if(index == 3){
            targetFile = "scieScoreAverage_map.csv";
        }


        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("ISO,score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));
            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
                if(!al.contains(sample[0])){
                    al.add(sample[0]);
                }
            }
            for(int i = 0; i < al.size(); i++){
//                writer.write(al.get(i));
//                writer.newLine();
                br = new BufferedReader(new FileReader(sourceFile));
                line = br.readLine();
                int sum = 0;
                int count = 0;
                while ((line = br.readLine()) != null) {
                    String[] sample = line.split(cvsSplitBy);
                    if(sample[0].equals(al.get(i))){
                        sum +=Integer.valueOf(sample[1]);
                        count +=1;
                    }

                }
                double result = (double)sum/(double)count;
                DecimalFormat df = new DecimalFormat("#.00");

                writer.write(al.get(i)+","+df.format(result));
//                int result = sum/count;
//                writer.write(al.get(i)+","+result);
                writer.newLine();


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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }





    public void processData_Countries111(){
        String sourceFile = "scoredItem2012.csv";
        String targetFile = "countries.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("countries");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile));

            while ((line = br.readLine()) != null) {

                String[] sample = line.split(cvsSplitBy);
//                writer.write(line);
//                writer.newLine();
//                String newLine = line.replace(" ", ",");
//                System.out.println(aa);

//                if (i < 500) {
//                    wTrain.write(newLine);
//                    wTrain.newLine();
//                } else {
//                    wTest.write(newLine);
//                    wTest.newLine();
//                }
//                i++;
//                String[] sample = line.split(cvsSplitBy);
//                double f1 = Double.valueOf(sample[0]);
//                double f2 = Double.valueOf(sample[1]);
//                double f3 = Double.valueOf(sample[2]);
//                double f4 = Double.valueOf(sample[3]);
//                double contructed = 0.0;

//                if((f2*(f1-f3)) == 0){
//                    contructed = 1;
//                }else{
//                    contructed = ((f1-f3)*f4)/(f2*(f1-f3));
//                }
//                contructed = f3*f4-f1*f2;

//                String newLine = contructed + ","+ sample[4];
//                line = br.readLine();
//                writer.write(line);
//                System.out.println(line);
//                System.out.println("-------------------------------------");
//                line = br.readLine();
//                System.out.println(line);
//                String newLine = line;
//                wTrain.write(newLine);
//                wTrain.newLine();

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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
