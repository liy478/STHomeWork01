package liy478;
//问题：13

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
//问题：13

import liy478.Student;

public class StudentManager {
	String msg="\t\t学号\t\t姓名\t\t出生日期";
	/**
    	 * Writing and operation of main interface
    	 * <p> Write the main interface with output statement
    	 * Using scanner to input data by keyboard
    	 * Use switch statement to select the operation
    	 * Complete with loop and return to the main interface again
    	 * @param array
    	 */  //问题：8
        public void app(ArrayList<Student> array) {
        //用循环完成再次回到主界面  问题：4、5
        	while (true) {
        	//用输出语句完成主界面的编写  问题：4、5
        		System.out.println("请选择操作：");
                System.out.println("***********************************");
                System.out.println("*                           1  插入                                  *");
                System.out.println("*                           2  查找                                  *");
                System.out.println("*                           3  删除                                  *");
                System.out.println("*                           4  修改                                  *");
                System.out.println("*                           5  输出                                  *");
                System.out.println("*                           6  退出                                  *");
                System.out.println("***********************************");

            //用Scanner实现键盘录入数据  问题：4、5
            Scanner scanner = new Scanner(System.in);
            int line = scanner.nextInt();

            //用switch语句完成操作的选择  问题：4、5
            switch (line) {
                case 1:
                    //System.out.println("插入");  问题：4、5
                    addStudent(array);
                    break;
                case 2:
                    //System.out.println("查找");  问题：4、5
                    deleteStudent(array);
                    break;
                case 3:
                    //System.out.println("删除");  问题：4、5
                    deleteStudent(array);
                    break;
                case 4:
                    //System.out.println("修改");  问题：4、5
                    updataStudent(array);
                    break;
                case 5:
                    //System.out.println("输出");  问题：4、5
                    findAllStudent(array);
                    break;
                case 6:
                    System.out.println("谢谢使用");
                    System.exit(0);
                    break;
                default:
                	System.out.printIn("您的输入有误，请重新输入")；
                	System.exit(0);
                	break;
            }
        }
    }
     //   问题：13
        
    /**
     * Define a method to add student information
     * <p>Use the keyboard to input, select and add students, and display the prompt information, which information to input
     * In order to make Sid accessible outside the while loop, we define it outside the loop
     * To get the program back here, we use recycling
     * Create a student object and assign the data entered by the keyboard to the member variables of the student object
     * Add the student object to the collection and save it
     * Give the prompt of adding success
     * @param array
     */  //问题：8
        public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        //String sid;  问题：1
        String id;
        //为了让程序能够回到这里，使用循环使用  问题：4、5
        while (true) {
            System.out.println("请输入学生学号：");
            //sid = sc.nextLine();  问题：1
            id = sc.nextLine();
            //boolean flag = isUsed(array, sid);  问题：1
            boolean flag = isUsed(array, id);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生出生日期：");
        String birDate = sc.nextLine();
        System.out.println("请输入学生性别：");
        String gender = sc.nextLine();
        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量  问题：4、5
        Student s = new Student();
        //s.setSid(sid);  问题：1
        s.setSid(id);
        s.setName(name);
        s.setBirDate(birDate);
        s.setGender(gender);
        //将学生对象添加到集合中  问题：4、5
        array.add(s);
        System.out.println("添加学生成功");

    }

/**
 * Define a method to determine whether the student number is occupied
 * <p>If it is the same as a student number in the collection, return "true"; if it is not the same, return "false"
 * @param array,id
 */  //问题：8
    //public static boolean isUsed(ArrayList<Student> array, String sid) {  问题：1
    public static boolean isUsed(ArrayList<Student> array, String id) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if (s.getSid().equals(sid)) {  问题：1
            if (s.getId().equals(id)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

/**
 * Define a method to view student information
 * <p>Display header information
 * Take out the data in the set and display the student information 
 * according to the corresponding format, and the age displays the supplementary "year"
 * @param array
 */  //问题：8
    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了不让程序继续往下执行  问题：4、5
            return;
        }
        System.out.println("学号\t\t\t姓名\t\t出生日期\t\t性别");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //System.out.println(s.getSid() + "\t\t"+ s.getName() + "\t\t" +s.getBirDate()+ "\t\t" + s.getGender());  问题：1
            System.out.println(s.getId() + "\t\t"+ s.getName() + "\t\t" +s.getBirDate()+ "\t\t" + s.getGender());
        }
    }

