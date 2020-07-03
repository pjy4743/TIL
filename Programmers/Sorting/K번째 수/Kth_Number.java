/**
* 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째수를 구하는 프로그램
*
* @date 2020. 07. 03
* @author Jaewon Park
*/

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int answerInit = 0;
        int[] answer = new int[50];

        for(int i=0; i<commands.length; i++) {
            for(int j=0; j<commands[i].length; j++) {
                int [] tmp = getSubArray(array, commands[i]);
                insertSort(tmp, 0, tmp.length);
                answer[answerInit++] = tmp[commands[i][2]];
                System.out.println("haha");
            }
        }

        return answer;
    }

    public int [] getSubArray(int [] array, int [] subCommands) {
        int init = 0;
        int [] temp = new int[50];
        for(int k=subCommands[0]; k<=subCommands[1]; k++) {
            temp[init++] = array[k-1];
        }

        return temp;
    }

    public void insertSort(int [] subArray, int p, int r) {
        for(int i=1; i<r; i++) {
            int j;
            int subTmp = subArray[i];
            for(j=i; j>p && subArray[j-1] > subTmp; j--)
                subArray[j] = subArray[j-1];
            subArray[j] = subTmp;
        }
    }
}

public class Kth_Number {
    public static void main(String [] args) {
        int [] array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        int [] answer = new Solution().solution(array, commands);

        int i = 0;
        while(answer[i] != 0) {
            System.out.println(answer[i++]);
        }
    }
}