while True:
    input_number = int(input("소수들을 알고 싶나요. 그럼 입력해보세요?"))
    count_num=0
    prime_check=0
    print("입력된 수는 %d:"%input_number)
    for i in range(1,input_number+1):
        print("%d" %i)
        prime_check = 0
        for j in range(1,i+1):
            if(i % j == 0):
                prime_check += 1


        if(prime_check == 2) :
            print("소수 = %d\n" %i)
            count_num +=1
    print("총 소수의 개수는 %d개 입니다." %count_num)
        
                
