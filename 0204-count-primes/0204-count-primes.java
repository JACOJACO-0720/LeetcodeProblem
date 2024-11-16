class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;

        boolean[] isPrime = new boolean[n+1];

        for (int i = 2; i <= Math.sqrt(n); i++){
            if (!isPrime[i]){
                for (int j = i*i; j <= n; j+=i){
                    isPrime[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++){
            if (!isPrime[i]) count++;
        }

        return count;
    }
}