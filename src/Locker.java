import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Locker {
    private static String Working_Directory;
    Locker()
    {
        Working_Directory=System.getProperty("user.dir");
    }
    public void Main_Screen_Display() throws IOException
    {
        System.out.println("--------------------Welcome to LockersMe------------------------");
        System.out.println("-----------------Developed by : Md Jashim Mondal----------------");
        System.out.println("----------Choose from any of the below displayed options--------");
        System.out.println("Option 1 : List down all files");
        System.out.println("Option 2 : Add, Delete, Search any file");
        System.out.println("Option 3 : Close the Application");
        System.out.print("Please enter your choice : ");
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        int x=0;
        s.trim();
        if(s.equalsIgnoreCase("option 1") || s.equalsIgnoreCase("1"))
            x=1;
        else if(s.equalsIgnoreCase("option 2") || s.equalsIgnoreCase("2"))
            x=2;
        else if(s.equalsIgnoreCase("option 3") || s.equalsIgnoreCase("3"))
            x=3;
        else
            x=0;
        switch (x){
            case 1:
                System.out.println("You chose the First Option.");
                List_All_Files();
                Main_Screen_Display();
                break;
            case 2:
                System.out.println("You chose the Second Option.");
                Business_operation();
                break;
            case 3:
                System.out.println("You chose the Third Option.");
                System.out.println("Thank you for using LockersMe.com");
                System.exit(0);
                break;
            default:
                System.out.println("Please choose a valid option.");
                Main_Screen_Display();
        }
    }

    public void  List_All_Files()
    {

        File f=new File(Working_Directory);
        File[] list_of_files_and_directories=f.listFiles();
        ArrayList<String> list_of_filenames=new ArrayList<String>();
        ArrayList<String> list_of_directorynames=new ArrayList<String>();
        for(File i:list_of_files_and_directories)
        {
            if(i.isFile())
            {
                list_of_filenames.add(i.getName());
            }
            else
            {
                list_of_directorynames.add(i.getName());
            }
        }
        Collections.sort(list_of_filenames);
        Collections.sort(list_of_directorynames);
        System.out.println("Following are the names of all the directories present inside \""+Working_Directory+"\" in ascending order :");
        for(String s:list_of_directorynames)
        {
            System.out.println(s);
        }
        System.out.println("Following are the names of all the files present inside \""+Working_Directory+"\" in ascending order :");
        for(String s:list_of_filenames)
        {
            System.out.println(s);
        }
    }
    public void Business_operation() throws IOException
    {
        System.out.println("----------Choose from any of the below displayed options--------");
        System.out.println("Option 1 : Add a file");
        System.out.println("Option 2 : Delete a file");
        System.out.println("Option 3 : Search a file");
        System.out.println("Option 4 : Return to Main Application");
        System.out.print("Please enter your choice : ");
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        int x=0;
        s.trim();
        if(s.equalsIgnoreCase("option 1") || s.equalsIgnoreCase("1"))
            x=1;
        else if(s.equalsIgnoreCase("option 2") || s.equalsIgnoreCase("2"))
            x=2;
        else if(s.equalsIgnoreCase("option 3") || s.equalsIgnoreCase("3"))
            x=3;
        else if(s.equalsIgnoreCase("option 4") || s.equalsIgnoreCase("4"))
            x=4;
        else
            x=0;
        switch (x){
            case 1:
                System.out.println("You chose the First Option.");
                add_File();
                break;
            case 2:
                System.out.println("You chose the Second Option.");
                delete_File();
                break;
            case 3:
                System.out.println("You chose the Third Option.");
                search_File();
                break;
            case 4:
                System.out.println("You chose the Fourth Option.");
                System.out.println("Returning to the Main Application...");
                Main_Screen_Display();
                break;
            default:
                System.out.println("Please choose a valid option.");
                Business_operation();
        }
    }
    public void add_File() throws IOException
    {
        String name;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the name of the file that you want to add :");
        name=sc.nextLine();
        boolean filefound=false;
        filefound=search_File(name);
        if(filefound == true)
        {
            System.out.println("A file with the same name is already present.");
            System.out.println("Please enter a different file name");
        }
        else
        {
            File file=new File(name);
            file.createNewFile();
            System.out.println("A new file with name "+name+" got created!");
        }
        Business_operation();
    }
    public void delete_File()  throws IOException
    {
        String name;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the name of the file that you want to delete :");
        name=sc.nextLine().trim();
        boolean filefound=false;
        filefound=search_File(name);
        if (filefound==true)
        {
            File file=new File(name);
            file.delete();
            System.out.println("File Deleted Successfully!");
        }
        else
        {
            System.out.println("The file with the specified could not be found.");
            System.out.println("Please enter a different file name");
        }
        Business_operation();
    }
    public void search_File() throws IOException
    {
        String name;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the name of the file that you want to search for");
        name=sc.nextLine().trim();
        boolean filefound=false;
        filefound=search_File(name);
        if(filefound==true)
        {
            System.out.println("File found!");
        }
        else
        {
            System.out.println("File that you are looking for could not be found!");
        }
        Business_operation();
    }
    public boolean search_File(String name) throws IOException
    {
        boolean filefound=false;
        File f=new File(Working_Directory);
        String[] file_list=f.list();
        for(String s:file_list)
        {
            s=s.trim();
            if(s.equals(name))
            {
                filefound=true;
            }
        }
        return filefound;
    }

    public static void main(String[] args) throws IOException {
        Locker ob= new Locker();
        ob.Main_Screen_Display();
    }
}
