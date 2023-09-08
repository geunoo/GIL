def solution(food):
    answer = ''

    for i in range(1, len(food)):
        for j in range(int(food[i]/2)):
            print(i)
            answer += f'{i}'
    
    answer += '0'

    food.reverse()
    print(food)

    for i in range(len(food)-1):
        for j in range(int(food[i]/2)):
            answer += f'{len(food)-1 - i}'
    return answer