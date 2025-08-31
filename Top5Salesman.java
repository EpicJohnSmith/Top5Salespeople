package top5salesman;

public class Top5Salesman 
{

	// HAD AI HELP ME HERE IN THIS PORTION
    // Class has name and salesTotal to make things easier 
    static class Salesperson 
    {
        String name;
        double salesTotal;

        public Salesperson() // FOR THIS SECTION WITH = -1
        {
            this.name = ""; 
            this.salesTotal = -1;
        }

        public Salesperson(String name, double salesTotal) 
        {
            this.name = name;
            this.salesTotal = salesTotal;
        }
    }

    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub

        Salesperson[] allSalespersons = new Salesperson[20];

        // Want to make 20 names and sales here for simplistic sake
        String[] names = {"Julian", "Andy", "Evan", "Emma", "Cross", "Malcolm", "Luke", "Nic", "Gavin",
                "John", "Noah", "James", "Alex", "Molly", "Scott", "David", "Nate", "Sam",
                "Seth", "Athan"};

        // HAD AI HELP ME HERE IN THIS PORTION
        double[] sales = new double[20];
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 20; i++)
        {
            sales[i] = 30000 + (random.nextDouble() * 70000); // FORGOT HOW RANDOM WORKED HERE
        }

        // Fill array so the code knows which person makes which $ amount
        for (int i = 0; i < 20; i++)
        {
            allSalespersons[i] = new Salesperson(names[i], sales[i]);
        }

        // Now have it displayed
        TopFive(allSalespersons); // NEEDED HELP HERE, BUT HAVE THE FUNCTION
    }

    // USED ZYBOOK CODING III: DATA STRUCTURES SECTION 1.3 HERE
    public static void TopFive(Salesperson[] allSalespersons)
    {
        // topSales array has 5 elements
        // Array elements have subitems for name and total sales
        // Array will be sorted from highest total sales to lowest total sales
        Salesperson[] topSales = new Salesperson[5];

        // Initialize all array elements with a negative sales total
        for (int i = 0; i < topSales.length; ++i)
        {
            topSales[i] = new Salesperson();
            topSales[i].name = "";
            topSales[i].salesTotal = -1;
        }

        for (Salesperson salesPerson : allSalespersons)
        {
            // If salesPerson's total sales is greater than the last
            // topSales element, salesPerson is one of the top five so far
            if (salesPerson.salesTotal > topSales[topSales.length - 1].salesTotal)
            {

                // Assign the last element in topSales with the current salesperson
                topSales[topSales.length - 1].name = salesPerson.name;
                topSales[topSales.length - 1].salesTotal = salesPerson.salesTotal;

                // Sort topSales in descending order
                SortDescending(topSales);
            }
        }
                
                //Display top 5 salespople
                System.out.println("Top 5 Salespeople:");
                System.out.println("------------------");
                for (int i = 0; i < topSales.length; ++i)
                {
                    if (topSales[i].salesTotal > -1)
                    {
                        System.out.println((i + 1) + ". " + topSales[i].name + ": $" + (int)topSales[i].salesTotal);
                    }
                }
            }

            // HAD AI HELP ME HERE IN THIS PORTION
            // Sort function in the descending order to show highest to lowest $ amount
            public static void SortDescending(Salesperson[] topSales)
            {
                for (int i = 0; i < topSales.length - 1; i++)
                {
                    for (int j = 0; j < topSales.length - 1 - i; j++)
                    {
                        if (topSales[j].salesTotal < topSales[j + 1].salesTotal) // THIS PART BAFFLED ME, HUH?
                        {
                            // Swap now
                            Salesperson temp = topSales[j];
                            topSales[j] = topSales[j + 1];
                            topSales[j + 1] = temp;
                        }
                    }
                }
            }
        }