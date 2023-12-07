import re
from functools import cmp_to_key

with open('d7.txt') as f:
    lines = f.readlines()


lines = [line.removesuffix("\n").split(" ") for line in lines]

chars = "A|K|Q|T|9|8|7|6|5|4|3|2|J"
charList = chars.split("|")


def isFiveOfKind(count) -> bool:

    if not jokerIsWildCard:
        return 5 in count.values()

    values = list(count.values())[:-1]

    five = 5 in values
    four = 4 in values and count["J"] == 1
    three = 3 in values and count["J"] == 2
    two = 2 in values and count["J"] == 3
    one = 1 in values and count["J"] == 4
    zero = count["J"] == 5
    return five or four or three or two or one or zero


def isFourOfKind(count) -> bool:
    if not jokerIsWildCard:
        return 4 in count.values()

    values = list(count.values())[:-1]

    four = 4 in values
    three = 3 in values and count["J"] == 1
    two = 2 in values and count["J"] == 2
    one = 1 in values and count["J"] == 3
    zero = count["J"] == 4
    # print(four, three, two, one, zero)
    return four or three or two or one or zero


def isFullHouse(count) -> bool:
    if not jokerIsWildCard:
        return 3 in count.values() and 2 in count.values()

    values = list(count.values())[:-1]
    nrThree = values.count(3)
    nrTwo = values.count(2)
    nrJok = count["J"]

    regular = 3 in values and 2 in values
    oneJoker = (nrTwo == 2 and nrJok >= 1) or (nrThree == 1 and nrJok >= 1)
    twoJoker = nrTwo == 1 and nrJok >= 2
    # can always find four of a kind with three J
    return regular or oneJoker or twoJoker


def isThreeOfKind(count) -> bool:
    if not jokerIsWildCard:
        return 3 in count.values()

    values = list(count.values())[:-1]

    three = 3 in values
    two = 2 in values and count["J"] == 1
    one = 1 in values and count["J"] == 2
    zero = count["J"] == 3
    return three or two or one or zero


def isTwoPairs(count) -> bool:
    values = list(count.values())
    if not jokerIsWildCard:
        if 2 not in values:
            return False

        values.remove(2)
        return 2 in values

    values = list(count.values())[:-1]

    nrTwo = values.count(2)
    nrJok = count["J"]

    regular = nrTwo == 2
    oneJoker = nrTwo == 1 and nrJok >= 1
    # can always find three of a kind with two J
    return regular or oneJoker


def isPair(count) -> bool:
    if not jokerIsWildCard:
        return 2 in count.values()

    values = list(count.values())[:-1]

    two = 2 in values
    one = 1 in values and count["J"] == 1
    zero = count["J"] == 2
    return two or one or zero


def determinHandValue(hand):
    count = {}

    for c in charList:
        count[c] = 0

    for c in hand:
        count[c] = count[c]+1

    if (isFiveOfKind(count)):
        return 6
    if (isFourOfKind(count)):
        return 5
    if (isFullHouse(count)):
        return 4
    if (isThreeOfKind(count)):
        return 3
    if (isTwoPairs(count)):
        return 2
    if (isPair(count)):
        return 1

    return 0


def determinCardValue(card):
    chars = "A|K|Q|T|9|8|7|6|5|4|3|2|J"
    valueCardList = chars.split("|")
    valueCardList.reverse()
    return valueCardList.index(card)


def sortCards(card1, card2):
    v1 = determinCardValue(card1)
    v2 = determinCardValue(card2)
    # print(card1, v1)
    # print(card2, v2)
    if v1 > v2:
        return 1
    elif v1 < v2:
        return -1
    return 0


def sortHands(hand1, hand2):
    v1 = determinHandValue(hand1[0])
    v2 = determinHandValue(hand2[0])
    # print(hand1[0], v1)
    # print(hand2[0], v2)
    if v1 > v2:
        return 1
    elif v1 < v2:
        return -1

    for i in range(len(hand1[0])):
        sortValue = sortCards(hand1[0][i], hand2[0][i])
        if (sortValue != 0):
            return sortValue

    return 0


jokerIsWildCard = False
cmp_items_py3 = cmp_to_key(sortHands)
lines.sort(key=cmp_items_py3)

winnings = 0

for i, value in enumerate(lines):
    rank = i + 1
    card = value[0]
    bet = int(value[1])

    winnings += rank * bet

jokerIsWildCard = True
lines.sort(key=cmp_items_py3)
winningsJoker = 0

for i, value in enumerate(lines):
    rank = i + 1
    card = value[0]
    bet = int(value[1])

    winningsJoker += rank * bet

print("Part 1:", winnings)
print("Part 2:", winningsJoker)
