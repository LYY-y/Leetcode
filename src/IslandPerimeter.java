public class IslandPerimeter {
    //50.12%,65.92%
    public int islandPerimeter(int[][] grid) {
        int allCount = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1) {
                    allCount += landCount(i, j, grid);
                }
            }
        }
        return allCount;
    }

    public int landCount(int i, int j, int[][] grid){
        int count = 4;
        if (i-1>=0&&grid[i-1][j]==1){
            count--;
        }
        if (i+1<grid.length&&grid[i+1][j]==1){
            count--;
        }
        if (j-1>=0&&grid[i][j-1]==1){
            count--;
        }
        if (j+1<grid[0].length&&grid[i][j+1]==1){
            count--;
        }
        return count;
    }

//    因为是一个闭合状态，在北边有一条边，必然在南边的某个地方也有一条边，在西边有一条边，必然在东边也会有一条边，
//    这样才能围成闭合图，所以只要求东南或者西南或者东北或者西北方向每次加两次即可
    public int islandPerimeter2(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[i].length;j++){
                if (grid[i][j] == 1){
                    count += 4;
                    if (j>0 && grid[i][j-1]==1){
                        count -= 2;
                    }
                    if (i>0 && grid[i-1][j]==1){
                        count -=2;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(new int[][]{{1,1}}));
        System.out.println(islandPerimeter.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));

    }
}
