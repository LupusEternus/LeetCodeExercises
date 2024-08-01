public class BestTimeToBuyAndSellStock_121 {

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1 ) return 0;
        int min_price = prices[0];
        int maxprof = 0;

        for(int i = 1; i < prices.length; i++){
            if(min_price > prices[i]){
                min_price= prices[i];
            }
            if(prices[i]- min_price > maxprof){
                maxprof = prices[i]- min_price;
            }
        }
        return maxprof;


    }
}
