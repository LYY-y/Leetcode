import java.util.*;

/**599. 两个列表的最小索引总和
 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

 示例 1:

 输入:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 输出: ["Shogun"]
 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 示例 2:

 输入:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 输出: ["Shogun"]
 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 提示:

 两个列表的长度范围都在 [1, 1000]内。
 两个列表中的字符串的长度将在[1，30]的范围内。
 下标从0开始，到列表的长度减1。
 两个列表都没有重复的元素。*/
public class MinimumIndexSumOfTwoLists {
    //80.42%,75.15%
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        int indexSum = Integer.MAX_VALUE;
        for (int i=0; i<list1.length; i++){
            map.put(list1[i],i);
        }
        for (int j=0; j<list2.length; j++){
            String restaurant = list2[j];
            if (map.containsKey(restaurant)){
                int temp = j+map.get(restaurant);
                if (indexSum == temp){
                    result.add(restaurant);
                }
                if (indexSum > temp){
                    result.clear();
                    result.add(restaurant);
                    indexSum = temp;
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    //100.00%,33.82%
    public String[] findRestaurant2(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            return findRestaurant2(list2, list1);
        }
        Map<String, Integer> map = new HashMap<>((int)(list1.length / 0.75)+1);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j < min) {
                    min = i + j;
                    list.clear();
                    list.add(list2[i]);
                } else if (min == i + j) {
                    list.add(list2[i]);
                }
            }
            if (min <= i) {
                break;
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args){
        MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists=new MinimumIndexSumOfTwoLists();
        System.out.println(minimumIndexSumOfTwoLists.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"}));
        System.out.println(minimumIndexSumOfTwoLists.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King",
                "KFC"},new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));
    }
}
