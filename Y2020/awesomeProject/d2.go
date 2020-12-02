package main

import (
	"fmt"
	"strconv"
	"strings"
	"time"
)

func D2() {
	s := OnPage("https://adventofcode.com/2020/day/2/input") // get input to string

	//s = []string{"1-3 a: abcde","1-3 b: cdefg","2-9 c: ccccccccc"}


	result := 0

	start := time.Now()

	// part 1
	println("Part 1: ")
	for _,val := range s {
		row := strings.Split(val, " ")
		var amount []int
		for _,val := range strings.Split(row[0], "-") {
			j,_ := strconv.Atoi(val)
			amount = append(amount, j)
		}
		letter := strings.TrimRight(row[1],":")
		newString := strings.ReplaceAll(row[2],letter,"")

		diff := len(row[2])-len(newString)

		if diff >= amount[0] && diff <= amount[1] {
			result++
		}
	}
	println(result)

	elapsed := time.Since(start)
	fmt.Println("Part 1 took",elapsed)


	println("")
	start = time.Now()
	// Part 2
	println("Part 2:")
	result = 0
	for _,val := range s {
		row := strings.Split(val, " ")
		var index []int
		for _,val := range strings.Split(row[0], "-") {
			j,_ := strconv.Atoi(val)
			index = append(index, j)
		}
		for i,val := range index{
			index[i] = val - 1
			val--
		}
		letter := strings.TrimRight(row[1],":")

		strarr := strings.Split(row[2], "")

		count := 0
		if strarr[index[0]] == letter {
			count++
		}
		if strarr[index[1]] == letter {
			count++
		}
		if count == 1 {
			result++
		}
	}
	println(result)

	elapsed = time.Since(start)
	fmt.Println("Part 2 took",elapsed)
}