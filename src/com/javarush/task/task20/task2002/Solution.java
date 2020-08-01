package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("c:\\1\\2.tmp", null);
            OutputStream outputStream = new FileOutputStream("c:\\1\\2.tmp");
            InputStream inputStream = new FileInputStream("c:\\1\\2.tmp");

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Ivanov");
            user.setBirthDate(new SimpleDateFormat("ddmmyyyy").parse("26061980"));
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if (javaRush.equals(loadedObject)){
                System.out.println("Ohh yeeee, it equels");
            }else System.out.println("Somthing went wrong with object");
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddmmyyyy");
            StringBuilder stringBuilder = new StringBuilder();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (!users.isEmpty()){
                for (User user : users){
                    stringBuilder.append(user.getFirstName()).append(" ");
                    stringBuilder.append(user.getLastName()).append(" ");
                    stringBuilder.append(user.isMale()).append(" ");
                  //  stringBuilder.append(simpleDateFormat.parse(user.getBirthDate().toString())).append(" ");
                    stringBuilder.append(user.getCountry().toString());

                    bufferedWriter.write(stringBuilder.toString());
                    bufferedWriter.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat format = new SimpleDateFormat("ddmmyyyy");
            while (bufferedReader.ready()){
                User user = new User();
                String line = bufferedReader.readLine();
                String [] lines = line.split(" ");
                user.setFirstName(lines[0]);
                user.setLastName(lines[1]);
                if (lines[2].equals("true")) {
                    user.setMale(true);
                } else {
                    user.setMale(false);
                }
                user.setBirthDate(format.parse(lines[4]));
                if (lines[5].equals("UKRAINE")){
                    user.setCountry(User.Country.UKRAINE);
                }else if (lines[5].equals("RUSSIA")){
                    user.setCountry(User.Country.RUSSIA);
                }else user.setCountry(User.Country.OTHER);

                users.add(user);
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
