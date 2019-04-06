class Face {
    int[][] newGrid;
    int[][] gridA;

    public Face(int[][] grid) {
        newGrid = new int[3][3];
        for(int i = 0; i < 3; i++) {
            newGrid[i] = grid[i].clone();
        }
        
        this.newGrid = newGrid;
    }

    public Face rotateRight() {
        gridA = new int[3][3];
        int j = 2;
        for (int row = 0; row < newGrid.length; row++) {
            for (int col = 0; col < newGrid[0].length; col++) {
                gridA[col][j] = newGrid[row][col];
            }
            j--;
        }
        Face newFace = new Face(gridA);
        return newFace;
    }

    public Face rotateLeft() {
        return this.rotateRight().rotateRight().rotateRight();
    }

    public Face rotateHalf() {
        return this.rotateRight().rotateRight();    
    }

    public int[][] getGrid() {
        gridA = new int[3][3];
        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[0].length; j++) {
                gridA[i][j] = newGrid[i][j];
            }
        }
        return gridA;
    }

    public String toString() {
        String output = "";
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                output += String.format("%02d", newGrid[row][col]);
            }
            output += '\n';
        } 
        return output;
    }
}
