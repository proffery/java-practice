package com.epam.rd.autotasks.words;


public class Main {

    public static void main(String[] args) {
        String winPath = "C:\\User\\Program Files\\my_prog_file.py";
        String unixPath = StringUtil.convertPath(winPath, false);
        System.out.println(unixPath);// "/Program Files/my_prog_file.py"

        unixPath = "../script.sh";
        winPath = StringUtil.convertPath(unixPath, true);
        System.out.println(winPath);// "..\\script.sh"
        unixPath = StringUtil.convertPath(unixPath, false);

        System.out.println(unixPath);// "../script.sh"

        unixPath = "//home/user/somefile";
        winPath = StringUtil.convertPath(unixPath, true); // "C:\\home\\user\\somefile"
        System.out.println(winPath);
    }
}