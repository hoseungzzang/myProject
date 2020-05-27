# Chap3. 계산기 설계

from tkinter import *
from decimal import *

# 키 입력 함수:
def click(key):
    if key == "=":
        try:
            result = str(eval(display.get()))
            display.insert(END, " = " +result)
        except:
            display.insert(END,"---->Error!")
    elif key == "C":
        display.delete(0, END)
    else:
        display.insert(END,key)
##### 메인:
window = Tk()
window.title("MyCalculator")

# top_row 프레임 생성
top_row = Frame(window)
top_row.grid(row=0, column=0, columnspan=2, sticky=N)

# 수정 가능한 엔트리 위젯
display = Entry(top_row, width=45, bg="light green")
display.grid()

# 숫자 버튼 프레임 생성
num_pad = Frame(window)
num_pad.grid(row=1, column=0, sticky=W)

num_pad_list = [
'7',  '8',  '9',
'4',  '5',  '6',
'1',  '2',  '3',
'0',  '.',  '=' ]

# 반복문으로 숫자 버튼 생성
r = 0
c = 0
for btn_text in num_pad_list:
    def cmd(x =btn_text):
        click(x)
    # 이 부분은 나중에 해결할 것입니다:
    Button(num_pad, text=btn_text, width=5, command=cmd).grid(row=r,column=c)
    c = c+1
    if c > 2:
        c = 0
        r = r+1

# 연산자 프레임 생성
operator = Frame(window)
operator.grid(row=1, column=1, sticky=E)

operator_list = [
'*', '/',  
'+', '-',
'(', ')',
'C' ]

# 반복문으로 연산자 버튼 생성
r = 0
c = 0
for btn_text in operator_list:
    def cmd(x=btn_text):
        click(x)
    Button(operator, text=btn_text, width=5, command=cmd).grid(row=r,column=c)
    c = c+1
    if c > 1:
        c = 0
        r = r+1


##### 메인 반복문 실행
window.mainloop()
