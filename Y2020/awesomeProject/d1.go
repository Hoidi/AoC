package main

import (
	"fmt"
	"sort"
	"strconv"
)


func d1() {
	s := OnPage("https://adventofcode.com/2020/day/1/input") // get input to string

	var a []int

	for _,val := range s {
		j,_ := strconv.Atoi(val)
		a = append(a, j)
	}

	//a = []int{1721,979,366,299,675,1456}

	sort.Ints(a)

	for _,val1 := range a {
		for _,val2 := range a {
			for _,val3 := range a {
				if val1+val2+val3==2020 {
					fmt.Println(val1,val2,val3)
					fmt.Println("Product: ",val1*val2*val3)
					return
				}
			}
		}
	}
}