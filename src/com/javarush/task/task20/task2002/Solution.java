package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("yourFile", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Andrii");
            user.setLastName("Serha");
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            user.setBirthDate(new SimpleDateFormat("ddMMyyyy").parse("27051981"));
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();
           // System.out.println(user.getBirthDate().getTime());

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

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
            PrintWriter writer = new PrintWriter(outputStream);
            if (users.size() > 0) {

                for (User user : users) {
                    writer.println("true");
                    writer.println(user.getFirstName() + " " + user.getLastName() + " " + user.isMale() + " " + user.getCountry() + " " + user.getBirthDate().getTime());
                }
                writer.flush();
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                if (reader.readLine().equals("true")) {
                    String[] temp = reader.readLine().split(" ");
                    User user = new User();
                    user.setFirstName(temp[0]);
                    user.setLastName(temp[1]);
                    if (temp[2].equals("true")) {
                        user.setMale(true);
                    } else user.setMale(false);
                    if (temp[3].equals("UKRAINE")) {
                        user.setCountry(User.Country.UKRAINE);
                    } else if (temp[3].equals("RUSSIA")) {
                        user.setCountry(User.Country.RUSSIA);
                    } else user.setCountry(User.Country.OTHER);
                    user.setBirthDate(new Date(Long.parseLong(temp[4])));
                    users.add(user);
                }
            }

            reader.close();
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
