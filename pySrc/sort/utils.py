class util:
    @staticmethod
    def less(a, b):
        return a < b

    @staticmethod
    def exch(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]
        return arr

    @staticmethod
    def show(arr):
        for a in arr:
            print(a,end=", ")
    @staticmethod
    def is_increase_sorted(arr):
        for i in range(1,len(arr)):
            if util.less(arr[i],arr[i-1]):
                return False
        return True


