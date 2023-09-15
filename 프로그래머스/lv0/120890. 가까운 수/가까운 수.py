def solution(array, n):
    answer = 0
    array.sort()
    temp = [abs(n-i) for i in array]
    return array[temp.index(min(temp))]
