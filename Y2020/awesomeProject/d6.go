package main

import (
	"fmt"
	"strings"
	"time"
)

func D6() {
	a := OnPage("6","\n\n")

	//a = []string{"abc", "a\nb\nc", "ab\nac", "a\na\na\na", "b"}


	start := time.Now()


	unique := 0
	all := 0

	for _,val := range a {
		all += noAll(strings.Split(val,"\n"))
		val = strings.ReplaceAll(val,"\n", "")
		unique += noUnique(val)
	}

	println("Number of unique:",unique)
	println("Number of all:",all)

	elapsed := time.Since(start)
	fmt.Println("Both parts took",elapsed)

	return
}

func noUnique(votes string) int {
	var unique string
	for _,val := range votes {
		if !strings.Contains(unique, string(val)) {
			unique += string(val)
		}
	}
	return len(unique)
}

func noAll(votes []string) int {
	var unique string
	for _,val := range votes[0] {
		unique += string(val)
	}

	for _,oneAll := range unique {
		for _,vote := range votes {
			if !strings.Contains(vote, string(oneAll)) {
				unique = strings.ReplaceAll(unique, string(oneAll), "")
			}
		}
	}
	return len(unique)
}

