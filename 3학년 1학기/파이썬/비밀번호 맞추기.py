import random

response1 = '걱정말고 다시 시도해보세요'
response2 = '그럴 듯 하지만 내 비밀번호는 정말 쉬워요'
response3 = '내 비밀번호가 아니에요. 내 비밀번호는 정말 쉬워요'
response4 = '잘했어요!'

MY_PASSWORD = 'hello'

def is_correct(guess, password):
    if guess == password:
        guess_correct = True

    else:
        guess_correct = False
    return guess_correct

print("안녕\n")
users_guess = input("추측한 내 비밀번호를 입력하세요.")

true_or_false = is_correct(users_guess, MY_PASSWORD)

while true_or_false == False:
    computer_response = random.randint(1,3)
    if computer_response ==1:
        print(response1)
    elif computer_response == 2:
        print(response2)
    else:
        print(response3)

    users_guess = input("\n 다음 비밀번호는 무엇입니까?")
    true_or_false = is_correct(users_guess, MY_PASSWORD)

print(response4)

input("\n\n 엔터 키를 눌러 종료하세요")
