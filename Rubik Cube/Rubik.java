class Rubik {
    int[][][] newGrid;
    static final int TOP = 0;
    static final int LEFT = 1;
    static final int FRONT = 2;
    static final int RIGHT = 3;
    static final int DOWN = 4;
    static final int BACK = 5;


    public Rubik(int[][][] grid) {
        newGrid = new int[6][3][3]; 

        if (grid.length != 6 || grid[0].length != 3 || grid[0][0].length != 3) {
            throw new IllegalArgumentException("Invalid grid!");
        }

        for (int k = 0; k < 6; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    newGrid[k][i][j] = grid[k][i][j];
                }
            }
        }
        this.newGrid = newGrid;
    }

    public Rubik viewRight() {
        int[][][] gridA = new int[6][3][3];
        gridA[TOP] = new Face(newGrid[TOP]).rotateRight().getGrid();
        gridA[LEFT] = new Face(newGrid[FRONT]).getGrid(); 
        gridA[FRONT] = new Face(newGrid[RIGHT]).getGrid();
        gridA[RIGHT] = new Face(newGrid[BACK]).rotateHalf().getGrid();
        gridA[DOWN] = new Face(newGrid[DOWN]).rotateLeft().getGrid();
        gridA[BACK] = new Face(newGrid[LEFT]).rotateHalf().getGrid();

        Rubik rubikA = new Rubik(gridA);
        return rubikA;
    }

    public Rubik viewLeft() {
        return this.viewRight().viewRight().viewRight();
    }

    public Rubik viewUp() {
        int[][][] gridA = new int[6][3][3];
        gridA[TOP] = new Face(newGrid[BACK]).getGrid();
        gridA[LEFT] = new Face(newGrid[LEFT]).rotateRight().getGrid(); 
        gridA[FRONT] = new Face(newGrid[TOP]).getGrid();
        gridA[RIGHT] = new Face(newGrid[RIGHT]).rotateLeft().getGrid();
        gridA[DOWN] = new Face(newGrid[FRONT]).getGrid();
        gridA[BACK] = new Face(newGrid[DOWN]).getGrid();

        Rubik rubikA = new Rubik(gridA);
        return rubikA;
    }

    public Rubik viewDown() {
        return this.viewUp().viewUp().viewUp();
    }

    public Rubik viewBack() {
        return this.viewRight().viewRight();
    }

    public Rubik frontfaceRight() {
        int[][][] gridA = new int[6][3][3];
        for (int f = 0; f < 6; f++) {
            for (int i = 0; i < 3; i++) {
                gridA[f][i] = newGrid[f][i].clone();
            }
        }

        gridA[FRONT] = new Face(gridA[FRONT]).rotateRight().getGrid();

        for (int i = 0; i < 3; i++) {
            int temp1 = newGrid[0][2][i];
            int temp2 = newGrid[3][i][0];
            int temp3 = newGrid[4][0][2-i];
            int temp4 = newGrid[1][2-i][2];
            gridA[0][2][i] = temp4;
            gridA[3][i][0] = temp1;
            gridA[4][0][2-i] = temp2;
            gridA[1][2-i][2] = temp3;
        }

        Rubik rubikA = new Rubik(gridA);
        return rubikA;

    }

    public Rubik frontfaceLeft() {
        return this.frontfaceRight().frontfaceRight().frontfaceRight();
    }
    
    public Rubik frontfaceHalf() {
        return this.frontfaceRight().frontfaceRight();
    }

    public Rubik rightfaceRight() {
        return this.viewRight().frontfaceRight().viewLeft();
    }

    public Rubik rightfaceLeft() {
        return this.rightfaceRight().rightfaceRight().rightfaceRight();
    }

    public Rubik rightfaceHalf() {
        return this.rightfaceRight().rightfaceRight();
    }

    public Rubik leftfaceRight() {
        return this.viewLeft().frontfaceRight().viewRight();
    }

    public Rubik leftfaceLeft() {
        return this.leftfaceRight().leftfaceRight().leftfaceRight();
    }

    public Rubik leftfaceHalf() {
        return this.leftfaceRight().leftfaceRight();
    }

    public Rubik upfaceRight() {
        return this.viewUp().frontfaceRight().viewDown();
    }

    public Rubik upfaceLeft() {
        return this.upfaceRight().upfaceRight().upfaceRight();
    }

    public Rubik upfaceHalf() {
        return this.upfaceRight().upfaceRight();
    }

    public Rubik downfaceRight() {
        return this.viewDown().frontfaceRight().viewUp();
    }

    public Rubik downfaceLeft() {
        return this.downfaceRight().downfaceRight().downfaceRight();
    }

    public Rubik downfaceHalf() {
        return this.downfaceRight().downfaceRight();
    }

    public Rubik backfaceRight() {
        return this.viewBack().frontfaceRight().viewBack();
    }

    public Rubik backfaceLeft() {
        return this.backfaceRight().backfaceRight().backfaceRight();
    }

    public Rubik backfaceHalf() {
        return this.backfaceRight().backfaceRight();
    }

    @Override
    public String toString() {
        String output = "";
        String dots = "......";

        //TOP
        for (int row = 0; row < 3; row++) {
            output += dots;
            for (int col = 0; col < 3; col++) {
                output += String.format("%02d", newGrid[0][row][col]);
            }
            output += dots + '\n';
        }

        //LEFT FRONT RIGHT
        for (int row = 0; row < 3; row++) {
            for (int face = 1; face < 4; face++) {
                for (int col = 0; col < 3; col++) {
                    output += String.format("%02d", newGrid[face][row][col]);
                }
            }
            output += '\n';
        }

        //DOWN
        for (int row = 0; row < 3; row++) {
            output += dots;
            for (int col = 0; col < 3; col++) {
                output += String.format("%02d", newGrid[4][row][col]);
            }
            output += dots + '\n';
        }

        //BACK
        for (int row = 0; row < 3; row++) {
            output += dots;
            for (int col = 0; col < 3; col++) {
                output += String.format("%02d", newGrid[5][row][col]);
            }
            output += dots + '\n';
        }

        return output;
    }
}
