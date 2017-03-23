package algorithm;

/**
 * date: 2017/03/22 16:36.
 * author: Yueqi Shi
 */
public class EightQueen {

    /**
     * �ʺ�����
     */
    private static final int QUEENS_COUNT = 8;

    /**
     * �ʺ�����
     */
    private int[][] queensArray = new int[QUEENS_COUNT][QUEENS_COUNT];

    /**
     * �������
     * 8�ʺ���Ϊ92
     */
    private int totalRes = 0;

    /**
     * �ݹ����
     * @param x ��ά�����һ������
     */
    public void eightQueen(int x) {
        for (int i = 0; i < QUEENS_COUNT; i++) {
            boolean isValidate = this.isPosValidate(x, i);
            if (!isValidate) {
                continue;
            } else if (x < QUEENS_COUNT - 1) {
                //���Լ����ݹ飬�ݹ��������յ�ǰ���ֵ������ѭ��
                this.queensArray[x][i] = 1;
                this.eightQueen(x + 1);
                this.clear(x, i);
            } else {
                //��i���Ϊ7ʱ������ĩβ�����д�ӡ
                this.queensArray[x][i] = 1;
                this.totalRes++;
                this.print();
                this.clear(x, i);
            }
        }
    }

    /**
     * �жϵ�ǰλ�õ�queen�Ƿ�Ϸ�
     * @param x ��ά�����һ������
     * @param y ��ά����ڶ�������
     * @return
     */
    public boolean isPosValidate(int x, int y) {
        //�ж��������Ƿ���queen
        for (int i = 0; i < x; i++) {
            if (this.queensArray[i][y] == 1) {
                return false;
            }
        }

        //�ж�б�����Ƿ���queen
        //��Ϊ������б�ߣ����жϴӸý�������Ϸ���
        int i = x - 1;
        int j = y - 1;
        while (i >= 0 && j >= 0) {
            if (this.queensArray[i--][j--] == 1) {
                return false;
            }
        }

        //�ڶ���б�ߣ��Ӹý�������Ϸ���
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
     * �ɹ����ӡ�ʺ�����
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
     * ���ָ��������
     * @param x ��ά�����һ������
     * @param y ��ά����ڶ�������
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
