import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] grid = new int[6][3][3];

        for (int f = 0; f < 6; f++) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    grid[f][r][c] = sc.nextInt();            
                } 
            }
        }

        Rubik rub = new Rubik(grid);
        while (sc.hasNext()) {
            String instr = sc.next();
            switch(instr) {
                case "F":
                    rub = rub.frontfaceRight();
                    break;
                case "F'":
                    rub = rub.frontfaceLeft();
                    break;
                case "F2":
                    rub = rub.frontfaceHalf();
                    break;
                case "R":
                    rub = rub.rightfaceRight();
                    break;
                case "R'":
                    rub = rub.rightfaceLeft();
                    break;
                case "R2":
                    rub = rub.rightfaceHalf();
                    break;
                case "U":
                    rub = rub.upfaceRight();
                    break;
                case "U'":
                    rub = rub.upfaceLeft();
                    break;
                case "U2":
                    rub = rub.upfaceHalf();
                    break;
                case "L":
                    rub = rub.leftfaceRight();
                    break;
                case "L'":
                    rub = rub.leftfaceLeft();
                    break;
                case "L2":
                    rub = rub.leftfaceHalf();
                    break;
                case "B":
                    rub = rub.backfaceRight();
                    break;
                case "B'":
                    rub = rub.backfaceLeft();
                    break;
                case "B2":
                    rub = rub.backfaceHalf();
                    break;
                case "D":
                    rub = rub.downfaceRight();
                    break;
                case "D'":
                    rub = rub.downfaceLeft();
                    break;
                case "D2":
                    rub = rub.downfaceHalf();
                    break;
                default:
                    rub = rub;
            }
        }

        System.out.println(rub);
    }
}
