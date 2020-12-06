import java.util.Stack;

/**1475. 商品折扣后的最终价格
 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。

 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。

 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。



 示例 1：

 输入：prices = [8,4,6,2,3]
 输出：[4,2,4,2,3]
 解释：
 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 商品 3 和 4 都没有折扣。
 示例 2：

 输入：prices = [1,2,3,4,5]
 输出：[1,2,3,4,5]
 解释：在这个例子中，所有商品都没有折扣。
 示例 3：

 输入：prices = [10,1,1,6]
 输出：[9,0,1,6]


 提示：

 1 <= prices.length <= 500
 1 <= prices[i] <= 10^3
 * */
public class FinalPricesWithASpecialDiscountInAShop {
    //100%,23.67%
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] discountedPrices = new int[len];
        int k = 0;
        for (int i = 0; i < len; i++){
            int a = prices[i];
            boolean flag = true;
            for (int j = i+1; j < len; j++){
                if (a >= prices[j]){
                    discountedPrices[k++] = a-prices[j];
                    flag = false;
                    break;
                }
            }
            if (flag && discountedPrices[i] == 0){
                discountedPrices[i] = prices[i];
                k++;
            }
        }
        return discountedPrices;
    }

    //改进
    public int[] finalPrices2(int[] prices) {
        for(int i=0 ;i<prices.length; ++i){
            for(int j=i+1 ;j<prices.length; ++j){
                if(prices[j]<=prices[i]){
                    prices[i]-=prices[j];
                    break;
                }
            }
        }
        return prices;
    }


    //用栈
    public int[] finalPrices3(int[] prices) {
        int len = prices.length;

        Stack<Integer> stack=new Stack<>();
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();    // java 的pop可以直接获取顶元素就不用像c++ 一样先top再pop了
                prices[index] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }


    public static void main(String[] args){
        FinalPricesWithASpecialDiscountInAShop finalPricesWithASpecialDiscountInAShop = new FinalPricesWithASpecialDiscountInAShop();
        finalPricesWithASpecialDiscountInAShop.finalPrices(new int[]{4,7,1,9,4,8,8,9,4});
        finalPricesWithASpecialDiscountInAShop.finalPrices(new int[]{8,4,6,2,3});
        finalPricesWithASpecialDiscountInAShop.finalPrices(new int[]{1,2,3,4,5});
        finalPricesWithASpecialDiscountInAShop.finalPrices(new int[]{10,1,1,6});
    }
}
