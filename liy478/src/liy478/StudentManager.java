package liy478;
//���⣺13

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
//���⣺13

import liy478.Student;

public class StudentManager {
	String msg="\t\tѧ��\t\t����\t\t��������";
	/**
    	 * Writing and operation of main interface
    	 * <p> Write the main interface with output statement
    	 * Using scanner to input data by keyboard
    	 * Use switch statement to select the operation
    	 * Complete with loop and return to the main interface again
    	 * @param array
    	 */  //���⣺8
        public void app(ArrayList<Student> array) {
        //��ѭ������ٴλص�������  ���⣺4��5
        	while (true) {
        	//�����������������ı�д  ���⣺4��5
        		System.out.println("��ѡ�������");
                System.out.println("***********************************");
                System.out.println("*                           1  ����                                  *");
                System.out.println("*                           2  ����                                  *");
                System.out.println("*                           3  ɾ��                                  *");
                System.out.println("*                           4  �޸�                                  *");
                System.out.println("*                           5  ���                                  *");
                System.out.println("*                           6  �˳�                                  *");
                System.out.println("***********************************");

            //��Scannerʵ�ּ���¼������  ���⣺4��5
            Scanner scanner = new Scanner(System.in);
            int line = scanner.nextInt();

            //��switch�����ɲ�����ѡ��  ���⣺4��5
            switch (line) {
                case 1:
                    //System.out.println("����");  ���⣺4��5
                    addStudent(array);
                    break;
                case 2:
                    //System.out.println("����");  ���⣺4��5
                    deleteStudent(array);
                    break;
                case 3:
                    //System.out.println("ɾ��");  ���⣺4��5
                    deleteStudent(array);
                    break;
                case 4:
                    //System.out.println("�޸�");  ���⣺4��5
                    updataStudent(array);
                    break;
                case 5:
                    //System.out.println("���");  ���⣺4��5
                    findAllStudent(array);
                    break;
                case 6:
                    System.out.println("ллʹ��");
                    System.exit(0);
                    break;
                default:
                	System.out.printIn("����������������������")��
                	System.exit(0);
                	break;
            }
        }
    }
     //   ���⣺13
        
    /**
     * Define a method to add student information
     * <p>Use the keyboard to input, select and add students, and display the prompt information, which information to input
     * In order to make Sid accessible outside the while loop, we define it outside the loop
     * To get the program back here, we use recycling
     * Create a student object and assign the data entered by the keyboard to the member variables of the student object
     * Add the student object to the collection and save it
     * Give the prompt of adding success
     * @param array
     */  //���⣺8
        public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        //String sid;  ���⣺1
        String id;
        //Ϊ���ó����ܹ��ص����ʹ��ѭ��ʹ��  ���⣺4��5
        while (true) {
            System.out.println("������ѧ��ѧ�ţ�");
            //sid = sc.nextLine();  ���⣺1
            id = sc.nextLine();
            //boolean flag = isUsed(array, sid);  ���⣺1
            boolean flag = isUsed(array, id);
            if (flag) {
                System.out.println("�������ѧ���Ѿ���ʹ�ã�����������");
            } else {
                break;
            }
        }
        System.out.println("������ѧ��������");
        String name = sc.nextLine();
        System.out.println("������ѧ���������ڣ�");
        String birDate = sc.nextLine();
        System.out.println("������ѧ���Ա�");
        String gender = sc.nextLine();
        //����ѧ�����󣬰Ѽ���¼������ݸ�ֵ��ѧ������ĳ�Ա����  ���⣺4��5
        Student s = new Student();
        //s.setSid(sid);  ���⣺1
        s.setSid(id);
        s.setName(name);
        s.setBirDate(birDate);
        s.setGender(gender);
        //��ѧ��������ӵ�������  ���⣺4��5
        array.add(s);
        System.out.println("���ѧ���ɹ�");

    }

