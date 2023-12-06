import re

with open('d4.txt') as f:
    lines = f.readlines()


sum = 0

games = {}

for line in lines:
    round = re.match("Card[ ]*(\d+): (.*)", line)

    cardId = int(round.group(1))
    play = round.group(2)
    [winnings, cards] = round.group(2).replace("  ", " ").split("|")

    winnings = winnings[:-1].split(" ")
    cards = cards[1:].split(" ")

    games[cardId] = {"winnings": winnings, "cards": cards, "playAmount": 1}

    numberOfWinnings = 0

    for card in cards:
        if (card in winnings):
            numberOfWinnings += 1

    roundWinnings = 0
    if (numberOfWinnings != 0):
        roundWinnings = 2**(numberOfWinnings-1)

    sum += roundWinnings

for line in lines:
    round = re.match("Card[ ]*(\d+): (.*)", line)

    cardId = int(round.group(1))

    winnings = games[cardId]["winnings"]
    cards = games[cardId]["cards"]
    playAmount = games[cardId]["playAmount"]

    numberOfWinnings = 0

    for card in cards:
        if (card in winnings):
            numberOfWinnings += 1

    for i in range(numberOfWinnings):
        if (cardId + i+1 in games.keys()):
            games[cardId + i+1]["playAmount"] += playAmount

totalScratchCards = 0

for key in games:
    game = games[key]
    totalScratchCards += game["playAmount"]

print("Part 1:", sum)
print("Part 2:", totalScratchCards)
