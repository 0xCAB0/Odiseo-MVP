# Odiseo: Offline communication between mobile devices

This repo contains the code for an offline communication application prototype using the [Berty Protocol](https://berty.tech)

## Set-Up

TODO

### Troubleshooting

- Cannot find gomobile
  **Error**

  ```txt
  cannot find package "golang.org/x/mobile/cmd/gomobile" in any of:
       /usr/local/go/src/golang.org/x/mobile/cmd/gomobile (from $GOROOT)
       /home/varo/go/src/golang.org/x/mobile/cmd/gomobile (from $GOPATH)
  ```

  **Suggested Solution**

  1. Execute `go env` to checkout your environment file
  2. Go to your `GOENV` location or if not set, set it to `/home/{$USER}/.config/go/env`
  3. Set your `GOPATH=/home/{$USER}/go/bin`
