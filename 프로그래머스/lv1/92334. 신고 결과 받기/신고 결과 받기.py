# 작성자 : 이준표
# 프로그래머스 문자열
# 2022 KAKAO BLIND RECRUITMEN 신고 결과 받기
# created: 2022.07.11


def solution(id_list, report, k):
    answer = []
    num = []
    length = len(id_list)
    
    for i in range(0,length):
        num.append(0)
        answer.append(0)
        
    arr = [[0]*length for _ in range(length)]
    
    for i in report:
        result = i.split()
        reporter = id_list.index(result[0])
        reportee = id_list.index(result[1])
        if(not arr[reporter][reportee] == 1):
            arr[reporter][reportee] = 1
            num[reportee] += 1
            
    for idx, val in enumerate(num):
        if(val >= k):
            for i in range(0,length):
                if(arr[i][idx] == 1):
                    answer[i] += 1
    
    return answer