/**
 * Define a method to delete student information
 * <p>Enter the student number to be deleted on the keyboard and display the prompt information
 * Before deleting / modifying students, judge whether the student number exists
 * If it does not exist, a prompt message is displayed
 * If it exists, delete / modify it
 * Traversing the collection removes the corresponding student object from the collection
 * @param array
 */  //问题：8
    public static void deleteStudent(ArrayList<Student> array) {
    	//键盘录入要删除的学生学号，显示提示信息  问题：4、5
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生的学号");
        //String sid = sc.nextLine();  问题：1
        String id = sc.nextLine();
        int index = -1;
        //遍历集合将对应学生对象从集合中删除  问题：4、5
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if (s.getSid().equals(sid)) {  问题：1
            if (s.getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该学号不存在，请重新输入");
        } else {
            array.remove(index);
            System.out.println("删除学生成功");
        }
    }

/**
 * Define a method to modify student information
 * <p>Enter the student number to be modified on the keyboard and display the prompt information
 * Before deleting / modifying students, judge whether the student number exists
 * If it does not exist, a prompt message is displayed
 * If it exists, delete / modify it
 * Traverse the set to modify the corresponding student information
 * Enter the student information to be modified by keyboard
 * Creating student objects
 * Prompt of successful modification is given
 * @param array
 */  //问题：8
    public static void updataStudent(ArrayList<Student> array) {
    	//键盘录入要修改的学生学号，显示提示信息  问题：4、5
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的学号");
        //String sid = sc.nextLine();  问题：1
        String id = sc.nextLine();
        int index = -1;
        //遍历集合修改对应的学生信息  问题：4、5
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if (s.getSid().equals(sid)) {  问题：1
            if (s.getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该学号不存在，请重新输入");
        } else {
            for (int j = 0; j < array.size(); j++) {
                Student student = array.get(j);
                //if (student.getSid().equals(sid)) {  问题：1
                if (student.getId().equals(id)) {
                	//键盘录入要修改的学生信息  问题：4、5
                    System.out.println("请输入学生的新姓名");
                    String name = sc.nextLine();
                    System.out.println("请输入学生的新出生日期");
                    String birDate = sc.nextLine();
                    System.out.println("请输入学生的新性别");
                    String gender = sc.nextLine();
                    // 创建学生对象  问题：4、5
                    Student s = new Student();
                    //s.setSid(sid);  问题：1
                    s.setId(id);
                    s.setName(name);
                    s.setBirDate(birDate);
                    s.setGender(gender);
                    array.set(j, s);
                    // 给出修改成功提示  问题：4、5
                    System.out.println("修改学生成功");
                    break;
                }
            }
        }
    }
    //  问题：13
    
    //定义一个方法，用于查找一个学生
    public void selectStu(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的学生的姓名：");
        String name = sc.nextLine();
        int index=-1;
        for (int i = 0; i < array.size(); i++) {
             Student s = array.get(i);
             if (s.getName().equals(name)) {
                //System.out.println(s.getSid()+s.getName()+s.getBirDate()+s.getGender());  问题：1
            	 System.out.println(s.getId()+s.getName()+s.getBirDate()+s.getGender());
                index=0;
                break;
               }
             }
        if(index==-1) {
       	 System.out.println("没有找到");
         }
    
    }
}//StudenManager的}  问题：6

