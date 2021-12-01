import re
import numpy as np

with open('d1.txt') as f:
    lines = f.readlines()

print(lines)

# result = re.sub('[^0-9]','', lines)

numbers = []

for a in range(len(lines)):
    numbers = np.append(numbers, int(re.sub('[^0-9]', '', lines[a])))

result = 0
prev = numbers[0]
for a in range(1, len(numbers)):
    if numbers[a] > prev:
        result += 1
    prev = numbers[a]

print(result)
