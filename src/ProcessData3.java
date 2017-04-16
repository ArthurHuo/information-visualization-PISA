import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by huoar on 2015/11/9.
 */
public class ProcessData3 {
    public void processData3(){
//        processData_LateSkipAverage();
//        processData_ScatterLateSkip();
//        processData_CellTVCarAverage();
//        processData_BookAtHomeAverage();
        processData_ScatterBooks();
    }


    public void processData_ScatterLateSkip(){
        String sourceFile1 = "LateSkipAverage.csv";
        String sourceFile2 = "scoreAverageByCountry.csv";
        String targetFile = "scatterLateSkip.csv";

        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter writer = null;

        String line = "";
        String line2 = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,LateForSchool,SkipWholeDay,SkipClass,Score");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile1));
            br2 = new BufferedReader(new FileReader(sourceFile2));
            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            line2 = br2.readLine();
            while ((line = br.readLine()) != null) {
                line2 = br2.readLine();
                String[] sample = line.split(cvsSplitBy);
                String[] sample2 = line2.split(cvsSplitBy);
                writer.write(sample[0]+","+sample[1]+","+sample[2]+","+sample[3]+","+sample2[1]);
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

    public void processData_ScatterBooks(){
        String sourceFile1 = "scatterLateSkip.csv";
        String sourceFile2 = "bookAtHomeAverage.csv";
        String targetFile = "scatterBooks.csv";

        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter writer = null;

        String line = "";
        String line2 = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,LateForSchool,SkipWholeDay,SkipClass,Score,Books");
            writer.newLine();

            writer.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(sourceFile1));
            br2 = new BufferedReader(new FileReader(sourceFile2));
            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();
            line2 = br2.readLine();
            while ((line = br.readLine()) != null) {
                line2 = br2.readLine();
                String[] sample = line.split(cvsSplitBy);
                String[] sample2 = line2.split(cvsSplitBy);
                writer.write(sample[0]+","+sample[1]+","+sample[2]+","+sample[3]+","+sample[4]+","+sample2[1]);
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

    public void processData_LateSkipAverage(){
        String sourceFile = "studentLateSkip.csv";
        String targetFile = "LateSkipAverage.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,LateForSchool,SkipWholeDay,SkipClass");
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
                int sum2 = 0;
                int count2 = 0;
                int sum3 = 0;
                int count3 = 0;
                while ((line = br.readLine()) != null) {
                    String[] sample = line.split(cvsSplitBy);
                    if(sample[0].equals(al.get(i))){
                        sum +=Double.valueOf(sample[1]);
                        count +=1;
                        sum2 +=Double.valueOf(sample[2]);
                        count2 +=1;
                        sum3 +=Double.valueOf(sample[3]);
                        count3 +=1;
                    }

                }
                double result = (double)sum/(double)count;
                double result2 = (double)sum2/(double)count2;
                double result3 = (double)sum3/(double)count3;

                DecimalFormat df = new DecimalFormat("#.00");

                writer.write(al.get(i).replaceAll("\"","")+","+df.format(result)+","+df.format(result2)+","+df.format(result3));
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


    public void processData_CellTVCarAverage(){
        String sourceFile = "studentPhoneTVComputer.csv";
        String targetFile = "PhoneTVComputerAverage.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,CellularPhones,Televisions,Computers,Cars,RoomsWithABathOrShower");
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
                int sum2 = 0;
                int count2 = 0;
                int sum3 = 0;
                int count3 = 0;
                int sum4 = 0;
                int count4 = 0;
                int sum5 = 0;
                int count5 = 0;
                while ((line = br.readLine()) != null) {
                    String[] sample = line.split(cvsSplitBy);
                    if(sample[0].equals(al.get(i))){
                        sum +=Double.valueOf(sample[1]);
                        count +=1;
                        sum2 +=Double.valueOf(sample[2]);
                        count2 +=1;
                        sum3 +=Double.valueOf(sample[3]);
                        count3 +=1;
                        sum4 +=Double.valueOf(sample[4]);
                        count4 +=1;
                        sum5 +=Double.valueOf(sample[5]);
                        count5 +=1;
                    }

                }
                double result = (double)sum/(double)count;
                double result2 = (double)sum2/(double)count2;
                double result3 = (double)sum3/(double)count3;
                double result4 = (double)sum4/(double)count4;
                double result5 = (double)sum5/(double)count5;

                DecimalFormat df = new DecimalFormat("#.00");

                writer.write(al.get(i).replaceAll("\"","")+","+df.format(result)+","+df.format(result2)+","+df.format(result3)+","+df.format(result4)+","+df.format(result5));
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

    public void processData_BookAtHomeAverage(){
        String sourceFile = "bookAtHome.csv";
        String targetFile = "bookAtHomeAverage.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,Books");
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
                        sum +=Double.valueOf(sample[1]);
                        count +=1;

                    }

                }
                double result = (double)sum/(double)count;


                DecimalFormat df = new DecimalFormat("#.00");

                writer.write(al.get(i).replaceAll("\"", "")+","+df.format(result));
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

}
