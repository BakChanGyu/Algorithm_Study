class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        
        for (int start = 0; start < 3; start++) {
            boolean[] isVisited = new boolean[n];
            int[] sum = new int[n];        
            int preSum = 0;
            
            for (int i = start; i < n; i++) {
                if (isVisited[i] == false) {
                    isVisited[i] = true;
                    sum[i] = money[i] + preSum;

                    int pre = (i - 1 + n) % n;
                    int next = (i + 1 + n) % n;

                    isVisited[pre] = true;
                    isVisited[next] = true;

                    preSum = sum[i];
                    answer = Math.max(answer, sum[i]);
                }
            }
        }
        
        return answer;
    }
}
