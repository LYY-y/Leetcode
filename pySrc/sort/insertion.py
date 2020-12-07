import sort.utils as u

# 插入排序
class insertion(u.util):
    def sort(self, arr):
        n = len(arr)
        for i in range(1, n):
            for j in range(i, 0, -1):
                if u.util.less(arr[j], arr[j-1]):
                    u.util.exch(arr, j, j-1)
        return arr

if __name__ == '__main__':
    print('插入排序法：')
    insertion = insertion()
    arr = [8,4,6,3,5,7,1,9,2]
    print("排序前", end=" ")
    u.util.show(arr)
    print('\n')
    sorted_arr = insertion.sort(arr)
    print("排序后",end=" ")
    u.util.show(sorted_arr)
    print('\n')
    print("是否按升序排序",u.util.is_increase_sorted(sorted_arr))





