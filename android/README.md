# Odiseo: Offline communication between mobile devices

This repo contains the code for an offline communication application prototype using the [Berty Protocol](https://berty.tech)

## Project Structure overview

For this MVP, the project structure is strictly based on the [berty app](https://github.com/berty/berty) monolithic architecture
and picking up just the necessary code for the project

- the `go` module contains the code that will be compiled into the `gomobile.aar` dependency, alongside all the go code the original berty project uses
  for version **v2.470.3**
- the `android` module contains the prototype implementation

## Set-Up

1. Install `asdf` following [this tutorial](https://asdf-vm.com/guide/getting-started.html)
2. Install the necessary tools

   ```bash
   make asdf.install_tools: asdf.install_plugins
   ```

3. Enter the `android` folder: `cd android`
4. Build the `gomobile` dependency

   ```bash
   make android.gomobile
   ```

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
