import java.io.*;
import java.util.ArrayList;

/**
 * Created by angel on 2015/10/31.
 */
public class ProcessData2 {
    public void processData2(){
//        processData_test();
//        processData_parentQualification();
//        processData_parentAboutSchool();
//        processData_parentAct();
//        processData_parentChooseSchool();
//        processData_parentMathImportance();
//        processData_studentLateSkip();
//        processData_studentPhoneTVComputer();
//        processData_bookAtHome();
    }

    public void processData_test(){
        String sourceFile = "student2012dict.csv";
        String targetFile = "3333.csv";

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
//            ArrayList<String> al = new ArrayList<String>();
//            line = br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
//                break;
//                String[] sample = line.split(cvsSplitBy);
//                if(!al.contains(sample[3].substring(1,4))){
//                    al.add(sample[3].substring(1,4));
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


    public void processData_studentLateSkip(){
        String sourceFile = "student2012.csv";
        String targetFile = "studentLateSkip.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = "@";

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
//            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                double late = 0;
                double skipDay = 0;
                double skipClass = 0;
                String[] sample = line.split(cvsSplitBy);
//                System.out.println(sample[18]+","+sample[19]+","+sample[20]);
                if(sample[18].replaceAll("\"","").replace(" ","").equals("None")){
                    late = 0;
                }else if(sample[18].replaceAll("\"","").replace(" ", "").equals("Oneortwotimes")){
                    late = 1.5;
                }else if(sample[18].replaceAll("\"","").replace(" ", "").equals("Threeorfourtimes")){
                    late = 3.5;
                }else if(sample[18].replaceAll("\"","").replace(" ", "").equals("Fiveormoretimes")){
                    late = 6.5;
                }

                if(sample[19].replaceAll("\"","").replace(" ", "").equals("None")){
                    skipDay = 0;
                }else if(sample[19].replaceAll("\"","").replace(" ", "").equals("Oneortwotimes")){
                    skipDay = 1.5;
                }else if(sample[19].replaceAll("\"","").replace(" ", "").equals("Threeorfourtimes")){
                    skipDay = 3.5;
                }else if(sample[19].replaceAll("\"","").replace(" ", "").equals("Fiveormoretimes")){
                    skipDay = 6.5;
                }

                if(sample[20].replaceAll("\"","").replace(" ", "").equals("1")){
                    skipClass = 0;
                }else if(sample[20].replaceAll("\"","").replace(" ", "").equals("2")){
                    skipClass = 1.5;
                }else if(sample[20].replaceAll("\"","").replace(" ", "").equals("3")){
                    skipClass = 3.5;
                }else if(sample[20].replaceAll("\"","").replace(" ","").equals("4")){
                    skipClass = 6.5;
                }



                writer.write(sample[1]+","+late+","+skipDay+","+skipClass);
                writer.newLine();


//                System.out.println(line);
//            line = br.readLine();
//            System.out.println(line);
//                writer.write(line);
//                writer.newLine();

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

    public void processData_studentPhoneTVComputer(){
        String sourceFile = "student2012.csv";
        String targetFile = "studentPhoneTVComputer.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = "@";

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
//            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();

            while ((line = br.readLine()) != null) {
//                double late = 0;
//                double skipDay = 0;
//                double skipClass = 0;

                int cellphone = 0;
                int tv = 0;
                int computer = 0;
                int car = 0;
                int room = 0;
                String[] sample = line.split(cvsSplitBy);
//                System.out.println(sample[60]+","+sample[61]+","+sample[62]+","+sample[63]+","+sample[64]+","+sample[65]);
                if(sample[61].replaceAll("\"", "").equals("None")){
                    cellphone = 0;
                }else if(sample[61].replaceAll("\"", "").equals("One")){
                    cellphone = 1;
                }else if(sample[61].replaceAll("\"", "").equals("Two")){
                    cellphone = 2;
                }else if(sample[61].replaceAll("\"", "").equals("Three or more")){
                    cellphone = 3;
                }

                if(sample[62].replaceAll("\"","").equals("None")){
                    tv = 0;
                }else if(sample[62].replaceAll("\"","").equals("One")){
                    tv = 1;
                }else if(sample[62].replaceAll("\"","").equals("Two")){
                    tv = 2;
                }else if(sample[62].replaceAll("\"","").equals("Three or more")){
                    tv = 3;
                }

                if(sample[63].replaceAll("\"","").equals("None")){
                    computer = 0;
                }else if(sample[63].replaceAll("\"","").equals("One")){
                    computer = 1;
                }else if(sample[63].replaceAll("\"","").equals("Two")){
                    computer = 2;
                }else if(sample[63].replaceAll("\"","").equals("Three or more")){
                    computer = 3;
                }



                if(sample[64].replaceAll("\"","").equals("None")){
                    car = 0;
                }else if(sample[64].replaceAll("\"","").equals("One")){
                    car = 1;
                }else if(sample[64].replaceAll("\"","").equals("Two")){
                    car = 2;
                }else if(sample[64].replaceAll("\"","").equals("Three or more")){
                    car = 3;
                }
                if(sample[65].replaceAll("\"","").equals("None")){
                    room = 0;
                }else if(sample[65].replaceAll("\"","").equals("One")){
                    room = 1;
                }else if(sample[65].replaceAll("\"","").equals("Two")){
                    room = 2;
                }else if(sample[65].replaceAll("\"","").equals("Three or more")){
                    room = 3;
                }





                writer.write(sample[1]+","+cellphone+","+tv+","+computer+","+car+","+room);
                writer.newLine();


//                System.out.println(line);
//            line = br.readLine();
//            System.out.println(line);
//                writer.write(line);
//                writer.newLine();

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


    public void processData_bookAtHome(){
        String sourceFile = "student2012.csv";
        String targetFile = "bookAtHome.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = "@";

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
//            ArrayList<String> al = new ArrayList<String>();
            line = br.readLine();

            while ((line = br.readLine()) != null) {
//                double late = 0;
//                double skipDay = 0;
//                double skipClass = 0;

                int books = 0;


                String[] sample = line.split(cvsSplitBy);
//                System.out.println(sample[66]+","+sample[61]+","+sample[62]+","+sample[63]+","+sample[64]+","+sample[65]);
                if(sample[66].replaceAll("\"", "").replaceAll(" ","").equals("0-10books")){
                    books = 5;
                }else if(sample[66].replaceAll("\"", "").replaceAll(" ", "").equals("11-25books")){
                    books = 18;
                }else if(sample[66].replaceAll("\"", "").replaceAll(" ", "").equals("26-100books")){
                    books = 63;
                }else if(sample[66].replaceAll("\"", "").replaceAll(" ", "").equals("101-200books")){
                    books = 150;
                }else if(sample[66].replaceAll("\"", "").replaceAll(" ", "").equals("201-500books")){
                    books = 350;
                }else if(sample[66].replaceAll("\"", "").replaceAll(" ", "").equals("Morethan500books")){
                    books = 500;
                }







                writer.write(sample[1]+","+books);
                writer.newLine();


//                System.out.println(line);
//            line = br.readLine();
//            System.out.println(line);
//                writer.write(line);
//                writer.newLine();

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





    public void processData_parentAboutSchool(){
        String sourceFile = "parent2012.csv";
        String targetFile = "parentAboutSchool.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,PA09Q01,PA09Q02,PA09Q03,PA09Q04,PA09Q05,PA09Q06,PA09Q07");
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


            while ((line = br.readLine()) != null) {
                int sch1 = 0;
                int sch2 = 0;
                int sch3 = 0;
                int sch4 = 0;
                int sch5 = 0;
                int sch6 = 0;
                int sch7 = 0;
                String[] sample = line.split(cvsSplitBy);
                if(sample[23].replaceAll("\"","").equals("Strongly agree")){
                    sch1 = 2;
                }else if(sample[23].replaceAll("\"","").equals("Agree")){
                    sch1 = 1;
                }else if(sample[23].replaceAll("\"", "").equals("Disagree")){
                    sch1 = -1;
                }else if(sample[23].replaceAll("\"", "").equals("Strongly disagree")){
                    sch1 = -2;
                }

                if(sample[24].replaceAll("\"","").equals("Strongly agree")){
                    sch2 = 2;
                }else if(sample[24].replaceAll("\"","").equals("Agree")){
                    sch2 = 1;
                }else if(sample[24].replaceAll("\"","").equals("Disagree")){
                    sch2 = -1;
                }else if(sample[24].replaceAll("\"","").equals("Strongly disagree")){
                    sch2 = -2;
                }

                if(sample[25].replaceAll("\"","").equals("Strongly agree")){
                    sch3 = 2;
                }else if(sample[25].replaceAll("\"","").equals("Agree")){
                    sch3 = 1;
                }else if(sample[25].replaceAll("\"","").equals("Disagree")){
                    sch3 = -1;
                }else if(sample[25].replaceAll("\"","").equals("Strongly disagree")){
                    sch3 = -2;
                }

                if(sample[26].replaceAll("\"","").equals("Strongly agree")){
                    sch4 = 2;
                }else if(sample[26].replaceAll("\"","").equals("Agree")){
                    sch4 = 1;
                }else if(sample[26].replaceAll("\"","").equals("Disagree")){
                    sch4 = -1;
                }else if(sample[26].replaceAll("\"","").equals("Strongly disagree")){
                    sch4 = -2;
                }

                if(sample[27].replaceAll("\"","").equals("Strongly agree")){
                    sch5 = 2;
                }else if(sample[27].replaceAll("\"","").equals("Agree")){
                    sch5 = 1;
                }else if(sample[27].replaceAll("\"","").equals("Disagree")){
                    sch5 = -1;
                }else if(sample[27].replaceAll("\"","").equals("Strongly disagree")){
                    sch5 = -2;
                }

                if(sample[28].replaceAll("\"","").equals("Strongly agree")){
                    sch6 = 2;
                }else if(sample[28].replaceAll("\"","").equals("Agree")){
                    sch6 = 1;
                }else if(sample[28].replaceAll("\"","").equals("Disagree")){
                    sch6 = -1;
                }else if(sample[28].replaceAll("\"","").equals("Strongly disagree")){
                    sch6 = -2;
                }

                if(sample[29].replaceAll("\"","").equals("Strongly agree")){
                    sch7 = 2;
                }else if(sample[29].replaceAll("\"","").equals("Agree")){
                    sch7 = 1;
                }else if(sample[29].replaceAll("\"","").equals("Disagree")){
                    sch7 = -1;
                }else if(sample[29].replaceAll("\"","").equals("Strongly disagree")){
                    sch7 = -2;
                }


                writer.write(sample[1]+","+sch1+","+sch2+","+sch3+","+sch4+","+sch5+","+sch6+","+sch7);
                writer.newLine();


//                System.out.println(line);
//            line = br.readLine();
//            System.out.println(line);
//                writer.write(line);
//                writer.newLine();

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

    public void processData_parentMathImportance(){
        String sourceFile = "parent2012.csv";
        String targetFile = "parentMathImportance.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,PA14Q01,PA14Q02,PA14Q03,PA14Q04");
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


            while ((line = br.readLine()) != null) {
                int sch1 = 0;
                int sch2 = 0;
                int sch3 = 0;
                int sch4 = 0;

                String[] sample = line.split(cvsSplitBy);
                if(sample[60].replaceAll("\"","").equals("Strongly agree")){
                    sch1 = 2;
                }else if(sample[60].replaceAll("\"","").equals("Agree")){
                    sch1 = 1;
                }else if(sample[60].replaceAll("\"", "").equals("Disagree")){
                    sch1 = -1;
                }else if(sample[60].replaceAll("\"", "").equals("Strongly disagree")){
                    sch1 = -2;
                }

                if(sample[61].replaceAll("\"","").equals("Strongly agree")){
                    sch2 = 2;
                }else if(sample[61].replaceAll("\"","").equals("Agree")){
                    sch2 = 1;
                }else if(sample[61].replaceAll("\"","").equals("Disagree")){
                    sch2 = -1;
                }else if(sample[61].replaceAll("\"","").equals("Strongly disagree")){
                    sch2 = -2;
                }

                if(sample[62].replaceAll("\"","").equals("Strongly agree")){
                    sch3 = 2;
                }else if(sample[62].replaceAll("\"","").equals("Agree")){
                    sch3 = 1;
                }else if(sample[62].replaceAll("\"","").equals("Disagree")){
                    sch3 = -1;
                }else if(sample[62].replaceAll("\"","").equals("Strongly disagree")){
                    sch3 = -2;
                }

                if(sample[63].replaceAll("\"","").equals("Strongly agree")){
                    sch4 = 2;
                }else if(sample[63].replaceAll("\"","").equals("Agree")){
                    sch4 = 1;
                }else if(sample[63].replaceAll("\"","").equals("Disagree")){
                    sch4 = -1;
                }else if(sample[63].replaceAll("\"","").equals("Strongly disagree")){
                    sch4 = -2;
                }




                writer.write(sample[1]+","+sch1+","+sch2+","+sch3+","+sch4);
                writer.newLine();


//                System.out.println(line);
//            line = br.readLine();
//            System.out.println(line);
//                writer.write(line);
//                writer.newLine();

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


    public void processData_parentChooseSchool(){
        String sourceFile = "parent2012.csv";
        String targetFile = "parentChooseSchool.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,PA12Q01,PA12Q02,PA12Q03,PA12Q04,PA12Q05,PA12Q06,PA12Q07,PA12Q08,PA12Q09,PA12Q10,PA12Q11");
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


            while ((line = br.readLine()) != null) {
                int[] sch1 = new int[]{0,0,0,0,0,0,0,0,0,0,0};

                String[] sample = line.split(cvsSplitBy);
                for(int i =0; i < 11; i++){
                    if(sample[42+i].replaceAll("\"","").equals("Not important")){
                        sch1[i] = 0;
                    }else if(sample[42+i].replaceAll("\"","").equals("Somewhat important")){
                        sch1[i] = 1;
                    }else if(sample[42+i].replaceAll("\"", "").equals("Important")){
                        sch1[i] = 2;
                    }else if(sample[42+i].replaceAll("\"", "").equals("Very important")){
                        sch1[i] = 3;
                    }
                }





                writer.write(sample[1]+","+sch1[0]+","+sch1[1]+","+sch1[2]+","+sch1[3]+","+sch1[4]+","+sch1[5]+","+sch1[6]+","+sch1[7]+","+sch1[8]+","+sch1[9]+","+sch1[10]);
                writer.newLine();


//                System.out.println(line);
//            line = br.readLine();
//            System.out.println(line);
//                writer.write(line);
//                writer.newLine();

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

    public void processData_parentAct(){
        String sourceFile = "parent2012.csv";
        String targetFile = "parentActivity.csv";

        BufferedReader br = null;
        BufferedWriter writer = null;

        String line = "";
        String cvsSplitBy = ",";

        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write("Country,PA10Q01,PA10Q02,PA10Q03,PA10Q04,PA10Q05,PA10Q06,PA10Q07,PA10Q08,PA10Q09,PA10Q10,PA10Q11");
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


            while ((line = br.readLine()) != null) {
                int ach1 = 0;
                int ach2 = 0;
                int ach3 = 0;
                int ach4 = 0;
                int ach5 = 0;
                int ach6 = 0;
                int ach7 = 0;
                int ach8 = 0;
                int ach9 = 0;
                int ach10 = 0;
                int ach11 = 0;
                String[] sample = line.split(cvsSplitBy);
                if(sample[30].replaceAll("\"","").equals("Yes")){
                    ach1 = 1;
                }
                if(sample[31].replaceAll("\"","").equals("Yes")){
                    ach2 = 1;
                }
                if(sample[32].replaceAll("\"","").equals("Yes")){
                    ach3 = 1;
                }
                if(sample[33].replaceAll("\"","").equals("Yes")){
                    ach4 = 1;
                }
                if(sample[34].replaceAll("\"","").equals("Yes")){
                    ach5 = 1;
                }
                if(sample[35].replaceAll("\"","").equals("Yes")){
                    ach6 = 1;
                }
                if(sample[36].replaceAll("\"","").equals("Yes")){
                    ach7 = 1;
                }
                if(sample[37].replaceAll("\"","").equals("Yes")){
                    ach8 = 1;
                }
                if(sample[38].replaceAll("\"","").equals("Yes")){
                    ach9 = 1;
                }
                if(sample[39].replaceAll("\"","").equals("Yes")){
                    ach10 = 1;
                }
                if(sample[40].replaceAll("\"", "").equals("Yes")){
                    ach11 = 1;
                }




                writer.write(sample[1]+","+ach1+","+ach2+","+ach3+","+ach4+","+ach5+","+ach6+","+ach7+","+ach8+","+ach9+","+ach10+","+ach11);
                writer.newLine();


//                System.out.println(line);
//            line = br.readLine();
//            System.out.println(line);
//                writer.write(line);
//                writer.newLine();

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




}
