with open('d1.txt') as f:
    lines = f.readlines()

print(lines)

sum = 0


def isStrInt(word: str) -> bool:
    if (("zero" in word) or reverseStr("zero") in word):
        return True
    if (("one" in word) or reverseStr("one") in word):
        return True
    if (("two" in word) or reverseStr("two") in word):
        return True
    if (("three" in word) or reverseStr("three") in word):
        return True
    if (("four" in word) or reverseStr("four") in word):
        return True
    if (("five" in word) or reverseStr("five") in word):
        return True
    if (("six" in word) or reverseStr("six") in word):
        return True
    if (("seven" in word) or reverseStr("seven") in word):
        return True
    if (("eight" in word) or reverseStr("eight") in word):
        return True
    if (("nine" in word) or reverseStr("nine") in word):
        return True

    return False


def strToIntStr(word: str) -> str:
    if (("zero" in word) or reverseStr("zero") in word):
        return "0"
    if (("one" in word) or reverseStr("one") in word):
        return "1"
    if (("two" in word) or reverseStr("two") in word):
        return "2"
    if (("three" in word) or reverseStr("three") in word):
        return "3"
    if (("four" in word) or reverseStr("four") in word):
        return "4"
    if (("five" in word) or reverseStr("five") in word):
        return "5"
    if (("six" in word) or reverseStr("six") in word):
        return "6"
    if (("seven" in word) or reverseStr("seven") in word):
        return "7"
    if (("eight" in word) or reverseStr("eight") in word):
        return "8"
    if (("nine" in word) or reverseStr("nine") in word):
        return "9"

    return "0"


def reverseStr(str: str) -> str:
    return str[::-1]


for line in lines:
    firstDigit = ""
    lastDigit = ""

    firstStr = ""
    lastStr = ""

    line = line.removesuffix("\n")

    for c in line:
        if (c.isnumeric()):
            firstDigit = c
            break
        else:
            firstStr += c

        if (isStrInt(firstStr)):
            firstDigit = strToIntStr(firstStr)
            break

    for c in reverseStr(line):
        if (c.isnumeric()):
            lastDigit = c
            break
        else:
            lastStr += c

        if (isStrInt(lastStr)):
            lastDigit = strToIntStr(lastStr)
            break

    if (lastDigit == ""):
        lastDigit = firstDigit

    num = int(firstDigit + lastDigit)
    print(num)

    sum += num


print("Result: " + str(sum))
