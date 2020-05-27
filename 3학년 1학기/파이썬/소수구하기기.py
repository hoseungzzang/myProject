while True:
    input_number=int(input("소수여부를 알고 싶나요. 그럼 입력해보세요?"))
    count_num = 1
    prime_check = 0
    print("입력된 수는 %d" %input_number)
    for i in range(input_number):
        if(input_number % count_num == 0):
            print(count_num)
            count_num += 1
            prime_check += 1
        else:
            count_num +=1

    if(prime_check == 2) :
        print("소수 맞습니다.")
    else:
        print("소수가 아니에요.")
