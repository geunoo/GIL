def solution(num_list, n):
    answer = [[]]
    for i in range(int(len(num_list) / n)):
        answer.append([num_list[j] for j in range(((i+1) * n) - n, (i+1) * n)])
    answer.pop(0)
    return answer