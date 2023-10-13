A CSV file containing information on car sales can be read and analyzed by Program5. It carries out the following key tasks:
Construction of Binary Search Trees with CSV Data Parsing:
The application reads data on car sales from a CSV file supplied as a command-line input. It parses the data and generates a SaleRecord object for each line of input. These records are arranged into binary search trees, one for every distinct automobile make, where each node denotes a record of a sale. While building the binary search trees, the program counts and records the number of left and right children for each node.
User Interaction: Through the console, the application offers a user-friendly menu structure.
Users are asked to provide a date (e.g., "2022-08-01") and a car brand (e.g., "Nissan"). The number of automobiles sold for the selected car created on and after the provided date is then calculated and shown by the application using the binary search trees that were built. It tracks and records how long it takes to perform these calculations.
Data Evaluation
The program provides two ways to determine how many sales records there are:
The left and right child count fields of the binary search tree are used in the first technique to determine the number of records.
The second method employs a recursive process to determine the total number of records. In order to compare the execution times of the two approaches, they are both used.
Error Handling: The program handles file I/O and date parsing exceptions, displaying error messages as necessary.
In conclusion, by building binary search trees for different car brands, this Java application effectively organizes and analyzes data on auto sales. It also offers a user-friendly interface for obtaining sales information based on user-specified parameters. Additionally, it offers alternatives for several ways to carry out these computations and reports the length of time required for each procedure.
