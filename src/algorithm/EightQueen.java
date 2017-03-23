package algorithm;

/**
 * date: 2017/03/22 16:36.
 * author: Yueqi Shi
 */
public class EightQueen {

    /**
     * 皇后数量
     */
    private static final int QUEENS_COUNT = 8;

    /**
     * 皇后数组
     */
    private int[][] queensArray = new int[QUEENS_COUNT][QUEENS_COUNT];

    /**
     * 结果总数
     * 8皇后结果为92
     */
    private int totalRes = 0;

    /**
     * 递归回溯
     * @param x 二维数组第一个坐标
     */
    public void eightQueen(int x) {
        for (int i = 0; i < QUEENS_COUNT; i++) {
            boolean isValidate = this.isPosValidate(x, i);
            if (!isValidate) {
                continue;
            } else if (x < QUEENS_COUNT - 1) {
                //可以继续递归，递归结束后，清空当前结点值，继续循环
                this.queensArray[x][i] = 1;
                this.eightQueen(x + 1);
                this.clear(x, i);
            } else {
                //当i结点为7时，即到末尾，进行打印
                this.queensArray[x][i] = 1;
                this.totalRes++;
                this.print();
                this.clear(x, i);
            }
        }
    }

    /**
     * 判断当前位置的queen是否合法
     * @param x 二维数组第一个坐标
     * @param y 二维数组第二个坐标
     * @return
     */
    public boolean isPosValidate(int x, int y) {
        //判断竖线上是否有queen
        for (int i = 0; i < x; i++) {
            if (this.queensArray[i][y] == 1) {
                return false;
            }
        }

        //判断斜线上是否有queen
        //因为有两条斜线，先判断从该结点向左上方向
        int i = x - 1;
        int j = y - 1;
        while (i >= 0 && j >= 0) {
            if (this.queensArray[i--][j--] == 1) {
                return false;
            }
        }

        //第二条斜线，从该结点向右上方向
        i = x - 1;
        j = y + 1;
        while (i >= 0 && j >= 0 && j < QUEENS_COUNT) {
            if (this.queensArray[i--][j++] == 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 成功后打印皇后数组
     */
    public void print() {
        System.out.println("**********the " + this.totalRes + " result**********");
        for (int i = 0; i < QUEENS_COUNT; i++) {
            for (int j = 0; j < QUEENS_COUNT; j++) {
                System.out.print(this.queensArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 清空指定坐标结点
     * @param x 二维数组第一个坐标
     * @param y 二维数组第二个坐标
     */
    public void clear(int x, int y) {
        this.queensArray[x][y] = 0;
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.eightQueen(0);

        System.out.println("********************************");
        System.out.println("total results: " + eightQueen.totalRes + "");
    }
}
