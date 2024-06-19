import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Travelapp
{
    Scanner sc = new Scanner(System.in);
    public static Map<String,Integer> hoteldetails = new HashMap<>();
    public static Map<String,String>  destinationdetails = new HashMap<>();
    public static  List<String> summary = new ArrayList<>();
        
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int ch=0;
        while(ch!=5)
        {
            System.out.println("1.Check Destination details");           
            System.out.println("2.Check Hotel availability");
            System.out.println("3.Post review");
            System.out.println("4.View Booking Summary");
            System.out.println("5.Exit Application");
            System.out.println("Enter your choice:");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                {
                    Checkdestinationdetails();
                    break;
                }
                case 2:
                {
                    CheckhotelAvailability();
                    break;
                }
                case 3:
                {
                    Postreview();
                    break;
                }
                case 4 : 
                {
                    ViewBooking();
                    break;
                }
                case 5 :
                {
                    System.out.println("Exiting");
                    break;
                }
                default:
                {
                    System.out.println("Invalid choice");
                }
            }
        }
        sc.close();
    }

    static void Checkdestinationdetails()
    {
        Scanner sc = new Scanner(System.in);
  
        String dest;
        destinationdetails.put("Munnar","Activities: x1 , x2");
        destinationdetails.put("Goa", "Activities: y1 , y2");
        destinationdetails.put("Wayanad", "Activities: z1 , z2");
        System.out.println("Please enter your desired destination we will check and report you if it's available in our plan:");
        dest = sc.next();
        if(destinationdetails.containsKey(dest))
        {
            System.out.println("Yes!! The plan is available, you can proceed for booking.");
            summary.add("User has chosen the destination: " + dest);
        }
        else
        {
            System.out.println("We are very sorry! Our plan doesn't include this location.");
        }
    }

    static void CheckhotelAvailability()   
    {
        hoteldetails.put("ABC",4);
        hoteldetails.put("DEF", 7);
        hoteldetails.put("XYZ", 2);

        Scanner sc = new Scanner(System.in);
        String hotelname;
        int nop;
        System.out.println("Enter the hotel name:");
        hotelname = sc.next();
        System.out.println("Enter number of people so that we can check for vacancy:");
        nop = sc.nextInt();
        if(hoteldetails.containsKey(hotelname))
        {
            if(hoteldetails.get(hotelname) >= nop)
            {
                System.out.println("Yes, this hotel is suitable for accommodation. It has a vacancy of " + hoteldetails.get(hotelname));
                summary.add("User has chosen the hotel: " + hotelname);
            }
            else
            {
                System.out.println("Sorry, please choose a different hotel.");
            }
        }
        else
        {
            System.out.println("Sorry!! Hotel not available.");                
        }
    }

    static void Postreview()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your review:");
        sc.nextLine();  // Consume the newline left by nextInt()
        String review = sc.nextLine();
        summary.add("User review: " + review);
        summary.add(review);
        System.out.println("Thank you for your review!");
    }

    static void ViewBooking()
    {
        for(String variable : summary)
        {
            System.out.println(variable);
        }
    }
}