/**
 * Define a method to determine whether the student number is occupied
 * <p>If it is the same as a student number in the collection, return "true"; if it is not the same, return "false"
 * @param array,id
 */  //���⣺8
    //public static boolean isUsed(ArrayList<Student> array, String sid) {  ���⣺1
    public static boolean isUsed(ArrayList<Student> array, String id) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if (s.getSid().equals(sid)) {  ���⣺1
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
 */  //���⣺8
    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("����Ϣ�����������Ϣ�ٲ�ѯ");
            //Ϊ�˲��ó����������ִ��  ���⣺4��5
            return;
        }
        System.out.println("ѧ��\t\t\t����\t\t��������\t\t�Ա�");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //System.out.println(s.getSid() + "\t\t"+ s.getName() + "\t\t" +s.getBirDate()+ "\t\t" + s.getGender());  ���⣺1
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
 */  //���⣺8
    public static void deleteStudent(ArrayList<Student> array) {
    	//����¼��Ҫɾ����ѧ��ѧ�ţ���ʾ��ʾ��Ϣ  ���⣺4��5
        Scanner sc = new Scanner(System.in);
        System.out.println("������Ҫɾ����ѧ����ѧ��");
        //String sid = sc.nextLine();  ���⣺1
        String id = sc.nextLine();
        int index = -1;
        //�������Ͻ���Ӧѧ������Ӽ�����ɾ��  ���⣺4��5
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if (s.getSid().equals(sid)) {  ���⣺1
            if (s.getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("��ѧ�Ų����ڣ�����������");
        } else {
            array.remove(index);
            System.out.println("ɾ��ѧ���ɹ�");
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
 */  //���⣺8
    public static void updataStudent(ArrayList<Student> array) {
    	//����¼��Ҫ�޸ĵ�ѧ��ѧ�ţ���ʾ��ʾ��Ϣ  ���⣺4��5
        Scanner sc = new Scanner(System.in);
        System.out.println("������Ҫ�޸ĵ�ѧ����ѧ��");
        //String sid = sc.nextLine();  ���⣺1
        String id = sc.nextLine();
        int index = -1;
        //���������޸Ķ�Ӧ��ѧ����Ϣ  ���⣺4��5
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if (s.getSid().equals(sid)) {  ���⣺1
            if (s.getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("��ѧ�Ų����ڣ�����������");
        } else {
            for (int j = 0; j < array.size(); j++) {
                Student student = array.get(j);
                //if (student.getSid().equals(sid)) {  ���⣺1
                if (student.getId().equals(id)) {
                	//����¼��Ҫ�޸ĵ�ѧ����Ϣ  ���⣺4��5
                    System.out.println("������ѧ����������");
                    String name = sc.nextLine();
                    System.out.println("������ѧ�����³�������");
                    String birDate = sc.nextLine();
                    System.out.println("������ѧ�������Ա�");
                    String gender = sc.nextLine();
                    // ����ѧ������  ���⣺4��5
                    Student s = new Student();
                    //s.setSid(sid);  ���⣺1
                    s.setId(id);
                    s.setName(name);
                    s.setBirDate(birDate);
                    s.setGender(gender);
                    array.set(j, s);
                    // �����޸ĳɹ���ʾ  ���⣺4��5
                    System.out.println("�޸�ѧ���ɹ�");
                    break;
                }
            }
        }
    }
    //  ���⣺13
    
    //����һ�����������ڲ���һ��ѧ��
    public void selectStu(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ���ҵ�ѧ����������");
        String name = sc.nextLine();
        int index=-1;
        for (int i = 0; i < array.size(); i++) {
             Student s = array.get(i);
             if (s.getName().equals(name)) {
                //System.out.println(s.getSid()+s.getName()+s.getBirDate()+s.getGender());  ���⣺1
            	 System.out.println(s.getId()+s.getName()+s.getBirDate()+s.getGender());
                index=0;
                break;
               }
             }
        if(index==-1) {
       	 System.out.println("û���ҵ�");
         }
    
    }
}//StudenManager��}  ���⣺6

