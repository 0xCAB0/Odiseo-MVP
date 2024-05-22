package main

import (
	"context"
	"fmt"

	"berty.tech/weshnet"
	"berty.tech/weshnet/pkg/protocoltypes"
)

func main() {
	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	client, err := weshnet.NewInMemoryServiceClient()
	if err != nil {
		panic(err)
	}
	defer client.Close()

	config, err := client.ServiceGetConfiguration(ctx,
		&protocoltypes.ServiceGetConfiguration_Request{})
	if err != nil {
		panic(err)
	}

	fmt.Println("Hello, world! My peer ID is", config.PeerID)
}
