import java.util.Arrays;

public class Table {
    private String [][] table;
    private String ANSI_BLACK = "\u001B[30m";
    private String ANSI_RED = "\u001B[31m";
    private String ANSI_GREEN = "\u001B[32m";
    private String ANSI_WHITE = "\u001B[37m";
    private String ANSI_BLUE = "\u001B[34m";


    public String[][] createTable() {
        table = new String[26][9];
        table[0][0] = "__";
        table[0][1] = "_";
        table[0][2] = "__";
        table[0][3] = "|";
        table[0][4] = "__";
        table[0][5] = "_";
        table[0][6] = ANSI_GREEN + "_0" + ANSI_BLACK;
        table[0][7] = "_";
        table[0][8] = "__";

        table[1][0] = ANSI_BLUE + " 1" + ANSI_BLACK;
        table[1][1] = "|";
        table[1][2] = ANSI_BLUE + " 1" + ANSI_BLACK;
        table[1][3] = "|";
        table[1][4] = ANSI_RED + " 1" + ANSI_BLACK;
        table[1][5] = "|";
        table[1][6] = " 2";
        table[1][7] = "|";
        table[1][8] = ANSI_RED + " 3" + ANSI_BLACK;

        table[2][0] = "--";
        table[2][1] = "+";
        table[2][2] = "--";
        table[2][3] = "+";
        table[2][4] = "--";
        table[2][5] = "+";
        table[2][6] = "--";
        table[2][7] = "+";
        table[2][8] = "--";

        table[3][0] = ANSI_BLUE + " -" + ANSI_BLACK;
        table[3][1] = "|";
        table[3][2] = ANSI_BLUE + " -" + ANSI_BLACK;
        table[3][3] = "|";
        table[3][4] = " 4";
        table[3][5] = "|";
        table[3][6] = ANSI_RED + " 5" + ANSI_BLACK;
        table[3][7] = "|";
        table[3][8] = " 6";

        table[4][0] = "--";
        table[4][1] = "+";
        table[4][2] = "--";
        table[4][3] = "+";
        table[4][4] = "--";
        table[4][5] = "+";
        table[4][6] = "--";
        table[4][7] = "+";
        table[4][8] = "--";

        table[5][0] = ANSI_BLUE + "18" + ANSI_BLACK;
        table[5][1] = "|";
        table[5][2] = ANSI_BLUE + "12" + ANSI_BLACK;
        table[5][3] = "|";
        table[5][4] = ANSI_RED + " 7" + ANSI_BLACK;
        table[5][5] = "|";
        table[5][6] = " 8";
        table[5][7] = "|";
        table[5][8] = ANSI_RED + " 9" + ANSI_BLACK;

        table[6][0] = "--";
        table[6][1] = "+";
        table[6][2] = "--";
        table[6][3] = "+";
        table[6][4] = "--";
        table[6][5] = "+";
        table[6][6] = "--";
        table[6][7] = "+";
        table[6][8] = "--";

        table[7][0] = ANSI_GREEN + "1%" + ANSI_BLACK;
        table[7][1] = "|";
        table[7][2] = "  ";
        table[7][3] = "|";
        table[7][4] = "10";
        table[7][5] = "|";
        table[7][6] = "11";
        table[7][7] = "|";
        table[7][8] = ANSI_RED + "12" + ANSI_BLACK;

        table[8][0] = "--";
        table[8][1] = "+";
        table[8][2] = "--";
        table[8][3] = "+";
        table[8][4] = "--";
        table[8][5] = "+";
        table[8][6] = "--";
        table[8][7] = "+";
        table[8][8] = "--";


        table[9][0] = ANSI_RED + "re" + ANSI_BLACK;
        table[9][1] = "|";
        table[9][2] = "  ";
        table[9][3] = "|";
        table[9][4] = "13";
        table[9][5] = "|";
        table[9][6] = ANSI_RED + "14" + ANSI_BLACK;
        table[9][7] = "|";
        table[9][8] = "15";

        table[10][0] = "--";
        table[10][1] = "+";
        table[10][2] = "--";
        table[10][3] = "+";
        table[10][4] = "--";
        table[10][5] = "+";
        table[10][6] = "--";
        table[10][7] = "+";
        table[10][8] = "--";

        table[11][0] = ANSI_RED + "re" + ANSI_BLACK;
        table[11][1] = "|";
        table[11][2] = ANSI_BLUE + "13" + ANSI_BLACK;
        table[11][3] = "|";
        table[11][4] = ANSI_RED + "16" + ANSI_BLACK;
        table[11][5] = "|";
        table[11][6] = "17";
        table[11][7] = "|";
        table[11][8] = ANSI_RED + "18" + ANSI_BLACK;

        table[12][0] = "--";
        table[12][1] = "+";
        table[12][2] = "--";
        table[12][3] = "+";
        table[12][4] = "--";
        table[12][5] = "+";
        table[12][6] = "--";
        table[12][7] = "+";
        table[12][8] = "--";

        table[13][0] = "bl";
        table[13][1] = "|";
        table[13][2] = ANSI_BLUE + " -" + ANSI_BLACK;
        table[13][3] = "|";
        table[13][4] = ANSI_RED + "19" + ANSI_BLACK;
        table[13][5] = "|";
        table[13][6] = "20";
        table[13][7] = "|";
        table[13][8] = ANSI_RED + "21" + ANSI_BLACK;

        table[14][0] = "--";
        table[14][1] = "+";
        table[14][2] = "--";
        table[14][3] = "+";
        table[14][4] = "--";
        table[14][5] = "+";
        table[14][6] = "--";
        table[14][7] = "+";
        table[14][8] = "--";

        table[15][0] = "bl";
        table[15][1] = "|";
        table[15][2] = ANSI_BLUE + "24" + ANSI_BLACK;
        table[15][3] = "|";
        table[15][4] = "22";
        table[15][5] = "|";
        table[15][6] = ANSI_RED + "23" + ANSI_BLACK;
        table[15][7] = "|";
        table[15][8] = "24";

        table[16][0] = "--";
        table[16][1] = "+";
        table[16][2] = "--";
        table[16][3] = "+";
        table[16][4] = "--";
        table[16][5] = "+";
        table[16][6] = "--";
        table[16][7] = "+";
        table[16][8] = "--";


        table[17][0] = ANSI_GREEN + "0%" + ANSI_BLACK;
        table[17][1] = "|";
        table[17][2] = "  ";
        table[17][3] = "|";
        table[17][4] = "25";
        table[17][5] = "|";
        table[17][6] = "26";
        table[17][7] = "|";
        table[17][8] = ANSI_RED + "27" + ANSI_BLACK;

        table[18][0] = "--";
        table[18][1] = "+";
        table[18][2] = "--";
        table[18][3] = "+";
        table[18][4] = "--";
        table[18][5] = "+";
        table[18][6] = "--";
        table[18][7] = "+";
        table[18][8] = "--";

        table[19][0] = ANSI_BLUE + "19" + ANSI_BLACK;
        table[19][1] = "|";
        table[19][2] = ANSI_BLUE + "25" + ANSI_BLACK;
        table[19][3] = "|";
        table[19][4] = "28";
        table[19][5] = "|";
        table[19][6] = "29";
        table[19][7] = "|";
        table[19][8] = ANSI_RED + "30" + ANSI_BLACK;

        table[20][0] = "--";
        table[20][1] = "+";
        table[20][2] = "--";
        table[20][3] = "+";
        table[20][4] = "--";
        table[20][5] = "+";
        table[20][6] = "--";
        table[20][7] = "+";
        table[20][8] = "--";

        table[21][0] = ANSI_BLUE +  " -" + ANSI_BLACK;
        table[21][1] = "|";
        table[21][2] = ANSI_BLUE + " -" + ANSI_BLACK;
        table[21][3] = "|";
        table[21][4] = "31";
        table[21][5] = "|";
        table[21][6] = ANSI_RED + "32" + ANSI_BLACK;
        table[21][7] = "|";
        table[21][8] = "33";

        table[22][0] = "--";
        table[22][1] = "+";
        table[22][2] = "--";
        table[22][3] = "+";
        table[22][4] = "--";
        table[22][5] = "+";
        table[22][6] = "--";
        table[22][7] = "+";
        table[22][8] = "--";

        table[23][0] = ANSI_BLUE + "36" + ANSI_BLACK;
        table[23][1] = "|";
        table[23][2] = ANSI_BLUE + "36" + ANSI_BLACK;
        table[23][3] = "|";
        table[23][4] = ANSI_RED + "34" + ANSI_BLACK;
        table[23][5] = "|";
        table[23][6] = "35";
        table[23][7] = "|";
        table[23][8] = (ANSI_RED + "36" + ANSI_BLACK);

        table[24][0] = "--";
        table[24][1] = "+";
        table[24][2] = "--";
        table[24][3] = "+";
        table[24][4] = "--";
        table[24][5] = "+";
        table[24][6] = "--";
        table[24][7] = "+";
        table[24][8] = "--";

        table[25][0] = "  ";
        table[25][1] = " ";
        table[25][2] = "  ";
        table[25][3] = "|";
        table[25][4] = "  ";
        table[25][5] = "|";
        table[25][6] = "  ";
        table[25][7] = "|";
        table[25][8] = "  ";

        System.out.println(Arrays.toString(table[0]));
        System.out.println(Arrays.toString(table[1]));
        System.out.println(Arrays.toString(table[2]));
        System.out.println(Arrays.toString(table[3]));
        System.out.println(Arrays.toString(table[4]));
        System.out.println(Arrays.toString(table[5]));
        System.out.println(Arrays.toString(table[6]));
        System.out.println(Arrays.toString(table[7]));
        System.out.println(Arrays.toString(table[8]));
        System.out.println(Arrays.toString(table[9]));
        System.out.println(Arrays.toString(table[10]));
        System.out.println(Arrays.toString(table[11]));
        System.out.println(Arrays.toString(table[12]));
        System.out.println(Arrays.toString(table[13]));
        System.out.println(Arrays.toString(table[14]));
        System.out.println(Arrays.toString(table[15]));
        System.out.println(Arrays.toString(table[16]));
        System.out.println(Arrays.toString(table[17]));
        System.out.println(Arrays.toString(table[18]));
        System.out.println(Arrays.toString(table[19]));
        System.out.println(Arrays.toString(table[20]));
        System.out.println(Arrays.toString(table[21]));
        System.out.println(Arrays.toString(table[22]));
        System.out.println(Arrays.toString(table[23]));
        System.out.println(Arrays.toString(table[24]));
        System.out.println(Arrays.toString(table[25]));

        return table;
    }

    @Override
    public String toString() {
        return "Table{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}
