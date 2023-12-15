import re

with open('d15.txt') as f:
    input = f.read()

maps = input.split(",")


def math(char: str, val: int) -> int:
    val += ord(char)
    val *= 17
    return val % 256


def update(seq, nr, boxNr):
    for i, (label, _) in enumerate(hashmap[boxNr]):
        if seq == label:
            hashmap[boxNr][i] = (seq, nr)
            return

    hashmap[boxNr].append((seq, nr))


def remove(seq, boxNr):
    for i, (label, _) in enumerate(hashmap[boxNr]):
        if seq == label:
            hashmap[boxNr].pop(i)
            return


part1 = 0
for seq in maps:
    hashValue = 0
    for char in seq:
        hashValue = math(char, hashValue)
    part1 += hashValue

hashmap = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [
], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
part2 = 0
for seq in maps:
    hashValue = 0

    if "-" in seq:
        seq = seq[:-1]
        for char in seq:
            hashValue = math(char, hashValue)
        remove(seq, hashValue)
    else:
        nr = seq[-1]
        seq = seq[:-2]
        for char in seq:
            hashValue = math(char, hashValue)
        update(seq, nr, hashValue)

part2 = 0
for boxNr, box in enumerate(hashmap):
    for slotNr, (_, focalLength) in enumerate(box):
        power = (boxNr+1) * (slotNr+1) * int(focalLength)
        part2 += power

print("Part 1:", part1)
print("Part 2:", part2)
