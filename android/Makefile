# Variables
GO := go # this allows to override the go version used
GO_TAGS ?= -tags "fts5 sqlite sqlite_unlock_notify"
BERTY_DAEMON_HOST ?= 127.0.0.1
BERTY_DAEMON_PORT ?= 1337
BERTY_DAEMON_OPTS ?= -p2p.webui-listener=""
BERTY_DAEMON_STORE ?= -store.dir=$(BERTY_DAEMON_PORT).db.d
GOMOBILE_ANDROID_TARGET ?= android
SHELL ?= /bin/bash
PATH := $(PATH):/usr/local/go/bin/go:~/go/bin
GOPATH := $(HOME)/go

# Wildcards
rwildcard = $(foreach d,$(wildcard $1*),$(call rwildcard,$d/,$2) $(filter $(subst *,%,$2),$d))
bridge_src := $(call rwildcard,../go,*.go *.m *.h) ../go.sum
android_gomobile_cache="$(PWD)/.gomobile-cache"
ext_ldflags = -ldflags="-X berty.tech/berty/v2/go/pkg/bertyversion.VcsRef=$(VCS_REF) -X berty.tech/berty/v2/go/pkg/bertyversion.Version=$(VERSION)"
minimum_android_ver = 21

.PHONY: clean.caches
clean.caches:
	rm -rf ~/.gradle/caches && \
	rm -rf ~/.gradle/.tmp/


.PHONY: clean
clean:
	./gradlew clean || true

	# Android files
	rm -rf .gradle
	rm -rf .idea
	rm -rf build
	rm -rf app/build
	rm -f libs/gobridge.aar
	# gomobile cache

ifeq (, $(wildcard $(android_gomobile_cache)))
	chmod -R u+wx $(android_gomobile_cache) && rm -rf $(android_gomobile_cache)
endif

	# Help complementary cleaning
	@echo ""
	@echo "Cleaned. Now you may consider clearing some of your system cache with one of the following commands."
	@echo ""
	@echo "  rm -rf $(HOME)/.gradle/caches"


#https://developer.android.com/build/building-cmdline

# .PHONY: android.debug
# android.debug: android.build
# $ANDROID_HOME/emulator/emulator @Pixel_7_Pro_API_30 &
# adb wait-for-device && adb install app/build/outputs/apk/dev/debug/app-dev-debug.apk

.PHONY: android.compile
android.compile: ./gradlew assembleDebug

.PHONY: android.build
android.compile: ./gradlew installDebug

.PHONY: android.gomobile
android.gomobile: android/libs/gobridge.aar

android/libs/gobridge.aar: $(bridge_src)
	cd .. && $(GO) mod download
	cd .. && $(GO) run golang.org/x/mobile/cmd/gomobile init
	mkdir -p $(android_gomobile_cache) libs
	cd .. && GO111MODULE=on $(GO) run golang.org/x/mobile/cmd/gomobile bind \
		-o $@ \
		-v $(ext_ldflags) \
		$(GO_TAGS) \
		-cache $(android_gomobile_cache) \
		-target $(GOMOBILE_ANDROID_TARGET) \
		-androidapi $(minimum_android_ver) \
		./go/framework/bertybridge
	cd .. && touch $@
	cd .. && $(GO) mod tidy
