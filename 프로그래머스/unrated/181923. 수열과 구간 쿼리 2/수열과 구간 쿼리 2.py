def solution(arr, queries):
    answer = []

    for i in range(len(queries)):
        k = []
        for j in range(queries[i][0], queries[i][1]+1):
            if arr[j] > queries[i][2]:
                k.append(arr[j])
        k.sort()
        if len(k) == 0:
            answer.append(-1)
        else:
            answer.append(k[0])

    return answer