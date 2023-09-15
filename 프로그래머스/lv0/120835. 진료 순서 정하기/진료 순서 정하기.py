import copy

def solution(emergency):
    answer = []
    k = copy.deepcopy(emergency)
    k.sort(reverse=True)
    answer = [k.index(i) + 1 for i in emergency]
    return answer

