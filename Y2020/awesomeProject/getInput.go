package main

import (
	"io/ioutil"
	"log"
	"net/http"
	"strings"
)

func OnPage(link string)([]string) {
	client := &http.Client{}
	req, _ := http.NewRequest("GET", link, nil)
	req.Header.Set("Cookie", "session=53616c7465645f5f24cecaa7fd8febeaac0d4f76aafa10f4e1efb26eb71d4b653e02a820bae4b1b14724ad795b8ecccf")
	res, err := client.Do(req)

	if err != nil {
		log.Fatal(err)
	}
	content, err := ioutil.ReadAll(res.Body)
	res.Body.Close()
	if err != nil {
		log.Fatal(err)
	}
	s := strings.Split(string(content), "\n") // split everything at newline
	s = s[:len(s)-1] // remove last element since it's empty
	return s
}
