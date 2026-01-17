public class Print_a_square_of_size_3 
{
    public static void main(String[] args) 
    {

        // MANUAL - COMMON - SIMPLE METHOD:

        System.out.println("*  *  *");
        System.out.println("*  *  *");
        System.out.println("*  *  *"); 

        System.out.println(); 

        // UsING String.repeat()
        for (int i=0 ; i <3 ; i++)
        {
        System.out.println("*".repeat(3));

        }

        System.out.println(); 

        // USING NESTED LOOPS:
        for (int i=0 ; i < 3 ; i++){       // ROWS
            for(int j=0 ; j < 3 ; j++){    // COLUMNS
                System.out.print("*");

            }

            System.out.println();
        }
    }
}

