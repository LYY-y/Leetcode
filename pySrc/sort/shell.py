import sort.utils as u

class shell(u.util):
    def sort(self, arr):
        n = len(arr)
        # 定义增量序列为n/2、(n/2)/2...
        # h = n//2
        h = 1
        while h < n // 3:
            h = 3 * h + 1
        while h >= 1:
            for i in range(h, n):
                # 使同一组的数据先排序
                for j in range(i, n, h):
                    while u.util.less(arr[j], arr[j-h]) and j >= h:
                        u.util.exch(arr, j, j-h)
                        j -= h
            h = h//3
        return arr

    # 更优
    def sort(self, arr):
        n = len(arr)
        # 定义增量序列为1，4，13...
        # h = 1
        # while h < n//3:
        #     h = 3*h+1
        h = n//2
        while h >= 1:
            for i in range(h, n):
                j = i
                # 一个一个直接排序
                while j >= h and u.util.less(arr[j],arr[j-h]):
                    u.util.exch(arr,j,j-h)
                    j -= h
            h = h//2
        return arr

if __name__ == '__main__':
    print('希尔排序法：')
    shell = shell()
    arr = [8,9,1,7,2,3,5,4,6,0]
    print("排序前", end=" ")
    u.util.show(arr)
    print('\n')
    sorted_arr = shell.sort(arr)
    print("排序后",end=" ")
    u.util.show(sorted_arr)
    print('\n')
    print("是否按升序排序",u.util.is_increase_sorted(sorted_arr))





