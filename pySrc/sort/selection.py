import sort.utils as u

# 选择排序
class selection(u.util):
    def sort(self, arr):
        n = len(arr)
        for i in range(n):
            min_index = i
            for j in range(i+1,n):
                if u.util.less(arr[j], arr[min_index]):
                    min_index = j
            u.util.exch(arr,i,min_index)
        return arr


if __name__ == '__main__':
    print('选择排序法：')
    selection = selection()
    arr = [8,4,6,3,5,7,1,9,2]
    print("排序前", end=" ")
    u.util.show(arr)
    print('\n')
    sorted_arr = selection.sort(arr)
    print("排序后",end=" ")
    u.util.show(sorted_arr)
    print('\n')
    print("是否按升序排序",u.util.is_increase_sorted(sorted_arr))